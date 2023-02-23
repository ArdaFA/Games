//Verwaltung des Kartenstapels
class Stack {
    public Card[] cards;
    public int top;

    public Stack(int size) {
        cards = new Card[size];
        top = -1;
    }

    public void push(Card card) {
        if (top == cards.length - 1) {
            System.out.println("Stack is full");
        } 
		else {
            cards[++top] = card;
        }
    }

    public Card pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } 
		else {
            return cards[top--];
        }
    }

    public Card showCard() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } 
		else {
            return cards[top];
        }
    }

    public int count() {
        return top + 1;
    }
}
