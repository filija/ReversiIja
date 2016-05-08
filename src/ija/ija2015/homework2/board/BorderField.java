package ija.ija2015.homework2.board;

/**
 * Třída reprezentující okrajové políčko
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */

public class BorderField implements Field, java.io.Serializable {    
    private Field array[];
    private Disk disk;
    
    public BorderField() {
        array = new Field[8];
    }
    
    /**
     * Funkce pro přídání vedlejšího políčka
     */
    public void addNextField(Field.Direction dirs, Field field){}
      
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
            this.disk = new Disk(false);
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
        return ((this.disk == null));   
    }
}
