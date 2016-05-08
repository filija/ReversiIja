package ija.ija2015.homework2.board;

import java.util.Arrays;
import java.util.Objects;

/**
 * Třída reprezentující aktivní políčko
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */

public class BoardField implements Field, java.io.Serializable {
    private Field array[];
    private int row;
    private int col;
    private Disk disk;
    
    public BoardField(int row, int col) {
        this.row = row;
        this.col = col;
        array = new Field[8];
    }
    
    /**
     * Funkce pro přídání vedlejšího políčka
     */
    public void addNextField(Field.Direction dirs, Field field) {
        this.array[dirs.ordinal()] = field;
    }
    
    /**
     * Funkce vracející vedlejší políčko
     */
    public Field nextField(Field.Direction dirs) {
       return this.array[dirs.ordinal()];
    }
    
    /**
     * Funkce pro vložení disku na pole
     */
    public boolean putDisk(Disk disk) {
        if (this.disk == null) {
            this.disk = disk;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Funkce pro navrácení disku z aktuálního pole
     */
    public Disk getDisk() {
        return this.disk;
    }

    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Arrays.deepHashCode(this.array);
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.col;
        hash = 29 * hash + Objects.hashCode(this.disk);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoardField other = (BoardField) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.col != other.col) {
            return false;
        }
        if (!Arrays.deepEquals(this.array, other.array)) {
            return false;
        }
        return true;
    }

    /**
     * Funkce pro ověření zda je možné vložit disk na pole
     */
    public boolean canPutDisk(Disk disk) {
        return this.disk == null;
    }
    
    /**
     * Funkce pro ověření prázdného políčka
     */
    public boolean isEmpty() {
        return (this.disk == null);   
    }
}
