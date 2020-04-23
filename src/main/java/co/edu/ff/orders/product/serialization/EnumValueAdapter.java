package co.edu.ff.orders.product.serialization;

import java.lang.reflect.Type;

import co.edu.ff.orders.product.domain.ProductStatus;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class EnumValueAdapter implements JsonDeserializer<ProductStatus> {
    @Override
    public ProductStatus deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        {
            ProductStatus[] scopes = ProductStatus.values();
            for (ProductStatus scope : scopes)
            {
                if (scope.toString().equals(jsonElement.getAsString()))
                    return scope;
            }
            return null;
        }
    }
}
