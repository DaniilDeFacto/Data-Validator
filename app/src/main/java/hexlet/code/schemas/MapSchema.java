package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        isInvalidType = data -> !(data instanceof Map<?, ?>) && !(data == null);
    }

    public MapSchema required() {
        addPredicate(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        addPredicate(data -> {
            Map<Object, Object> correctData = (Map<Object, Object>) data;
            return correctData.size() == maxSize;
        });
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addPredicate(data -> {
            Map<String, Object> correctData = (Map<String, Object>) data;
            long falseCount = correctData.keySet().stream()
                    .filter(key -> !schemas.get(key).isValid(correctData.get(key)))
                    .count();
            return falseCount == 0;
        });
        return this;
    }
}
