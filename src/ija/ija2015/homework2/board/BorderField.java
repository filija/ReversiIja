package ija.ija2015.homework2.board;

/**
 *
 * @author xturek05
 */
public class BorderField implements Field, java.io.Serializable {    
    private Field array[];
    private Disk disk;
    
    public BorderField() {
        array = new Field[8];
    }
    
    @Override
    public void addNextField(Field.Direction dirs, Field field){}
    
    @Override  
    public Field nextField(Field.Direction dirs) {
       return this.array[dirs.ordinal()];
    }
    
    @Override    
    public boolean putDisk(Disk disk) {
        if (this.disk == null) {
            this.disk = new Disk(false);
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
    public boolean canPutDisk(Disk disk) {
        return this.disk == null;
    }
    
    @Override
    public boolean isEmpty() {
        return ((this.disk == null));   
    }
}
