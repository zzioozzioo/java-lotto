package lotto.controller;


import lotto.domain.*;
import lotto.service.CalcService;
import lotto.service.LottoService;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final LottoService lottoService = new LottoService();
    private final CalcService calcService = new CalcService();
    private final InputView inputMessage = new InputView();
    private final OutputView displayMessage = new OutputView();

    public void run() {

        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        InputAmount amount = getBuyAmountInput();
        List<Lotto> allUserLotto = getAllUserLottoNumber(amount);
        Winning winning = getWinningNumberInput();

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(allUserLotto, winning);

        // TODO: 여기까지 못 가는 듯.. 당첨 통계를 내지 못하고 NullPointException으로 종료됨
        getWinningStatistics(lottoResult, amount);
    }

    public InputAmount getBuyAmountInput() {
        int amount = inputMessage.readUserBuyAmount();
        return new InputAmount(amount);
    }

    public List<Lotto> getAllUserLottoNumber(InputAmount inputAmount) {
        int quantity = calcService.countHowManyLotto(inputAmount);
        displayMessage.printBuyHowManyLotto(quantity);

        List<Lotto> allUserLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            allUserLotto.add(getOneUserLottoNumber());
        }
        displayUserLottoResult(allUserLotto);
        return allUserLotto;
    }

    public Lotto getOneUserLottoNumber() { // 완
        return lottoService.getRandomLottoNumber();
    }

    public void displayUserLottoResult(List<Lotto> allUserLotto) {
        for (Lotto lotto : allUserLotto) {
            displayMessage.printUserLottoNumber(lotto.getNumbers());
        }
    }

    public Winning getWinningNumberInput() {
        Lotto lotto = new Lotto(inputMessage.readLottoWinningNumber());
        return getBonusNumberInput(lotto);
    }

    public Winning getBonusNumberInput(Lotto lotto) {
        int bonus = inputMessage.readLottoBonusNumber();
        return new Winning(lotto, bonus);
    }

    public void getWinningStatistics(LottoResult lottoResult, InputAmount amount) {
        displayMessage.printWinningStatistics();

        displayMessage.printWinningRank(lottoResult);

        double winnings = calcService.calculateWinnings(lottoResult);
        String rateOfReturn = calcService.calculateRateOfReturn(winnings, amount);

        displayMessage.printRateOfReturn(rateOfReturn);
    }
}
