package application;


public class Maquereau extends Poisson{

	public Maquereau(int abs, int ord, int dir, int cara, Ecosysteme eco) {
		super(abs, ord, 8, cara, 4, dir, 12, eco);
	}
	public String toString() {
		return "Je suis un maquereau, " + super.toString();
	}
	
	
	
	public void bouger2()
	{
		int ab = this.getAbs();
		int or = this.getOrd();
		int vit = this.getVitesse();
		System.out.println("Maquereau en [" + ab + "," + or + "] observe !");	
		Poisson voisin = this.observer2();
		
		// Tout d'abord : les potes
		
		if (voisin instanceof Maquereau) {
			System.out.println("Il est proche d'un autre Maquereau !");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			if (ab + (xv-ab)*vit/norm < 550) { //Pas trop à droite
				if (ab + (xv-ab)*vit/norm > 0) { //Pas trop à gauche
					if (or + (yv-or)*vit/norm < 300) { //Pas trop bas
						if (or + (yv-or)*vit/norm > 0) { //Pas trop haut
							System.out.println("Il s'approche de son copain Maquereau");
							setAbs((int)(ab + (xv-ab)*vit/norm));
							setOrd((int)(or + (yv-or)*vit/norm));
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
				this.manger2(voisin); // la proie est mangé
				System.out.println("Il a mangé la proie");
				//this.faim = cap; //défini dans le constructeur de poisson, normalement vu que Sardine hérite de poisson ça passe
				setAbs(xv);
				setOrd(yv);				
			}
			else {
				this.setVitesse(5); // acceleration
				if (ab + (xv-ab)*vit/norm < 550) { //Pas trop à droite
					if (ab + (xv-ab)*vit/norm > 0) { //Pas trop à gauche
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
		
		// Puis, les prédateurs
		
		else if (voisin instanceof GrandRequin) {
			System.out.println("Il est proche d'un prédateur Grand Requin!");
			int xv = voisin.getAbs();
			int yv = voisin.getOrd();
			double norm = Math.sqrt(Math.pow(xv-ab,2) + Math.pow(yv-or,2));
			if (ab + (-xv+ab)*vit/norm < 550) { //Pas trop à droite
				if (ab + (-xv+ab)*vit/norm > 0) { //Pas trop à gauche
					if (or + (-yv+or)*vit/norm < 300) { //Pas trop bas
						if (or + (-yv+or)*vit/norm > 0) { //Pas trop haut
							System.out.println("Il fuit le danger Grand Requin");
							setAbs((int)(ab + (-xv+ab)*vit/norm));
							setOrd((int)(or + (-yv+or)*vit/norm));
						}
						else {
							System.out.println("Il ne peut pas fuire");
						}
					}
					else {
						System.out.println("Il ne peut pas fuire");
					}
				}
				else {
					System.out.println("Il ne peut pas fuire");
				}
			}
			else {
				System.out.println("Il ne peut pas fuire");
			}
		}
		
		// Enfin, les autres
		
		else {
			System.out.println("Il est proche d'une autre espèce neutre !");
			int xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement aléatoire entre [-vitesse; + vitesse] */
			int yalea = -vit + (int)(Math.random() * (2*vit + 1)); 
			while ((ab + xalea) <0 || (ab + xalea) >550 || (or + yalea)<0 || (or +yalea) >300) {
				xalea = -vit + (int)(Math.random() * (2*vit + 1)); /* mouvement aléatoire entre [-vitesse; + vitesse] */
				yalea = -vit + (int)(Math.random() * (2*vit + 1));
			}
			setAbs(ab + xalea);
			setOrd(ab + yalea);
			System.out.println("Il bouge de manière normale !");
		}
		
		//Gérer la faim (a revoir)
		
//		this.faim = this.faim - 5;
//		if (this.faim <= 0) {
//		System.out.println("Maquereau meurt de faim"); //cela n'arrive jamais en pratique pour les crevettes
//		ecosys.getPoissons().remove(this);
//		}
		
	}
	

	

}