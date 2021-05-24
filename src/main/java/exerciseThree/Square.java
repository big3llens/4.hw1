package exerciseThree;

public class Square extends Shape{

    protected double x = 5.0;
    protected double y = 6.5;

    public void rotation(){
        System.out.println("Вращает квадрат против часовой стрелки вокруг точки : " + x + ":" + y);
    }

}
