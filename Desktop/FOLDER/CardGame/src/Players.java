import java.util.ArrayList;


public class Players {
	ArrayList<Cards> hand = new ArrayList<Cards>();
	String name;
	boolean myTurn;
	Players(String name) {
		this.name = name;
	}
	
	public void addCard(Cards c) {
		hand.add(c);
	}
	
	public ArrayList<Cards> getHand() {
		return hand;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getMyTurn() {
		return myTurn;
	}
	
	public void remove(Cards c) {
		hand.remove(c);
	}
	
	public Cards compTurn(String suit) {
		ArrayList<Cards> temp = new ArrayList<Cards>();
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getSuit().equals(suit)) {
				temp.add(hand.get(i));
			}
		}
		if (temp.size() > 0) {
			Cards highest = temp.get(0);
			int highestATM = temp.get(0).getValue();
			for(int i = 1; i < temp.size(); i++) {
				if(temp.get(i).getValue() > highestATM) {
					highestATM = temp.get(i).getValue();
					highest = temp.get(i);
				}
				else {
					highest = temp.get(0);
				}
			}
			hand.remove(highest);
			return highest;
		}
		else {
			Cards lowest = hand.get(0);
			int lowestNum = hand.get(0).getValue();
			for(int i = 1; i < hand.size(); i++) {
				if(hand.get(i).getValue() < lowestNum) {
					lowestNum = hand.get(i).getValue();
					lowest = hand.get(i);
				}
			}
			hand.remove(lowest);
			return lowest;
		}
	}
	
	public Cards CompTurnW() {
		Cards temp = hand.get(((int)(Math.random() * hand.size())));
		hand.remove(temp);
		return temp;
	}
}