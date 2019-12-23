package application;

public class Crevette extends Poisson{
	
	public Crevette(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 10, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis une crevette, " + super.toString();
	}
	
	
	
	public void bouger()
	{System.out.println("Crevette bouge !"); 
	this.observer();
	int a = getAbs();
	int b = getOrd();
	setAbs(a -2 );


	}
	
	public void manger()
	{System.out.println("Crevette mange !"); 
	}
	
	

}