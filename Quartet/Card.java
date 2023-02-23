class Card {
    private String name;
    private String affiliation;
    private double height;
    private int intelligence;
    private int strength;
    private int jediPower;

	//erstellt die Karten und ihre Kategorien
    public Card(String name, String affiliation, double height, int intelligence, int strength, int jediPower) {
        this.name = name;
        this.affiliation = affiliation;
        this.height = height;
        this.intelligence = intelligence;
        this.strength = strength;
        this.jediPower = jediPower;
    }

    public String getName() {
        return name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public double getHeight() {
        return height;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getJediPower() {
        return jediPower;
    }

    @Override
    public String toString() {
        return "name: " + name + "\naffiliation: " + affiliation + "\nheight: " + height + "\nintelligence: " + intelligence + "\nstrength: " + strength + "\njedi power: " + jediPower;
    }
}
