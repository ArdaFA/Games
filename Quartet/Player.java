import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Player {
    public String name;
    public int score;
    public Stack stack;
    
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.stack = new Stack(8);
    }
	
    public int countCards() {
        return stack.count();
    }

    public void addPoint() {
        score++;
    }

    public int getPoints() {
        return score;
    }
    public void addCard(Card card){
        stack.push(card);
    }
    public void showCard() {
        System.out.println(stack.showCard());
    }

	//beschreibt, was beim Spieler passiert bzw. was er machen muss
    public Card playCard(String category) {
        String[] categories = {"height", "intelligence", "strength", "jediPower"};
        while (!Arrays.asList(categories).contains(category)) {
            System.out.println("Please give a relevant category");
            category = scanner.nextLine();
        }
        Card card = stack.pop();
        return card;
    }

	// beschreibt, dass die Karte ausgegeben wird
    public Card playCard() {
        Random random = new Random();
        String[] categories = {"height", "intelligence", "strength", "jediPower"};
        String category = categories[random.nextInt(4)];
        Card card = stack.pop();
        System.out.println("Player: " + name + " played card: " + card);
        System.out.println("Category: " + category + " value: " + getValue(card, category));
        return card;
    }
    
    public String getRandomCategory() {
        String[] categories = {"height", "intelligence", "strength", "jediPower"};
        Random random = new Random();
        return categories[random.nextInt(4)];
    }


    public double getValue(Card card, String category) {
        switch (category) {
            case "height":
                return card.getHeight();
            case "intelligence":
                return card.getIntelligence();
            case "strength":
                return card.getStrength();
            case "jediPower":
                return card.getJediPower();
            default:
                return 0;
        }
    }
} 
