package com.lee.java8.chapter3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<OnlineClass> springClass = new ArrayList<>();
        springClass.add(new OnlineClass(1, "spring boot", true));
        springClass.add(new OnlineClass(2, "spring data jpa", true));
        springClass.add(new OnlineClass(3, "spring mvc", false));
        springClass.add(new OnlineClass(4, "spring core", false));
        springClass.add(new OnlineClass(5, "rest api development", false));

        // spring 으로 시작하는 수업
        springClass.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));

        // close 되지 않은 수업
        springClass.stream()
                // .filter(oc -> !oc.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        // 수업 이름만 모아서 스트림 만들기
        springClass.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        // 수업 이름만 모아서 스트림 만들고 정렬 리스트 만들기
        List<String> collect = springClass.stream().sorted().map(OnlineClass::getTitle).collect(Collectors.toList());

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(springClass);
        events.add(javaClasses);

        // 두 수업 목록에 들어있는 모든 수업 아이디 출력
        events.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        // 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        // 자바 수업 중에 Test가 들어있는 수업이 있는지 확인
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        // 스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기
        List<String> spring = springClass.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());

        spring.forEach(System.out::println);
    }


    static class OnlineClass {
        private int id;
        private String title;
        private boolean closed;

        public OnlineClass(int id, String title, boolean closed) {
            this.id = id;
            this.title = title;
            this.closed = closed;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public boolean isClosed() {
            return closed;
        }
    }
}
