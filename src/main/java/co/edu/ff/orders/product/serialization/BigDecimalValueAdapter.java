package co.edu.ff.orders.product.serialization;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.function.Function;

import com.google.gson.*;

public class BigDecimalValueAdapter <T extends BigDecimalSerializable>   implements JsonSerializer<T>, JsonDeserializer {

    private final Function<BigDecimal, T> factory;

    public BigDecimalValueAdapter(Function<BigDecimal, T> factory) {
        this.factory = factory;
    }

    @Override
    public JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        BigDecimal values = t.BIG_DECIMAL();
        return new JsonPrimitive(values);
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        BigDecimal value = jsonElement.getAsBigDecimal();
        return factory.apply(value);
    }
}
