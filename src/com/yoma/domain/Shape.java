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
        this.copyElements();
        ShapeItem shapeItem = items.get(0);
        shapeItem.setDirection(Direction.UP);
        shapeItem.setX(shapeItem.getX());
        shapeItem.setY(shapeItem.getY()-5);
    }
    public void moveDown() {
        this.copyElements();
        ShapeItem shapeItem = items.get(0);
        shapeItem.setDirection(Direction.DOWN);
        shapeItem.setX(shapeItem.getX());
        shapeItem.setY(shapeItem.getY()+5);
    }
    public void moveLeft() {
        this.copyElements();
        ShapeItem shapeItem = items.get(0);
        shapeItem.setDirection(Direction.LEFT);
        shapeItem.setX(shapeItem.getX()-5);
        shapeItem.setY(shapeItem.getY());
    }
    public void moveRight() {
        this.copyElements();
        ShapeItem shapeItem = items.get(0);
        shapeItem.setDirection(Direction.RIGHT);
        shapeItem.setX(shapeItem.getX()+5);
        shapeItem.setY(shapeItem.getY());
    }
    void copyElements(){
        for (int i=items.size()-1;i>0;i--){
            items.get(i).setY(items.get(i-1).getY());
            items.get(i).setX(items.get(i-1).getX());
            items.get(i).setDirection(items.get(i-1).getDirection());
        }
    }
}
