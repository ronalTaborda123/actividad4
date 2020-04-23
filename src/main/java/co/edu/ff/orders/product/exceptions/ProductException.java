package co.edu.ff.orders.product.exceptions;

public abstract class ProductException extends RuntimeException{
    public ProductException(String message) {
        super(message);
    }
}
