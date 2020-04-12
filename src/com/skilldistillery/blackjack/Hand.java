package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand;
	public abstract int getHandValue();
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void ClearHand() {
		hand.clear();
	}
}
