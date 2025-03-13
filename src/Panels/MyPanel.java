package Panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import partPackage.Part;

public class MyPanel extends JPanel {
    BufferedImage background = null;

    myButton characters,vehicles,tires,gliders;

    selectionPanel characterSelection,vehicleSelection, tireSelection,gliderSelection;

    StatsPanel statsPanel;

    public MyPanel(Part[] c, Part[] v, Part[] t, Part[] g) {


        try {
            background = ImageIO.read(new File("src/images/Background.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setPreferredSize(new Dimension(background.getWidth(), background.getHeight()));
        this.setLayout(null);
        
        //extentiating all of the JButtons
        characters = new myButton(c[4]);
        vehicles = new myButton(v[16]);
        tires = new myButton(t[2]);
        gliders = new myButton(g[13]);

        statsPanel = new StatsPanel(c[4],v[16],t[2],g[13]);
        this.add(statsPanel);

        //setting the bounds of each button
        characters.setBounds(20,150,110,110);
        vehicles.setBounds(140,150,110,110);
        tires.setBounds(260,150,110,110);
        gliders.setBounds(380,150,110,110);

        characterSelection = new selectionPanel(c,characters,statsPanel);
        vehicleSelection = new selectionPanel(v,vehicles,statsPanel);
        tireSelection = new selectionPanel(t,tires,statsPanel);
        gliderSelection = new selectionPanel(g,gliders,statsPanel);

        this.add(characterSelection);
        this.add(vehicleSelection);
        this.add(tireSelection);
        this.add(gliderSelection);

        //Setting the action listeners
        characters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleSelection.setVisible(false);
                tireSelection.setVisible(false);
                gliderSelection.setVisible(false);
                characterSelection.setVisible(true);
            }
        });
        vehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tireSelection.setVisible(false);
                gliderSelection.setVisible(false);
                characterSelection.setVisible(false);
                vehicleSelection.setVisible(true);
            }
        });
        tires.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleSelection.setVisible(false);
                gliderSelection.setVisible(false);
                characterSelection.setVisible(false);
                tireSelection.setVisible(true);
            }
        });
        gliders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicleSelection.setVisible(false);
                tireSelection.setVisible(false);
                characterSelection.setVisible(false);
                gliderSelection.setVisible(true);
            }
        });

        //Adding the Buttons to the JPanel
        this.add(characters);
        this.add(vehicles);
        this.add(tires);
        this.add(gliders);

        //Showing the stats

    }


    //Used to paint the background for now
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }


}
