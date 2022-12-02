package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    JButton red, blue, black, rectangle, oval, line, eraser, delete, freehand;
    Checkbox dotted, filled;

    Graphics2D g2d;
    ArrayList<Shape> allshapes, temp;

    Point p1, p2, fp;
    int width, height, x1, y1, x2, y2;
    Color c;
    //Rectangle sh1;Oval sh2;Line sh3;
    boolean isDragged, isDotted, isFilled;
    SelectShape s;


    public MyPanel() {


        this.setBackground(Color.white);
        setLayout(null);

        this.setVisible(true);

        isDragged = false;
        isDotted = false;
        isFilled = false;
        allshapes = new ArrayList<>();
        temp = new ArrayList<>();


        red = new JButton("RED");
        blue = new JButton("Blue");
        black = new JButton("Black");
        red.setBounds(10, 10, 90, 50);
        blue.setBounds(10, 70, 90, 50);
        black.setBounds(10, 130, 90, 50);
        red.setBackground(Color.red);
        blue.setBackground(Color.BLUE);
        black.setBackground(Color.BLACK);

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.red;

            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.blue;

            }
        });

        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.black;

            }
        });

        rectangle = new JButton("rectangle");
        oval = new JButton("oval");
        line = new JButton("line");
        eraser = new JButton("eraser");
        dotted = new Checkbox("dotted");
        filled = new Checkbox("filled");
        delete = new JButton("delete");
        freehand = new JButton("Free");

        rectangle.setBounds(10, 190, 90, 50);
        oval.setBounds(10, 250, 90, 50);
        line.setBounds(10, 310, 90, 50);
        eraser.setBounds(10, 370, 90, 50);
        dotted.setBounds(10, 430, 90, 50);
        filled.setBounds(10, 490, 90, 50);
        delete.setBounds(10, 550, 90, 50);
        freehand.setBounds(10, 610, 90, 50);
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sh1=new Rectangle();
                s = SelectShape.Rectangle;
            }
        });


        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sh1=new Rectangle();
                s = SelectShape.Oval;
            }
        });


        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //sh1=new Rectangle();
                s = SelectShape.Line;
            }
        });
        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = SelectShape.Eraser;
            }
        });
        freehand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = SelectShape.Freehand;
            }
        });
        filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    isFilled = true;
                } else isFilled = false;
            }
        });
        dotted.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    isDotted = true;
                } else isDotted = false;
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp.clear();
                allshapes = temp;
                repaint();
            }
        });
        this.add(red);
        this.add(black);
        this.add(blue);
        this.add(rectangle);
        this.add(oval);
        this.add(line);
        this.add(eraser);
        this.add(filled);
        this.add(dotted);
        this.add(delete);
        this.add(freehand);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (s == SelectShape.Line) {
                    p1 = e.getPoint();
                    isDragged = false;
                    updateUI();
                }
                if (s == SelectShape.Rectangle || s == SelectShape.Oval) {
                    x1 = e.getX();
                    y1 = e.getY();
                    x2 = e.getX();
                    y2 = e.getX();
                    isDragged = false;
                    updateUI();
                }
                if (s == SelectShape.Eraser) {
                    allshapes.add(new Eraser(e.getPoint()));
                    isDragged = true;
                }
                if (s == SelectShape.Freehand) {

                    allshapes.add(new FreeHand(e.getPoint(),c));
                    isDragged = true;
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (s == SelectShape.Line) {

                    x2 = e.getX();
                    y2 = e.getY();
                    allshapes.add(new Line(p1,p2,c,isDotted));
                    isDragged = false;
                    repaint();
                }
                if (s == SelectShape.Rectangle) {
                    fp = new Point(Math.min(x1, x2), Math.min(y1, y2));
                    width = Math.abs(x1 - x2);
                    height = Math.abs(y1 - y2);

                    allshapes.add(new Rectangle(fp, width, height, c, isFilled, isDotted));
                    isDragged = false;
                    repaint();
                }
                if (s == SelectShape.Oval) {
                    fp = new Point(Math.min(x1, x2), Math.min(y1, y2));
                    width = Math.abs(x1 - x2);
                    height = Math.abs(y1 - y2);

                    allshapes.add(new Oval(fp, width, height, c, isDotted, isFilled));
                    isDragged = false;
                    repaint();
                }


            }

            @Override
            public void mouseEntered(MouseEvent e) {


            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (s == SelectShape.Line) {
                    p2=e.getPoint();
                    isDragged = true;
                    updateUI();
                }
                if (s == SelectShape.Rectangle || s == SelectShape.Oval) {
                    x2 = e.getX();
                    y2 = e.getY();
                    isDragged = true;
                    updateUI();
                }
                if (s == SelectShape.Eraser) {
                    allshapes.add(new Eraser(e.getPoint()));
                    isDragged = true;
                    updateUI();

                }
                if (s == SelectShape.Freehand) {

                    allshapes.add(new FreeHand(e.getPoint(),c));
                    isDragged = true;
                    updateUI();
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }


    public void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;


        for (Shape sha : allshapes) {
            g.setColor(sha.getColor());
            if (sha.isDotted()) {
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, new float[]{9}, 0));
            } else
                g2d.setStroke(new BasicStroke(0));
            if (sha instanceof Line) {

                //g.drawLine(x1, y1, x2, y2);
                 g.drawLine(((Line) sha).getP1().x, ((Line) sha).getP1().y, ((Line) sha).getP2().x, ((Line) sha).getP2().y);
            }
            if (sha instanceof Rectangle) {
                if (((Rectangle) sha).isFilled())
                    g.fillRect(((Rectangle) sha).getStartPoint().x, ((Rectangle) sha).getStartPoint().y, ((Rectangle) sha).getWidth(), ((Rectangle) sha).getHeight());
                else
                    g.drawRect(((Rectangle) sha).getStartPoint().x, ((Rectangle) sha).getStartPoint().y, ((Rectangle) sha).getWidth(), ((Rectangle) sha).getHeight());
            }
            if (sha instanceof Oval) {
                if (((Oval) sha).isFilled()) {
                    g.fillOval(((Oval) sha).getStartPoint().x, ((Oval) sha).getStartPoint().y, ((Oval) sha).getWidth(), ((Oval) sha).getHeight());
                } else
                    g.drawOval(((Oval) sha).getStartPoint().x, ((Oval) sha).getStartPoint().y, ((Oval) sha).getWidth(), ((Oval) sha).getHeight());

            }
            if (sha instanceof Eraser) {
                g.fillRect(((Eraser) sha).startPoint.x, ((Eraser) sha).startPoint.y, ((Eraser) sha).getWidth(), ((Eraser) sha).getHeight());
            }


        /*if(isDragged)
        {
            g.setColor(c);
            if(isDotted)
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10,  new float[]{9}, 0));
            else
                g2d.setStroke(new BasicStroke(0));
            if(s == SelectShape.Line)
                g.drawLine( x1,  y1, x2,  y2);
            if(isFilled)
            {
                if(s == SelectShape.Rectangle)
                    g.fillRect(Math.min(x1, x2),Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2)) ;
                if(s == SelectShape.Oval)
                    g.fillOval(Math.min(x1, x2),Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2)) ;
            }
            else
            {
                if(s == SelectShape.Rectangle)
                    g.drawRect(Math.min(x1, x2),Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2)) ;
                if(s == SelectShape.Oval)
                    g.drawOval(Math.min(x1, x2),Math.min(y1, y2),Math.abs(x1-x2),Math.abs(y1-y2)) ;
            }
        }*/


        }
    }
}
