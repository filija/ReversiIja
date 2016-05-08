package ija.ija2015.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameMenu extends JFrame{
    private JFrame frame;
    
    Font font = new Font("Dialog", Font.PLAIN, 15);
    private CreatBoard start = null;
    public NewGameMenu() {
        
        frame = new JFrame("Othello - New Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 400, 450);
        frame.getContentPane().setLayout(null);
        frame.toFront();       
         
        
        
        JLabel lblBoardSize = new JLabel();
        lblBoardSize.setBounds(30, 30, 200, 150);
        frame.getContentPane().add(lblBoardSize);
        
        JLabel lblNumberOfPlayers = new JLabel();
        lblNumberOfPlayers.setBounds(30, 70, 200, 150);
        frame.getContentPane().add(lblNumberOfPlayers);
        
        JRadioButton r1 = new JRadioButton("6x6");
        JRadioButton r2 = new JRadioButton("8x8", true);
        JRadioButton r3 = new JRadioButton("10x10");
        JRadioButton r4 = new JRadioButton("12x12");
        
        JRadioButton r5 = new JRadioButton("Player", true);
        JRadioButton r6 = new JRadioButton("Computer1");
        JRadioButton r7 = new JRadioButton("Computer2");
        
        JPanel checkBoxPanel = new JPanel();
        JCheckBox checkBox = new JCheckBox("Zamrzaní");
        checkBox.setSelected(false);
        checkBoxPanel.add(checkBox);
        checkBoxPanel.setSize(100, 200);
        checkBoxPanel.setBounds(30, 120, 300, 50);
        
        JTextField i = new JTextField("");
        i.setColumns(3);
        checkBoxPanel.add(i);
        JTextField b = new JTextField("");
        b.setColumns(3);
        checkBoxPanel.add(b);
        JTextField c = new JTextField("");
        c.setColumns(3);
        checkBoxPanel.add(c);
        frame.add(checkBoxPanel);
        
        
        ButtonGroup boardSizeGroup = new ButtonGroup();
        boardSizeGroup.add(r1);
        boardSizeGroup.add(r2);
        boardSizeGroup.add(r3);   
        boardSizeGroup.add(r4); 
        
        ButtonGroup playerGroup = new ButtonGroup();
        playerGroup.add(r5);
        playerGroup.add(r6);
        playerGroup.add(r7);
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
        lblNumberOfPlayers.add(r7);
        
        JButton b1 = new JButton("Start Game");
        b1.setBounds(115, 250, 150, 50);
        b1.setFont(font);
        frame.getContentPane().add(b1);
        b1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){	//Vytvoreni desky po kliku na start game
        		
                        //zamrzani desky je nastaveno
                        boolean checked = checkBox.isSelected();
                        int I=0;
                    	int B=0;
                    	int C=0;
                        //i.getText() - ziskas obsah i
                        if(checked){
                        	try{
                        	I=Integer.parseInt(i.getText());
                        	B=Integer.parseInt(b.getText());
                        	C=Integer.parseInt(c.getText());
                        	}
                        	catch(NumberFormatException exc){
                        		System.out.println("Vyplnte vsechna pole");
                        		return;
                        	}
                        }
                   
                        //b.getText()
                        //c.getText()

                        
        		if(r1.isSelected()){
        			System.out.println("Je zvolena moznost 6");
                                if (r5.isSelected()) {
                                    start=new CreatBoard(6, 0, null, I, B, C, checked);
                                } else if (r6.isSelected()) {
                                    start=new CreatBoard(6, 1, null, I, B, C, checked);
                                } else {
                                    start=new CreatBoard(6, 2, null, I, B, C, checked);
                                }
        		}
        		if(r2.isSelected()){
        			System.out.println("Je zvolena moznost 8");
        			if (r5.isSelected()) {
                                    start=new CreatBoard(8, 0, null, I, B, C, checked);
                                } else if (r6.isSelected()) {
                                    start=new CreatBoard(8, 1, null, I, B, C, checked);
                                } else {
                                    start=new CreatBoard(8, 2, null, I, B, C, checked);
                                }
        		}
        		if(r3.isSelected()){
        			System.out.println("Je zvolena moznost 10");
        			if (r5.isSelected()) {
                                    start=new CreatBoard(10, 0, null, I, B, C, checked);
                                } else if (r6.isSelected()) {
                                    start=new CreatBoard(10, 1, null, I, B, C, checked);
                                } else {
                                    start=new CreatBoard(10, 2, null, I, B, C, checked);
                                }
        		}
        		if(r4.isSelected()){
        			System.out.println("Je zvolena moznost 12");
        			if (r5.isSelected()) {
                                    start=new CreatBoard(12, 0, null, I, B, C, checked);
                                } else if (r6.isSelected()) {
                                    start=new CreatBoard(12, 1, null, I, B, C, checked);
                                } else {
                                    start=new CreatBoard(12, 2, null, I, B, C, checked);
                                }
        		}
        		
        		frame.dispose();
        	}
        });
        
        JButton b3 = new JButton("Exit");
        b3.setBounds(115, 320, 150, 50);
        b3.setFont(font);
        b3.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        frame.getContentPane().add(b3);
        
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }
    
}