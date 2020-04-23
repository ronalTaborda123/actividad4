package co.edu.ff.orders.user.serialization;

import co.edu.ff.orders.user.domain.Username;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UsernameAdapter implements JsonDeserializer<Username>, JsonSerializer<Username> {
    @Override
    public Username deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String value = json.getAsString();
        return Username.of(value);
    }

    @Override
    public JsonElement serialize(Username src, Type typeOfSrc, JsonSerializationContext context) {
        String value = src.getValue();
        return new JsonPrimitive(value);
    }
}
