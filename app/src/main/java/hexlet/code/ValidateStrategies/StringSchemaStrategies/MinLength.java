package hexlet.code.ValidateStrategies.StringSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public final class MinLength implements ValidateStrategy {
    private final int length;

    public MinLength(int pLength) {
        this.length = pLength;
    }

    @Override
    public boolean validate(Object data) {
        String correctData = (String) data;
        return correctData.length() >= length;
    }
}
