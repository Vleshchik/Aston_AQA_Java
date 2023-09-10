package Aston.lesson5.Task1;

public class Plate {
    public static int amountOfFood;

    public Plate(int amountOfFood) {
        this.amountOfFood = amountOfFood;

    }
    void addFood(int food) {
        amountOfFood += food;
    }
    void info() {
        System.out.println("В тарелке " + this.amountOfFood + " еды.");
    }

}
