package com.yoma.domain;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SnakePanel extends JPanel {

    private final static int UNIT = 5;

    public SnakePanel(){
        shape = new Shape();
        shape.getItems().add(new ShapeItem(220,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(215,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(210,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(205,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(200,100,Direction.RIGHT));
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, getWidth(), getHeight());
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

    public void moveUp() {
        shape.moveUp();
        this.repaint();
    }

    public void moveDown() {
        shape.moveDown();
        this.repaint();
    }

    public void moveLeft() {
        shape.moveLeft();
        this.repaint();
    }

    public void moveRight() {
        shape.moveRight();
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
}
