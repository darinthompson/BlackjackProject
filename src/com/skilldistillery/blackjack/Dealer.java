package com.skilldistillery.blackjack;

public class Dealer extends Person{
	private Deck deck;
	
	public Dealer(String _name, double _dollarAmount) {
		super(_name, _dollarAmount);
		deck = new Deck();
	}
	
	public void getNewDeck() {
		deck = new Deck();
	}
	
	public Card Deal() {
		return deck.DealCards();
	}
	
	public void showHand() {
		for (Card card : hand.getHand()) {
			card.printCard();
		}
	}
	
	public void showDeck() {
		for (Card card : deck.GetDeck()) {
			card.printCard();
		}
	}
	
	public int getDeckCount() {
		return deck.GetCardCount();
	}
}