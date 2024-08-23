package lotto.view;

import lotto.domain.Input;

// View: 콘솔의 입출력 관리
// 사용자 입력, 화면 출력
public class InputMessage {

    private Input input;

    public void getUserBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void getLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void getLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
