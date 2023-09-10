package Aston.lesson5.Task2;



public class Triangle extends Figure {
    public int side_a;
    public int side_b;
    public int side_c;
    public double halfPerimeter;
    public Triangle(String form, String border, String color, int side_a, int side_b, int side_c){
        super(form, border, color);
        this.perimeter = (side_a + side_b + side_c);
        halfPerimeter = (double) this.perimeter / 2;
        this.square =(double) Math.sqrt(halfPerimeter * (halfPerimeter - side_a) * (halfPerimeter - side_b) * (halfPerimeter - side_c));
    }
}
