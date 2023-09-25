package hexlet.code.ValidateStrategies.StringSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public class MinLength implements ValidateStrategy {
    private final int length;

    public MinLength(int length) {
        this.length = length;
    }

    @Override
    public boolean validate(Object data) {
        String correctData = (String) data;
        return correctData.length() >= length;
    }
}