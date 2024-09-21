package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {

    @DisplayName("로또 결과 초기화 테스트")
    @Test
    void InitLottoResult() {
        //given
        LottoResult lottoResult = new LottoResult();

        //when
        HashMap<Rank, Integer> resultMap = lottoResult.getLottoResult();

        //then
        assertEquals(0, resultMap.get(Rank.FIRST));
        assertEquals(0, resultMap.get(Rank.SECOND));
        assertEquals(0, resultMap.get(Rank.THIRD));
        assertEquals(0, resultMap.get(Rank.FOURTH));
        assertEquals(0, resultMap.get(Rank.FIFTH));
        assertEquals(0, resultMap.get(Rank.MISS));
    }

    @DisplayName("로또 결과 계산 테스트")
    @Test
    void CalculateLottResult() {
        //given
        LottoResult lottoResult = new LottoResult();
        HashMap<Rank, Integer> resultMap = lottoResult.getLottoResult();

        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );
        Winning winning = new Winning(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        //when
        lottoResult.calculateLottoResult(lottoList, winning);

        //then
        assertEquals(1, resultMap.get(Rank.FIRST));
        assertEquals(1, resultMap.get(Rank.SECOND));
        assertEquals(1, resultMap.get(Rank.THIRD));
        assertEquals(0, resultMap.get(Rank.FOURTH));
        assertEquals(0, resultMap.get(Rank.FIFTH));
        assertEquals(0, resultMap.get(Rank.MISS));
    }
}