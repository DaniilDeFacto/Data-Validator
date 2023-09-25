package hexlet.code.StringSchemaStrategy;

public class Required implements StringSchemaStrategy {
    @Override
    public boolean isValid(String data) {
        return data != null && !data.isEmpty();
    }
}
