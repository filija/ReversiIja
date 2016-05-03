package ija.ija2015.actions;

import ija.ija2015.homework2.game.Game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/*
 * Uložení hry
 */
public class SaveGame {
    String fileName;
    JFrame frame = new JFrame("Save Game");
    JPanel panel = new JPanel();
    JTextField textfield = new JTextField("", 10);
    JButton button = new JButton("Save");

    public SaveGame(Game game) {
	panel.add(textfield);
	panel.add(button);
	frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
        
        button.addActionListener((ActionEvent e) -> {
            fileName = textfield.getText();
            frame.dispose();
            JFrame newframe = new JFrame("Save");
            newframe.add(panel);
            newframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            try {
                FileOutputStream saveFile = new FileOutputStream(fileName + ".save");
                ObjectOutputStream save = new ObjectOutputStream(saveFile);
                save.writeObject(game);
                save.close();
            } catch (Exception exc){
                JOptionPane.showMessageDialog(newframe, "Error while saving file.");
                return;
            }
            JOptionPane.showMessageDialog(newframe, "Game saved");
        });    
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

    }    
}
