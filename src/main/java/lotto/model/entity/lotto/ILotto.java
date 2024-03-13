package lotto.model.entity.lotto;

import java.util.SortedSet;
import base.InternalSchema;

/**
 * Lotto Entity를 정의하는 Schema
 */
interface ILotto extends InternalSchema {
    SortedSet<Integer> numbers();
}
