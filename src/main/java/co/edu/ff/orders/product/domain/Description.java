package co.edu.ff.orders.product.domain;


import org.apache.commons.lang3.StringUtils;

import co.edu.ff.orders.common.Preconditions;
import co.edu.ff.orders.user.serialization.StringSerializable;
import lombok.Value;

@Value(staticConstructor = "of")
public class Description implements StringSerializable {
    String value;

    public Description(String value){
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value));
        Preconditions.checkArgument(value.length() <= 280);
        this.value = value;
    }

    @Override
    public String valueOf() {
        return value;
    }
}
