package lotto.view;

import lotto.domain.Input;

import static camp.nextstep.edu.missionutils.Console.*;

// View: 콘솔의 입출력 관리
// 사용자 입력, 화면 출력
public class InputMessage {

    private Input input;

    // TODO: 당첨 번호 입력 기능 구현
    public void getLottoNumber() {

    }

    // TODO: 로또 구입 금액 입력 기능 구현
    public void getUserInputAmount() {
        input.setBuyAmount(readLine());
    }
}
