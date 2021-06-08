package hw3;

public class PingPong {

    private boolean ping = true;

    public synchronized void doPing () {
        while (!ping){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ping = false;
        System.out.println("Ping");
        notifyAll();
    }

    public synchronized void doPong () {
        while (ping){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ping = true;
        System.out.println("Pong");
        notifyAll();
    }
}
