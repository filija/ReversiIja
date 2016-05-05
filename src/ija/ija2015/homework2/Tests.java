/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.homework2.game.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

	@Test
	public void putDiskTest(){
		System.out.println("putDiskTest");
		ReversiRules pravidla=new ReversiRules(8);
		Board deska=new Board(pravidla);
		Game hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		hra.nextPlayer();
		
		Field fb1=hra.getBoard().getField(0, 0);
		Field fw1=hra.getBoard().getField(1, 1);
		Field fb2=hra.getBoard().getField(2, 2);
		hra.currentPlayer().putDisk(fb2);
		hra.currentPlayer().putDisk(fw1);
		assertTrue("put", hra.currentPlayer().canPutDisk(fb1));
	
		
		hra.nextPlayer();		
		
	
	}
	
}
