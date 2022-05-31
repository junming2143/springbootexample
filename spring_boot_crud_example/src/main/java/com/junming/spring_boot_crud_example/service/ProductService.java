package com.junming.spring_boot_crud_example.service;

import com.junming.spring_boot_crud_example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.junming.spring_boot_crud_example.repository.ProductRepository;

import java.util.List;

/**
 * @Service annotation indicate that they're holding the business logic.
 * This class holds the business logic to the CRUD functions of Product
 */
@Service
public class ProductService { //Do not mistake that this class is an implementation of the ProductRepository interface. The repository interface is implemented in some other class in the CRUDRepository framework. We then inject the interface to this class to use the methods in the CRUDRepository

    @Autowired  //automatic dependency injection. If there is only a single constructor, can omit the autowired
    private ProductRepository repository;
    //Interface cannot be instantiated. It can only be implemented. An object that implements the ProductRepository interface is created by the Spring IOC container
    //We then use @Autowired to inject the dependency (information of the object into the interface type)
    //Injection of dependency only occurs after constructor has been called. So if you want to run any method automatically after an object is instantiated, use postconstruct annotation.
    //Why we use interface type as the variable instead of class type?
    //https://www.quora.com/In-Java-should-I-use-interface-as-variable-type-instead-of-class-and-why
    //using interface type as the variable allows for loose coupling.

    /**
     *  post methods to save product data to database
     */
    public Product saveProduct(Product product){
        return repository.save(product);  //this is an inbuilt methods given by jpa com.junming.spring_boot_crud_example.repository
    }

    /**
     * Post method to save a list of products into the database
     */
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products); //this is an inbuilt methods given by jpa com.junming.spring_boot_crud_example.repository
    }

    /**
     * get methods to get list of product objects from database
     */
    public List<Product> getProducts(){
        return repository.findAll(); //this is an inbuilt methods given by jpa com.junming.spring_boot_crud_example.repository
    }

    /**
     * get methods to get specific product by id
     */
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    /**
     * get methods to get specific product by name
     */
    public Product getProductByName(String name){
        return repository.findByName(name);  //this method is not an inbuilt method given by jpa repo.
    }                                            // need to specify them in ProductRepository

    /**
     * delete methods to delete specific product by id
     */
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed || " +id;
    }

    /**
     * put method. Getter and setter method in entity class gets used here
     */
    public Product updateProduct(Product product){
         Product existingProduct = repository.findById(product.getId()).orElse(product);
         existingProduct.setName(product.getName());
         existingProduct.setQuantity(product.getQuantity());
         existingProduct.setPrice(product.getPrice());
         return repository.save(existingProduct);
    }
}
