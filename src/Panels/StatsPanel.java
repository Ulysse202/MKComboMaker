package Panels;

import partPackage.Part;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StatsPanel extends JPanel {
    private int[] stats;
    private Part character,vehicle,tires,glider;
    private BufferedImage[] gauges;
    private JLabel[] labels;

    public StatsPanel(Part character,Part vehicle,Part tires,Part glider){
        stats = new int[14];
        gauges = new BufferedImage[21];
        try{
            for(int i =0;i<21;i++){
                gauges[i] = ImageIO.read(new File("src/images/gauge/gauge"+i+".png"));
            }
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
        this.character = character;
        this.vehicle = vehicle;
        this.tires = tires;
        this.glider = glider;
        setStats();
        this.setVisible(true);
        this.setBounds(800,200,400,400);
    }


    //resets the stats for each combo and changes the gauges
    public void resetStat(Part newPart){
        switch(newPart.getPartType()){
            case "characters":
                character = newPart;
                break;
            case "vehicles":
                vehicle = newPart;
                break;
            case "tires":
                tires = newPart;
                break;
            case "gliders":
                glider = newPart;
        }
        setStats();
        repaint();
    }

    //sets the stats for the given combo
    private void setStats(){
        for(int i =0;i<14;i++){
            stats[i] = character.getStat(i) + vehicle.getStat(i) + tires.getStat(i) + glider.getStat(i);
        }
    }

    //paints the gauges
    @Override
    public void paintComponent(Graphics g){
        for(int i = 0;i<14;i++){
            g.drawImage(gauges[stats[i]],0,(i*28),this);
        }
    }
}
