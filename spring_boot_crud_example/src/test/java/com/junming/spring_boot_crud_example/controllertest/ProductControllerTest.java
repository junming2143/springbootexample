package com.junming.spring_boot_crud_example.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junming.spring_boot_crud_example.controller.ProductController;
import com.junming.spring_boot_crud_example.entity.Product;
import com.junming.spring_boot_crud_example.repository.ProductRepository;
import com.junming.spring_boot_crud_example.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


//Using this annotation will disable full auto-configuration and instead apply only configuration relevant to MVC tests
//In an application with multiple controllers, if you only want to test one controller, you can even ask for only one to be instantiated.
//(i.e. @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver beans but not @Component, @Service or @Repository beans).
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper; // parse or deserialize JSON content into a Java object

    @MockBean
    ProductService productService;
    //use @MockBean to create and inject a mock for the ProductService(if you do not do so, the application context cannot start), and we set its expectations using Mockito.
    //Mocking is the act of removing external dependencies from a unit test in order to create a controlled environment around it.


    Product RECORD_1 = new Product(1, "iphone", 23, 800.00);
    Product RECORD_2 = new Product(2, "ipod", 27, 400.00);
    Product RECORD_3 = new Product(3, "imac", 31, 2500.00);

    @Test
    public void findAllProducts_success() throws Exception
    {
        List<Product> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(productService.getProducts()).thenReturn(records);
        //With Mockito, you create a mock, tell Mockito what to do when specific methods are called on it, and then use the mock instance in your test instead of the real thing. After the test, you can query the mock to see what specific
        //methods were called or check the side effects in the form of changed state.

        //The Mockito when().thenReturn() chain method mocks the getAllRecords() method call in the JPA repository, so every time the method is called within the controller,
        //it will return the specified value in the parameter of the thenReturn() method.
        // In this case, it returns a list of three pre-set patient records, instead of actually making a database call.
        //Test the method first, then test the endpoint next.


        //After perform() is ran, andExpect() methods are subsequently chained to it and tests against the results returned by the method.
        //For this call, we've set 3 assertions within the andExpect() methods: that the response returns a 200 or an OK status code, the response returns a list of size 3,
        //and the third Product object from the list has a name property of imac.
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("imac")));
    }

    @Test
    public void getProductById_success() throws Exception
    {
        Mockito.when(productService.getProductById(RECORD_1.getId())).thenReturn(RECORD_1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/productById/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("iphone")));
    }

    @Test
    public void addProduct_success() throws Exception
    {
        Product pdt = Product.builder()
                .name("Magic keyboard")
                .quantity(100)
                .price(150.00)
                .build();

        Mockito.when(productService.saveProduct(pdt)).thenReturn(pdt);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(pdt));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is("Magic keyboard")));
    }
}
