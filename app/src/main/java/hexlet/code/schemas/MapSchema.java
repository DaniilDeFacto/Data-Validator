package hexlet.code.schemas;

import hexlet.code.ValidateStrategies.MapSchemaStrategies.Required;
import hexlet.code.ValidateStrategies.MapSchemaStrategies.Shape;
import hexlet.code.ValidateStrategies.MapSchemaStrategies.Sizeof;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addStrategy(new Required());
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        addStrategy(new Sizeof(maxSize));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addStrategy(new Shape(schemas));
        return this;
    }

    public boolean isInvalidType(Object data) {
        return !(data instanceof Map<?, ?>) && !(data == null);
    }
}
