package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	private int numOfCards = 52;
	
	public Deck() {
		makeDeck();
		shuffleDeck();
	}
	
	public List<Card> GetDeck() {
		return deck;
	}
	
	private void makeDeck() {
		for(Suit s: Suit.values()) {
			for(Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
	}
	
	private void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public Card DealCards() {
		numOfCards--;
		Card c = deck.get(0);
		deck.remove(c);
		return c;
	}
	
	public int GetCardCount( ) {
		return numOfCards;
	}
}
