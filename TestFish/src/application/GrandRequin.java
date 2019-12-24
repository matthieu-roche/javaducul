package application;

public class GrandRequin extends Poisson{
	
	public GrandRequin(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 10, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un Grand Requin, " + super.toString();
	}
	
	
	
	public void bouger()
	{System.out.println("Grand Requin bouge !"); 
	//this.observer();
	int a = getAbs();
	int b = getOrd();
	setAbs(a + 10 );
	setOrd(b - 10 );

	}
	
	public void manger()
	{
		this.viser();
		//System.out.println("Grand Requin mange !"); 
	}
	
	

}