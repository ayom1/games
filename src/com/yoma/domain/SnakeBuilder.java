package com.yoma.domain;

import java.util.ArrayList;
import java.util.List;

public class SnakeBuilder {
    public final static int UNIT = 5;
    public final static int X = 400;
    public final static int Y = 200;
    public static Shape initShape(){
        Shape shape = new Shape();
        shape.getItems().add(new ShapeItem(220,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(215,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(210,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(205,100,Direction.RIGHT));
        shape.getItems().add(new ShapeItem(200,100,Direction.RIGHT));
        return shape;
    }

    public static List<ShapeItem> generateAllShapeItems(){
        List<ShapeItem> items = new ArrayList<>();
        for (int i =0;i<X;i+=UNIT){
            for (int j=0;j<Y;j+=UNIT) {
                ShapeItem shapeItem = new ShapeItem(i,j,Direction.RIGHT);
                items.add(shapeItem);
            }
        }
        return items;
    }

    public static Rat initRat() {
        List<ShapeItem> items = generateAllShapeItems();
        Rat rat = new Rat();
        int slot = (int) (Math.random()*items.size());
        rat.setX(items.get(slot).getX());
        rat.setY(items.get(slot).getY());
        return rat;
    }

}
