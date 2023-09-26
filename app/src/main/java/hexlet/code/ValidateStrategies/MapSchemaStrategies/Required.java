package hexlet.code.ValidateStrategies.MapSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public final class Required implements ValidateStrategy {
    @Override
    public boolean validate(Object data) {
        return data != null;
    }
}
