package Panels;

import partPackage.Part;

import javax.swing.*;
import java.awt.*;

public class myButton extends JButton {

    private Part part;
    private ImageIcon ii;

    public myButton(Part p){
        part = p;
        ii =  p.getIcon();
        repaint();
    }

    public void resetIcon(Part p){
        part = p;
        ii=part.getIcon();

    }

    public ImageIcon fetchIcon() {return ii;}

    public Part getPart(){return part;}

    @Override
    public void paintComponent(Graphics g){
        Image scaledImage = ii.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        super.paintComponent(g);

    }
}
