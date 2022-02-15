package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private static final String EMPTY_DECK_EXCEPTION_MESSAGE = "[ERROR] 덱에 남은 카드가 없습니다.";
    private static final int SELECTED_CARD = 0;

    private final List<Card> cards;

    protected Cards(final List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    private Cards() {
        this.cards = Arrays.stream(Pattern.values())
            .flatMap(pattern ->
                Arrays.stream(Rank.values())
                    .map(rank -> new Card(pattern, rank))
                    .collect(Collectors.toList()).stream())
            .collect(Collectors.toList());
    }

    protected static Cards create() {
        return new Cards();
    }

    protected Card drawOne() {
        validateIsEmpty();
        Collections.shuffle(cards);
        return cards.get(SELECTED_CARD);
    }

    private void validateIsEmpty() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DECK_EXCEPTION_MESSAGE);
        }
    }

    protected Cards without(final Card card) {
        cards.remove(card);
        return new Cards(cards);
    }
}
