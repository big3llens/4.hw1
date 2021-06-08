package hw3;

public class Counter {

    private int count = 0;

    public synchronized void doCount(){
        count++;
        System.out.println(count);
    }
}
