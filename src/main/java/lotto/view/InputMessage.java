package lotto.view;

import lotto.domain.Input;

import static camp.nextstep.edu.missionutils.Console.*;

// View: 콘솔의 입출력 관리
// 사용자 입력, 화면 출력
public class InputMessage {

    private Input input;

    // TODO: 당첨 번호 입력 기능 구현
    public void getLottoNumber() {

        // TODO: view에서 인덱싱하고 문자열 배열로 변환하고 이런 건 아닌 듯함
        //  여기선 단순히 전달만 받고 나머지는 validator에서 해야 하나?
        //  ㄴㄴ service에서 넘겨받아서 인덱싱하고 validator 호출하면 됨
        input.setWinningNumber(readLine());
    }

    // TODO: 로또 구입 금액 입력 기능 구현
    public void getUserInputAmount() {
        input.setBuyAmountString(readLine());
    }
}
