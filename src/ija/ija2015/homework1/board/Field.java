package ija.ija2015.homework1.board;

import java.io.Serializable;

public interface Field {
	public enum Direction implements Serializable,Comparable<Direction> {
		D, L, LD, LU, R, RD, RU, U	
		
	}
	
	void addNextField(Field.Direction dirs, Field field);
	Disk getDisk();
	Field nextField(Field.Direction dirs);
	boolean putDisk(Disk disk);
}

