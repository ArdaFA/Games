public class Card {
	
	private char value;
	private boolean guess = false;
	
	//Constructor
	public Card(char value) {
		this.value = value;
	}
	
	//Getters and Setters
	public char getValue() {
		return value;
	}
	
	public void setValue() {
		this.value = value;
	}
	
	public boolean isGuess() {
		return guess;
	}
	
	public void setGuess(boolean guess) {
		this.guess = guess;
	}

}
