package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
	protected String name;
	protected BlackJackHand hand;
	protected double dollarAmount;
	
	Person(String _name, double _dollarAmount) {
		name = _name;
		dollarAmount = _dollarAmount;
		hand = new BlackJackHand();
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDollarAmount(double _dollarAmount) {
		dollarAmount = _dollarAmount;
	}
	
	public double getDollarAmount() {
		return dollarAmount;
	}
	
	public BlackJackHand getHand() {
		return hand;
	}
	
	public abstract void showHand();
}
