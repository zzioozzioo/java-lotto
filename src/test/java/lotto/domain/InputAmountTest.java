package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputAmountTest {

    @DisplayName("범위에서 벗어난 금액을 입력하면 예외가 발생한다.")
    @Test
    void createInputAmountByWrongRange() {
        assertThatThrownBy(() -> new InputAmount(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 한 장의 금액으로 나누어 떨어지지 않는 금액을 입력하면 예외가 발생한다.")
    @Test
    void InputAmountHasChange() {
        assertThatThrownBy(() -> new InputAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 금액에 대한 로또의 수량이 올바르게 계산해 반환한다.")
    @Test
    void getLottoQuantity() {
        //given
        InputAmount amount = new InputAmount(8000);

        //when
        int quantity = amount.calculateLottoQuantity();

        //then
        assertEquals(quantity, 8);
    }

    @DisplayName("사용자가 입력한 금액을 올바르게 반환한다.")
    @Test
    void getInputAmount() {
        //given
        InputAmount amount = new InputAmount(8000);

        //when
        long totalAmount = amount.getTotalAmount();

        //then
        assertEquals(totalAmount, 8000);
    }
}
