package Panels;

import partPackage.Part;

import javax.swing.*;
import java.awt.*;

public class myButton extends JButton {

    private Part part;
    private JLabel label;
    private ImageIcon ii;

    public myButton(Part p){
        part = p;
        ii =  p.getIcon();
        label = new JLabel();
        label.setIcon(ii);
        this.add(label);
    }

    public void resetIcon(Part p){
        part = p;
        ii=part.getIcon();
        label.setIcon(ii);
    }

    public ImageIcon fetchIcon() {return ii;}

    public Part getPart(){return part;}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Image scaledImage = ii.getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH);
        g.drawImage(scaledImage,0,0,this);
    }
}
