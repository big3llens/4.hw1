package hw3;

import java.util.concurrent.locks.Lock;

public class Main {

    public static void main(String[] args) {
//        doExerciseOne();
        doExerciseTwo();
    }

    public static void doExerciseOne(){
        PingPong pingPong = new PingPong();
        new Thread(pingPong::doPing).start();
        new Thread(pingPong::doPing).start();
        new Thread(pingPong::doPing).start();
        new Thread(pingPong::doPong).start();
        new Thread(pingPong::doPong).start();
        new Thread(pingPong::doPong).start();
    }

    public static void doExerciseTwo(){
        Counter counter = new Counter();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                counter.doCount();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                counter.doCount();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                counter.doCount();
            }
        }).start();
    }

}
