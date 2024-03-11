package lotto.model.entity;


import lotto.util.LottoEnum;

public final class LottoBonusNumber {
    final int number;

    public LottoBonusNumber(Lotto winningLotto, int number) {
        this.number = number;
        validate(winningLotto);
    }

    private void validate(Lotto winningLotto) {
        int MIN_NUMBER = LottoEnum.MIN_NUMBER.getValue();
        int MAX_NUMBER = LottoEnum.MAX_NUMBER.getValue();
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 " + MIN_NUMBER + "이상 " + MAX_NUMBER + "이하의 숫자여야 합니다.");
        }

        if (winningLotto.numbers().contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}