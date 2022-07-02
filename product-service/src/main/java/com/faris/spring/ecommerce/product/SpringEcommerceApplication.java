package com.faris.spring.ecommerce.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.faris.spring.ecommerce",
        exclude = SecurityAutoConfiguration.class //disable security temporary
)
public class SpringEcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEcommerceApplication.class, args);
    }
}
