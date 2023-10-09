package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private final List<Predicate<Object>> predicates = new ArrayList<>();
    protected Predicate<Object> isInvalidType;

    protected final void addPredicate(Predicate<Object> predicate) {
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
