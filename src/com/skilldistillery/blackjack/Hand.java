package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public List<Card> getHand() {
		return hand;
	}
	
	public int getHandValue() {
		int score = 0;
		for (Card card : hand) {
			if(card.getRank().toString().equals("Ace") && score > 10) {
				card.getRank().setValue(1);
			}
			score += card.GetValue();
		}
		return score;
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void ClearHand() {
		hand.clear();
	}
}
