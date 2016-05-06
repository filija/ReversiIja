package ija.ija2015.gui;

import ija.ija2015.actions.LoadGame;
import ija.ija2015.actions.StartNewGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    
    private JFrame frame;
    
     public MainMenu() {
        //pismo
        Font font = new Font("Dialog", Font.PLAIN, 15);
         
        
        frame = new JFrame("Othello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 250, 350);
        frame.getContentPane().setLayout(null);
        frame.toFront();       
        
        JButton b1 = new JButton("New game");
        b1.setBounds(50, 50, 150, 50);
        b1.setFont(font);
        b1.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new NewGameMenu();
        });
        frame.getContentPane().add(b1);
        
        JButton b2 = new JButton("Load game");
        b2.setBounds(50, 125, 150, 50);
        b2.setFont(font);
        b2.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new LoadGame(frame);
        });
        frame.getContentPane().add(b2);
        
        JButton b3 = new JButton("Exit");
        b3.setBounds(50, 200, 150, 50);
        b3.setFont(font);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            }
        });
        frame.getContentPane().add(b3);
        
        frame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
}