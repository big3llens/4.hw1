package hw2;

public interface LinkedList <E>{

    void add(E value);
    void addFirst(E value);
    void addLast(E value);
    E removeFirst();
    E removeLast();
    void contains(E value);

}
