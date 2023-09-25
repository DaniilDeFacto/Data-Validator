package hexlet.code.ValidateStrategies.NumberSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public class Range implements ValidateStrategy {
    private final int start;
    private final int finish;

    public Range(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public boolean validate(Object data) {
        Integer correctData = (Integer) data;
        return correctData >= start && correctData <= finish;
    }
}
