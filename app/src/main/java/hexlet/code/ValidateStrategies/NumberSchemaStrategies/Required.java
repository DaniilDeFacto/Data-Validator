package hexlet.code.ValidateStrategies.NumberSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public class Required implements ValidateStrategy {
    @Override
    public boolean validate(Object data) {
        Integer correctData = (Integer) data;
        return correctData != null;
    }
}
