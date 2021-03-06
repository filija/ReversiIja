/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.BoardField;
import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.board.Rules;

/**
 *
 * @author xturek05
 */
public class ReversiRules implements Rules, java.io.Serializable{
    
    private int size;
    
    public ReversiRules(int size) {
        this.size = size;
    }
    
    @Override
    public int getSize() {
        return this.size;
    }
    
    @Override
    public int numberDisks() {
        return (this.size*this.size/2);
    }
    
    @Override
    public Field createField(int row, int col) {
        Field field = (Field) new BoardField(row, col);
        return field;
    } 
}