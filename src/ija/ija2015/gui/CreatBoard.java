package ija.ija2015.gui;

import ija.ija2015.actions.HelpRules;
import ija.ija2015.actions.LoadGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.Player;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.actions.SaveGame;
import java.awt.Toolkit;
import ija.ija2015.gui.colorDisk; 
import ija.ija2015.gui.FieldGUI;

public class CreatBoard implements MouseListener{
	JFrame BoardWindow;
	JPanel board;
	FieldGUI square[][];
	JLabel hrac;
	JLabel skore;
	JLabel errOutput;	//Vystup pro zadane chybne pole
	JLabel countOfDisksW;
	JLabel countOfDisksB;

	
	JPanel infoPanel;
    JMenuBar menuBar;
	private Game hra;
	private int size;
	private int countW;
	private int countB;
	final private int stackCount;
	private LoadGame loader;
	
	public CreatBoard(int sizeBoard, boolean computer, Game game) {
		this.size=sizeBoard;
		stackCount=sizeBoard*sizeBoard;
		BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		infoPanel=new JPanel();
		errOutput=new JLabel("");
		countOfDisksW=new JLabel("");
		countOfDisksB=new JLabel("");
		
		if(sizeBoard==6){
			BoardWindow.setSize(700, 500);
			infoPanel.setPreferredSize(new Dimension(200, 350));
		}
		else if(sizeBoard==8){
			BoardWindow.setSize(800, 600);
			infoPanel.setPreferredSize(new Dimension(200, 400));
		}
		else if(sizeBoard==10){
			BoardWindow.setSize(900, 700);
			infoPanel.setPreferredSize(new Dimension(200, 400));
		}
		else{
			BoardWindow.setSize(1000, 800);
			infoPanel.setPreferredSize(new Dimension(200, 400));
		}
			
			
		BoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BoardWindow.setLayout(new FlowLayout());
		BoardWindow.setVisible(true);
		board=new JPanel();
		hrac=new JLabel("");
		BoardWindow.add(board);
		
		
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		infoPanel.setVisible(true);
		
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
                	loader=new LoadGame(BoardWindow);
                   
                });
              
                JMenuItem save = new JMenuItem("Uložit hru");
                file.add(save);
                save.addActionListener((ActionEvent e) -> {
                	new SaveGame().saveGame(hra);
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
		//board.setPreferredSize(new Dimension(500, 500));
		board.setBounds(0, 0, sizeBoard, sizeBoard);
		square=new FieldGUI[sizeBoard][sizeBoard];
		Color colorOfField=new Color(81, 191, 81);
		for(int i=0;i<size; i++) 
			for(int j=0; j<size; j++)
			{		
				square[i][j]=new FieldGUI();
				square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				square[i][j].setBackground(colorOfField);
				board.add(square[i][j]);
			}
		
		BoardWindow.add(new JPanel());
		infoPanel.add(hrac, BorderLayout.PAGE_END);
		infoPanel.add(errOutput, BorderLayout.LINE_END);
		infoPanel.add(countOfDisksW, BorderLayout.LINE_END);
		infoPanel.add(countOfDisksB, BorderLayout.LINE_END);
		BoardWindow.add(infoPanel, FlowLayout.LEFT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		BoardWindow.setLocation(dim.width/2-BoardWindow.getSize().width/2, dim.height/2-BoardWindow.getSize().height/2);
		
		if(game==null)
			this.playGame();
		else
			this.playLoadGame(game);
		
	}
	/**
	 * Funkce pro aktualizaci desky a kamenu na desce
	 * @param hra
	 */
	public void updateBoard(Game hra)
	{
		countW=0;
		countB=0;
		for(int i=0; i<this.size; i++)
			for(int j=0; j<this.size; j++)
			{
				if(!(hra.getBoard().getField(i, j).isEmpty())){
					if(hra.getBoard().getField(i, j).getDisk().isWhite())
					{
						this.square[i][j].putImgDisk(colorDisk.WHITE);	
						countW++;
					}
					else{
						this.square[i][j].putImgDisk(colorDisk.BLACK);
						countB++;
					}
				}
			}
	}
	
	public void playLoadGame(Game hra)
	{
		this.hra=hra;
		board.addMouseListener(this);
		


		if(hra.currentPlayer().isWhite())
			hrac.setText("Hrac na tahu: Bily");
		else
			hrac.setText("Hrac na tahu: Cerny");
		this.updateBoard(hra);
		countOfDisksW.setText("K dispozici bily: "+(stackCount-countW));
		countOfDisksB.setText("K dispozici cerny: "+(stackCount-countB));
	}
	/**
	 * Funkce pro inicializaci hry
	 */
	public void playGame()
	{
		board.addMouseListener(this);
		ReversiRules pravidla=new ReversiRules(this.size+2);
		Board deska=new Board(pravidla);
		hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		hra.nextPlayer();
		if(hra.currentPlayer().isWhite())
			hrac.setText("Hrac na tahu: Bily");
		else
			hrac.setText("Hrac na tahu: Cerny");
		this.updateBoard(hra);
		countOfDisksW.setText("K dispozici bily: "+(stackCount-countW));
		countOfDisksB.setText("K dispozici cerny: "+(stackCount-countB));
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO Vytvorit i pro ostatni velikosti desek, jen souradnice.
			int i=e.getY()/63;
			int j=e.getX()/63;
			colorDisk actual;
			System.out.println("i je: "+i);
			System.out.println("j je: "+j);
				
			if(hra.currentPlayer().isWhite()){
				actual=colorDisk.WHITE;
			}				
			else{
				actual=colorDisk.BLACK;
			}
			
			if(hra.currentPlayer().canPutDisk(hra.getBoard().getField(i, j)))
			{
				errOutput.setText("");
				if(hra.currentPlayer().isWhite())
					hrac.setText("Hrac na tahu: Cerny");
				else
					hrac.setText("Hrac na tahu: Bily");
				square[i][j].putImgDisk(actual);
				hra.currentPlayer().putDisk(hra.getBoard().getField(i, j));
				this.updateBoard(this.hra);
				hra.nextPlayer();
			}
			else{
				errOutput.setText("Neplatne pole");
				//this.updateBoard(this.hra);
				
			}
			countOfDisksW.setText("K dispozici bily: "+(stackCount-countW));
			countOfDisksB.setText("K dispozici cerny: "+(stackCount-countB));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}



