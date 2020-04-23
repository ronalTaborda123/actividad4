package co.edu.ff.orders.product.exceptions;

import co.edu.ff.orders.product.domain.ProductOperationRequest;
import lombok.EqualsAndHashCode;
import lombok.Value;


@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductAlreadyExistsException extends ProductException {
    ProductOperationRequest product;

    private ProductAlreadyExistsException(ProductOperationRequest product){
        super(String.format("Product %s already exists", product.getName()));
        this.product = product;
    }
}
