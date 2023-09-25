package hexlet.code;

import hexlet.code.StringSchemaStrategy.Contains;
import hexlet.code.StringSchemaStrategy.MinLength;
import hexlet.code.StringSchemaStrategy.Required;
import hexlet.code.StringSchemaStrategy.StringSchemaStrategy;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {
    private final List<StringSchemaStrategy> strategys = new ArrayList<>();

    public void required() {
        this.strategys.add(new Required());
    }
    public void minLength(int length) {
        this.strategys.add(new MinLength(length));
    }

    public void contains(String subString) {
        this.strategys.add(new Contains(subString));
    }

    public boolean isValid(Object data) {
        if (!(data instanceof String) && data != null) {
            return false;
        }
        if (strategys.isEmpty()) {
            return true;
        } else {
            for (var strategy : strategys) {
                if (!strategy.isValid((String) data)) {
                    return false;
                }
            }
        }
        return true;
    }
}
