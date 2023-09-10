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
        System.out.println("Фигура: " + this.form);
        System.out.println("Цвет границы: " + this.border);
        System.out.println("Цвет заливки: " + this.color);
        System.out.println("Периметр: " + this.perimeter);
        System.out.println("Площадь: " + this.square);
        System.out.println("----------------------");
    }
}
