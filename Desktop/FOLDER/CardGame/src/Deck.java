import java.util.ArrayList;


public class Deck {
	ArrayList<Cards> deckCards = new ArrayList<Cards>();
	 int index = 0;
	String [] suits = {"D", "C", "H", "S"};
	
	Deck() {
		for(int i = 0; i < suits.length; i++) {
			for(int t = 2; t <= 14; t++) {
				Cards a = new Cards(suits[i],t);
				deckCards.add(a);
			}
		}
	}
	
	
	public int getDeckSize() {
		return deckCards.size();
	}
	
	public ArrayList<Cards> getDeck() {
		return deckCards;
	}
	
	public void shuffle() {
		for(int i = 0; i < deckCards.size(); i++) {
			int index = (int) (Math.random() * deckCards.size());
			Cards temp = deckCards.get(i);
			deckCards.set(i, deckCards.get(index));
			deckCards.set(index, temp);
		}
	}
	
	public Cards deal() {
		if(index == 52)
			index = 0;
		return deckCards.get(index++);
	}
}
