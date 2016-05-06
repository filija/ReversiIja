package ija.ija2015.actions;

import ija.ija2015.gui.CreatBoard;
import ija.ija2015.homework2.game.Game;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadGame {
	 Game game;
    public  LoadGame(JFrame frame) {
       
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Saves (.save)", "save");
        fileChooser.setFileFilter(filter);
        
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION || returnVal == JFileChooser.ERROR_OPTION){
            return;
        }

        File savedFile = fileChooser.getSelectedFile();

        try {
            FileInputStream loadFile = new FileInputStream(savedFile);
            ObjectInputStream load = new ObjectInputStream(loadFile);
            
            game = (Game) load.readObject();
            System.out.println(game);
            
            load.close();
        } catch (Exception exc){
            JOptionPane.showMessageDialog(frame, "Cant open selected file");
            return;
        }

        frame.setVisible(false);
        frame.dispose();
        
        new CreatBoard(game.getBoard().getSize()-2, true).updateBoard(game);
    }
    
    public Game getLoadGame(){
    	return this.game;
    	
    }
}
