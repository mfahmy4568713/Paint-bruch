package MyPackage;

import java.awt.*;


public class Shape {
    Color c;
    boolean dotted;
    public Shape(Color c ,boolean dotted){
        this.c=c;
        this.dotted=dotted;
    }

    public Shape(Color c) {
        this.c=c;
    }

    public boolean isDotted() {
        return dotted;
    }
    public void setDotted() {
        this.dotted=dotted;
    }
    public Color getColor() {
        return c;
    }
    public void  setColor (Color c) {
        this.c = c;
    }
    public Shape () {}
}
