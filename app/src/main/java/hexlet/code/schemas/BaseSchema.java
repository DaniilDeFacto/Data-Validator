package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> predicates = new ArrayList<>();

    protected final void addPredicate(Predicate<Object> predicate) {
        this.predicates.add(predicate);
    }

    protected BaseSchema required() {
        addPredicate(Objects::nonNull);
        return this;
    }

    public final boolean isValid(Object data) {
        return predicates.stream().allMatch(predicate -> predicate.test(data));
    }
}
