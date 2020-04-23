package co.edu.ff.orders.product.domain;



public interface ProductOperation {

    Product value();
    Boolean isValid();
    String errorMessage();
}
