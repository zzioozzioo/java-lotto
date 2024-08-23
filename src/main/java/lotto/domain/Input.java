package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Input {


    // 자료형 변경 전
    private String buyAmountString;
    private String winningNumber;
    private String bonusNumberString;

    // 자료형 변경 후

    private int buyAmount;
    private List<Integer> winningNumberList = new ArrayList<>(6);
    private int bonusNumber;
    public Input() {
    }

    public String getBuyAmountString() {
        return buyAmountString;
    }

    public void setBuyAmountString(String buyAmountString) {
        this.buyAmountString = buyAmountString;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    public String getBonusNumberString() {
        return bonusNumberString;
    }

    public void setBonusNumberString(String bonusNumberString) {
        this.bonusNumberString = bonusNumberString;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public void setWinningNumberList(List<Integer> winningNumberList) {
        this.winningNumberList = winningNumberList;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

}
