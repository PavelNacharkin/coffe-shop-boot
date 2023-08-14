package ru.itsjava.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class IOServiceImplTest {
    @Configuration
    static class MyConfigurationIOServiceImpl {

        @Bean
        public IOService ioService() {
            IOService mockedIOService = Mockito.mock(IOServiceImpl.class);
            when(mockedIOService.input()).thenReturn("55.9");
            return mockedIOService;
        }
    }

    @Autowired
    private IOService ioService;


    @Test
    public void shouldHaveCorrectMethodInput() {

        assertEquals(55.9, Double.parseDouble(ioService.input()));
    }
}
