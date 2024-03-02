package lotto.data;

public enum ExceptionStatus {

    IllegalPurchaseRemainderException("[ERROR] 구입 금액은 1000으로 나눠 떨어질 때 입력할 수 있어요."),
    IllegalPurchaseNegativeException("[ERROR] 구입 금액은 0 이상일 때 입력할 수 있어요."),
    IllegalLottoException("[ERROR] 당첨 번호는 중복이 없을 때 입력할 수 있어요."),
    IllegalBonusException("[ERROR] 보너스 번호는 당첨 보호와 중복이 없을 때 입력할 수 있어요.");

    private String message;

    ExceptionStatus(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }

}
