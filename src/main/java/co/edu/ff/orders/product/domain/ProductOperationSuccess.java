package co.edu.ff.orders.product.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationSuccess implements  ProductOperation {

    Product value;
    @Override
    public Product value() {
        return value;
    }

    @Override
    public Boolean isValid() {
        return true;
    }

    @Override
    public String errorMessage() {
        return null;
    }
}
