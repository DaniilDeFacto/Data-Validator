package hexlet.code.ValidateStrategies.MapSchemaStrategies;

import hexlet.code.ValidateStrategies.ValidateStrategy;

import java.util.Map;

public final class Sizeof implements ValidateStrategy {
    private final int maxSize;

    public Sizeof(int pMaxSize) {
        this.maxSize = pMaxSize;
    }

    @Override
    public boolean validate(Object data) {
        Map<Object, Object> correctData = (Map<Object, Object>) data;
        return correctData.size() == maxSize;
    }
}
