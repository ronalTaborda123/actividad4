package co.edu.ff.orders.product.domain;

import co.edu.ff.orders.product.exceptions.ProductException;
import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationFailure implements ProductOperation {

    ProductException productException;

    @Override
    public Product value() {
        return null;
    }

    @Override
    public Boolean isValid() {
        return false;
    }

    @Override
    public String errorMessage() {
        return productException.getMessage();
    }
}
