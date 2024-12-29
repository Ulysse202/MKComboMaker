import Panels.MyPanel;
import partPackage.Part;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Part[] characters = new Part[52];
        Part[] vehicle = new Part[41];
        Part[] tires = new Part[22];
        Part[] gliders = new Part[15];

        //init all fo the Part arrays
        try {
            int[] temp = new int[14];

            Scanner sc = new Scanner(new FileInputStream("src/InitFiles/CharacterStats.txt"));
            partArraySetter(sc,characters,temp,"characters");
            sc.close();;

            sc = new Scanner(new FileInputStream("src/InitFiles/VehicleStats.txt"));
            partArraySetter(sc,vehicle,temp,"vehicles");
            sc.close();;

            sc = new Scanner(new FileInputStream("src/InitFiles/TireStats.txt"));
            partArraySetter(sc,tires,temp,"tires");
            sc.close();;

            sc = new Scanner(new FileInputStream("src/InitFiles/GliderStats.txt"));
            partArraySetter(sc,gliders,temp,"gliders");
            sc.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JFrame jf = new JFrame();
        jf.setTitle("Mario Kart 8 Combos");
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        MyPanel mp = new MyPanel(characters,vehicle,tires,gliders);
        jf.add(mp);
        jf.pack();
    }

    private static void partArraySetter(Scanner sc, Part[] partsArray, int[] properties, String currentPackage){
        int i =0;
        while(sc.hasNextLine()){
            String[] splitLine = sc.nextLine().split(",");
            for(int j = 0;j<14;j++) properties[j] = Integer.parseInt(splitLine[j+1]);
            partsArray[i] = new Part(properties,splitLine[0],currentPackage);
            i++;
        }
    }

}