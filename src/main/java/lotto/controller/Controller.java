package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.Input;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.LottoService;
import lotto.view.InputMessage;

import java.util.List;

public class Controller {

    // 이렇게 의존성 주입을 하는 게 더 낫다고 함..!
    private User user;
    private Winning winning;
    private LottoService lottoService;
    private InputMessage inputMessage;

    public void getBuyAmount() {
        inputMessage.getUserBuyAmount();
        int amount = lottoService.convertStringToInt(readLine());
        user.setBuyAmount(amount);
    }

    public void getWinningNumberInput() {
        inputMessage.getLottoWinningNumber();
        List<Integer> list = lottoService.convertStringToList(readLine());
        winning.setWinningNumberList(list);
    }

}
