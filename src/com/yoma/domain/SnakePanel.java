package com.yoma.domain;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SnakePanel extends JPanel {

    private final static int UNIT = 5;

    public SnakePanel(){
        shape = SnakeBuilder.initShape();
        rat = SnakeBuilder.initRat(shape.getItems());

    }

    public void paint(Graphics graphics){
        if(this.crashed){
            return;
        }
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
        if(this.detectCollision(shape.getItems())){
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(0,0,20,20,true);
            this.crashed = true;
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

    private boolean crashed;

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

    private boolean detectCollision(List<ShapeItem> items) {
        ShapeItem firstItem = items.get(0);
        for (int i=1;i<items.size();i++){
            if(firstItem.getX()==items.get(i).getX()
                    && firstItem.getY()==items.get(i).getY()){
                return true;
            }
        }
        return false;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
}
