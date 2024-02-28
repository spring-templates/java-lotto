package org.example.actors;

import lombok.Getter;
import lombok.Setter;
import org.example.Winnings;

public class Lotto {
    @Getter
    private int[] lottoNumbers;

    @Getter
    @Setter
    private Winnings winnings;
}
