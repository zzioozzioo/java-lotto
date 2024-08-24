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
        // TODO: user.initLottoResult()를 그대로 넣는 게 맞나 고민
        user.initLottoResult();
        getBuyAmountInput();
        getAllUserLottoNumber();
        getWinningNumberInput();
        getBonusNumberInput();
        getLottoResult();
        getWinningStatistics();
        // TODO: 당첨 통계 출력
        //  1. 일치 개수별 당첨 개수
        //  2. 수익률
    }

    public void getBuyAmountInput() {
        inputMessage.getUserBuyAmount();
        int amount = lottoService.convertInputAmount(readLine());
        user.setBuyAmount(amount);
    }

    public void getAllUserLottoNumber() {
        calcService.countHowManyLotto();
        displayResult.displayBuyHowManyLotto();
        int quantity = user.getLottoQuantity();

        for (int i = 0; i < quantity; i++) {
            getOneUserLottoNumber();
        }
        displayUserLottoResult();
    }

    public void getOneUserLottoNumber() {
        Lotto lotto = userService.getRandomNumber(); // sort 완료
        user.buyLotto(lotto); // add 완료
    }

    public void displayUserLottoResult() {
        for (Lotto lotto : user.getPurchasedLotteries()) {
            displayResult.displayUserLottoNumber(lotto.getNumbers());
        }
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

    public void getLottoResult() {
        calcService.calculateLottoResult();
    }


    public void getWinningStatistics() {
        displayResult.displayWinningStatistics();

        // 일치 개수별 당첨 개수 출력
        displayResult.displayWinningRank();

        // 수익률 출력
        calcService.calculateWinnings();
        calcService.caculateRateOfReturn();
        displayResult.displayRateOfReturn();
    }
}
