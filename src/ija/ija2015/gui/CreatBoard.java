package ija.ija2015.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CreatBoard {
	CreatBoard(int sizeBoard, boolean computer){
		JFrame BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		BoardWindow.setSize(500, 500);
		BoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardWindow.setLayout(new FlowLayout());
		BoardWindow.setVisible(true);
		
		String hrac;
		if(computer)
			hrac="Pocitac";
		else
			hrac="Clovek";
		JLabel popisek=new JLabel("velikost desky je: "+ sizeBoard+ "Hra je proti: "+hrac);

		BoardWindow.add(new JPanel());
		BoardWindow.add(popisek);
	}
}
