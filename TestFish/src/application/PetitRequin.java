package application;

public class PetitRequin extends Poisson{
	
	public PetitRequin(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 9, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un Petit Requin, " + super.toString();
	}
	
	
//	
//	public void bouger()
//	{System.out.println("Petit Requin bouge !"); 
//	this.observer();
//	int a = getAbs();
//	int b = getOrd();
//	setAbs(a + 6 );
//	setOrd(b + 6 );
//
//	}
//	
	
	public void bouger2()
	{
		System.out.println("Petit Requin bouge !"); 
		Poisson voisin = this.observer2();
		
		if (voisin instanceof PetitRequin) {
			setAbs(voisin.getAbs() - 1/2); // lorsque le voisin est un allié, le poisson s'en rapproche.
			setOrd(voisin.getOrd() - 1/2);
		}
		if (voisin instanceof Sardine) {
			this.manger2(voisin);
		}
		
		int a = getAbs();
		int b = getOrd();
		setAbs(a + 6 );
		setOrd(b - 6 );
	}
	
	

}