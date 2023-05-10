package com.example.novella;
public class Currency {
    private int value;
    public Currency(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void add(int amount) {
        value += amount;
    }
    public void subtract(int amount) {
        value -= amount;
    }
}
