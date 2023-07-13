package ru.itsjava.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Coffee {
    private final String coffeeName;

    @Override
    public String toString() {
        return coffeeName;
    }
}
