package ija.ija2015.homework2.game;

/**
 * Trida implementujici blokovani kamenu
 * @author kuba
 *
 */
public class DiskFrozen implements Runnable{

	private int timeToFreeze;	//Doba k zamrznuti
	private int timeOfFreeze;	//Doba zamrazeni
	private int countFreezeDisks;	//Pocet zamrznutych disku
	private Game hra; 
	Thread thr;
	
	public DiskFrozen(int ttf, int tof, int cfd, Game hra)
	{
		timeOfFreeze=tof;
		timeToFreeze=ttf;
		countFreezeDisks=cfd;
		this.hra=hra;
		thr=new Thread(this, "frozen");
		thr.start();
	}
	
	@Override
	/**
	 * Spusteni vlakna na blokovani kamenu
	 */
	public void run() {
		// TODO Auto-generated method stu
		int iter=0; //pocitadlo zmrzlych disku
		try{
			Thread.sleep(timeToFreeze*1000);
		
		  while(iter<this.countFreezeDisks)
		  {
			for(int i=0; i<hra.getBoard().getSize(); i++)
				for(int j=0; j<hra.getBoard().getSize(); j++)
				{
					if(iter==this.countFreezeDisks)
						break;
					if(!hra.getBoard().getField(i, j).isEmpty())
						if(Math.random() < 0.5)
						{
							if(!hra.getBoard().getField(i, j).getDisk().isFrozen()){
								hra.getBoard().getField(i, j).getDisk().setFrozen();
								iter++;
							}
						}
				}
		  }
		  
		  Thread.sleep(timeOfFreeze*1000);
		  this.freezeBack();
		  
		}
		
		catch(InterruptedException exc)
		{
			System.out.println("Vlakno preruseno");
		}
		
	}
	/**
	 * Funkce pro navrat blokovanych kamenu do puvodniho stavu
	 */
	public void freezeBack()
	{
		for(int i=0; i<hra.getBoard().getSize(); i++)
			for(int j=0; j<hra.getBoard().getSize(); j++)
			{
				if(!hra.getBoard().getField(i, j).isEmpty()){
					if(hra.getBoard().getField(i, j).getDisk().isFrozen())
					{
						hra.getBoard().getField(i, j).getDisk().unSetFrozen();
					}
				}
			}
		thr.run();
	}
	
}
