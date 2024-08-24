package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.CalcService;
import lotto.service.ConvertService;
import lotto.service.UserService;
import lotto.view.DisplayResult;
import lotto.view.InputMessage;

import java.util.List;

public class Controller {

    private User user;
    private Winning winning;
    private ConvertService lottoService;
    private UserService userService;
    private CalcService calcService;
    private InputMessage inputMessage;
    private DisplayResult displayResult;

    public void run() {
        getBuyAmountInput();
        getWinningNumberInput();
        getBonusNumberInput();
        getAllUserLottoNumber();
    }

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

    public void getAllUserLottoNumber() {
        displayResult.displayBuyHowManyLotto();
        int quantity = user.getLottoQuantity();
        // 사용자 로또 번호 생성
        for (int i = 0; i < quantity; i++) {
            getOneUserLottoNumber();
        }
        displayUserLottoResult();
    }

    private void displayUserLottoResult() {
        for (Lotto lotto : user.getPurchasedLotteries()) {
            displayResult.displayUserLottoNumber(lotto.getNumbers());
        }
    }

    private void getOneUserLottoNumber() {
//            userService.getRandomNumber();
//            displayResult.displayUserLottoNumber();
//            calcService.calculateWinning();
        Lotto lotto = userService.getRandomNumber(); // sort 완료
        user.buyLotto(lotto); // add 완료
    }

}
