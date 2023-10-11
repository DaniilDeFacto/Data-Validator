package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addPredicate(data -> data instanceof Integer || data == null);
    }

    public NumberSchema required() {
        super.required();
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
            return correctData == null || (correctData >= start && correctData <= finish);
        });
        return this;
    }
}
