package co.edu.ff.orders.product.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class ProductOperationRequest {
    Name name;
    Description description;
    BasePrice baseprice;
    TaxRate taxrate;
    ProductStatus productstatus;
    InventoryQuantity inventoryquantity;
}
