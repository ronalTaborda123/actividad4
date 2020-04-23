package co.edu.ff.orders.user.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.edu.ff.orders.product.domain.*;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductId id1 = ProductId.of(resultSet.getLong("ID"));
        Name name = Name.of(resultSet.getString("NAME"));
        Description description = Description.of(resultSet.getString("DESCRIPTION"));
        BasePrice basePrice = BasePrice.of(resultSet.getBigDecimal("BASEPRICE"));
        TaxRate taxRate = TaxRate.of(resultSet.getBigDecimal("TAXRATE"));
        ProductStatus productStatus = ProductStatus.valueOf(resultSet.getString("PRODUCTSTATUS"));
        InventoryQuantity inventoryQuantity = InventoryQuantity.of(resultSet.getInt("INVENTORYQUANTITY"));

        return Product.of(id1, name, description,basePrice,taxRate,productStatus,inventoryQuantity);
    }
}
