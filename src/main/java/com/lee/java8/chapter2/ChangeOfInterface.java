package com.lee.java8.chapter2;

import java.util.Locale;

public interface ChangeOfInterface {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     * 스펙을 자세히 기술해야 한다.
     * 재정의하여 사용할 수 있다.
     * Object Method를 재정의 할 수 없다.
     */
    default void printNameUppercase(){
        System.out.println(getName().toUpperCase());
    }

    static void printAnything(){
        System.out.println("printAnything");
    }

    String getName();
}
