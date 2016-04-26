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
	public void easyGameTest(){
		System.out.println("Jednoduchy test hry");
		ReversiRules pravidla=new ReversiRules(8);
		Board deska=new Board(pravidla);
		Game hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		
		assertTrue("Test hrace na tahu", hra.currentPlayer().isWhite());
		assertEquals("Test velikosti desky",8, deska.getSize());
		
		//Spravne pocatecni umisteni kamenu
		assertTrue("Spravne pocatecni umisteni kamenu", hra.getBoard().getField(4, 4).getDisk().isWhite());
		assertFalse("Spravne pocatecni umisteni kamenu", hra.getBoard().getField(4, 5).getDisk().isWhite());
		assertFalse("Spravne pocatecni umisteni kamenu", hra.getBoard().getField(5, 4).getDisk().isWhite());
		assertTrue("Spravne pocatecni umisteni kamenu", hra.getBoard().getField(5, 5).getDisk().isWhite());
		hra.nextPlayer();
		Field bad=hra.getBoard().getField(5, 3);
		Field blackGo=hra.getBoard().getField(5, 6);
		assertFalse("Pokladani kamene na nespravne policko", cerny.canPutDisk(bad));
		hra.currentPlayer().putDisk(blackGo);
		assertTrue("Kameny po vlozeni cerneho kamenu", hra.getBoard().getField(4, 4).getDisk().isWhite());
		assertFalse("Kameny po vlozeni cerneho kamenu", hra.getBoard().getField(4, 5).getDisk().isWhite());
		assertTrue("Test prazdnosti pole", hra.getBoard().getField(4, 6).isEmpty());
		assertFalse("Kameny po vlozeni cerneho kamenu", hra.getBoard().getField(5, 4).getDisk().isWhite());
		assertFalse("Kameny po vlozeni cerneho kamenu", hra.getBoard().getField(5, 5).getDisk().isWhite());
		assertFalse("Kameny po vlozeni cerneho kamenu", hra.getBoard().getField(5, 6).getDisk().isWhite());
		assertTrue("Test prazdnosti pole", hra.getBoard().getField(7, 7).isEmpty());
		
	}
	@Test
	public void deepTest(){
		System.out.println("Pokrocilejsi test");
		ReversiRules pravidla=new ReversiRules(8);
		Board deska=new Board(pravidla);
		Game hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		
		assertFalse("test prazdne sady", bily.emptyPool());
		
		Player noActive=new Player(true); 
		assertFalse("Pridani dalsiho hrace do hry", hra.addPlayer(noActive));
		assertEquals("test poctu kamenu", 8*8/2, hra.getBoard().getRules().numberDisks());
		hra.nextPlayer();
		hra.nextPlayer();
		assertTrue("Test nextPlayer", hra.currentPlayer().isWhite());
	}
	
	@Test
	public void gameTest(){
		System.out.println("Test hry");
		ReversiRules pravidla=new ReversiRules(8);
		Board deska=new Board(pravidla);
		Game hra=new Game(deska);
		
		Player bily=new Player(true);
		Player cerny=new Player(false);
		
		hra.addPlayer(bily);
		hra.addPlayer(cerny);
		
		hra.nextPlayer();
		Field fb1=hra.getBoard().getField(4, 3);
		Field fb2=hra.getBoard().getField(6, 5);
		Field fb3=hra.getBoard().getField(6, 3);
		Field fw1=hra.getBoard().getField(5, 3);
		Field fw2=hra.getBoard().getField(5, 6);
		Field fw3=hra.getBoard().getField(5, 2);
		
		hra.currentPlayer().putDisk(fb1);
		hra.nextPlayer();
		hra.currentPlayer().putDisk(fw1);
		hra.nextPlayer();
		hra.currentPlayer().putDisk(fb2);
		hra.nextPlayer();
		hra.currentPlayer().putDisk(fw2);
		hra.nextPlayer();
		hra.currentPlayer().putDisk(fb3);
		hra.nextPlayer();
		hra.currentPlayer().putDisk(fw3);
		
		for(int i=4; i<=6; i++)
			for(int j=2; j<=6; j++)
			{
				if((i==4 && j==2) || (i==4 && j==6) || (i==6 && j==2)
				|| (i==6 && j==4) || (i==6 && j==6)){
					assertTrue("Prazdna policka", hra.getBoard().getField(i, j).isEmpty());
				}
				else{
					if(i==4 || i==6){
						assertFalse("Cerne kameny", hra.getBoard().getField(i, j).getDisk().isWhite());
					}
					else{
						assertTrue("Bile kameny", hra.getBoard().getField(i,j).getDisk().isWhite());
					}
				}
			}		
	}
}
