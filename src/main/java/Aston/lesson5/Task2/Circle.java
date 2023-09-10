package Aston.lesson5.Task2;

public class Circle extends Figure {
    public int radius;
    public Circle(String form, String border, String color, int radius){
        super(form, border, color);
        this.radius = radius;
        this.perimeter = (double) (2 * Math.PI * this.radius);
        this.square = (double) (Math.PI * Math.pow(this.radius, 2));
    }
}
