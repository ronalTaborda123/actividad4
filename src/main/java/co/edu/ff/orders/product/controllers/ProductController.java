package co.edu.ff.orders.product.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ff.orders.product.domain.*;
import co.edu.ff.orders.product.exceptions.ProductDoesNotExistsException;
import co.edu.ff.orders.product.services.ProductServices;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    @PostMapping
    public ResponseEntity<ProductOperation>createUser(@RequestBody ProductOperationRequest productOperationRequest){
        ProductOperation productOperation =  productServices.createProduct(productOperationRequest);
        if(productOperation.isValid()){
            return ResponseEntity.ok(productOperation);
        }
        else if(!productOperation.isValid()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(productOperation);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(productOperation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOperation>getProductById(@PathVariable Long id){
        ProductId productId=ProductId.of(id);
        Optional<Product> productOpcional=productServices.findById(productId);
       if(!productOpcional.isPresent()){
            ProductDoesNotExistsException productDoesNotExistsException =  ProductDoesNotExistsException.of(id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ProductOperationFailure.of(productDoesNotExistsException));
        }else{
            return ResponseEntity.ok(ProductOperationSuccess.of(productOpcional.get()));
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>>getListProduct(){
        List<Product> listProduct= productServices.findall();
        return ResponseEntity.ok(listProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOperation> updateProduct(@PathVariable Long id,@RequestBody ProductOperationRequest productOperationRequest){
        ProductId productId=ProductId.of(id);
        ProductOperation productOperation = productServices.updateProduct(productId,productOperationRequest);
        if(productOperation.isValid()){
            return ResponseEntity.ok(productOperation);
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productOperation);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductOperation> deleteProduct(@PathVariable Long id){
        ProductId productId=ProductId.of(id);
        ProductOperation productOperation = productServices.deleteProduct(productId);
        if(productOperation.isValid()){
            return ResponseEntity.ok(productOperation);
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productOperation);
        }
    }


}
