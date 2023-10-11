package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        addPredicate(data -> data instanceof String || data == null);
    }

    public StringSchema required() {
        addPredicate(data -> {
            String correctData = (String) data;
            return !StringUtils.isEmpty(correctData);
        });
        return this;
    }
    public StringSchema minLength(int length) {
        addPredicate(data -> {
            String correctData = (String) data;
            return correctData == null || correctData.length() >= length;
        });
        return this;
    }

    public StringSchema contains(String subString) {
        addPredicate(data -> {
            String correctData = (String) data;
            return correctData == null || correctData.contains(subString);
        });
        return this;
    }
}
