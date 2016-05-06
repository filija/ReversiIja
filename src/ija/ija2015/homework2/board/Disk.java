package ija.ija2015.homework2.board;

import java.util.Objects;

/**
 *
 * @author xturek05
 */
public class Disk implements java.io.Serializable{

    private String color;
    
    public Disk(boolean isWhite) {
        if (isWhite) {   
            this.color = "white";
        }
        else {
            this.color = "black";
        }
    }

    public void turn(){
        if ("white".equals(this.color)) {
            this.color = "black";
        }
        else {
            this.color = "white";
        }
    }

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
}