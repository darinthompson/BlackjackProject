package com.skilldistillery.blackjack;

public class BlackJackHand extends Hand{
	
	public BlackJackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int score = 0;
		for (Card card : hand) {
			score += card.GetValue();
			if(card.getRank().toString().equals("ACE") && score > 10 && score != 21) {
				score -= 10;
			}
		}	
		return score;
	}
	
	public boolean isBlackJack() {
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			return true;
		}
		return false;
	}
}
