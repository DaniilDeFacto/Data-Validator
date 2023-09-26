package hexlet.code;

import hexlet.code.Schemes.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        Validator validator = new Validator();
        this.schema = validator.map();
    }

    @Test
    public void isValidSimpleTest() {
        assertThat(schema.isValid(null)).isTrue();
        schema = schema.required().sizeof(0);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
    }

    @Test
    public void requiredTest() {
        schema.required();
        Map<String, String> data = new HashMap<>();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(data)).isTrue();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    public void sizeofTest() {
        schema.sizeof(2);
        Map<String, String> data = new HashMap<>();
        assertThat(schema.isValid(data)).isFalse();
        data.put("key1", "value1");
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
        data.put("key3", "value3");
        assertThat(schema.isValid(data)).isFalse();
    }
}
