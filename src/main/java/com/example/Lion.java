package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline feline;

    // Конструктор, принимающий только строку
    public Lion(String sex) throws Exception {
        this(sex, new Feline());
    }

    // Конструктор, принимающий строку и объект Feline
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
        this.feline = feline;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}