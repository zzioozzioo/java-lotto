package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.Input;
import lotto.service.LottoService;
import lotto.view.InputMessage;

public class Controller {

    // 이렇게 의존성 주입을 하는 게 더 낫다고 함..!
    private LottoService lottoService;
    private InputMessage inputMessage;
    public void getWinningNumberInput() {
        inputMessage.getLottoWinningNumber();
        lottoService.convertStringToList(readLine());
    }
}
