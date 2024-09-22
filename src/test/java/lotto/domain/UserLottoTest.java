package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLottoTest {

    @DisplayName("사용자 전체 로또 번호 생성 테스트")
    @Test
    void GenerateAllUserLotto() {
        //given
        int quantity = 3;
        UserLotto userLotto = new UserLotto();

        //when
        userLotto.generateAllUserLotto(quantity);

        //then
        assertEquals(3, userLotto.getAllUserLotto().size());
    }

    @DisplayName("사용자 로또 1장 번호 생성 테스트")
    @Test
    void GenerateOneUserLotto() {
        //given
        UserLotto userLotto = new UserLotto();

        //when
        Lotto lotto = userLotto.generateOneUserLotto();

        //then
        assertEquals(6, lotto.getNumbers().size());
    }
}
