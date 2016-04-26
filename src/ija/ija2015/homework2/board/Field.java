package ija.ija2015.homework2.board;

/**
 *
 * @author xturek05
 */
public interface Field {

    public static enum Direction {
        D, L, LD, LU, R, RD, RU, U;
    }
    
    void addNextField(Field.Direction dirs, Field field);
    boolean canPutDisk(ija.ija2015.homework2.board.Disk disk);
    ija.ija2015.homework2.board.Disk getDisk();
    boolean isEmpty();
    Field nextField(Field.Direction dirs);   
    boolean putDisk(Disk disk);   
}
