package application;


public class Maquereau extends Poisson{

	public Maquereau(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 10, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un maquereau, " + super.toString();
	}
	
	
	
	public void bouger()
	{System.out.println("Maquereau bouge !"); 
	this.observer();
	int a = getAbs();
	int b = getOrd();
//
//	if (a - 30 < 0) 
//		{setAbs(540);}
//	if (a - 30 > 540) 
//	{setAbs(0);}
//	else 
	setAbs(a - 5);
	
//	if (b - 10 > 300) 
//	{setOrd(0);}
//	if (b - 10 < 0) 
//	{setOrd(300);}
//else 
	setOrd(b -3);

	}
	
	public void manger()
	{System.out.println("Maquereau mange !"); 
	}
	
	

}