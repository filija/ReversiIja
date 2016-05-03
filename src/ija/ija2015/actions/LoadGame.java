package ija.ija2015.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadGame {

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
            load.close();
        } catch (Exception exc){
            JOptionPane.showMessageDialog(frame, "Cant open selected file");
            return;
        }

        frame.setVisible(false);
        frame.dispose();
    }
}
