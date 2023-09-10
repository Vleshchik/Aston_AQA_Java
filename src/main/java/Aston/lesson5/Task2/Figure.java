package Aston.lesson5.Task2;

public class Figure {
    public String form;
    public String border;
    public String color;
    public double square;
    public double perimeter;

    public Figure(String form, String border, String color) {
        this.form = form;
        this.border = border;
        this.color = color;
    }
    void info(){
        System.out.println(this.form);
        System.out.println(this.border);
        System.out.println(this.color);
        System.out.println(this.perimeter);
        System.out.println(this.square);
        System.out.println("----------------------");
    }
}
