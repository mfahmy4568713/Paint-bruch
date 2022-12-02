package MyPackage;

import java.awt.*;

public class Oval extends Shape {
    Point startPoint;
    int width;
    int height;
    boolean filled;

    public Oval(Point startPoint, int width, int height) {
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }
    public Oval(Point startPoint, int width, int height, Color shapeColor) {
        super(shapeColor);
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }

    public Oval(Point startPoint, int width, int height, Color shapeColor, boolean dotted,boolean filled) {
        super(shapeColor, dotted);
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}