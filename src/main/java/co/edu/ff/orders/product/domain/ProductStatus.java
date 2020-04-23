package co.edu.ff.orders.product.domain;


import java.util.HashMap;
import java.util.Map;

public enum ProductStatus {
    BORRADOR("${borrador}"),
    PUBLICADO("${publicado}");

    String scope;

    ProductStatus(String scope)
    {
        this.scope = scope;
    }
}
