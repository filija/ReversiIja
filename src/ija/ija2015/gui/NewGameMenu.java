
package ija.ija2015.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameMenu extends JFrame{
    private JFrame frame;
    
    Font font = new Font("Dialog", Font.PLAIN, 15);
         
    public NewGameMenu() {
        
        frame = new JFrame("Othello - New Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 300);
        frame.getContentPane().setLayout(null);
        frame.toFront();       
         
        
        
        JLabel lblBoardSize = new JLabel();
        lblBoardSize.setBounds(30, 30, 200, 150);
        frame.getContentPane().add(lblBoardSize);
        
        JLabel lblNumberOfPlayers = new JLabel();
        lblNumberOfPlayers.setBounds(30, 70, 200, 150);
        frame.getContentPane().add(lblNumberOfPlayers);
        
        JRadioButton r1 = new JRadioButton("6x6");
        r1.setActionCommand("6");
        JRadioButton r2 = new JRadioButton("8x8", true);
        r2.setActionCommand("8");
        JRadioButton r3 = new JRadioButton("10x10");
        r3.setActionCommand("10");
        JRadioButton r4 = new JRadioButton("12x12");
        r4.setActionCommand("12");
        
        JRadioButton r5 = new JRadioButton("Computer", true);
        r5.setActionCommand("computer");
        JRadioButton r6 = new JRadioButton("Player");
        r6.setActionCommand("player");
        
        ButtonGroup boardSizeGroup = new ButtonGroup();
        boardSizeGroup.add(r1);
        boardSizeGroup.add(r2);
        boardSizeGroup.add(r3);   
        boardSizeGroup.add(r4); 
        
        ButtonGroup playerGroup = new ButtonGroup();
        playerGroup.add(r5);
        playerGroup.add(r6);
        
        lblBoardSize.setLayout( new FlowLayout());
        lblBoardSize.setText("Board Size:");
        lblBoardSize.setSize(400, 30);
        lblBoardSize.add(r1);
        lblBoardSize.add(r2);
        lblBoardSize.add(r3);
        lblBoardSize.add(r4);
        frame.setVisible(true);
        
        lblNumberOfPlayers.setLayout( new FlowLayout());
        lblNumberOfPlayers.setText("Versus:");
        lblNumberOfPlayers.setSize(400, 30);
        lblNumberOfPlayers.add(r5);
        lblNumberOfPlayers.add(r6);
        
        JButton b1 = new JButton("Start Game");
        b1.setBounds(100, 120, 150, 50);
        b1.setFont(font);
        frame.getContentPane().add(b1);
        b1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){	//Vytvoreni desky po kliku na star game
        		CreatBoard start = null;
        		if(r1.isSelected()){
        			System.out.println("Je zvolena moznost 6");
        			start=new CreatBoard(6, r5.isSelected());
        		}
        		if(r2.isSelected()){
        			System.out.println("Je zvolena moznost 8");
        			start=new CreatBoard(8, r5.isSelected());
        		}
        		if(r3.isSelected()){
        			System.out.println("Je zvolena moznost 10");
        			start=new CreatBoard(10, r5.isSelected());
        		}
        		if(r4.isSelected()){
        			System.out.println("Je zvolena moznost 12");
        			start=new CreatBoard(12, r5.isSelected());
        		}
        		frame.dispose();
        		start.PlayGame(); //Hra zacina
        	}
        });
        
        JButton b3 = new JButton("Exit");
        b3.setBounds(100, 200, 150, 50);
        b3.setFont(font);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            }
        });
        frame.getContentPane().add(b3);
        
     
    }
}
