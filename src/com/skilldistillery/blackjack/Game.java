package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	private static Dealer dealer;
	private static Player player;
	private static Scanner scan;

	public Game() {
		scan = new Scanner(System.in);
		dealer = new Dealer("Dealer", 5_000);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.Greeting();

		while (true) {
			g.firstDeal();
			g.playGame();

			System.out.println("\n===================================");
			while (true) {
				int userChoice = g.ValidateInt("Play again? 1. Yes | 2. No");
				if (userChoice == 1) {
					player.getHand().ClearHand();
					dealer.getHand().ClearHand();
					if (dealer.getDeckCount() < 15) {
						dealer.getNewDeck();
					}
					break;
				}
				if (userChoice == 2) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				} else {
					System.out.println("Not a valid response");
				}
			}
		}
	}

	public void playGame() {
		while (true) {
			System.out.println("1. Hit | 2. Stay");
			int userChoice = ValidateInt(">> ");

			if (userChoice == 1) {
				player.getHand().addCard(dealer.Deal());
				displayTable();
				if (player.getHand().isBust()) {
					System.out.println("BUST! Dealer Wins");
					return;
				} else if (player.getHand().isBlackJack()) {
					break;
				}
			} else if (userChoice == 2) {
				break;
			} else {
				System.out.println("NOT A VALID CHOICE!");
			}
		}

		while (dealer.getHand().getHandValue() < 17) {
			dealer.getHand().addCard(dealer.Deal());
		}

		System.out.println("==========================");
		dealer.showHand();
		System.out.println("Final Dealer Score: " + dealer.getHand().getHandValue());
		if (dealer.getHand().getHandValue() > 21) {
			System.out.println("BUST Player Wins!");
		}

		if (!player.getHand().isBust() && !dealer.getHand().isBust()) {
			determineWinner();
		}
	}

	public void determineWinner() {
		if (player.getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
			System.out.println("PUSH");
		} else if (player.getHand().isBlackJack() && !dealer.getHand().isBlackJack()) {
			System.out.println("BLACKJACK, YOU WIN!");
		} else if (!player.getHand().isBlackJack() && dealer.getHand().isBlackJack()) {
			System.out.println("Blackjack, dealer wins.");
		} else if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("YOU WIN!");
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("Dealer wins");
		} else {
			System.out.println("PUSH");
		}
	}

	private void displayTable() {
		System.out.println("Dealer Showing: ");
		System.out.println("-------------------");
		dealer.showHandInitial();
		System.out.println();
		System.out.println("Player Showing: ");
		System.out.println("-------------------");
		player.showHand();
		System.out.println("\nScore: " + player.getHand().getHandValue());
		System.out.println("**********");
	}

	private void firstDeal() {
		player.getHand().addCard(dealer.Deal());
		player.getHand().addCard(dealer.Deal());
		dealer.getHand().addCard(dealer.Deal());
		dealer.getHand().addCard(dealer.Deal());
		System.out.println("==================");
		System.out.println();

		displayTable();

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
