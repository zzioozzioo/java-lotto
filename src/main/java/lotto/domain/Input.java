package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private String buyAmount;

    private List<String> winningNumberList = new ArrayList<>();
    private String bonusNumber;

    public Input() {
    }

    public String getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(String buyAmount) {
        this.buyAmount = buyAmount;
    }

    public List<String> getWinningNumberList() {
        return winningNumberList;
    }

    public void setWinningNumberList(List<String> winningNumberList) {
        this.winningNumberList = winningNumberList;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
