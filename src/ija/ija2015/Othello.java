package ija.ija2015;

import ija.ija2015.gui.MainMenuFrame;

public class Othello {
 
    private MainMenuFrame mainMenuFrame;
    
    public static void main(String argv[]) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            startGame();
        });
    }

    private static void startGame() {
        new Othello();
    }

    public Othello(){
        this.mainMenuFrame = new MainMenuFrame();
    }
}