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
    public void complexValidationTest() {
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        schema.required().minLength(5).contains("hex");
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
        schema.minLength(6);
        assertThat(schema.isValid("hexlet.io")).isTrue();
        assertThat(schema.isValid("hex")).isFalse();
        assertThat(schema.isValid("hexlet")).isTrue();
    }

    @Test
    public void containsTest() {
        schema.contains("what does");
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("fox say: what does the dog say")).isTrue();
        assertThat(schema.isValid("what is it")).isFalse();
        assertThat(schema.isValid("does what")).isFalse();
    }
}
