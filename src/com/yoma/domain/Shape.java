package com.yoma.domain;


import com.yoma.shape.SnakePanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.List;

public class Shape {
    public Shape(){
        items = new ArrayList<ShapeItem>();
    }
    private List<ShapeItem> items;

    public List<ShapeItem> getItems() {
        return items;
    }

    public void setItems(List<ShapeItem> items) {
        this.items = items;
    }
    public static final String SOUND_FILENAME = "/resources/food.wav";
    private void playSound()
    {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Shape.class.getResourceAsStream(SOUND_FILENAME));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    public void moveUp(SnakePanel snakePanel) {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.DOWN.ordinal()) {
            // detect collision
            if(snakePanel.getRat().getX()==shapeItem.getX()&&snakePanel.getRat().getY()==shapeItem.getY()){
                shapeItem = new ShapeItem(snakePanel.getRat().getX(),snakePanel.getRat().getY()-5,Direction.UP);
                items.add(0,shapeItem);
                snakePanel.setRat(SnakeBuilder.initRat(items));
                this.playSound();
                snakePanel.raiseScore();
            }else {
                this.copyElements();
                shapeItem.setDirection(Direction.UP);
                shapeItem.setX(shapeItem.getX());
                shapeItem.setY(shapeItem.getY() - 5);
            }
            if(shapeItem.getY()==0) {
                shapeItem.setY(SnakeBuilder.Y-5);
            }
        }
    }
    public void moveDown(SnakePanel snakePanel) {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.UP.ordinal()) {
            if(snakePanel.getRat().getX()==shapeItem.getX()&&snakePanel.getRat().getY()==shapeItem.getY()){
                shapeItem = new ShapeItem(snakePanel.getRat().getX(),snakePanel.getRat().getY()+5,Direction.DOWN);
                items.add(0,shapeItem);
                snakePanel.setRat(SnakeBuilder.initRat(items));
                this.playSound();
            }else {
                this.copyElements();
                shapeItem.setDirection(Direction.DOWN);
                shapeItem.setX(shapeItem.getX());
                shapeItem.setY(shapeItem.getY() + 5);
            }
            if(shapeItem.getY()==SnakeBuilder.Y) {
                shapeItem.setY(5);
            }
        }
    }
    public void moveLeft(SnakePanel snakePanel) {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.RIGHT.ordinal()) {
            if(snakePanel.getRat().getX()==shapeItem.getX()&&snakePanel.getRat().getY()==shapeItem.getY()){
                shapeItem = new ShapeItem(snakePanel.getRat().getX()-5,snakePanel.getRat().getY(),Direction.LEFT);
                items.add(0,shapeItem);
                snakePanel.setRat(SnakeBuilder.initRat(items));
                this.playSound();
            }else {
                this.copyElements();
                shapeItem.setDirection(Direction.LEFT);
                shapeItem.setX(shapeItem.getX() - 5);
                shapeItem.setY(shapeItem.getY());
            }
            if(shapeItem.getX()==-5) {
                shapeItem.setX(SnakeBuilder.X);
            }
        }
    }
    public void moveRight(SnakePanel snakePanel) {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.LEFT.ordinal()) {
            if(snakePanel.getRat().getX()==shapeItem.getX()&&snakePanel.getRat().getY()==shapeItem.getY()){
                shapeItem = new ShapeItem(snakePanel.getRat().getX()+5,snakePanel.getRat().getY(),Direction.RIGHT);
                items.add(0,shapeItem);
                snakePanel.setRat(SnakeBuilder.initRat(items));
                this.playSound();

            }else {
                this.copyElements();
                shapeItem.setDirection(Direction.RIGHT);
                shapeItem.setX(shapeItem.getX() + 5);
                shapeItem.setY(shapeItem.getY());
            }
            if(shapeItem.getX()==SnakeBuilder.X) {
                shapeItem.setX(5);
            }
        }
    }
    void copyElements(){
        for (int i=items.size()-1;i>0;i--){
            items.get(i).setY(items.get(i-1).getY());
            items.get(i).setX(items.get(i-1).getX());
            items.get(i).setDirection(items.get(i-1).getDirection());
        }
    }
}
