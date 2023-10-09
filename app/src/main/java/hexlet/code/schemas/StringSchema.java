package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        isInvalidType = data -> !(data instanceof String) && !(data == null);
    }

    public StringSchema required() {
        addPredicate(data -> {
            String correctData = (String) data;
            return data != null && !correctData.isEmpty();
        });
        return this;
    }
    public StringSchema minLength(int length) {
        addPredicate(data -> {
            String correctData = (String) data;
            return correctData.length() >= length;
        });
        return this;
    }

    public StringSchema contains(String subString) {
        addPredicate(data -> {
            String correctData = (String) data;
            return correctData.contains(subString);
        });
        return this;
    }
}
