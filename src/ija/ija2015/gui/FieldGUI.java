package ija.ija2015.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ija.ija2015.gui.CreatBoard;
/**
 * 
 * @author Jakub Filipek
 *	Trida Definujici graficke policko desky
 */

public class FieldGUI extends JPanel{
	ImageIcon white;
	ImageIcon black;
	JLabel diskerW;
	JLabel diskerB;
	colorDisk playerOnMove;
	
	FieldGUI(){
		super(new BorderLayout());
		white=new ImageIcon("lib/img/white.png");
		black=new ImageIcon("lib/img/black.png");
		diskerW=new JLabel("", white, JLabel.CENTER);
		diskerB=new JLabel("", black, JLabel.CENTER);
		this.add(diskerW, BorderLayout.CENTER);		
		this.add(diskerB, BorderLayout.CENTER);
		diskerW.setVisible(false);
		diskerB.setVisible(false);
	}
	
	public void setPlayerOnMove(colorDisk color){
		this.playerOnMove=color;
	}
	
	/**
	 * 
	 * @param color
	 * Funkce pro vlozeni obrazku kamene na pole
	 */
	public void putImgDisk(colorDisk color){
		     
		if(colorDisk.WHITE==color)
		{
			diskerB.setVisible(false);
			diskerB.remove(this);
			this.add(diskerW, BorderLayout.CENTER); 
			diskerW.setVisible(true);
		}
		else{
			diskerW.setVisible(false);	
			diskerB.remove(this);
			this.add(diskerB, BorderLayout.CENTER);
			diskerB.setVisible(true);			
		}
	}

	
}
