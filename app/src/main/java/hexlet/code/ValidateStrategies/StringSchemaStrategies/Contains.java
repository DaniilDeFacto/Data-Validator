package hexlet.code.ValidateStrategies.StringSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public final class Contains implements ValidateStrategy {
    private final String subString;

    public Contains(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean validate(Object data) {
        String correctData = (String) data;
        return correctData.contains(subString);
    }
}
