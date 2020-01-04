package application;


public class Sardine extends Poisson{

	public Sardine(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 7, cara, 3, dir, 12, eco);
	}
	public String toString() {
		return "Je suis une sardine, " + super.toString();
	}
	
	
	public void bouger2()
	{
		int ab = this.getAbs();
		int or = this.getOrd();
		int vit = this.getVitesse();
		System.out.println("Sardine en [" + ab + "," + or + "] observe !");	
		Poisson voisin = this.observer2();
		
		// Tout d'abord : les potes
		
		if (voisin instanceof Sardine) {
			System.out.println("Elle est proche d'une autre Sardine !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			if (ab + (xv-ab)*vit/norm < 550) { //Pas trop à droite
				if (ab + (xv-ab)*vit/norm > 0) { //Pas trop à gauche
					if (or + (yv-or)*vit/norm < 300) { //Pas trop bas
						if (or + (yv-or)*vit/norm > 0) { //Pas trop haut
							// pour vérifier que les nouvelles coordonnées ne seront pas les memes que le voisins ( pas de superposition de poissons)
							if (ab + (xv-ab)*vit/norm == voisin.getAbs()) { // si l'abscisse est la meme
								if (!(or + (yv-or)*vit/norm == voisin.getOrd())) { // il faut que l'ordonnée ne soit pas la même
									System.out.println("Elle s'approche de sa copine Sardine"); // alors ils peuvent se rapprocher
									setAbs((int)(ab + (xv-ab)*vit/norm));
									setOrd((int)(or + (yv-or)*vit/norm));
								}
								else {
									System.out.println("Elle est déja très proche de sa copine Sardine"); // sinon c'est qu'ils sont déja assez proche
								}
							}
							else { // si l'abscisse n'est pas la même
								System.out.println("Elle s'approche de sa copine Sardine"); // il peut s'approcher pas de problèmes
								setAbs((int)(ab + (xv-ab)*vit/norm));
								setOrd((int)(or + (yv-or)*vit/norm));
							}	
						}
						else {
							System.out.println("Elle ne peut pas s'approcher");
						}
					}
					else {
						System.out.println("Elle ne peut pas s'approcher");
					}
				}
				else {
					System.out.println("Elle ne peut pas s'approcher");
				}
			}
			else {
				System.out.println("Elle ne peut pas s'approcher");
			}
		}
		
		// Ensuite, les proies
		
		else if (voisin instanceof Crevette) {
			System.out.println("Elle est proche d'une proie Crevette !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			System.out.println("Elle essaye d'attaquer la proie Crevette");
			// determiner si le poisson se rapproche de sa proie ou le mange direct
			int distsecu = 5; // a determiner avec les tests
			if (norm <= distsecu) {
				this.manger2(voisin); // la proie est mangé
				System.out.println("Elle a mangé la proie");
				setAbs(xv);
				setOrd(yv);				
			}
			else {
				this.setVitesse(5); // elle accelere
				if (ab + (xv-ab)*vit/norm < 550) { //Pas trop à droite
					if (ab + (xv-ab)*vit/norm > 0) { //Pas trop à gauche
						if (or + (yv-or)*vit/norm < 300) { //Pas trop bas
							if (or + (yv-or)*vit/norm > 0) { //Pas trop haut
								System.out.println("Elle s'approche de sa proie");
								setAbs((int)(ab + (xv-ab)*vit/norm));
								setOrd((int)(or + (yv-or)*vit/norm));
							}
							else {
								System.out.println("Elle ne peut pas s'approcher de sa proie");
							}
						}
						else {
							System.out.println("Elle ne peut pas s'approcher de sa proie");
						}
					}
					else {
						System.out.println("Elle ne peut pas s'approcher de sa proie");
					}
				}
				else {
					System.out.println("Elle ne peut pas s'approcher de sa proie");
				}
				
			}
		}
		
		// Puis, les prédateurs
		
		else if (voisin instanceof Maquereau || voisin instanceof PetitRequin || voisin instanceof GrandRequin) {
			System.out.println("Elle est proche d'un prédateur !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			if (ab + (-xv+ab)*vit/norm < 550) { //Pas trop à droite
				if (ab + (-xv+ab)*vit/norm > 0) { //Pas trop à gauche
					if (or + (-yv+or)*vit/norm < 300) { //Pas trop bas
						if (or + (-yv+or)*vit/norm > 0) { //Pas trop haut
							System.out.println("Elle fuit le danger");
							setAbs((int)(ab + (-xv+ab)*vit/norm));
							setOrd((int)(or + (-yv+or)*vit/norm));
						}
						else {
							System.out.println("Elle ne peut pas fuire");
						}
					}
					else {
						System.out.println("Elle ne peut pas fuire");
					}
				}
				else {
					System.out.println("Elle ne peut pas fuire");
				}
			}
			else {
				System.out.println("Elle ne peut pas fuire");
			}
		}
		
		// Enfin, les autres mais normalement, yen a pas ici
		
//		else {
//			System.out.println("Elle est proche d'une autre espèce neutre !");
//			int xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement aléatoire entre [-vitesse; + vitesse] */
//			int yalea = -vit + (int)(Math.random() * (2*vit + 1)); 
//			while ((ab + xalea) <0 || (ab + xalea) >550 || (or + yalea)<0 || (or +yalea) >300) {
//				xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement aléatoire entre [-vitesse; + vitesse] */
//				yalea = -vit + (int)(Math.random() * (2*vit + 1));
//			}
//			setAbs(ab + xalea);
//			setOrd(or + yalea);
//			System.out.println("Elle bouge de manière normale !");
//		}
		
		//Gérer la faim 
		
		setFaim(getFaim() - 5);  
		if (getFaim() <= 0) {
		System.out.println("Sardine meurt de faim"); //cela n'arrive jamais en pratique pour les crevettes
		getEco().getPoissons().remove(this);
		}
		
		
		
	}
	
}
	
