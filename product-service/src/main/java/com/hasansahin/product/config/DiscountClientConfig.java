package com.hasansahin.product.config;

import com.hasansahin.product.client.DiscountClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class DiscountClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.hasansahin.soap.ws.client");
        return marshaller;
    }
    @Bean
    public DiscountClient discountClient(Jaxb2Marshaller marshaller) {
        DiscountClient client = new DiscountClient();
        client.setDefaultUri("http://localhost:8082/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
