package blackjack.domain.card;

public enum Denomination {

    ACE("A", 11), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7), EIGHT("7", 8), NINE("9", 9), TEN("10", 10),
    JACK("J", 10), QUEEN("Q", 10), KING("K", 10);

    private final String name;
    private final int value;

    Denomination(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
}