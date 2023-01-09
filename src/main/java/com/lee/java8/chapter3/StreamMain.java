package com.lee.java8.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. Stream
 * 데이터를 담고 있는 저장소(컬렉션)이 아니다.
 * Funtional in nature, 스트림이 처리하는 데이터 소스를 변경하지 않는다.
 * 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
 * 무제한일 수도 있다. (Short Circuit 메소드를 사용해서 제한할 수 있다)
 *
 * 2. 스트림 파이프라인
 * 0 또는 다수의 중계 오퍼레이션(intermediate operation)과 한개의 종료 오퍼레이션(terminal operation)으로 구성
 * 스트림의 데이터 소스는 오직 터미널 오퍼레이션을 실행할 때에만 처리
 *
 * 3. 중계 오퍼레이션(intermediate operation)
 * Stream을 리턴
 * filter, map, sorted..
 *
 * 4. 종료 오퍼레이션(terminal operation)
 * Stream을 리턴하지 않는다.
 * collect, count, min..
 */
public class StreamMain {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("lee");
        names.add("keesun");
        names.add("toby");

        // intermediate operation (중계 오퍼레이션)은 Stream을 리턴한다.
        // 이때 실행하지 않는다.
        names.stream().map((s) -> {
            System.out.println("s = " + s);
            return s.toUpperCase();
        });

        // terminal operation (결과 오퍼레이션)은 Stream을 리턴하지 않는다.
        // List, min, max 등 다양한 결과값으로 실행할 수 있다.
        List<String> collect = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 스트림이 처리하는 데이터 소스를 변경하지 않는다.
        names.forEach(System.out::println);
    }
}
