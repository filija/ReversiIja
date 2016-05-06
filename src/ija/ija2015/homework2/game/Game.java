/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;

/**
 *
 * @author xturek05
 */
public class Game implements java.io.Serializable{
    protected Player player1;
    protected Player player2;
    protected Player playerOnTurn;
    protected Board board;
    
    public Game(Board board) {
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
}
