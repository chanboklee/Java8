package com.lee.java8.chapter4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApi {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = spring.isPresent();
        System.out.println("present = " + present);

        // get을 사용하지 말고 Optional API를 사용하자
        OnlineClass onlineClass = spring.get();
        System.out.println("onlineClass = " + onlineClass);

        // Optional API
        // 있어도 없어도 실행
        OnlineClass onlineClass1 = spring.orElse(createNewClass());
        System.out.println("onlineClass1 = " + onlineClass1.getTitle());

        // 없을때 실행
        OnlineClass onlineClass2 = spring.orElseGet(OptionalApi::createNewClass);
        System.out.println("onlineClass2 = " + onlineClass2.getTitle());

        // 예외
        OnlineClass onlineClass3 = spring.orElseThrow(IllegalStateException::new);
        System.out.println("onlineClass3 = " + onlineClass3.getTitle());

        // map으로 사용하게 되면 Optional을 한번 더 감싸서 나옴
        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();

        // flatMap으로 사용하면 안에서 Optional로 감싸진것을 풀어줌
        Optional<Progress> progress2 = spring.flatMap(OnlineClass::getProgress);


    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
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
            return Optional.empty();
        }
    }
}
