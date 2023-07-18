package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsjava.domain.Coffee;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class CoffeeHouseImplTest {
    @Configuration
    static class MyConfiguration {

        @Bean
        public IOService ioService() {
            IOService mockIOService = Mockito.mock(IOServiceImpl.class);
            when(mockIOService.input()).thenReturn("999.99");
            return mockIOService;
        }

        @Bean
        public CoffeeService coffeeService() {
            CoffeeService mockCoffeeServiceService = Mockito.mock(CoffeeServiceImpl.class);
            when(mockCoffeeServiceService.getCoffeeByPrice(999.99)).thenReturn(new Coffee("Whiskey with coffee"));
            return mockCoffeeServiceService;
        }

        @Bean
        public CoffeeHouse coffeeHouse(CoffeeService coffeeService, IOService ioService) {
            return new CoffeeHouseImpl(coffeeService, ioService);
        }
    }
    @Autowired
    private CoffeeHouse coffeeHouse;


    @DisplayName("корректный метод Добро пожаловать ")
    @Test
    public void shouldHaveCorrectWelcomeTheUserTakeTheMoneyAndBuyCoffee(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        coffeeHouse.welcomeTheUserTakeTheMoneyAndBuyCoffee();
        Assertions.assertEquals("Приветсвую тебя путник!\n" +
                "Не зря ты забрел в лучшую кофейню на Диком Западе\n" +
                "Вот наш ассортимент:  \n" +
                " - Irish Raff --- 59.9$\n" +
                " - Almond Latte --- 75.9$\n" +
                " - Branded coffee --- 999.99$\n" +
                "Сначала деньги, потом кофе и лучше без резких движений дружище!\n" +
                "Твой Whiskey with coffee готов! Наслаждайся\n" +
                "Буду рад увидеть тебя снова\n",out.toString());

    }
}
