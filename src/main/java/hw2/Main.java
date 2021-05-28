package hw2;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> array =  new ArrayListImpl<>(3);
        array.add(5);
        array.add(3);
        array.add(8);
        System.out.println(array);
        System.out.println(array.get(2));
    }
}
