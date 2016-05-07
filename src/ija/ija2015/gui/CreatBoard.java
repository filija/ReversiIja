package ija.ija2015.gui;

import ija.ija2015.actions.AiAction;
import ija.ija2015.actions.HelpRules;
import ija.ija2015.actions.LoadGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.*;

import javax.swing.*;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.Player;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.actions.SaveGame;
import java.awt.Toolkit;
import ija.ija2015.gui.colorDisk; 
import ija.ija2015.gui.FieldGUI;

public class CreatBoard implements MouseListener, ActionListener{
	JFrame BoardWindow;
	JPanel board;
	FieldGUI square[][];
	JLabel hrac;
	JLabel skore;
	JLabel errOutput;	//Vystup pro zadane chybne pole
	JLabel countOfDisksW;
	JLabel countOfDisksB;
	JButton undo;
	
	JPanel infoPanel;
        JMenuBar menuBar;
	private Game hra;
	private int size;
	private int countW;
	private int countB;
	private int iterator;
	final private int stackCount;
	private Game prevGame[];
	private LoadGame loader;
        int AI;
	
	public CreatBoard(int sizeBoard, int computer, Game game) {
		this.size=sizeBoard;
                this.AI = computer;
		stackCount=sizeBoard*sizeBoard;
		prevGame=new Game[60];
		BoardWindow=new JFrame("Reversi play"); 	//frame hraciho pole
		infoPanel=new JPanel();
		errOutput=new JLabel("");
		countOfDisksW=new JLabel("");
		countOfDisksB=new JLabel("");
		undo=new JButton("UNDO");
		
		undo.setSize(new Dimension(10, 10));
		undo.setVisible(true);
		undo.addActionListener(this);
		
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
		infoPanel.add(undo, BorderLayout.PAGE_START);
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
            boolean boardFull = true;
            boolean noMoves = true;
            countW=0;
            countB=0;
            for(int i=0; i<this.size; i++) {
                for(int j=0; j<this.size; j++) {
                    if(!(hra.getBoard().getField(i, j).isEmpty())){
			if(hra.getBoard().getField(i, j).getDisk().isWhite()) {
                            this.square[i][j].putImgDisk(colorDisk.WHITE);	
                            countW++;
			} else {
                            this.square[i][j].putImgDisk(colorDisk.BLACK);
                            countB++;
			}
                    } else {
                        if (hra.currentPlayer().canPutDisk(hra.getBoard().getField(i, j))) {
                            noMoves = false;
                        }
                        boardFull = false;
                    }
                }
            }  
            if (noMoves || boardFull) {
                finishGame(hra);
            }

	}
        
        public void finishGame(Game game) {
            int size = game.getBoard().getSize();
            int score1 = game.getBoard().countBlack();
            int score2 = game.getBoard().countWhite();
            
            if (score1 > score2) {
                if ((score1 + score2) != (size-2)*(size-2)) {
                    score1 = (size-2)*(size-2) - score2; 
                }
                //skore.setText("Vyhrává černý hráč se skórem: " + score1);
                JOptionPane.showMessageDialog(BoardWindow, "Vyhrává černý hráč se skórem: " + score1);
            } else {
                if ((score1 + score2) != (size-2)*(size-2)) {
                     System.out.print("score1: " + score1 + "\nscore2: " + score2 + "\nsize: " + (size-2)*(size-2) + "\n");
                    score2 = (size-2)*(size-2) - score1;
                }
                //skore.setText("Vyhrává bílý hráč se skórem: " + score2);
                JOptionPane.showMessageDialog(BoardWindow, "Vyhrává bílý hráč se skórem: " + score2);
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
		iterator=0;
		board.addMouseListener(this);
		ReversiRules pravidla=new ReversiRules(this.size+2);
		Board deska=new Board(pravidla);
		hra=new Game(deska, this.AI);
		
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
	
	public void undoGame(Game hra){
		for(int i=0;i<hra.getBoard().getSize(); i++)
			for(int j=0; j<hra.getBoard().getSize(); j++)
			{
				if(!hra.getBoard().getField(i, j).isEmpty())
					System.out.println("i je: "+i+" j je: "+j);
			}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
            //TODO Vytvorit i pro ostatni velikosti desek, jen souradnice.
			
		
		 /*Tady se resi UNDO*/
        
		prevGame[iterator]=new Game(hra.getBoard(), AI);						
		iterator++;
		
		/*Konec UNDO*/
			int i=e.getY()/63;
            int j=e.getX()/63;
            colorDisk actual;
            
            if(hra.currentPlayer().isWhite()){
                actual=colorDisk.WHITE;
            } else {
                actual=colorDisk.BLACK;
            }
            
            if(hra.currentPlayer().canPutDisk(hra.getBoard().getField(i, j))) {
                errOutput.setText("");
                if (AI == 0) {
                    if(hra.currentPlayer().isWhite()) {
                        hrac.setText("Hrac na tahu: Cerny");
                    } else {
                        hrac.setText("Hrac na tahu: Bily");
                    }
                }
                square[i][j].putImgDisk(actual);
                hra.currentPlayer().putDisk(hra.getBoard().getField(i, j));
                hra.nextPlayer();
                
                if (this.AI != 0) {
                    this.hra = AiAction.aiAction(hra, AI);         
                }
                updateBoard(this.hra);
            } else {
                errOutput.setText("Neplatne pole");
                //this.updateBoard(this.hra);
            }
            countOfDisksW.setText("K dispozici bily: "+(stackCount-countW));
            countOfDisksB.setText("K dispozici cerny: "+(stackCount-countB));
           
        }
	
	/*Tady se resi UNDO*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.undoGame(prevGame[iterator-1]);
	}
	/*Konec UNDO*/
	
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