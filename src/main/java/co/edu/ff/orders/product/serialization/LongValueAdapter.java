package co.edu.ff.orders.product.serialization;

import java.lang.reflect.Type;
import java.util.function.Function;

import com.google.gson.*;

public class LongValueAdapter <T extends LongSerializable>   implements JsonSerializer<T>, JsonDeserializer {

    private final Function<Long, T> factory;

    public LongValueAdapter(Function<Long, T> factory) {
        this.factory = factory;
    }

    @Override
    public JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        Long values = t.vaALong();
        return new JsonPrimitive(values);
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Long value = jsonElement.getAsLong();
        return factory.apply(value);
    }
}
