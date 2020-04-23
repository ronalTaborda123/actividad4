package co.edu.ff.orders.product.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.ff.orders.product.domain.*;


@Repository
public interface ProductRepository {

     ProductOperation insertOne(ProductOperationRequest productOperationRequest);

     Optional<Product> findById(ProductId productId);

     List<Product> findAll();

     ProductOperation updateOne(ProductId productId,ProductOperationRequest productOperationRequest);

     ProductOperation  deleteOne(ProductId productId);

     Optional<Product> findByName(Name name);
}
