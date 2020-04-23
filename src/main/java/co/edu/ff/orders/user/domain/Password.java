package co.edu.ff.orders.user.domain;

import co.edu.ff.orders.common.Preconditions;
import co.edu.ff.orders.user.serialization.StringSerializable;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Value(staticConstructor = "of")
public class Password implements StringSerializable {
    String value;

    public Password(String value){
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() >= 8);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
