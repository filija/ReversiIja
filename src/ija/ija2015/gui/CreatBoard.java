package ija.ija2015.gui;

import ija.ija2015.actions.HelpRules;
import ija.ija2015.actions.LoadGame;
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
	JLabel popisek;
	JLabel hrac;
    JMenuBar menuBar;
	private Game hra;
	private int size;
	
	CreatBoard(int sizeBoard, boolean computer) {
		this.size=sizeBoard;
		BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		BoardWindow.setSize(600, 600);
		BoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                BoardWindow.setLayout(new FlowLayout());
		BoardWindow.setVisible(true);
		board=new JPanel();
		popisek=new JLabel("");
		hrac=new JLabel("");
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
		square=new FieldGUI[sizeBoard+1][sizeBoard+1];
		
		for(int i=0;i<size; i++) 
			for(int j=0; j<size; j++)
			{		
		
					square[i][j]=new FieldGUI();
					square[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					square[i][j].setBackground(Color.green);
					board.add(square[i][j]);
				
			}
		
		BoardWindow.add(new JPanel());
		BoardWindow.add(popisek);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		BoardWindow.setLocation(dim.width/2-BoardWindow.getSize().width/2, dim.height/2-BoardWindow.getSize().height/2);
		BoardWindow.add(hrac);
		
		this.playGame();

	}
	/**
	 * Funkce pro aktualizaci desky a kamenu na desce
	 * @param hra
	 */
	public void updateBoard(Game hra)
	{
		for(int i=0; i<this.size; i++)
			for(int j=0; j<this.size; j++)
			{
				if(!(hra.getBoard().getField(i, j).isEmpty())){
					if(hra.getBoard().getField(i, j).getDisk().isWhite())
					{
						this.square[i][j].putImgDisk(colorDisk.WHITE);							
					}
					else{
						this.square[i][j].putImgDisk(colorDisk.BLACK);
					}
				}
			}
		
	}
	
	/**
	 * Funkce pro inicializaci hry
	 */
	public void playGame()
	{
		board.addMouseListener(this);

		ReversiRules pravidla=new ReversiRules(this.size);
		Board deska=new Board(pravidla);
		hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		hra.nextPlayer();
		if(hra.currentPlayer().isWhite())
			System.out.println("Bily");
		else
			System.out.println("cerny");
		this.updateBoard(hra);
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
				square[i][j].putImgDisk(actual);
				hra.currentPlayer().putDisk(hra.getBoard().getField(i, j));
				this.updateBoard(this.hra);
				popisek.setText("");
				hra.nextPlayer();
			}
			else{
				popisek.setText("Neplatne policko");
				this.updateBoard(this.hra);
			}
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



