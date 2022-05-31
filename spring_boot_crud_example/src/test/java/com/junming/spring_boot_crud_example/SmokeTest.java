package com.junming.spring_boot_crud_example;

import com.junming.spring_boot_crud_example.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;  //We use AssertJ (which provides assertThat() and other methods) to express the test assertions.

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ProductController controller;
    //Spring interprets the @Autowired annotation, and the controller is injected before the test methods are run.

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();  //To verify that context is creating your controller
        //The assertThat is one of the JUnit methods from the Assert object that can be used to check if a specific value match to an expected one.
        //It primarily accepts 2 parameters. First one if the actual value and the second is a matcher object. It will then try to compare this two and returns a boolean result if its a match or not. Example of its usage as per below.
        //Only failed assertions are recorded.
    }

}
