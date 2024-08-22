# 💵 로또 구현 기능 목록 💵
***

## 입력 기능
- 당첨 번호 입력 기능
  - **getLottoNumber** 메서드 구현
    - 6개의 당첨 번호와 1개의 보너스 숫자를 입력
      - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
      - 번호는 쉼표를 기준으로 구분
    - 선택한 숫자가 기존의 숫자와 중복이 아닌지 확인
      - **validateDuplicateWinningNumber** 구현
        - 사용자 입력값이 1~45 사이의 서로 다른 여섯 자리 숫자인지 판별
        - **IsDigit** 메서드 구현
          - 사용자 입력값이 숫자가 맞는지 판별
          - 잘못된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
        - **IsInRange** 메서드 구현
          - 사용자 입력값이 숫자 범위에 포함된 값인지 판별
          - 범위에서 벗어난 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
        - **IsDuplicated** 메서드 구현
          - 사용자 입력값에 중복이 없는지 판별
          - 중복된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
      - **validateDuplicateBonusNumber** 구현
        - 6개의 당첨 번호에 포함된 숫자인지 판별
        - 포함된 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
    - 당첨 번호는 로또 객체의 winningNumberList에 저장
    - 보너스 숫자는 로또 객체의 bonusNumber에 저장

- 로또 구입 금액 입력 기능
  - **userInputAmount** 메서드 구현
    - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
    - 입력값이 올바른 값인지 확인
    - **validateInputAmount** 메서드 구현
      - 사용자 입력값이 숫자가 맞는지 판별
        - **IsDigit** 메서드 구현
          - 범위에서 벗어난 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
      - 사용자 입력값이 1,000~100,000 사이의 값인지 판별
        - **IsInRange** 메서드 구현
          - 범위에서 벗어난 값을 입력한 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
      - 입력받은 금액이 한 장당 금액으로 나누어 떨어지는지 판별
        - **hasChange** 메서드 구현
          - 나머지가 있는 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
  - 사용자 객체의 buyAmount에 저장

## 사용자 로또 번호 생성 기능
- **getUserNumber** 메서드 구현
  - 사용자 객체를 매개변수로 받아 로또 수량 lottoQuantity만큼 숫자 뽑기를 반복 
    - 중복되지 않는 숫자 6개 뽑기
      - `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용
      - 선택한 숫자가 기존의 숫자와 중복이 아닌지 확인
      - [수정필요] 선택한 6개의 숫자를 사용자 객체의 userNumberList에 저장

## 계산 기능
- 로또 수량 계산 기능
  - **countHowManyLotto** 메서드 구현
    - 사용자 객체의 buyAmount를 한 장당 금액으로 나누기
    - 로또 수량을 사용자 객체의 lottoQuantity에 저장

- 당첨 내역 계산 기능
  - **calculateWinning** 메서드 구현
    - 사용자 객체와 로또 객체를 매개변수로 받아 로또 번호 리스트와 당첨 번호를 비교
      - 로또 번호 리스트의 사이즈(즉 로또 수량)만큼 반복
      - 6개 번호가 일치: 1등
      - 5개 번호 + 보너스 숫자 일치: 2등
      - 5개 번호 일치: 3등
      - 4개 번호 일치: 4등
      - 3개 번호 일치: 5등
    - 등수별 당첨 개수를 랭크 객체의 rankList에 저장
    - 총 당첨금을 사용자 객체의 winnings에 저장

- 수익률 계산 기능
  - **caculateRateOfReturn** 메서드 구현
    - 사용자 객체를 매개변수로 받아 수익률을 계산
      - 구매 금액을 총 당첨금으로 나누기
      - 소수점 둘째 자리에서 반올림
    - 수익률을 사용자 객체의 rateOfReturn에 저장

## 출력 기능
- 사용자 로또 번호 출력 기능
  - **printUserNumber** 메서드 구현
    - 중복되지 않는 숫자 6개를 담은 리스트 userNumberList를 매개변수로 받아 출력
      - 숫자는 오름차순으로 정렬

- 당첨 내역 출력 기능
  - **printWinningState** 메서드 구현
    - 랭크 객체를 매개변수로 받아 당첨 내역 출력
      - 5등부터 1등까지 차례대로 출력 

- 수익률 출력 기능
  - **printRateOfReturn** 메서드 구현
    - 사용자 객체의 수익률을 출력

## 예외 처리 기능
- 사용자 입력값 유효성 검사
  - 당첨 번호 입력 시
    - 1~45 사이의 서로 다른 여섯 자리 숫자가 아닌 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
      - 숫자가 아닌 경우
      - 범위에 맞지 않는 경우
      - 중복이 있는 경우
  - 로또 구입 금액 입력 시
    - 로또 금액으로 나누어 떨어지는 1,000~100,000 사이의 숫자가 아닌 경우 `IllegalArgumentException` 예외 발생시킨 후 애플리케이션 종료
      - 숫자가 아닌 경우
      - 범위에 맞지 않는 경우
      - 구입 금액이 로또 금액으로 나누어 떨어지지 않는 경우