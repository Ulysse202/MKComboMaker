package Panels;

import partPackage.Part;

import javax.swing.*;

public class myButton extends JButton {

    private Part part;
    private JLabel label;
    private ImageIcon ii;

    public myButton(Part p){
        part = p;
        ii =  p.getIcon();
        label = new JLabel();
        label.setIcon(p.getIcon());
        this.add(label);
    }

    public void resetIcon(Part p){
        part = p;
        label.setIcon(part.getIcon());
        ii = part.getIcon();
    }

    public ImageIcon fetchIcon() {return ii;}

    public Part getPart(){return part;}
}
