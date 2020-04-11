package com.skilldistillery.blackjack;

public class Card {
	 private Rank rank;
	 private Suit suit;
	 
	 public Card(Rank _rank, Suit _suit) {
		 rank = _rank;
		 suit = _suit;
	 }
	 
	 public int GetValue() {
		 return rank.getValue();
	 }
	 
	 public Rank getRank() {
		 return rank;
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	public void printCard() {
		//return (rank + " of " + suit);
		String faceValue = "";
		String suitValue = "";
		
		switch(rank.toString()) {
		case "JACK": 
			faceValue = "J";
			break;
		case "QUEEN":
			faceValue = "Q";
			break;
		case "KING":
			faceValue = "K";
			break;
		case "ACE":
			faceValue = "A";
			break;
		default:
			faceValue = String.valueOf(rank.getValue());
			break;
		}
		
		switch(suit.toString()) {
		case "Hearts":
			suitValue = "\u2665";
			break;
		case "Spades":
			suitValue = "\u2664";
			break;
		case "Diamonds":
			suitValue = "\u2666";
			break;
		case "Clubs":
			suitValue = "\u2667";
			break;
		}
		
		System.out.println(" ____ ");
		System.out.println("|    |");
		if(faceValue.equals("10")) {
			System.out.println("| " + faceValue + " |");
		} else {
			System.out.println("| " + faceValue + "  |");
		}
		System.out.println("| " + suitValue + "  |");
		System.out.println("|____|");
		
		
	}
	
//	public void printBlankCard() {
//		sout
//	}
	 
	 
	 
	 
}
