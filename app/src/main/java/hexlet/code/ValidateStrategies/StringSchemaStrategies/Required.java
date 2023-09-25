package hexlet.code.ValidateStrategies.StringSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public class Required implements ValidateStrategy {
    @Override
    public boolean validate(Object data) {
        String correctData = (String) data;
        return data != null && !correctData.isEmpty();
    }
}
