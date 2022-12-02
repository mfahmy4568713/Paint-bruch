package MyPackage;

import java.awt.*;

public class Line extends Shape {
    Point p1;
    Point p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Line() {
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public Line(Point p1, Point p2,Color c)
    {
        super(c);
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(Point p1, Point p2, Color shapeColor, boolean dotted) {
        super(shapeColor, dotted);
        this.p1 = p1;
        this.p2 = p2;
    }

}