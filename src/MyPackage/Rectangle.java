package MyPackage;

import java.awt.*;

public class Rectangle extends Shape{
    Point startPoint;
    int width;
    int height;
    boolean filled;

    public Rectangle(){
        this.height=height;
        this.startPoint=startPoint;
        this.width=width;
    }
    public Rectangle(Point startPoint,int width,int height,Color c){
        super(c);
        this.height=height;
        this.startPoint=startPoint;
        this.width=width;
    }
    public Rectangle(Point startPoint,int width,int height,Color c,boolean filled,boolean dotted){
        super(c,dotted);
        this.height=height;
        this.startPoint=startPoint;
        this.width=width;
        this.filled=filled;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isFilled() {
        return filled;
    }
}
