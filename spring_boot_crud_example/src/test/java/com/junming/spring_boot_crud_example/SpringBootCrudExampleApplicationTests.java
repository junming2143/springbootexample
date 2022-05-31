package com.junming.spring_boot_crud_example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * write a simple sanity check test that will fail if the application context cannot start.
 */
@SpringBootTest //The @SpringBootTest annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.
class SpringBootCrudExampleApplicationTests {

	@Test
	public void contextLoads() {
		SpringBootCrudExampleApplication.main(new String[] {});
	}

}
