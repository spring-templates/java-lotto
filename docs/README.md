# Layered Architecture에 따른 기능 목록

### Presentation Layer - 사용자와 상호작용

- UserInputManager - 사용자의 입력
  - 로또 구입 금액 입력
  - 당첨 번호 입력
  - 보너스 번호 입력
- SystemOutputManager - 값 출력
  - 로또 수량 및 번호 출력
  - 당첨 내역 출력
  - 수익률 출력

### Application Layer - 기능적 요구사항

- LottoGenerator - 금액에 따라 로또를 생성
  - 구입 금액에 따른 로또 수량 계산
  - 로또 수량에 따른 로또 번호 생성

- LottoResultCalculator - 로또 당첨 내역과 수익률 계산
  - 로또의 당첨 내역와 수익률 계산

[//]: # (다른 많은 클래스가 LottoValidator를 의존하게 될 것 같음. 차라리 검사를 분리하는게 좋을듯)

[//]: # (- LottoValidator )

[//]: # (  - 로또 구입 금액 유효성 검사)

[//]: # (  - 생성한 로또 유효성 검사)

[//]: # (  - 당첨 번호 유효성 검사)

[//]: # (  - 보너스 번호 유효성 검사)

### Data Layer
- Customer - class - **정확한** 고객의 저장
  - 사용자 구입 금액 저장
  - 생성한 로또 저장
  - 로또 구입 금액 유효성 검사
- LottoCompany - recode - **정확한** 당첨 번호와 보너스 번호 저장
  - 당첨 번호 저장
  - 보너스 번호 저장
  - 당첨 번호와 보너스 번호 유효성 검사
- Lotto - recode - **정확한** 로또 번호 저장
  - 로또 저장
  - 생성한 로또 유효성 검사
- Winnings - enum
  - 상금과 당첨 액수 저장
- ErrorStatus - enum
  - 예외 코드와 에러 메세지 저장

### Util

- ErrorException
  - 커스텀 exception 발생