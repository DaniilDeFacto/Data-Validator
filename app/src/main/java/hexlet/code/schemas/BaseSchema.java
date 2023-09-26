package hexlet.code.schemas;

import hexlet.code.ValidateStrategies.ValidateStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {
    public final List<ValidateStrategy> strategies = new ArrayList<>();

    public boolean isValid(Object data) {
        if (isInvalidType(data)) {
            return false;
        } else if (strategies.isEmpty()) {
            return true;
        } else {
            long falseCount = strategies.stream()
                    .filter(strategy -> !strategy.validate(data))
                    .count();
            return falseCount == 0;
        }
    }

    public abstract boolean isInvalidType(Object data);
}
