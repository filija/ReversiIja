package ija.ija2015.actions;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class HelpRules {
    
    public HelpRules() {
        
        JFrame frame = new JFrame("Help");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 350, 300);
        frame.getContentPane().setLayout(null);
        frame.toFront();       
        
        JButton closeButton = new JButton("Zavřít");
        closeButton.setBounds(150, 200, 50, 30);
        closeButton.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        frame.getContentPane().add(closeButton);
        frame.setVisible(true);
    }
}