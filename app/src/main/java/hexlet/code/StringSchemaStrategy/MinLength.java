package hexlet.code.StringSchemaStrategy;

public class MinLength implements StringSchemaStrategy {
    private final int length;

    public MinLength(int length) {
        this.length = length;
    }

    @Override
    public boolean isValid(String data) {
        return data.length() >= length;
    }
}
