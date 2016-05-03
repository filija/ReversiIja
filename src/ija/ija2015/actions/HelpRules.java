package ija.ija2015.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class HelpRules {
    
    public HelpRules() {
        
        JFrame frame = new JFrame("Reversi play"); 	//frame hraciho pole
	frame.setSize(600, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
        
        JButton close = new JButton("Zavřít napovědu");
        close.setBounds(100, 200, 150, 50);
        close.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        frame.getContentPane().add(close);
    }
}