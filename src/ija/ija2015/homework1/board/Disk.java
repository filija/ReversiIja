package ija.ija2015.homework1.board;

public class Disk {
	private boolean whiteDisk;	//barva disku
	
	public Disk(boolean isWhite)
	{
		whiteDisk=isWhite;
	}
	
	//zmena barvy kamene
	public void turn()
	{
		whiteDisk=(!whiteDisk);
	}
	
	//Test, zda je kamen bily
	public boolean isWhite()
	{
		return whiteDisk;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (whiteDisk ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disk other = (Disk) obj;
		if (whiteDisk != other.whiteDisk)
			return false;
		return true;
	}
}
