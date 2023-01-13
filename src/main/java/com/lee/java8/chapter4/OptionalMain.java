package com.lee.java8.chapter4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Optional 사용 시 주의할 것
 * 리턴값으로만 쓰기를 권장.. (메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지말자)
 * Optional을 리턴하는 메소드에서 null을 리턴하지 말자
 * 프리미티브 타입을 Optional을 따로 있다. OptionalInt, OptionalLong..
 * Collection, Map, Stream Array Optional은 Optional로 감싸지 말자..
 */
public class OptionalMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        // getProgress() null exception..
        Progress progress = spring_boot.getProgress().get();
    }

    static class Progress {
        private Duration studyDuration;

        private boolean finished;

        public Duration getStudyDuration() {
            return studyDuration;
        }

        public void setStudyDuration(Duration studyDuration) {
            this.studyDuration = studyDuration;
        }
    }

    static class OnlineClass {
        private int id;
        private String title;
        private boolean closed;

        private Progress progress;

        public OnlineClass(int id, String title, boolean closed) {
            this.id = id;
            this.title = title;
            this.closed = closed;
        }

        OnlineClass() {
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

        public Optional<Progress> getProgress() {
            return Optional.ofNullable(progress);
        }
    }
}
