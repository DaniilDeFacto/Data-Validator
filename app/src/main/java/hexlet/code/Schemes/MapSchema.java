package hexlet.code.Schemes;
import hexlet.code.ValidateStrategies.MapSchemaStrategies.Required;
import hexlet.code.ValidateStrategies.MapSchemaStrategies.Sizeof;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        this.strategies.add(new Required());
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        this.strategies.add(new Sizeof(maxSize));
        return this;
    }

    public boolean isInvalidType(Object data) {
        return !(data instanceof Map<?, ?>) && !(data == null);
    }
}
