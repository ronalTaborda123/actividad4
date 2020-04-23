package co.edu.ff.orders.user.domain;

import co.edu.ff.orders.common.Preconditions;
import co.edu.ff.orders.user.serialization.StringSerializable;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value(staticConstructor = "of")
public class Username implements StringSerializable {
    String value;

    private Username(String value){
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() >= 6);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
