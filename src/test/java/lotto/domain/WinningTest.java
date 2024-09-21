package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningTest {

    @DisplayName("범위에서 벗어난 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRange() {
        assertThatThrownBy(() -> new Winning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 중복된 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicated() {
        assertThatThrownBy(() -> new Winning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2개 이하 일치할 경우 MISS를 반환한다.")
    @Test
    void matchMissRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.MISS, matchRank);
    }

    @DisplayName("3개 일치할 경우 FIFTH를 반환한다.")
    @Test
    void matchFifthRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.FIFTH, matchRank);
    }

    @DisplayName("4개 일치할 경우 FOURTH를 반환한다.")
    @Test
    void matchFourthRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.FOURTH, matchRank);
    }

    @DisplayName("5개 일치하고 보너스 숫자가 일치하지 않을 경우 THIRD를 반환한다.")
    @Test
    void matchThirdRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.THIRD, matchRank);
    }

    @DisplayName("5개 일치하고 보너스 숫자가 일치할 경우 SECOND를 반환한다.")
    @Test
    void matchSecondRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.SECOND, matchRank);
    }

    @DisplayName("6개 일치할 경우 FIRST를 반환한다.")
    @Test
    void matchFirstRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Winning winning = new Winning(winningNumbers, 7);

        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank matchRank = winning.matchRank(userLottoNumbers);

        assertEquals(Rank.FIRST, matchRank);
    }

}
