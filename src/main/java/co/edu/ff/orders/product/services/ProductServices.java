package co.edu.ff.orders.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ff.orders.product.domain.*;
import co.edu.ff.orders.product.exceptions.ProductAlreadyExistsException;
import co.edu.ff.orders.product.exceptions.ProductDoesNotExistsException;
import co.edu.ff.orders.product.repositories.ProductRepository;

@Service
public class ProductServices {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductOperation createProduct(ProductOperationRequest productOperationRequest){
            return productRepository.insertOne(productOperationRequest);
    }

    public Optional<Product> findById(ProductId productId){
        return productRepository.findById(productId);
    }


    public List<Product> findall(){
        return productRepository.findAll();
    }

    public ProductOperation updateProduct(ProductId productId, ProductOperationRequest productOperationRequest){
        return productRepository.updateOne(productId,productOperationRequest);
    }

    public ProductOperation deleteProduct(ProductId productId){
        Optional<Product>productDelete=productRepository.findById(productId);
        if(!productDelete.isPresent()){
            ProductDoesNotExistsException productDoesNotExistsException =   ProductDoesNotExistsException.of(productId.getValue());
            return ProductOperationFailure.of(productDoesNotExistsException);
        }else{
            productRepository.deleteOne(productId);
            return ProductOperationSuccess.of(productDelete.get());
        }

    }
}
