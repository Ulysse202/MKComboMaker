package partPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Part {

    private int[] stats;
    private String name;
    private ImageIcon icon;
    private String partType;


    public Part(int[] properties,String name,String p){
        this.name = name;
        this.partType = p;
        stats = new int[14];
        this.icon = new ImageIcon("src/images/"+p+"/"+name+".png");
        Image image = icon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);

        int i = 0;
        for(int property : properties){
            this.stats[i] = property;
            i++;
        }
    }

    public Part(Part part){
        this.name = part.name;
        int i = 0;
        for(int property : part.stats){
            this.stats[i] = property;
            i++;
        }
    }

    public ImageIcon getIcon(){
        return this.icon;
    }

    public String getPartType(){ return partType; }

    public int getStat(int index) { return stats[index];}
}
