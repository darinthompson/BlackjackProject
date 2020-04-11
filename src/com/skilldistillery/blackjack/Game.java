package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private static Dealer dealer;
	private static Player player;
	private static Scanner scan;
	private static boolean continueGame;

	public Game() {
		scan = new Scanner(System.in);
		dealer = new Dealer("Dealer", 5_000);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.Greeting();

		while (true) {
			

			
			g.playGame(player);

			if (continueGame == true) {
				g.playGame(dealer);
				g.determineWinner();
			}
			System.out.println("================================");
			System.out.println("|| Play again? 1. Yes | 2. No ||");
			System.out.println("================================");
			int userChoice = 0;
			while(userChoice != 1 && userChoice != 2) {
				userChoice = g.ValidateInt(">> ");
			}
			if(userChoice == 1) {
				if(dealer.getDeckCount() < 10) {
					dealer.getNewDeck();
				}
				player.getHand().ClearHand();
				dealer.getHand().ClearHand();
			} else {
				System.out.println("Thanks for playing. Come back soon!");
			}
		}

	}

	public void playGame(Person person) {
		if (person instanceof Player) {
			person.getHand().addCard(dealer.Deal());
			takeTurn(person);
			while (true) {
				System.out.println("1. Hit | 2. Stay");
				int userChoice = ValidateInt(">> ");
				if (userChoice == 1) {
					if (takeTurn(person) == false) {
						break;
					}
				} else if (userChoice == 2) {
					continueGame = true;
					break;
				} else {
					System.out.println("That is not one of the options");
				}
			}
		} else if (person instanceof Dealer) {
			person.getHand().addCard(dealer.Deal());
			takeTurn(person);
			while (person.getHand().getHandValue() < 17) {
				takeTurn(person);
			}
		}
	}

	public void determineWinner() {
		if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println(player.getName() + "Wins!");
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("House wins.");
		} else {
			System.out.println("Push");
		}
	}

	private boolean takeTurn(Person person) {
		person.getHand().addCard(dealer.Deal());
		person.showHand();
		System.out.println();
		System.out.println("==================");
		System.out.println("Current Score: " + person.getHand().getHandValue());
		System.out.println();

		if (person.getHand().getHandValue() == 21) {
			if (person instanceof Player) {
				System.out.println("WINNER!");
				continueGame = false;
				return false;
			}
			if (person instanceof Dealer) {
				System.out.println("House Wins.");
				continueGame = false;
				return false;
			}
		}

		if (person.getHand().getHandValue() > 21) {
			if (person instanceof Player) {
				System.out.println("BUST");
				continueGame = false;
				return false;
			}
			if (person instanceof Dealer) {
				System.out.println("Dealer Busts, you win");
				continueGame = false;
				return false;
			}
		}

		return true;
	}

	public void Greeting() {
		System.out.println("Hello, and welcome to BlackJack!");
		System.out.print("Name: ");
		String name = scan.nextLine();
		player = new Player(name, 5_000);
	}

	public int ValidateInt(String prompt) {
		int userNum;
		while (true) {
			System.out.print(prompt);
			try {
				userNum = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid amount(Must be a number).");
				System.out.println();
				scan.nextLine();
			}
		}
		scan.nextLine();
		return userNum;
	}
}
