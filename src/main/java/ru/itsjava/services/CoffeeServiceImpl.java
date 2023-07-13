package ru.itsjava.services;

import org.springframework.stereotype.Service;
import ru.itsjava.domain.Coffee;
@Service
public class CoffeeServiceImpl implements CoffeeService {
    @Override
    public Coffee getCoffeeByPrice(double price) {
        if (price == 59.9) {
            return new Coffee("Irish Raff");
        } else if (price == 75.9) {
            return new Coffee("Almond Latte");
        } else if (price == 999.99) {
            return new Coffee("Whiskey with coffee");
        } else return new Coffee(" Кажется у Вас нет потребности в кофе, вы и так бодры :-)");

    }

}
