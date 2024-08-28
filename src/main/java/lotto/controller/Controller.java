package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;


import lotto.domain.Lotto;
import lotto.domain.InputAmount;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.service.CalcService;
import lotto.service.ConvertService;
import lotto.service.LottoService;
import lotto.view.DisplayMessage;
import lotto.view.InputMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    private final ConvertService convertService = new ConvertService();
    private final LottoService lottoService = new LottoService();
    private final CalcService calcService = new CalcService();
    private final InputMessage inputMessage = new InputMessage();
    private final DisplayMessage displayMessage = new DisplayMessage();

    public void run() {

        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        InputAmount amount;
        List<Lotto> allUserLotto;
        Winning winning;
        HashMap<Rank, Integer> lottoResult;

        amount = getBuyAmountInput();

        allUserLotto = getAllUserLottoNumber(amount);
        winning = getWinningNumberInput();

        lottoResult = getLottoResult(allUserLotto, winning);
        getWinningStatistics(lottoResult, amount);
    }

    public InputAmount getBuyAmountInput() {
        inputMessage.getUserBuyAmount();
        int amount = convertService.convertInputAmount(readLine().trim());
        return new InputAmount(amount);
    }

    public List<Lotto> getAllUserLottoNumber(InputAmount inputAmount) {
        int quantity = calcService.countHowManyLotto(inputAmount);
        displayMessage.displayBuyHowManyLotto(quantity);

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
            displayMessage.displayUserLottoNumber(lotto.getNumbers());
        }
    }

    public Winning getWinningNumberInput() {
        inputMessage.getLottoWinningNumber();
        Lotto lotto = new Lotto(convertService.convertStringToList(readLine().trim()));
        return getBonusNumberInput(lotto);
    }

    public Winning getBonusNumberInput(Lotto lotto) {
        inputMessage.getLottoBonusNumber();
        int bonus = convertService.convertBonusNumber(readLine().trim());
        return new Winning(lotto, bonus);
    }

    public HashMap<Rank, Integer> getLottoResult(List<Lotto> lottoList, Winning winning) {
        HashMap<Rank, Integer> lottoResult = lottoService.initLottoResult();

        return calcService.calculateLottoResult(lottoResult, lottoList, winning);
    }

    public void getWinningStatistics(HashMap<Rank, Integer> lottoResult, InputAmount amount) {
        displayMessage.displayWinningStatistics();

        displayMessage.displayWinningRank(lottoResult);

        long winnings = calcService.calculateWinnings(lottoResult);
        double rateOfReturn = calcService.calculateRateOfReturn(winnings, amount);

        displayMessage.displayRateOfReturn(rateOfReturn);
    }
}
