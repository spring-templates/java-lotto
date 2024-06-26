# MVC 패턴

```text
1. Model은 Controller와 View에 의존하지 않아야 한다.
2. View는 Model에만 의존해야 하고, Controller에는 의존하면 안 된다.
3. View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받아야 한다.
4. Controller는 Model과 View에 의존해도 된다.
5. View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.
```

### InputView

- [x] 구매 금액 입력
    ```text
    구입금액을 입력해 주세요.
    (입력) 8000
    ```
- [x] 당첨 번호 입력
    ```text
    당첨 번호를 입력해 주세요.
    (입력) 1,2,3,4,5,6
    ```
- [x] 보너스 번호 입력
    ```text
    보너스 번호를 입력해 주세요.
    (입력) 7
    ```

### OutputView

- 구매 결과 출력
    - [x] 구매한 로또의 수량 출력
    -
   ```text
   8개를 구매했습니다.
   [8, 21, 23, 41, 42, 43]
   [3, 5, 11, 16, 32, 38]
   [7, 11, 16, 35, 36, 44]
   [1, 8, 11, 31, 41, 42]
   [13, 14, 16, 38, 42, 45]
   [7, 11, 30, 40, 42, 43]
   [2, 13, 22, 32, 38, 45]
   [1, 3, 5, 14, 22, 45]
      ```
- 당첨 통계 출력
    - [x] 일치 개수별 당첨 금액
    - [x] 각 종류별 당첨 횟수
    - [x] 총 수익률: 소숫점 둘째 자리에서 반올림하여 출력
    ```text
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```

