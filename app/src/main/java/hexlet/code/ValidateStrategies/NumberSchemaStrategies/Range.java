package hexlet.code.ValidateStrategies.NumberSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

public final class Range implements ValidateStrategy {
    private final int start;
    private final int finish;

    public Range(int pStart, int pFinish) {
        this.start = pStart;
        this.finish = pFinish;
    }

    @Override
    public boolean validate(Object data) {
        Integer correctData = (Integer) data;
        return correctData >= start && correctData <= finish;
    }
}
