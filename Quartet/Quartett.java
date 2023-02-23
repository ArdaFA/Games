import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Quartett {
	
	public static void main(String[] args) {
        Player player = new Player("Player 1");
        Player computer = new Player("Computer");
		boolean turnselect = true;

       
        Card[] cards = { 										// Erstellt 8 Karten und teilt diese zwischen Spieler und Comoputer auf; Werte sind veränderbar
                new Card("Kurt", "REBEL", 0.40, 4, 1, 9),
                new Card("Michael", "IMPERIUM", 1.90, 6, 9, 7),
                new Card("John", "REBEL", 1.80, 8, 5, 8),
                new Card("Rafael", "IMPERIUM", 0.66, 9, 3, 10),
                new Card("Joe", "EMPIRE", 1.75, 5, 2, 3),
                new Card("Patrick", "IMPERIUM", 1.65, 7, 7, 6),
                new Card("Glen", "REBEL", 1.83, 2, 8, 1),
                new Card("Jeff", "IMPERIUM", 1.78, 3, 4, 5)
        };
        Collections.shuffle(Arrays.asList(cards));

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                player.addCard(cards[i]);
            } else {
                computer.addCard(cards[i]);
            }
        }

        // Durchführung des Spiels
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player;
        Player otherPlayer = computer;
		int Runde = 1;
        while (player.countCards() > 0 && computer.countCards() > 0) {
			System.out.println("Runde: " + Runde);
			System.out.println("Spielerkarte:");
			player.showCard();
            if (currentPlayer == player) {		//beschreibt was passieren soll, wenn Spieler an der Reihe
                System.out.println("Select category: height, intelligence, strength, jediPower");
				boolean tmpcat = true;
				String category = "";
				while(tmpcat) {		//überprüft die Eingabe des Spielers
					String[] categories = {"height", "intelligence", "strength", "jediPower"};
					category = scanner.nextLine();
					for (String tmpcats : categories) {
						if (tmpcats.equals(category)) {
							tmpcat = false;
						}
					}
					if (tmpcat) {
						System.out.println("ungueltige Eingabe");
					}
				}
				System.out.println("Computerkarte:");
				computer.showCard();
                Card playerCard = player.playCard(category);
                Card computerCard = computer.playCard(category);
				System.out.println("Vergleich der Werte:");
                double playerValue = player.getValue(playerCard, category);
                double computerValue = computer.getValue(computerCard, category);
				System.out.println(playerValue);
				System.out.println(computerValue);
                if (playerValue > computerValue) {
                    player.addPoint();
                } 
				else if (playerValue == computerValue) {
				} 
				else {
                	computer.addPoint();
                    otherPlayer = player;
                    currentPlayer = computer;
                }
            } 
			else {				//beschreibt was passiert, wenn der Computer an der Reihe
				String cat = player.getRandomCategory();
				System.out.println("selected category:"+ cat);
				System.out.println("Computerkarte:");
				computer.showCard();
                Card playerCard = player.playCard(cat);
                Card computerCard = computer.playCard(cat);
				System.out.println("Vergleich der Werte:");
                double playerValue = player.getValue(playerCard, cat);
                double computerValue = computer.getValue(computerCard, cat);
				System.out.println(playerValue);
				System.out.println(computerValue);
                if (playerValue > computerValue) {
                    player.addPoint();
					otherPlayer = computer;
                    currentPlayer = player;
                }
				else if (playerValue == computerValue){
				}
				else {
                	computer.addPoint();
                }
            }
            System.out.println("Player points: " + player.getPoints() + " Computer points: " + computer.getPoints());
			System.out.println("");
			Runde++;
        }

        // Ausgabe, wenn Spiel vorbei ist
        if (player.getPoints() > computer.getPoints()) {
            System.out.println("Player wins!");
        }
		else if (player.getPoints() < computer.getPoints()){
            System.out.println("Computer wins!");
        }
		else {
			System.out.println("Unentschieden!");
		}
    }

} 
