import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Cards {
	String suit;
	int value;
	Image cardImg;
	ImageView imgView;
	boolean myTurn = false;
	
	
	Cards(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	Cards() {
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public Image getImage() {
		return cardImg;
	}
	
	public void setImage(String f) {
		String com = "file:images\\" + f + ".jpg";
		this.cardImg = new Image(com);
		this.imgView = new ImageView(cardImg);
	}
	
	public String toString() {
		return suit + value;
	}
	
	public ImageView getIV() {
		return imgView;
	}
}
