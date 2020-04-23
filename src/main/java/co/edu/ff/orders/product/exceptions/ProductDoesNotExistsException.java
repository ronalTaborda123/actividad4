package co.edu.ff.orders.product.exceptions;

import co.edu.ff.orders.product.domain.Product;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value(staticConstructor = "of")
public class ProductDoesNotExistsException extends ProductException {
    Long id;

    private ProductDoesNotExistsException(Long id){
        super(String.format("Product %s does not exist", id));
        this.id = id;
    }
}
