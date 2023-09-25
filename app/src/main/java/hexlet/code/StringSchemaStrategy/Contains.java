package hexlet.code.StringSchemaStrategy;

public class Contains implements StringSchemaStrategy {
    private final String subString;

    public Contains(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean isValid(String data) {
        return data.contains(subString);
    }
}
