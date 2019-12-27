package application;


public class Sardine extends Poisson{

	public Sardine(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 7, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis une sardine, " + super.toString();
	}
	
	
//	
//	public void bouger()
//	{System.out.println("Sardine bouge !"); 
//	this.observer();
//	int a = getAbs();
//	int b = getOrd();
////
////	if (a + 20 <= 540) 
////		{setAbs(a + 20);}
////	else 
//	setAbs(a + 3);
//
//	}
	
	
	public void bouger2()
	{
		System.out.println("Sardine bouge !"); 
		Poisson voisin = this.observer2();
		
		if (voisin instanceof Maquereau) {
			this.manger2(voisin);
		}
		if (voisin instanceof Sardine) {
			this.manger2(voisin);
		}
		
		int a = getAbs();
		int b = getOrd();
		setAbs(a + 12 );
		setOrd(b - 12 );
	}
	
}
	
