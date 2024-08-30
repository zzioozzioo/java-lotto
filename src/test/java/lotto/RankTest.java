package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {


    @DisplayName("2개 이하 일치할 경우 MISS를 반환한다.")
    @Test
    void determineRankWhenMiss() {
        Rank rank = Rank.determineRank(2, false);
        assertEquals(Rank.MISS, rank);
    }

    @DisplayName("3개 일치할 경우 FIFTH를 반환한다.")
    @Test
    void determineRankWhenFifth() {
        Rank rank = Rank.determineRank(3, false);
        assertEquals(Rank.FIFTH, rank);
    }

    @DisplayName("4개 일치할 경우 FOURTH를 반환한다.")
    @Test
    void determineRankWhenFourth() {
        Rank rank = Rank.determineRank(4, false);
        assertEquals(Rank.FOURTH, rank);
    }

    @DisplayName("5개 일치하고 보너스 숫자가 일치하지 않을 경우 FIFTH를 반환한다.")
    @Test
    void determineRankWhenThird() {
        Rank rank = Rank.determineRank(5, false);
        assertEquals(Rank.THIRD, rank);
    }

    @DisplayName("5개 일치하고 보너스 숫자가 일치할 경우 FIFTH를 반환한다.")
    @Test
    void determineRankWhenSecond() {
        Rank rank = Rank.determineRank(5, true);
        assertEquals(Rank.SECOND, rank);
    }

    @DisplayName("6개 일치할 경우 FIRST를 반환한다.")
    @Test
    void determineRankWhenFirst() {
        Rank rank = Rank.determineRank(6, false);
        assertEquals(Rank.FIRST, rank);
    }

    @DisplayName("일치 개수가 유효하지 않으면 예외를 반환한다.")
    @Test
    void determineRankWhenInvalidInput() {
        assertThatThrownBy(() -> Rank.determineRank(7, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}
