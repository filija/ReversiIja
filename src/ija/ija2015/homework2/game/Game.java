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
public class Game {
    private Player player1;
    private Player player2;
    private Player playerOnTurn;
    private Board board;
    
    public Game(Board board) {
        this.board = board;
    }
    
    public boolean addPlayer(Player player) {
        if (this.player1 == null) {
            player.init(this.board);
            this.player1 = player;
            if (this.player1.isWhite()) {
                this.playerOnTurn = this.player1;
            }
        } else if (this.player2 == null) {
            player.init(this.board);
            this.player2 = player;
            if (this.player1.isWhite()) {
                this.playerOnTurn = this.player1;
            }
        } else {
            return false;
        }
        return true;
    }
    
    public Player currentPlayer() {
        return this.playerOnTurn;
    }
    
    public Player nextPlayer() {
        if (this.playerOnTurn == this.player1) {
            this.playerOnTurn = this.player2;
        } else {
            this.playerOnTurn = this.player1;
        }
        return this.playerOnTurn;
    }
    
    public Board getBoard() {
       return this.board; 
    }

    
}
