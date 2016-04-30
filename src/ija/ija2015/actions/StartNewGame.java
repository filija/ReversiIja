
package ija.ija2015.actions;

import ija.ija2015.gui.NewGameMenu;
import javax.swing.JFrame;
import java.awt.event.*;

public class StartNewGame{
    
    public void startNewGame(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        new NewGameMenu();
    }
}
