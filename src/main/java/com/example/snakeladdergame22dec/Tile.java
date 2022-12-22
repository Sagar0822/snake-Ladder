package com.example.snakeladdergame22dec;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle { //shape class
    public Tile(int size){
        setWidth(size);
        setHeight(size);
        setFill(Color.RED);
        setStroke(Color.BLACK);
    }
}
