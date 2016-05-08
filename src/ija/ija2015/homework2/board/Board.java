package ija.ija2015.homework2.board;

/**
 * Třída reprezentující hrací desku
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */
public class Board implements java.io.Serializable{
    
    private int size;
    private Field field[][];
    BoardField boardfield;
    BorderField borderfield;
    Rules rules;

    public Board(Rules rules) {
        this.rules = rules;
        this.size = this.rules.getSize();
        field = new Field[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {           
                 this.field[row][col] = new BoardField(row, col);                
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {    
                if ((row >= 0) && (col >= 0) && (row <= size - 1) && (col <= size - 1)) {
                    if (row > 1) {
                        this.field[row][col].addNextField(Field.Direction.U, this.field[row-1][col]);
                    }
                    if ((row > 1) && (col < size - 1)) {
                        this.field[row][col].addNextField(Field.Direction.RU, this.field[row-1][col+1]);
                    }
                    if (col < size - 1) {
                        this.field[row][col].addNextField(Field.Direction.R, this.field[row][col+1]);
                    }
                    if ((row < size - 1) && (col < size - 1)) {
                        this.field[row][col].addNextField(Field.Direction.RD, this.field[row+1][col+1]);
                    }
                    if (row < size - 1) {
                        this.field[row][col].addNextField(Field.Direction.D, this.field[row+1][col]);
                    }
                    if ((row < size - 1) && (col > 1)) {
                        this.field[row][col].addNextField(Field.Direction.LD, this.field[row+1][col-1]);
                    }
                    if (col > 1) {
                        this.field[row][col].addNextField(Field.Direction.L, this.field[row][col-1]);
                    }
                    if ((row > 1) && (col > 1)) {
                        this.field[row][col].addNextField(Field.Direction.LU, this.field[row-1][col-1]);
                    }
                }
            }
        }
    }
    
    /**
     * Funkce pro vrácení pole desky
     * @param row řadek desky
     * @param col sloupec desky
     * @return	hrací políčko
     */
    public Field getField(int row, int col) {
        return this.field[row][col];
    }
    
    /**
     * Funkce pro vrácení velikosti hrací desky
     * @return	velikost desky
     */
    public int getSize() {
        return this.size;
    } 
    
    /**
     * Funkce pro vrácení herních pravidel
     * @return	pravidla
     */
    public Rules getRules() {
        return this.rules;
    }


    /**
     * Funkce počítaní černých kamenů
     * @return	počet černých kamenů
     */
    public int countBlack() {
        int count = 0;
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) { 
                if (!field[row][col].isEmpty()) {
                    if (!field[row][col].getDisk().isWhite()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    /**
     * Funkce počítaní bílých kamenů
     * @return	počet bílých kamenů
     */
    public int countWhite() {
        int count = 0;
        size = getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {  
                if (!field[row][col].isEmpty()) {
                    if (field[row][col].getDisk().isWhite()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
