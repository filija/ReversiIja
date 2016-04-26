package ija.ija2015.homework1.board;

public class BorderField implements Field{
	private Disk disk;

	public BorderField(){
		return;
	}
	
	public void addNextField(Direction dirs, Field field) {
		// TODO Auto-generated method stub
		return;
	}

	public Disk getDisk() {
		// TODO Auto-generated method stub
		if(this.disk!=null)
			return this.disk;
		else
			return null;
	}

	public Field nextField(Direction dirs) {

		return null;
	}

	public boolean putDisk(Disk disk) {

		if(this.disk!= null)
			return false;
		else{
			this.disk=disk;
		}
		return true;
	}
}
