package co.edu.ff.orders.product.domain;


import lombok.Value;

@Value(staticConstructor = "of")
public class Product {
    ProductId productId;
    Name name;
    Description description;
    BasePrice basePrice;
    TaxRate taxRate;
    ProductStatus productStatus;
    InventoryQuantity inventoryQuantity;

}
