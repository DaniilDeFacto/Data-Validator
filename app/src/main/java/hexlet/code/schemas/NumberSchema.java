package hexlet.code.schemas;

import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Positive;
import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Range;
import hexlet.code.ValidateStrategies.NumberSchemaStrategies.Required;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        this.strategies.add(new Required());
        return this;
    }
    public NumberSchema positive() {
        this.strategies.add(new Positive());
        return this;
    }

    public NumberSchema range(int start, int finish) {
        this.strategies.add(new Range(start, finish));
        return this;
    }

    public boolean isInvalidType(Object data) {
        return !(data instanceof Integer) && !(data == null);
    }
}
