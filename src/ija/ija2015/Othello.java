package ija.ija2015;

import ija.ija2015.gui.MainMenu;
import javax.swing.*;

public class Othello {
 
    private MainMenu mainMenuFrame;
    
    public static void main(String argv[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
        	public void run(){
        		new Othello();
        	}
        });
    }

    public Othello(){
        this.mainMenuFrame = new MainMenu();
    }
}