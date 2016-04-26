package ija.ija2015.homework2.board;

/**
 *
 * @author xturek05
 */
public class BorderField implements Field {    
    private Field array[];
    private Disk disk;
    
    public BorderField() {
        array = new Field[8];
    }
    
    public void addNextField(Field.Direction dirs, Field field){}
    
    public Field nextField(Field.Direction dirs) {
       return this.array[dirs.ordinal()];
    }
     
    public boolean putDisk(Disk disk) {
        if (this.disk == null) {
            this.disk = new Disk(false);
            this.disk = disk;
            return true;
        } else {
            return false;
        }		
    }

    public Disk getDisk() {
        return this.disk;
    }

    public boolean canPutDisk(Disk disk) {
        return this.disk == null;
    }
    
    public boolean isEmpty() {
        return ((this.disk == null));   
    }
}
