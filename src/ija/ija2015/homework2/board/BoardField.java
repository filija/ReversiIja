package ija.ija2015.homework2.board;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author xturek05
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
    
    @Override
    public void addNextField(Field.Direction dirs, Field field) {
        this.array[dirs.ordinal()] = field;
    }
    
    @Override
    public Field nextField(Field.Direction dirs) {
       return this.array[dirs.ordinal()];
    }
    
    @Override
    public boolean putDisk(Disk disk) {
        if (this.disk == null) {
            this.disk = disk;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Disk getDisk() {
        return this.disk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Arrays.deepHashCode(this.array);
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.col;
        hash = 29 * hash + Objects.hashCode(this.disk);
        return hash;
    }

    @Override
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

    @Override
    public boolean canPutDisk(Disk disk) {
        return this.disk == null;
    }
    
    @Override
    public boolean isEmpty() {
        return (this.disk == null);   
    }
}
