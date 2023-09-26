package hexlet.code;

import hexlet.code.Schemes.BaseSchema;
import hexlet.code.Schemes.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    private Validator validator;
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        this.validator = new Validator();
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

    @Test
    public void shapeTest() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());
        schema.shape(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue();
        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();
        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();
        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();
    }
}
