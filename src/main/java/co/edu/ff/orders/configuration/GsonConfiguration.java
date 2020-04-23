package co.edu.ff.orders.configuration;

import co.edu.ff.orders.product.domain.*;
import co.edu.ff.orders.product.serialization.BigDecimalValueAdapter;
import co.edu.ff.orders.product.serialization.EnumValueAdapter;
import co.edu.ff.orders.product.serialization.IntegerValueAdapter;
import co.edu.ff.orders.product.serialization.LongValueAdapter;
import co.edu.ff.orders.user.domain.Password;
import co.edu.ff.orders.user.domain.Username;
import co.edu.ff.orders.user.exceptions.UserException;
import co.edu.ff.orders.user.serialization.StringValueAdapter;
import co.edu.ff.orders.user.serialization.UsernameAdapter;
import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.function.Function;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson gson(){
        Function<String, Password> creator = new Function<String, Password>() {
            @Override
            public Password apply(String s) {
                return Password.of(s);
            }
        };

        return new GsonBuilder()
                .registerTypeAdapter(Username.class, new StringValueAdapter<>(Username::of))
                .registerTypeAdapter(Password.class, new StringValueAdapter<Password>(creator))
                .registerTypeAdapter(ProductId.class, new LongValueAdapter<>(ProductId::of))
                .registerTypeAdapter(Name.class,new StringValueAdapter<>(Name::of))
                .registerTypeAdapter(Description.class,new StringValueAdapter<>(Description::of))
                .registerTypeAdapter(BasePrice.class, new BigDecimalValueAdapter<>(BasePrice::of))
                .registerTypeAdapter(TaxRate.class, new BigDecimalValueAdapter<>(TaxRate::of))
                .registerTypeAdapter(ProductStatus.class, new EnumValueAdapter())
                .registerTypeAdapter(InventoryQuantity.class,new IntegerValueAdapter<>(InventoryQuantity::of))
                .registerTypeAdapter(UserException.class, new JsonSerializer<UserException>() {
                    @Override
                    public JsonElement serialize(UserException src, Type typeOfSrc, JsonSerializationContext context) {
                        JsonObject jsonObject = new JsonObject();
                        String message = src.getMessage();
                        JsonPrimitive errorValue = new JsonPrimitive(message);
                        jsonObject.add("error", errorValue);
                        return jsonObject;
                    }
                })
                .create();
    }
}
