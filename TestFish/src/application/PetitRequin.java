package application;

public class PetitRequin extends Poisson{
	
	public PetitRequin(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 10, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un Petit Requin, " + super.toString();
	}
	
	
	
	public void bouger()
	{System.out.println("Petit Requin bouge !"); 
	this.observer();
	int a = getAbs();
	int b = getOrd();
	setAbs(a + 6 );
	setOrd(b + 6 );

	}
	
	public void manger()
	{System.out.println("Petit Requin mange !"); 
	}
	
	

}