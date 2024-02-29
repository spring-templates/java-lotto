# Layered Architecture에 따른 기능 목록

### Presentation Layer - 사용자와 상호작용

- UserInputManager
  - 로또 구입 금액 입력
  - 당첨 번호 입력
  - 보너스 번호 입력
- SystemOutputManager
  - 로또 수량 및 번호 출력
  - 당첨 내역 출력
  - 수익률 출력

### Application Layer - 기능적 요구사항

- LottoGenerator
  - 구입 금액에 따른 로또 수량 계산
  - 로또 수량에 따른 로또 번호 생성
- LottoResultCalculator
  - 로또의 당첨 내역와 수익률 계산
- LottoValidator
    - 로또 구입 금액 유효성 검사
    - 생성한 로또 유효성 검사
    - 당첨 번호 유효성 검사
    - 보너스 번호 유효성 검사

### Data Layer
- Customer
  - 사용자 구입 금액 저장
  - 생성한 로또 저장
- NanumLotto
  - 당첨 번호 저장
  - 보너스 번호 저장
- Lotto
  - 로또 저장
- Winnings
  - 상금과 당첨 액수 저장