package co.edu.ff.orders.user.serialization;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.function.Function;

public class StringValueAdapter<IN extends StringSerializable> implements JsonSerializer<IN>, JsonDeserializer<IN> {
    private final Function<String, IN> factory;

    public StringValueAdapter(Function<String, IN> factory) {
        this.factory = factory;
    }


    @Override
    public IN deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String value = json.getAsString();
        return factory.apply(value);
    }

    @Override
    public JsonElement serialize(IN src, Type typeOfSrc, JsonSerializationContext context) {
        String value = src.valueOf();
        return new JsonPrimitive(value);
    }
}
