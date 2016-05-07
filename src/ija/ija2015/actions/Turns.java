package ija.ija2015.actions;

public class Turns {

    int x[];
    int y[];
    
    public Turns(){
        x = new int[140];
        y = new int[140];
    }
    
    public void saveTurn(int x, int y, int index) {
      if(index>0){
    	this.x[index]=x;
        this.y[index]=y;
      }
      else
    	  return;
    }
    
    public int getXTurn(int index) {
        return this.x[index];
    }
   
   public int getYTurn(int index) {
        return this.y[index];
    }
}
