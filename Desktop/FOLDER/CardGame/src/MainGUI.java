import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainGUI extends Application{
	private Stage primaryStage;
	private Scene scene;
	private GridPane playedCards; 
	private BorderPane pane, central;
	private HBox myCards, ai2Cards, firstPlayed, secondPlayed, thirdPlayed, fourthPlayed;
	private VBox ai1Cards, ai3Cards;
	private Game game;
	private Button nextRound, playAgain;
	private Cards AI1Card, AI2Card, AI3Card, cardPlayed, highestCard;
	private Label winner; 
	int testing = 1;  //Testing Purposes
	
	
	@Override
	public void start(Stage PrimaryStage) {
		primaryStage = PrimaryStage;
		game = new Game();
		layoutGUI();
		cardHandler();
		buttonHandler();
		
	}
	
	public void layoutGUI() {
		pane = new BorderPane();
		central = new BorderPane();
		pane.setPrefSize(1500,800);
		pane.setStyle("-fx-background-color:antiquewhite");
		
		nextRound = new Button("Next Round");
		
		myCards = new HBox(-150);
		ai2Cards = new HBox(-150);
		ai3Cards = new VBox(-228);
		ai1Cards = new VBox(-228);
		playedCards = new GridPane();
		playedCards.setHgap(5.5);
		firstPlayed = new HBox(-175);
		secondPlayed = new HBox(-175);
		thirdPlayed = new HBox(-175);
		fourthPlayed = new HBox(-175);
		
		myCards.setMaxWidth(400);
		ai2Cards.setMaxWidth(400);
		ai3Cards.setMaxHeight(400);
		ai1Cards.setMaxHeight(400);
		
		ai1Cards.setPadding(new Insets(3));
		ai1Cards.setScaleX(.75);
		ai1Cards.setScaleY(.75);

		ai2Cards.setPadding(new Insets(3));
		ai2Cards.setScaleX(.75);
		ai2Cards.setScaleY(.75);
		
		ai3Cards.setPadding(new Insets(3));
		ai3Cards.setScaleX(.75);
		ai3Cards.setScaleY(.75);

		myCards.setPadding(new Insets(3));
		myCards.setScaleX(.75);
		myCards.setScaleY(.75);
		
		for(int i = 0; i < game.hum.getHand().size(); i++) {
			myCards.getChildren().add(game.arr.get(i));
			ai1Cards.getChildren().add(game.arr1.get(i));
			ai2Cards.getChildren().add(game.arr2.get(i));
			ai3Cards.getChildren().add(game.arr3.get(i));	
		} 
		
		pane.setTop(ai2Cards);
		pane.setBottom(myCards);
		pane.setRight(ai3Cards);
		pane.setLeft(ai1Cards);
		pane.setCenter(central); 
		
		
		central.setCenter(playedCards);
		central.setBottom(nextRound);
		central.setAlignment(playedCards,Pos.CENTER);
		central.setAlignment(nextRound, Pos.CENTER);
		central.setMaxWidth(400);
		central.setMaxHeight(400);
		
		pane.setAlignment(myCards, Pos.CENTER);
		pane.setAlignment(ai2Cards, Pos.CENTER);
		pane.setAlignment(ai3Cards, Pos.CENTER_RIGHT);
		pane.setAlignment(ai1Cards, Pos.CENTER_LEFT);  
		
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	//The event handler that'll play the card when it is clicked
	public void cardHandler() {
		game.arr.get(0).setOnMouseClicked(e -> playCard(0));
		game.arr.get(1).setOnMouseClicked(e -> playCard(1));
		game.arr.get(2).setOnMouseClicked(e -> playCard(2));
		game.arr.get(3).setOnMouseClicked(e -> playCard(3));
		game.arr.get(4).setOnMouseClicked(e -> playCard(4));
		game.arr.get(5).setOnMouseClicked(e -> playCard(5));
		game.arr.get(6).setOnMouseClicked(e -> playCard(6));
		game.arr.get(7).setOnMouseClicked(e -> playCard(7));
		game.arr.get(8).setOnMouseClicked(e -> playCard(8));
		game.arr.get(9).setOnMouseClicked(e -> playCard(9));
		game.arr.get(10).setOnMouseClicked(e -> playCard(10));
		game.arr.get(11).setOnMouseClicked(e -> playCard(11));
		game.arr.get(12).setOnMouseClicked(e -> playCard(12));
	}
	
	
	//When card at 0 is clicked, it is removed from player's hand and placed in the center,
	//firstPlayed is the first card on the table and playedCards is the GridPane that holds all the cards played
	private void playCard(int r) {
		if(game.highOne == 1) {
			cardPlayed = game.hum.getHand().get(r);
			AI1Card = game.AI1.compTurn(cardPlayed.getSuit());
			AI2Card = game.AI2.compTurn(cardPlayed.getSuit());
			AI3Card = game.AI3.compTurn(cardPlayed.getSuit());
		
			firstPlayed.getChildren().add(cardPlayed.getIV());
			secondPlayed.getChildren().add(AI1Card.getIV());
			thirdPlayed.getChildren().add(AI2Card.getIV());
			fourthPlayed.getChildren().add(AI3Card.getIV());
		
			game.allPlayed = true;
		
			playedCards.add(firstPlayed, 0, 0);
			playedCards.add(secondPlayed, 1, 0);
			playedCards.add(thirdPlayed, 2, 0);
			playedCards.add(fourthPlayed, 3, 0);
		}
		
		if(game.highOne == 2) {
			cardPlayed = game.hum.getHand().get(r);
			
			fourthPlayed.getChildren().add(cardPlayed.getIV());
			
			playedCards.add(fourthPlayed, 3, 0);
			
			game.allPlayed = true;
		}
		
		if(game.highOne == 3) {
			cardPlayed = game.hum.getHand().get(r);
			
			thirdPlayed.getChildren().add(cardPlayed.getIV());
			
			playedCards.add(thirdPlayed, 2, 0);
			
			game.hum.myTurn = true;
			
			if(game.hum.myTurn) {
				
				AI1Card = game.AI1.compTurn(AI2Card.getSuit());
				
				fourthPlayed.getChildren().add(AI1Card.getIV());
				
				playedCards.add(fourthPlayed, 3, 0);
				
				game.hum.myTurn = false;	
			}
			game.allPlayed = true;
		}
		
		if(game.highOne == 4) {
			cardPlayed = game.hum.getHand().get(r);
			
			secondPlayed.getChildren().add(cardPlayed.getIV());
			
			playedCards.add(secondPlayed, 1, 0);
			
			game.hum.myTurn = true;
			
			if(game.hum.myTurn) {
				AI1Card = game.AI1.compTurn(AI3Card.getSuit());
				AI2Card = game.AI2.compTurn(AI3Card.getSuit());
				
				thirdPlayed.getChildren().add(AI1Card.getIV());
				fourthPlayed.getChildren().add(AI2Card.getIV());
				
				playedCards.add(thirdPlayed, 2, 0);
				playedCards.add(fourthPlayed, 3, 0);
				
				game.hum.myTurn = false;	
			}
			game.allPlayed = true;
		}	
	}
	
	
	//Event handler for next round button
	public void buttonHandler() {
		nextRound.setOnAction(e -> next());		
	}
	
	private void next() {
		game.temp = new ArrayList<Cards>();
		
		game.temp.add(cardPlayed);
		game.temp.add(AI1Card);
		game.temp.add(AI2Card);
		game.temp.add(AI3Card);
		
		if(game.highOne == 1)
			highestCard = game.highestCard(game.temp, cardPlayed);
		if(game.highOne == 2)
			highestCard = game.highestCard(game.temp, AI1Card);
		if(game.highOne == 3)
			highestCard = game.highestCard(game.temp, AI2Card);
		if(game.highOne == 4)
			highestCard = game.highestCard(game.temp, AI3Card);
		
		game.highOne = game.priority(highestCard, cardPlayed, AI1Card, AI2Card);
		
		if(testing == 13) {
			firstPlayed.getChildren().clear();
			secondPlayed.getChildren().clear();
			thirdPlayed.getChildren().clear();
			fourthPlayed.getChildren().clear();
			playedCards.getChildren().clear();
			
			winner = new Label("Game has ended");
			
			central.setTop(winner);
			central.setAlignment(winner, Pos.CENTER);
			
			playAgain = new Button("Play Again");
			central.setCenter(playAgain);
			central.setAlignment(playAgain, Pos.CENTER);
			
			playAgain.setOnAction(e -> nextGame());
			
			
			game.allPlayed = false;
		}
		
		if(game.allPlayed) {
			firstPlayed.getChildren().clear();
			secondPlayed.getChildren().clear();
			thirdPlayed.getChildren().clear();
			fourthPlayed.getChildren().clear();
			playedCards.getChildren().clear();
			
		if(game.highOne == 2) {  
			AI1Card = game.AI1.CompTurnW();
			AI2Card = game.AI2.compTurn(AI1Card.getSuit());
			AI3Card = game.AI3.compTurn(AI1Card.getSuit());
			
			firstPlayed.getChildren().add(AI1Card.getIV());
			secondPlayed.getChildren().add(AI2Card.getIV());
			thirdPlayed.getChildren().add(AI3Card.getIV());
			
			
			playedCards.add(firstPlayed, 0, 0);
			playedCards.add(secondPlayed, 1, 0);
			playedCards.add(thirdPlayed, 2, 0);
		}
		
		if(game.highOne == 3) {
			AI2Card = game.AI2.CompTurnW();
			AI3Card = game.AI3.compTurn(AI2Card.getSuit());
			
			firstPlayed.getChildren().add(AI2Card.getIV());
			secondPlayed.getChildren().add(AI3Card.getIV());
			
			playedCards.add(firstPlayed, 0, 0);
			playedCards.add(secondPlayed, 1, 0);
		}
		
		if(game.highOne == 4) {
			AI3Card = game.AI3.CompTurnW();
			
			firstPlayed.getChildren().add(AI3Card.getIV());
			
			playedCards.add(firstPlayed, 0, 0);
		}
		
		winner = new Label(game.winner(game.temp, highestCard) + " won the previous round, " + game.whoPlayed(highestCard, game.temp) + " starts");
		
		central.setTop(winner);
		central.setAlignment(winner, Pos.CENTER);
		
		game.allPlayed = false;
		
		testing++;
		}
	}
	
	private void nextGame() {
		game = new Game();
		layoutGUI();
		cardHandler();
		buttonHandler();
		testing = 1;
	}
}