package com.junming.spring_boot_crud_example.controller;

import com.junming.spring_boot_crud_example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.junming.spring_boot_crud_example.service.ProductService;

import java.util.List;

/**
 * The class is flagged as a @RestController, meaning it is ready for use by Spring MVC to handle web requests.
 * This controller is used to execute basic CRUD functions of Product.
 */
@RestController
public class ProductController {

    @Autowired  //automatic dependency injection
    private ProductService service;

    @RequestMapping("/")  // @PostMapping and @GetMapping are specialized version of @RequestMapping
    public @ResponseBody String greeting() {
        return "Hello to Product RestAPI";
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        //RequestBody annotation maps the HttpRequest body to a transfer or domain object
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        //RequestBody annotation maps the HttpRequest body to a transfer or domain object
        return service.saveProducts(products);
    }

    //@GetMapping maps /products to the findAllProducts() method. When invoked from a browser or by using curl on the command line, the method returns pure text.
    //That is because @RestController combines @Controller and @ResponseBody, two annotations that results in web requests returning data rather than a view.
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name)
    {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return service.deleteProduct(id);
    }
}

//@RequestBody annotation binds the content sent in (POST / PUT) request body with the annotated variable. Since there is no 'body' part in GET request, spring throws HttpMessageNotReadableException to indicate the same.
//As a general rule, you can only use @RequestBody for the requests which can have 'body' content e.g. POST or PUT.