package Aston.lesson5.Task2;

public class Main {
    public static  void main (String[] args) {
        Triangle a = new Triangle("треугольник","красный","белый",3,4,5);
        Square b = new Square("прямоугольник","зеленый","желтый",3,4);
        Circle c = new Circle("круг","синий","оранжевый", 3);
        a.info();
        b.info();
        c.info();
    }
}
