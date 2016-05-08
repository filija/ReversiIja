package ija.ija2015.homework2.board;

import java.util.Objects;

/**
 * Třída reprezentující Disk
 * @author Filípek Jakub (xfilip34)
 * @author Turek Matej	(xturek05)
 */

public class Disk implements java.io.Serializable{

    private String color;
    private boolean frozen;
    
    public Disk(boolean isWhite) {
        if (isWhite) {   
            this.color = "white";
        }
        else {
            this.color = "black";
        }
        
        this.frozen=false;
    }

    /**
     * Funkce pro otáčení disku
     */
    public void turn(){
        if ("white".equals(this.color)) {
            this.color = "black";
        }
        else {
            this.color = "white";
        }
    }

    /**
     * Funkce pro ověření zda je disk bilý
     * @return True, pokud je disk bílý
     */
    public boolean isWhite(){
        return "white".equals(this.color);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.color);
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
        final Disk other = (Disk) obj;
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
    
    /**
     * Funkce pro ověření zda je disk zablokován
     * @return true, pokud je disk blokovaný
     */
    public boolean isFrozen()
    {
    	if(this.frozen)
    		return true;
    	else
    		return false;
    }
    
    /**
     * nastaví disk na blokovaný
     */
    public void setFrozen()
    {
    	if(!this.frozen)
    		this.frozen=true;
    }
    
    /**
     * nastaví disk na neblokovaný
     */
    public void unSetFrozen()
    {
    	if(this.frozen)
    		this.frozen=false;
    }
    
}