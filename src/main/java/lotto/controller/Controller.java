package lotto.controller;


import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.OutputView;
import lotto.view.InputView;

import java.util.List;

public class Controller {

    private final LottoService lottoService = new LottoService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {

        try {
            playLottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void playLottoGame() {
        InputAmount amount = getBuyAmountInput();
        UserLotto userLotto = getUserLottoNumber(amount);
        Winning winning = getWinningNumberInput();

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(userLotto, winning);

        getWinningStatistics(lottoResult, amount);
    }

    public InputAmount getBuyAmountInput() {
        int amount = inputView.readUserBuyAmount();
        return new InputAmount(amount);
    }

    public UserLotto getUserLottoNumber(InputAmount inputAmount) {
        int quantity = lottoService.countHowManyLotto(inputAmount);
        outputView.printBuyHowManyLotto(quantity);

        UserLotto userLotto = new UserLotto();
        userLotto.generateAllUserLotto(quantity);

        displayUserLottoResult(userLotto.getAllUserLotto());
        return userLotto;
    }

    public void displayUserLottoResult(List<Lotto> allUserLotto) {
        for (Lotto lotto : allUserLotto) {
            outputView.printUserLottoNumber(lotto.getNumbers());
        }
    }

    public Winning getWinningNumberInput() {
        Lotto lotto = new Lotto(inputView.readLottoWinningNumber());
        return getBonusNumberInput(lotto);
    }

    public Winning getBonusNumberInput(Lotto lotto) {
        int bonus = inputView.readLottoBonusNumber();
        return new Winning(lotto, bonus);
    }

    public void getWinningStatistics(LottoResult lottoResult, InputAmount amount) {
        outputView.printWinningStatistics();
        outputView.printWinningRank(lottoResult);

        double winnings = lottoService.calculateWinnings(lottoResult);
        String rateOfReturn = lottoService.calculateRateOfReturn(winnings, amount);

        outputView.printRateOfReturn(rateOfReturn);
    }
}
