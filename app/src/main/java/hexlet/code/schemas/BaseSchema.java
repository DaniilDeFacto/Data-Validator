package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate> predicates = new ArrayList<>();
    protected Predicate isInvalidType;

    protected final void addPredicate(Predicate predicate) {
        this.predicates.add(predicate);
    }

    public final boolean isValid(Object data) {
        if (isInvalidType.test(data)) {
            return false;
        } else if (predicates.isEmpty()) {
            return true;
        } else {
            return predicates.stream().allMatch(predicate -> predicate.test(data));
        }
    }
}
