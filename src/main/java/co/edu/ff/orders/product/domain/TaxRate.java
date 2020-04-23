package co.edu.ff.orders.product.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import co.edu.ff.orders.common.Preconditions;
import co.edu.ff.orders.product.serialization.BigDecimalSerializable;
import lombok.Value;

@Value(staticConstructor = "of")
public class TaxRate implements BigDecimalSerializable {

    BigDecimal value;

    public TaxRate(BigDecimal value){
        Preconditions.checkNotNull(value);
        Preconditions.checkArgument(StringUtils.isNoneBlank(value.toString()));
        Preconditions.checkArgument(value.toString().length() >= 0 && value.toString().length() <= 1);
        this.value = value;
    }

    @Override
    public BigDecimal BIG_DECIMAL() {
        return value;
    }
}
