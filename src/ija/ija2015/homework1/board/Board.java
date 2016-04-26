package ija.ija2015.homework1.board;

public class Board {
	
	protected Field field[][];
	private int size;	//velikost desky
 	
	public Board(int size)
	{
 		this.size=size;
 		field=new Field[size][size];
 		
 		for(int i=0; i<size; i++)
 		{
 			for(int j=0; j<size; j++)
 			{
 				if((i>0 && i<size-1) && (j>0 && j<size-1)){
 					this.field[i][j]=new BoardField(i, j);
 				}
 				else{
 					this.field[i][j]=new BorderField();
 					
 				}
 			}
 		}
 		
 		for(int i=0; i<size; i++)
 		{
 			for(int j=0; j<size; j++)
 			{
 				if((i>0 && i<size-1) && (j>0 && j<size-1)){
 				
 					if(i!=1)
 						this.field[i][j].addNextField(Field.Direction.U, this.field[i-1][j]);
 					if(i!=size-1)
 						this.field[i][j].addNextField(Field.Direction.D, this.field[i+1][j]);
 					if(j!=1)
 						this.field[i][j].addNextField(Field.Direction.L, this.field[i][j-1]);
 					if(j!=size-1)
 						this.field[i][j].addNextField(Field.Direction.R, this.field[i][j+1]);
 					if(i!=1 && j!=1)
 						this.field[i][j].addNextField(Field.Direction.LU, this.field[i-1][j-1]);
 					if(i!=1 && j!=size-1)
 						this.field[i][j].addNextField(Field.Direction.RU, this.field[i-1][j+1]);
 					if(i!=size-1 && j!=1)
 						this.field[i][j].addNextField(Field.Direction.LD, this.field[i+1][j-1]);
 					if(i!=size-1 && j!=size-1)
 						this.field[i][j].addNextField(Field.Direction.RD, this.field[i+1][j+1]);
 						
 						
 				}
 			}
 		}
	
	}
	
	public Field getField(int row, int col)
	{
		return this.field[row][col];
	}
 	
 	public int getSize()
 	{
 		return this.size;
 	}

}
