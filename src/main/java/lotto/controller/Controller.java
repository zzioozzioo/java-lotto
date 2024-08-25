package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.service.CalcService;
import lotto.service.ConvertService;
import lotto.service.LottoService;
import lotto.view.DisplayMessage;
import lotto.view.InputMessage;

import java.util.List;

public class Controller {

    private User user = new User();
    private Winning winning = new Winning();
    private ConvertService convertService = new ConvertService();
    private LottoService lottoService = new LottoService();
    private CalcService calcService = new CalcService();
    private InputMessage inputMessage = new InputMessage();
    private DisplayMessage displayMessage = new DisplayMessage();

    public void run() {

        getInitialLottoResult();
        getBuyAmountInput();
        getAllUserLottoNumber();
        getWinningNumberInput();
        getBonusNumberInput();
        getLottoResult();
        getWinningStatistics();
    }

    private void getInitialLottoResult() {
        lottoService.initLottoResult(user);
    }

    public void getBuyAmountInput() {
        inputMessage.getUserBuyAmount();
        int amount = convertService.convertInputAmount(readLine());
        user.setBuyAmount(amount);
    }

    public void getAllUserLottoNumber() {
        calcService.countHowManyLotto(user);
        displayMessage.displayBuyHowManyLotto(user);
        int quantity = user.getLottoQuantity();

        for (int i = 0; i < quantity; i++) {
            getOneUserLottoNumber();
        }
        displayUserLottoResult();
    }

    public void getOneUserLottoNumber() {
        Lotto lotto = lottoService.getRandomLottoNumber(user);
        user.buyLotto(lotto);
    }

    public void displayUserLottoResult() {
        for (Lotto lotto : user.getPurchasedLotteries()) {
            displayMessage.displayUserLottoNumber(lotto.getNumbers());
        }
    }

    public void getWinningNumberInput() {
        inputMessage.getLottoWinningNumber();
        List<Integer> list = convertService.convertStringToList(readLine());
        winning.setWinningNumberList(list);
    }

    public void getBonusNumberInput() {
        inputMessage.getLottoBonusNumber();
        int bonus = convertService.convertBonusNumber(readLine(), winning);
        winning.setBonusNumber(bonus);
    }

    public void getLottoResult() {
        calcService.calculateLottoResult(user, winning);
    }


    public void getWinningStatistics() {
        displayMessage.displayWinningStatistics();

        // 일치 개수별 당첨 개수 출력
        displayMessage.displayWinningRank(user);

        // 수익률 출력
        calcService.calculateWinnings(user);
        calcService.calculateRateOfReturn(user);
        displayMessage.displayRateOfReturn(user);
    }
}
