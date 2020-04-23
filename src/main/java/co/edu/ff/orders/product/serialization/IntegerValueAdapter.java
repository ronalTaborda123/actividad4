package co.edu.ff.orders.product.serialization;

import java.lang.reflect.Type;
import java.util.function.Function;

import com.google.gson.*;

public class IntegerValueAdapter <T extends IntegerSerializable>   implements JsonSerializer<T>, JsonDeserializer {

    private final Function<Integer, T> factory;

    public IntegerValueAdapter(Function<Integer, T> factory) {
        this.factory = factory;
    }

    @Override
    public JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext) {
        Integer values = t.valuInteger();
        return  new JsonPrimitive(values);
    }

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Integer value= jsonElement.getAsInt();
        return factory.apply(value);
    }

}
