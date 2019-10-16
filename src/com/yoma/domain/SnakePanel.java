package com.yoma.domain;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SnakePanel extends JPanel {

    private final static int UNIT = 5;

    public SnakePanel(){
        shape = SnakeBuilder.initShape();
        rat = SnakeBuilder.initRat(shape.getItems());
        System.out.println(rat.getX());
        System.out.println(rat.getY());
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.BLUE);
        graphics.fillRect(rat.getX(), rat.getY(), SnakePanel.UNIT, SnakePanel.UNIT);
        List<ShapeItem> items = shape.getItems();
        ShapeItem item = null;
        for (int i=0;i<items.size();i++){
            item = items.get(i);
            //System.out.println(""+item.getX()+" "+item.getY()+" "+item.getDirection());
            if(i==0){
                graphics.setColor(Color.GREEN);
                graphics.fillRect(item.getX(), item.getY(), SnakePanel.UNIT, SnakePanel.UNIT);
            }else {
                graphics.setColor(Color.RED);
                graphics.fillRect(item.getX(), item.getY(), SnakePanel.UNIT, SnakePanel.UNIT);
            }
        }

//        graphics.fillRect(20, 20, 100, 200);
    }

    private Shape shape;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    private Rat rat;

    public void moveUp() {
        shape.moveUp(this);
        this.repaint();
    }

    public void moveDown() {
        shape.moveDown(this);
        this.repaint();
    }

    public void moveLeft() {
        shape.moveLeft(this);
        this.repaint();
    }

    public void moveRight() {
        shape.moveRight(this);
        this.repaint();
    }

    public void moveSnake() {
        ShapeItem shapeItem = shape.getItems().get(0);
        if(shapeItem.getDirection().ordinal() == Direction.UP.ordinal()){
            this.moveUp();
        }else if(shapeItem.getDirection().ordinal() == Direction.DOWN.ordinal()){
            this.moveDown();
        }else if(shapeItem.getDirection().ordinal() == Direction.RIGHT.ordinal()){
            this.moveRight();
        }else if(shapeItem.getDirection().ordinal() == Direction.LEFT.ordinal()){
            this.moveLeft();
        }
    }

    public Rat getRat() {
        return rat;
    }

    public void setRat(Rat rat) {
        this.rat = rat;
    }
}
