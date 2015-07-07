import java.util.ArrayList;

import javafx.scene.image.ImageView;


public class Game {
	int scoret1 = 0;
	int scoret2 = 0;
	String winner = "";
	int round = 0;
	String team1 = "";
	String team2 = "";
	Players hum,AI1,AI2,AI3;
	int highOne = 1;
	Deck deck;
	ArrayList<Cards> temp;
	ArrayList<ImageView> arr,arr1,arr2,arr3;
	boolean allPlayed = false;
	
	
	Game() {
		hum = new Players("jack");
		AI1 = new Players("AI1");
		AI2 = new Players("AI2");
		AI3 = new Players("AI3");
		
		team1 = hum.getName() + " " + AI2.getName();
		team2 = AI1.getName() + " " + AI3.getName();
		
		deck = new Deck();
		deck.shuffle();
		
		temp = new ArrayList<Cards>();
		
		arr = new ArrayList<ImageView>();
		arr1 = new ArrayList<ImageView>();
		arr2 = new ArrayList<ImageView>();
		arr3 = new ArrayList<ImageView>();
		
		dealImage(hum,arr,deck);
		dealImage(AI1,arr1,deck);
		dealImage(AI2,arr2,deck);
		dealImage(AI3,arr3,deck);

	}
	
	public void dealImage(Players p, ArrayList<ImageView> arr,Deck deck) {
		for(int i = 0; i < 13; i++) {
			p.addCard(deck.deal());
			p.getHand().get(i).setImage(p.getHand().get(i).toString());
			arr.add(p.getHand().get(i).getIV());
		}
	}
	
	Game(Players a, Players b, Players c, Players d) {
		this.hum = a;
		this.AI1 = b;
		this.AI2 = c;
		this.AI3 = d;
		
		team1 = a.getName() + " " + c.getName();
		team2 = b.getName() + " " + d.getName(); 
		
		deck = new Deck();
		
	}
	
	public Cards highestCard(ArrayList<Cards> arr, Cards c) {
		
		ArrayList<Cards> temp = new ArrayList<Cards>();
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getSuit().equals(c.getSuit())) {
				temp.add(arr.get(i));
			}
		}
		int highest = temp.get(0).getValue();
		Cards tempC = temp.get(0);
		for(int i = 1; i < temp.size(); i++) {
			if(temp.get(i).getValue() > highest) {          //figure out a way to add score here
				highest = temp.get(i).getValue();
				tempC = temp.get(i);
			}
			
		} 
	//	return temp.toString();
		return tempC;
		
	}
	
	public String winner(ArrayList<Cards> arr, Cards highest) {
		if(highest.toString().equals(arr.get(1).toString()) || highest.toString().equals(arr.get(3).toString())) {
			scoret2++;
			return team2;
		}
		else {
			scoret1++;
			return team1;
		}
		
	} 
	
	public int getScoret1() {
		return scoret1;
	}
	
	public int getScoret2() {
		return scoret2;
	}
	
	public int priority(Cards highest, Cards hum, Cards AI1, Cards AI2) {
		if(hum.toString().equals(highest.toString()))
			return 1;
		 if(AI1.toString().equals(highest.toString()))
			return 2;
		 if(AI2.toString().equals(highest.toString()))
			return 3;
		 
			return 4;
		
	}
	
	public int testTurn(Cards highest, ArrayList<Cards> arr) {
		
		for(int t = 0; t < arr.size(); t++) {
			if(arr.get(t).toString().equals(highest.toString())) {
				highOne = t;
			}
		}
		return highOne;
	}
	
	public String playHand(Players a) {
		String s = "";
		for(int i = 0; i < a.getHand().size(); i++) {
			s = s + a.getHand().get(i) + " ";
		}
		return s; 
	}
	
	public Cards cardPlayed(Cards c, ArrayList<Cards> arr) {
		arr.add(c);
		return c;
	}
	
	public String whoPlayed(Cards highestCard, ArrayList<Cards> arr) {
		if(arr.indexOf(highestCard) == 0)
			return "Player";
		if(arr.indexOf(highestCard) == 1) 
			return "AI1";
		if(arr.indexOf(highestCard) == 2)
			return "AI2";
		
		return "AI3";
		
	}
}
