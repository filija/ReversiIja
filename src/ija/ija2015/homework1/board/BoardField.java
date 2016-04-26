package ija.ija2015.homework1.board;

import java.util.Arrays;

public class BoardField implements Field{

	private int row;
	private int col;
	private Disk disk;
	private Field field[];
	
	public BoardField(int row, int col)
	{
			this.row=row;
			this.col=col;
			field=new Field[8];
	}
	
	public void addNextField(Direction dirs, Field field) {
		// TODO Auto-generated method stub
			this.field[dirs.ordinal()]=field;
	}

	public Disk getDisk() {
		if(this.disk!=null)
			return this.disk;
		else
			return null;
	}

	public Field nextField(Field.Direction dirs) {
		//TODO Auto-generated method stu
		return this.field[dirs.ordinal()];
	}	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + ((disk == null) ? 0 : disk.hashCode());
		result = prime * result + Arrays.hashCode(field);
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		BoardField other = (BoardField) obj;
		if (col != other.col){
			return false;
		}
		if (disk == null) {
			if (other.disk != null){
				return false;
			}
		} else if (!disk.equals(other.disk)){
			return false;
		}
		
		if (row != other.row){
			return false;
		}
		return true;
	}

	public boolean putDisk(Disk disk) {
		if(this.disk!=null)
			return false;
		else{
			this.disk=new Disk(false);
			this.disk=disk;
			return true;
		}		
	}


}
