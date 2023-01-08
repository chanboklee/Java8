package com.lee.java8.chapter2;

import java.util.Locale;

public class ChangeOfInterfaceImpl implements ChangeOfInterface{

    String name;

    public ChangeOfInterfaceImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    // 재정의하여 사용할 수 있다.
    @Override
    public void printNameUppercase() {
        System.out.println(this.name.toUpperCase());
    }
}
