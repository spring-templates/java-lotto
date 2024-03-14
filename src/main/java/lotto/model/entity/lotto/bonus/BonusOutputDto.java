package lotto.model.entity.lotto.bonus;

public record BonusOutputDto(
        Integer bonusNumber
) implements IBonusOutputDto {
    @Override
    public String toString() {
        return bonusNumber.toString();
    }
}
