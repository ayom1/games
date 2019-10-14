package com.yoma.domain;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel {

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
        shape.getItems().forEach(
                item -> {
                    System.out.println(""+item.getX()+" "+item.getY()+" "+item.getDirection());
                    graphics.setColor(Color.RED);
                    graphics.drawRect(item.getX(),item.getY(),5,5);
//                    graphics.drawLine(item.getX(),item.getY(),item.getX(),0);
                }
        );

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
