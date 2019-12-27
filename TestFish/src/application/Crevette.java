package application;

public class Crevette extends Poisson{
	
	public Crevette(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 6, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis une crevette, " + super.toString();
	}
	
	
	
//	public void bouger()
//	{System.out.println("Crevette bouge !"); 
//	this.observer();
//	int a = getAbs();
//	int b = getOrd();
//	setAbs(a -2 );
//
//
//	}
	
	public void bouger3()
	{
		System.out.println("Crevette bouge !"); 
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
	
	
	public void bouger2()
	{
		System.out.println("Crevette bouge !");	
		Poisson voisin = this.observer2();
		
		if (voisin instanceof Crevette) {
			System.out.println("Copines !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			if ((xv-this.getAbs())*this.getVitesse() < 550) { //Pas trop à droite
				if ((xv-this.getAbs())*this.getVitesse() > 0) { //Pas trop à gauche
					if ((yv-this.getOrd())*this.getVitesse() < 300) { //Pas trop bas
						if ((yv-this.getOrd())*this.getVitesse() > 0) { //Pas trop haut
							
							setAbs((xv-this.getAbs())*this.getVitesse());
							setOrd((yv-this.getAbs())*this.getVitesse());
						}
						}
					}
					
				}
			}
		}


}