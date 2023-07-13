package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("coffeeHouse")
@RequiredArgsConstructor
public class CoffeeHouseImpl implements CoffeeHouse {
    private final CoffeeService coffeeService;
    private final IOService ioService;

    @Override
    public void welcomeTheUserTakeTheMoneyAndBuyCoffee() {
        System.out.println("Приветсвую тебя путник!");
        System.out.println("Не зря ты забрел в лучшую кофейню на Диком Западе");
        System.out.println("Вот наш ассортимент:  " + "\n" + " - Irish Raff --- 59.9$" + "\n" + " - Almond Latte --- 75.9$"
                + "\n" + " - Branded coffee --- 999.99$");
        System.out.println("Сначала деньги, потом кофе и лучше без резких движений дружище!");
        double price = Double.parseDouble(ioService.input());
        System.out.println("Твой " + coffeeService.getCoffeeByPrice(price)+" готов! Наслаждайся");
        System.out.println("Буду рад увидеть тебя снова");
    }
}
