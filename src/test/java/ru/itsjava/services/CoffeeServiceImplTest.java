package ru.itsjava.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CoffeeServiceImplTest {

    @Configuration
    static class MyConfigurationCoffeeServiceImpl {

        @Bean
        public CoffeeService coffeeService() {
            CoffeeService mockCoffeeService = Mockito.mock(CoffeeServiceImpl.class);
            when(mockCoffeeService.getCoffeeByPrice(55.9)).thenReturn(new Coffee("Irish Raff"));
            return mockCoffeeService;

        }
    }

    @Autowired
    private CoffeeService coffeeService;


    @Test
    public void shouldHaveCorrectMethodGetCoffeeByPrice(){
        Coffee coffee = new Coffee("Irish Raff");

        assertEquals(coffee.getCoffeeName(),coffeeService.getCoffeeByPrice(55.9));
    }
}
