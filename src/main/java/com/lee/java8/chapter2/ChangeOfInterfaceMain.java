package com.lee.java8.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class ChangeOfInterfaceMain {
    public static void main(String[] args) {
        ChangeOfInterfaceImpl changeOfInterface = new ChangeOfInterfaceImpl("lee");
        changeOfInterface.printName();
        changeOfInterface.printNameUppercase();
        ChangeOfInterface.printAnything();

        // 자바8 API
        List<String> name = new ArrayList<>();
        name.add("lee");
        name.add("toby");
        name.add("keesun");

        // method reference
        name.forEach(System.out::println);

        name.removeIf(s -> s.startsWith("k"));
        name.forEach(System.out::println);

    }
}
