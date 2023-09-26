package hexlet.code.schemas;

import hexlet.code.ValidateStrategies.StringSchemaStrategies.Contains;
import hexlet.code.ValidateStrategies.StringSchemaStrategies.MinLength;
import hexlet.code.ValidateStrategies.StringSchemaStrategies.Required;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        this.strategies.add(new Required());
        return this;
    }
    public StringSchema minLength(int length) {
        this.strategies.add(new MinLength(length));
        return this;
    }

    public StringSchema contains(String subString) {
        this.strategies.add(new Contains(subString));
        return this;
    }

    public boolean isInvalidType(Object data) {
        return !(data instanceof String) && !(data == null);
    }
}
