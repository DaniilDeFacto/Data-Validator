package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        addPredicate(data -> data instanceof Map<?, ?> || data == null);
    }

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int maxSize) {
        addPredicate(data -> {
            Map<Object, Object> correctData = (Map<Object, Object>) data;
            return correctData == null || correctData.size() == maxSize;
        });
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addPredicate(data -> {
            Map<String, Object> correctData = (Map<String, Object>) data;
            return correctData == null || correctData.keySet().stream()
                    .allMatch(key -> schemas.get(key).isValid(correctData.get(key)));
        });
        return this;
    }
}
