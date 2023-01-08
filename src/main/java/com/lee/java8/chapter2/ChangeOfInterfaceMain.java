package com.lee.java8.chapter2;

public class ChangeOfInterfaceMain {
    public static void main(String[] args) {
        ChangeOfInterfaceImpl changeOfInterface = new ChangeOfInterfaceImpl("lee");
        changeOfInterface.printName();
        changeOfInterface.printNameUppercase();
        ChangeOfInterface.printAnything();
    }
}
