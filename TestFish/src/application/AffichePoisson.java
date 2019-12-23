package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class AffichePoisson {

	
	private int ID;
	private int pos_x;
	private int pos_y;
	private int taille_x;
	private int taille_y;

	

	  
	public AffichePoisson(int x, int y, int id, int tx, int ty){
	    
		    pos_x = x;
		    pos_y = y;
		    ID = id; 
		    taille_x = tx;
		    taille_y = ty; }
		    
	public void add_image(Pane pane) {
				int a = getPos_x();
				int b = getPos_y();
				int c = getTaille_x();
				int d = getTaille_y();
				
				Image image = new Image(getClass().getResourceAsStream("product_sardine.png"));
				ImageView iv1=new ImageView(image);
			    iv1.setFitHeight(c);
			    iv1.setFitWidth(d);
			    Button sound_button = new Button("");
			    sound_button.setGraphic(iv1);
			    sound_button.setStyle("-fx-background-color: rgba(0, 0, 255, 0); ");
			    sound_button.setLayoutX(a);
			    sound_button.setLayoutY(b);
			    pane.getChildren().add(sound_button);
			}

			public int getTaille_x() {
				return taille_x;
			}

			public void setTaille_x(int taille_x) {
				this.taille_x = taille_x;
			}

			public int getTaille_y() {
				return taille_y;
			}

			public void setTaille_y(int taille_y) {
				this.taille_y = taille_y;
			}

			public int getID() {
				return ID;
			}

			public void setID(int iD) {
				ID = iD;
			}

			public int getPos_x() {
				return pos_x;
			}

			public void setPos_x(int pos_x) {
				this.pos_x = pos_x;
			}

			public int getPos_y() {
				return pos_y;
			}

			public void setPos_y(int pos_y) {
				this.pos_y = pos_y;
			}
				
	
	
		  } 