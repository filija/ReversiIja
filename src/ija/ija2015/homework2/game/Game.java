/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
import java.io.*;
import java.util.*;
import java.awt.*;

/**
 *
 * @author xturek05
 */
public class Game implements java.io.Serializable, Cloneable{
    protected Player player1;
    protected Player player2;
    protected Player playerOnTurn;
    protected Board board;
    int Ai;
    
    public Game(Board board, int Ai) {
        this.Ai = Ai;
        this.board = board;
    }

    public Game() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean addPlayer(Player player) {
        if (player1 == null) {
            player.init(board);
            player1 = player;
            if (player1.isWhite()) {
                playerOnTurn = player1;
            }
        } else if (player2 == null) {
            player.init(board);
            player2 = player;
            if (player1.isWhite()) {
                playerOnTurn = player1;
            }
        } else {
            return false;
        }
        return true;
    }
    
    public Player currentPlayer() {
        return playerOnTurn;
    }
    
    public Player nextPlayer() {
        if (playerOnTurn == player1) {
            playerOnTurn = player2;
        } else {
            playerOnTurn = player1;
        }
        return playerOnTurn;
    }
    
    public Board getBoard() {
       return board; 
    }
    
    public int getAi(){
            return this.Ai;
    }
    
    public Game clone() throws CloneNotSupportedException {
        return (Game) super.clone();
    }
    
	public void setBoard(Board board) {
		this.board = board;
	}

	public void setAi(int ai) {
		Ai = ai;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getPlayerOnTurn() {
		return playerOnTurn;
	}

	public void setPlayerOnTurn(Player playerOnTurn) {
		this.playerOnTurn = playerOnTurn;
	}
    
}
