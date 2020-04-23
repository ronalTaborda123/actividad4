package co.edu.ff.orders.user.serialization;

import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.Username;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PasswordAdapter implements JsonDeserializer<Password>, JsonSerializer<Password> {
    @Override
    public Password deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String value = json.getAsString();
        return Password.of(value);
    }

    @Override
    public JsonElement serialize(Password src, Type typeOfSrc, JsonSerializationContext context) {
        String value = src.getValue();
        return new JsonPrimitive(value);
    }
}
