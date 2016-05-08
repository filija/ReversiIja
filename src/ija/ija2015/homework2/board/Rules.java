/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.board;

/**
 * Rozhraní reprezentující pravidla hry
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */
public interface Rules {
    
    int getSize();
    int numberDisks();
    Field createField(int row, int col);
}
