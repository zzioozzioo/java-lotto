package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.ConvertService;
import lotto.view.InputMessage;

import java.util.List;

public class Controller {

    // 이렇게 의존성 주입을 하는 게 더 낫다고 함..!
    private User user;
    private Winning winning;
    private ConvertService lottoService;
    private InputMessage inputMessage;

    public void getBuyAmountInput() {
        inputMessage.getUserBuyAmount();
        int amount = lottoService.convertInputAmount(readLine());
        user.setBuyAmount(amount);
    }

    public void getWinningNumberInput() {
        inputMessage.getLottoWinningNumber();
        List<Integer> list = lottoService.convertStringToList(readLine());
        winning.setWinningNumberList(list);
    }

    public void getBonusNumberInput() {
        inputMessage.getLottoBonusNumber();
        int bonus = lottoService.convert(readLine());
        winning.setBonusNumber(bonus);
    }

}
