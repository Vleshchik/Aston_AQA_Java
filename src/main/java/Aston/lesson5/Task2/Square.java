package Aston.lesson5.Task2;

public class Square extends Figure {
    public int side_a;
    public int side_b;

    public Square(String form, String border, String color, int side_a, int side_b) {
        super(form, border, color);
        this.perimeter = (2 * (side_a + side_b));
        this.square = side_a * side_b;
    }
}
