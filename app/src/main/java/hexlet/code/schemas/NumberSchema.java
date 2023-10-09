package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        isInvalidType = data -> !(data instanceof Integer) && !(data == null);
    }

    public NumberSchema required() {
        addPredicate(Objects::nonNull);
        return this;
    }
    public NumberSchema positive() {
        addPredicate(data -> {
            Integer correctData = (Integer) data;
            return correctData == null || correctData > 0;
        });
        return this;
    }

    public NumberSchema range(int start, int finish) {
        addPredicate(data -> {
            Integer correctData = (Integer) data;
            return correctData >= start && correctData <= finish;
        });
        return this;
    }
}
