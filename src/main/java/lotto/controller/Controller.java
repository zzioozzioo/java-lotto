package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.CalcService;
import lotto.service.ConvertService;
import lotto.service.UserService;
import lotto.view.DisplayResult;
import lotto.view.InputMessage;
import lotto.view.DisplayResult;

import java.util.List;

public class Controller {

    // 이렇게 의존성 주입을 하는 게 더 낫다고 함..!
    private User user;
    private Winning winning;
    private ConvertService lottoService;
    private UserService userService;
    private CalcService calcService;
    private InputMessage inputMessage;
    private DisplayResult displayResult;

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

    public void getUserLottoNumber() {
        displayResult.displayBuyHowManyLotto();
        int num = user.getLottoQuantity();
        for (int i = 0; i < num; i++) {
            userService.getRandomNumber();
            displayResult.displayUserLottoNumber();
            calcService.calculateWinning();
        }
    }

}
