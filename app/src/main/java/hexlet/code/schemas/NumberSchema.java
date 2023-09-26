package hexlet.code.schemas;

import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Positive;
import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Range;
import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Required;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addStrategy(new Required());
        return this;
    }
    public NumberSchema positive() {
        addStrategy(new Positive());
        return this;
    }

    public NumberSchema range(int start, int finish) {
        addStrategy(new Range(start, finish));
        return this;
    }

    public boolean isInvalidType(Object data) {
        return !(data instanceof Integer) && !(data == null);
    }
}
