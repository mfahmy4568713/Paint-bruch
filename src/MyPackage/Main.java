package MyPackage;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
                JFrame f = new JFrame();
                f.setTitle("Painter");
                f.setSize(2000,2000);
                MyPanel mp =new MyPanel();

                f.setContentPane(mp);
                f.setVisible(true);
                mp.setBackground(Color.black);
            }
        }