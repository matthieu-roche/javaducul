package application;

public class GrandRequin extends Poisson{
	
	public GrandRequin(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 10, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un Grand Requin, " + super.toString();
	}
	
	public void bouger2()
	{
		int ab = this.getAbs();
		int or = this.getOrd();
		int vit = this.getVitesse();
		System.out.println("Grand Requin en [" + ab + "," + or + "] observe !");	
		Poisson voisin = this.observer2();
		
		// Tout d'abord : les potes YEN A PAS ICI
				
		// Ensuite, les proies

		if (voisin instanceof Sardine || voisin instanceof Maquereau) {
			System.out.println("Il est proche d'une proie !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			System.out.println("Il essaye d'attaquer la proie");
			// determiner si le poisson se rapproche de sa proie ou le mange direct
			int distsecu = 5; // a determiner avec les tests
			if (norm <= distsecu) {
				this.manger2(voisin); // la proie est mang�
				System.out.println("Il a mang� la proie");
				//this.faim = cap; //d�fini dans le constructeur de poisson, normalement vu que Sardine h�rite de poisson �a passe
				setAbs(xv);
				setOrd(yv);				
			}
			else {
				this.setVitesse(5); // acceleration
				if (ab + (xv-ab)*vit/norm < 550) { //Pas trop � droite
					if (ab + (xv-ab)*vit/norm > 0) { //Pas trop � gauche
						if (or + (yv-or)*vit/norm < 300) { //Pas trop bas
							if (or + (yv-or)*vit/norm > 0) { //Pas trop haut
								System.out.println("Il s'approche de sa proie");
								setAbs((int)(ab + (xv-ab)*vit/norm));
								setOrd((int)(or + (yv-or)*vit/norm));
							}
							else {
								System.out.println("Il ne peut pas s'approcher de sa proie");
							}
						}
						else {
							System.out.println("Il ne peut pas s'approcher de sa proie");
						}
					}
					else {
						System.out.println("Il ne peut pas s'approcher de sa proie");
					}
				}
				else {
					System.out.println("Il ne peut pas s'approcher de sa proie");
				}
				
			}
		}
		
		// Puis, les pr�dateurs YEN A PAS ICI
		
		// Enfin, les autres
		
		else {
			System.out.println("Il est proche d'une autre esp�ce neutre !");
			int xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement al�atoire entre [-vitesse; + vitesse] */
			int yalea = -vit + (int)(Math.random() * (2*vit + 1)); 
			while ((ab + xalea) <0 || (ab + xalea) >550 || (or + yalea)<0 || (or +yalea) >300) {
				xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement al�atoire entre [-vitesse; + vitesse] */
				yalea = -vit + (int)(Math.random() * (2*vit + 1));
			}
			setAbs(ab + xalea);
			setOrd(ab + yalea);
			System.out.println("Il bouge de mani�re normale !");
		}
		
		//G�rer la faim (a revoir)
		
//		this.faim = this.faim - 5;
//		if (this.faim <= 0) {
//		System.out.println("Petit Requin meurt de faim"); //cela n'arrive jamais en pratique pour les crevettes
//		ecosys.getPoissons().remove(this);
//		}
	
	
	}

	

}