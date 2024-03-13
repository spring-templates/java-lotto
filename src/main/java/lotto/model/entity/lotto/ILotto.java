package lotto.model.entity.lotto;

import base.InternalSchema;
import java.util.SortedSet;

/**
 * Lotto Entity를 정의하는 Schema
 */
interface ILotto extends InternalSchema {
    SortedSet<Integer> numbers();
}
