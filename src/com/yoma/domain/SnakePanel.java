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
}
