import java.util.Scanner;

public class Main {
	
	// we need an array to save the value if cards
	
	private static Card[][] cards = new Card[5][5];

	public static void main(String[] args) {
		
		cards[0][0] = new Card('X');
		cards[0][1] = new Card('1');
		cards[0][2] = new Card('2');
		cards[0][3] = new Card('3');
		cards[0][4] = new Card('4');
		cards[1][0] = new Card('1');
		cards[1][1] = new Card('A');
		cards[1][2] = new Card('E');
		cards[1][3] = new Card('F');
		cards[1][4] = new Card('D');
		cards[2][0] = new Card('2');
		cards[2][1] = new Card('G');
		cards[2][2] = new Card('B');
		cards[2][3] = new Card('A');
		cards[2][4] = new Card('D');
		cards[3][0] = new Card('3');
		cards[3][1] = new Card('E');
		cards[3][2] = new Card('C');
		cards[3][3] = new Card('G');
		cards[3][4] = new Card('F');
		cards[4][0] = new Card('4');
		cards[4][1] = new Card('B');
		cards[4][2] = new Card('H');
		cards[4][3] = new Card('C');
		cards[4][4] = new Card('H');
		
		cards[0][0].setGuess(true);
		cards[0][1].setGuess(true);
		cards[0][2].setGuess(true);
		cards[0][3].setGuess(true);
		cards[0][4].setGuess(true);
		cards[1][0].setGuess(true);
		cards[2][0].setGuess(true);
		cards[3][0].setGuess(true);
		cards[4][0].setGuess(true);
	
		
		System.out.println("Welcomte to the Guessing Game! \n"
				+ "You can enter the coordinates (row and column) with a space between");
		while (isFinished() == false) {
			
			gameBoard();
			Guess();
			
		}
		
	}
	
	public static void Guess() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("give the coordinates of the point you want to guess: ");
		int i1 = scanner.nextInt();
		int j1 = scanner.nextInt();
		
		
		cards[i1][j1].setGuess(true);
		gameBoard();
		
		
		System.out.print("give the coordinates of the point you want to guess: ");
		int i2 = scanner.nextInt();
		int j2 = scanner.nextInt();
		
		if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
			cards[i2][j2].setGuess(true);
		}
		
		else {
			cards[i1][j1].setGuess(false);
		}
	}
	
	public static void gameBoard() {
		
		for (int i = 0; i < 5; i++) {
			
			System.out.println("------------------------");
			
			for (int j = 0; j < 5; j++) {
				
				
				if(cards[i][j].isGuess()) { // if guess is true
					// Show which has found
					System.out.print(" |" + cards[i][j].getValue() + "| ");
				}
				
				else { // if guess is wrong
					System.out.print(" | | ");
				}
				
			}
			System.out.println(""); // to go to the bottom line
		}
		System.out.println("------------------------");
	}
	
	
	public static boolean isFinished() {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				
				if(cards[i][j].isGuess() == false) {
					return false;
				}
			}
		}
		return true;
	}
}