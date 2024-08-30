package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByWrongRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 개수를 올바르게 계산해 반환한다.")
    @Test
    void getWrongMatchCount() {

        //given
        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int count = userLottoNumbers.countMatch(winningNumbers);

        //then
        assertEquals(count, 6);
    }

    @DisplayName("숫자를 포함하고 있는지 여부를 올바르게 판별해 반환한다.")
    @Test
    void containNumber() {
        //given
        Lotto userLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int targetNumber = 1;

        //when
        boolean result = userLottoNumbers.containNumber(targetNumber);

        //then
        assertTrue(result);
    }
}
