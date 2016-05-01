package ija.ija2015.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.Player;
import ija.ija2015.homework2.game.ReversiRules;

public class CreatBoard{
	JFrame BoardWindow;
	JPanel board;
	JPanel square[][];
	JLabel popisek;
	private ReversiRules pravidla;
	private Board deska;
	private Game hra;
	private Player bily;
	private Player cerny;
	private int size;
	
	CreatBoard(int sizeBoard, boolean computer){
		this.size=sizeBoard;
		BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		BoardWindow.setSize(600, 600);
		BoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BoardWindow.setLayout(new FlowLayout());
		BoardWindow.setVisible(true);
		board=new JPanel();
		popisek=new JLabel("Hrac: ");
		BoardWindow.add(board);
		
		JPanel square;
		
		board.setLayout(new GridLayout(sizeBoard, sizeBoard));
		board.setPreferredSize(new Dimension(500, 500));
		board.setBounds(0, 0, sizeBoard, sizeBoard);
		
		/*Vytvoreni hry+inicializace*/
		pravidla=new ReversiRules(sizeBoard);
		deska=new Board(pravidla);
		hra=new Game(deska);
		bily=new Player(true);
		cerny=new Player(false);
		hra.addPlayer(cerny);
		hra.addPlayer(bily);
		bily.init(deska);
		cerny.init(deska);
		/*Konec vytvareni hry a inicializace*/
		
		for(int i=0;i<sizeBoard*sizeBoard; i++)
		{
			int row=i/sizeBoard;
			int col=i%sizeBoard;
			square=new JPanel();
			
			square=new JPanel(new BorderLayout());
			square.setBorder(BorderFactory.createLineBorder(Color.black));
			
				if(deska.getField(row, col).isEmpty()){
					square.setBackground(Color.green);
					board.add(square);
				}
				else{
					if(deska.getField(row, col).getDisk().isWhite())
					{
						square.setBackground(Color.white);
						board.add(square);
					}
					else{
						square.setBackground(Color.black);
						board.add(square);
					}
				}
				
			
		}
		
		BoardWindow.add(new JPanel());
		BoardWindow.add(popisek);
	}
	
	public void PlayGame(){
		System.out.println("Hra zacina");

	}
	
	
	
}
