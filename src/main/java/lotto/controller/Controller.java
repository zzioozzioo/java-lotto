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

    private User user = new User();
    private Winning winning = new Winning();
    private ConvertService convertService = new ConvertService();
    private UserService userService = new UserService();
    private CalcService calcService = new CalcService();
    private InputMessage inputMessage = new InputMessage();
    private DisplayResult displayResult = new DisplayResult();

    public void run() {
        // TODO: user.initLottoResult()를 그대로 넣는 게 맞나 고민
        user.initLottoResult();
        getBuyAmountInput(); // 여기까진 ㄱㅊ
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
        int amount = convertService.convertInputAmount(readLine());
//        int amount = convertService.convertInputAmount("8000");
        user.setBuyAmount(amount);
    }

    public void getAllUserLottoNumber() {
        calcService.countHowManyLotto(user);
        displayResult.displayBuyHowManyLotto(user);
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
        List<Integer> list = convertService.convertStringToList(readLine());
        winning.setWinningNumberList(list);
    }

    public void getBonusNumberInput() {
        inputMessage.getLottoBonusNumber();
        int bonus = convertService.convert(readLine());
        winning.setBonusNumber(bonus);
    }

    public void getLottoResult() {
        calcService.calculateLottoResult(user);
    }


    public void getWinningStatistics() {
        displayResult.displayWinningStatistics();

        // 일치 개수별 당첨 개수 출력
        displayResult.displayWinningRank(user);

        // 수익률 출력
        calcService.calculateWinnings(user);
        calcService.caculateRateOfReturn(user);
        displayResult.displayRateOfReturn(user);
    }
}
