package Panels;

import javax.swing.*;
import partPackage.Part;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectionPanel extends JPanel implements ActionListener {

    myButton[] buttons;
    myButton caller;
    StatsPanel statsPanel;
    static final Dimension MIN_SIZE = new Dimension(20,20);
    static final Dimension MAX_SIZE = new Dimension(30,30);

    public selectionPanel(Part[] icons,myButton caller,StatsPanel statsDisplay){
        this.statsPanel = statsDisplay;
        this.caller = caller;
        buttons = new myButton[icons.length];
        initButtons(icons);
        this.setLayout(new GridLayout(6,10));
        this.setVisible(false);
        this.setBounds(20,280,470,300);
        for(myButton b : buttons){
            this.add(b);
        }
    }

    private void initButtons(Part[] icons){
        int i = 0;
        for(Part p : icons){
            this.buttons[i] = new myButton(p);
            this.buttons[i].setMinimumSize(MIN_SIZE);
            this.buttons[i].setMaximumSize(MAX_SIZE);
            this.buttons[i].setBorderPainted(false);
            this.buttons[i].setContentAreaFilled(false);
            this.buttons[i].setFocusPainted(false);
            this.buttons[i].addActionListener(this);
            i++;

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        myButton temp = (myButton) e.getSource();
        caller.resetIcon(temp.getPart());
        statsPanel.resetStat(temp.getPart());
        this.setVisible(false);
    }
}
