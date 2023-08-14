package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Coffee {
    private final String coffeeName;

    @Override
    public String toString() {
        return coffeeName;
    }
}
