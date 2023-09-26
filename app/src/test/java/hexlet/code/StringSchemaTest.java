package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public final class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    public void beforeEach() {
        Validator validator = new Validator();
        this.schema = validator.string();
    }

    @Test
    public void isValidSimpleTest() {
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        schema = schema.required().minLength(5).contains("hex");
        assertThat(schema.isValid("hexlet")).isTrue();
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();
    }

    @Test
    public void minLengthTest() {
        schema.minLength(9);
        assertThat(schema.isValid("hexlet")).isFalse();
        assertThat(schema.isValid("hexlet.io")).isTrue();
        schema.minLength(5);
        assertThat(schema.isValid("hexlet")).isFalse();
        schema.minLength(10);
        assertThat(schema.isValid("hexlet.io")).isFalse();
    }

    @Test
    public void containsTest() {
        schema.contains("wh");
        assertThat(schema.isValid("what does the fox say")).isTrue();
        schema.contains("what");
        assertThat(schema.isValid("what does the fox say")).isTrue();
        schema.contains("whatthe");
        assertThat(schema.isValid("what does the fox say")).isFalse();
    }
}
