package com.yoma.domain;

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

    public void moveUp() {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.DOWN.ordinal()) {
            this.copyElements();
            shapeItem.setDirection(Direction.UP);
            shapeItem.setX(shapeItem.getX());
            shapeItem.setY(shapeItem.getY() - 5);
        }
    }
    public void moveDown() {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.UP.ordinal()) {
            this.copyElements();
            shapeItem.setDirection(Direction.DOWN);
            shapeItem.setX(shapeItem.getX());
            shapeItem.setY(shapeItem.getY() + 5);
        }
    }
    public void moveLeft() {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.RIGHT.ordinal()) {
            this.copyElements();
            shapeItem.setDirection(Direction.LEFT);
            shapeItem.setX(shapeItem.getX() - 5);
            shapeItem.setY(shapeItem.getY());
        }
    }
    public void moveRight() {
        ShapeItem shapeItem = items.get(0);
        if(shapeItem.getDirection().ordinal()!=Direction.LEFT.ordinal()) {
            this.copyElements();
            shapeItem.setDirection(Direction.RIGHT);
            shapeItem.setX(shapeItem.getX() + 5);
            shapeItem.setY(shapeItem.getY());
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
