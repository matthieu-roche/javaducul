package application;

public class PetitRequin extends Poisson{
	
	public PetitRequin(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 9, cara, 5, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un Petit Requin, " + super.toString();
	}
	
	public void bouger2()
	{
		int ab = this.getAbs();
		int or = this.getOrd();
		int vit = this.getVitesse();
		System.out.println("Petit Requin en [" + ab + "," + or + "] observe !");	
		Poisson voisin = this.observer2();
		
		// Tout d'abord : les potes

		if (voisin instanceof PetitRequin) {
			System.out.println("Il est proche d'un autre Petit Requin !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			if (ab + (xv-ab)*vit/norm < 550) { //Pas trop � droite
				if (ab + (xv-ab)*vit/norm > 0) { //Pas trop � gauche
					if (or + (yv-or)*vit/norm < 300) { //Pas trop bas
						if (or + (yv-or)*vit/norm > 0) { //Pas trop haut
							// pour v�rifier que les nouvelles coordonn�es ne seront pas les memes que le voisins ( pas de superposition de poissons)
							if (ab + (xv-ab)*vit/norm == voisin.getAbs()) { // si l'abscisse est la meme
								if (!(or + (yv-or)*vit/norm == voisin.getOrd())) { // il faut que l'ordonn�e ne soit pas la m�me
									System.out.println("Il s'approche de son copain Petit Requin"); // alors ils peuvent se rapprocher
									setAbs((int)(ab + (xv-ab)*vit/norm));
									setOrd((int)(or + (yv-or)*vit/norm));
								}
								else {
									System.out.println("Il est d�ja tr�s proche de son copain Petit Requin"); // sinon c'est qu'ils sont d�ja assez proche
								}
							}
							else { // si l'abscisse n'est pas la m�me
								System.out.println("Il s'approche de son copain Petit Requin"); // il peut s'approcher pas de probl�mes
								setAbs((int)(ab + (xv-ab)*vit/norm));
								setOrd((int)(or + (yv-or)*vit/norm));
							}	
						}
						else {
							System.out.println("Il ne peut pas s'approcher");
						}
					}
					else {
						System.out.println("Il ne peut pas s'approcher");
					}
				}
				else {
					System.out.println("Il ne peut pas s'approcher");
				}
			}
			else {
				System.out.println("Il ne peut pas s'approcher");
			}
		}
		
		// Ensuite, les proies

		else if (voisin instanceof Sardine) {
			System.out.println("Il est proche d'une proie Sardine !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			System.out.println("Il essaye d'attaquer la proie Sardine");
			// determiner si le poisson se rapproche de sa proie ou le mange direct
			int distsecu = 5; // a determiner avec les tests
			if (norm <= distsecu) {
				this.manger2(voisin); // la proie est mang�
				System.out.println("Il a mang� la proie");
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
		
		setFaim(getFaim() - 5);  
		if (getFaim() <= 0) {
		System.out.println("Petit Requin meurt de faim"); //cela n'arrive jamais en pratique pour les crevettes
		getEco().getPoissons().remove(this);
		}
	
	
	
	}
	
	

}