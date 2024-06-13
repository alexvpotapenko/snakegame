package com.alex.snake;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class Snake extends Rectangle {

    private Array<Rectangle> tails = new Array<>();

    public void reset() {
        x = 400;
        y = 240;
        System.out.println("Snake has been reset");
    }

    public void expand() {
        Rectangle tail = new Rectangle();
        tail.width = 8;
        tail.height = 8;
        tails.add(tail);

    }

    public Rectangle getTail (int i) {
        return tails.get(i);
    }





}
