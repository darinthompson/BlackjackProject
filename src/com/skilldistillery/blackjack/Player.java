package com.skilldistillery.blackjack;

public class Player extends Person{
	
	public Player(String _name, double _dollarAmount) {
		super(_name, _dollarAmount);
	}
	
	public void showHand() {
		for (Card card : hand.getHand()) {
			card.printCard();
		}
	}
}
