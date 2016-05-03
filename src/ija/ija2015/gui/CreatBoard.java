package ija.ija2015.gui;

import ija.ija2015.actions.HelpRules;
import ija.ija2015.actions.LoadGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.*;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.Player;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.actions.SaveGame;
import java.awt.Toolkit;
import javax.swing.border.Border;
import ija.ija2015.gui.colorDisk; 
import ija.ija2015.gui.FieldGUI;

public class CreatBoard{
	JFrame BoardWindow;
	JPanel board;
	FieldGUI square[][];
	JLabel popisek;
    JMenuBar menuBar;
	private Game hra;
	private ImageIcon white;
	private ImageIcon black;
	private int size;
	
	CreatBoard(int sizeBoard, boolean computer) {
		this.size=sizeBoard;
		BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		BoardWindow.setSize(600, 600);
		BoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BoardWindow.setLayout(new FlowLayout());
		BoardWindow.setVisible(true);
		board=new JPanel();
		popisek=new JLabel("Hrac: ");
		BoardWindow.add(board);
		
                JMenuBar menuBar = new JMenuBar();
                BoardWindow.setJMenuBar(menuBar);
                
                JMenu file = new JMenu("Soubor");
                menuBar.add(file);
                JMenuItem newGame = new JMenuItem("Nová hra");
                file.add(newGame);
                newGame.addActionListener((ActionEvent e) -> {
                    BoardWindow.dispose();
                    new NewGameMenu();
                });
                JMenuItem load = new JMenuItem("Načíst hru");
                file.add(load);
                load.addActionListener((ActionEvent e) -> {
                    new LoadGame(BoardWindow);
                });
                JMenuItem save = new JMenuItem("Uložit hru");
                file.add(save);
                save.addActionListener((ActionEvent e) -> {
                    new SaveGame(hra);
                });
                JMenuItem exit = new JMenuItem("Konec");
                file.add(exit);
                exit.addActionListener((ActionEvent e) -> {
                    BoardWindow.dispose();
                });
		
                JMenu help = new JMenu("Nápověda");
                menuBar.add(help);
                JMenuItem rules = new JMenuItem("Pravidlá hry");
                help.add(rules);
                rules.addActionListener((ActionEvent e) -> {
                    new HelpRules();
                });
                JMenuItem about = new JMenuItem("O aplikaci");
                help.add(about);

                
		board.setLayout(new GridLayout(sizeBoard, sizeBoard));
		board.setPreferredSize(new Dimension(500, 500));
		board.setBounds(0, 0, sizeBoard, sizeBoard);
		
		square=new FieldGUI[sizeBoard][sizeBoard];
		for(int i=0;i<sizeBoard; i++) 
			for(int j=0; j<sizeBoard; j++)
			{			                   
				square[i][j]=new FieldGUI();
				square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				square[i][j].setBackground(Color.green);		
				square[i][j].addMouseListener(square[i][j]);
				board.add(square[i][j]);	
				BoardWindow.add(new JPanel());
				BoardWindow.add(popisek);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				BoardWindow.setLocation(dim.width/2-BoardWindow.getSize().width/2, dim.height/2-BoardWindow.getSize().height/2);
		}
		
		this.playGame();

	}

	/**
	 * Funkce pro inicializaci a prubeh hry
	 */
	public void playGame()
	{
		ReversiRules pravidla=new ReversiRules(this.size);
		Board deska=new Board(pravidla);
		Game hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		
	  for(int k=0; k<10; k++)
	  {
		for(int i=0; i<this.size; i++)
			for(int j=0; j<this.size; j++)
			{
				if(!(hra.getBoard().getField(i, j).isEmpty())){
					if(hra.getBoard().getField(i, j).getDisk().isWhite())
					{
						this.square[i][j].putImgDisk(colorDisk.WHITE);
						hra.currentPlayer().putDisk(deska.getField(i, j));
						continue;
					}
					else{
						this.square[i][j].putImgDisk(colorDisk.BLACK);
						hra.currentPlayer().putDisk(deska.getField(i, j));
						continue;
					}
				}
				
					if(hra.currentPlayer().isWhite())
						square[i][j].setPlayerOnMove(colorDisk.WHITE);
					else
						square[i][j].setPlayerOnMove(colorDisk.BLACK);
					
					//square[i][j].addMouseListener(square[i][j]);
			}
			hra.nextPlayer();
	   }
	}
}