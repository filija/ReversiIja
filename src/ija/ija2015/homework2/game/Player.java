/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.Disk;
import ija.ija2015.homework2.board.Field;
import java.util.Objects;

/**
 *
 * @author xturek05
 */

public class Player implements java.io.Serializable{
    
    private String color;
    private int DiskCount;
    
    public Player(boolean isWhite) {
        if (isWhite) {   
            this.color = "white";
        } else {
            this.color = "black";
        }
        this.DiskCount = 0;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.color);
    }
    
    public boolean isWhite() {
        return "white".equals(this.color);
    }
    
    public boolean canPutDisk(Field field) {
        if (!field.isEmpty()) {
            return false;
        } else {   
            Field field2;
            for(Field.Direction dir : Field.Direction.values()) {
                field2 = field.nextField(dir);
                if (field2 != null) {
                    if (field2.getDisk() != null && !field2.getDisk().isFrozen()) {
                        if (field2.getDisk().isWhite() != "white".equals(this.color)) {
                            while (field2 != null && field2.getDisk() != null) {
                                if (field2.getDisk().isWhite() == "white".equals(this.color)) {
                                    return true;
                                }
                                field2 = field2.nextField(dir);
                            }
                        }
                    }
                }
            }		
        }
        return false;
    }
    
    public boolean emptyPool() {
        return this.DiskCount == 0;
    }
    
    public boolean putDisk(Field field) {
        Disk disk = new Disk("white".equals(this.color));

        if (field.putDisk(disk)) {
            Field field2;
            Field.Direction changeDir;
                
            for(Field.Direction dir : Field.Direction.values()) {
                changeDir = null;
                field2 = field.nextField(dir);

                if (field2 != null && field2.getDisk() != null) {
                    if (field2.getDisk().isWhite() != "white".equals(this.color)) {

                        while (field2 != null && field2.getDisk() != null && !field2.getDisk().isFrozen()) {
                            if(field2.getDisk().isWhite() == "white".equals(this.color)) {
                                changeDir = dir;
                                break;
                            }
                            field2 = field2.nextField(dir);
                        }

                        if (changeDir != null) {
                            field2 = field.nextField(changeDir);
                            while (field2.getDisk().isWhite() != "white".equals(this.color)) {
                                field2.getDisk().turn();
                                field2 = field2.nextField(changeDir);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public void init(Board board) {
        int size = board.getSize();
        this.DiskCount = size;

        board.getField((size/2)-2, (size/2)-2).putDisk(new Disk(true));
        board.getField(size/2-1, size/2-1).putDisk(new Disk(true));
        board.getField((size/2)-2, size/2-1).putDisk(new Disk(false));
        board.getField(size/2-1, (size/2)-2).putDisk(new Disk(false));
    }
}