package com.junming.spring_boot_crud_example.repository;

import com.junming.spring_boot_crud_example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository is a Spring annotation that indicates that the decorated class is a repository.
 * repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //interface extend interface. Class extend class. class implement interface
    //interface cannot be instantiated. Can only be implemented by a class.

    /**
     *This method is a custom method and not in the JpaRepositry. But, JpaRepository can read the 'findBy' keyword and look at the word after 'findBy'
     */
    Product findByName(String name);
}