package hexlet.code.ValidateStrategies.MapSchemaStrategies;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.ValidateStrategies.ValidateStrategy;

import java.util.Map;

public class Shape implements ValidateStrategy {
    private final Map<String, BaseSchema> schemas;

    public Shape(Map<String, BaseSchema> schemas) {
        this.schemas = schemas;
    }

    @Override
    public boolean validate(Object data) {
        Map<String, Object> correctData = (Map<String, Object>) data;
        long falseCount = correctData.keySet().stream()
                .filter(key -> !schemas.get(key).isValid(correctData.get(key)))
                .count();
        return falseCount == 0;
    }
}
