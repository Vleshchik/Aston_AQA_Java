package Aston.lesson5.Task1;

public class Dog extends Animal{
    public static int numberOfDogs = 0;

    public Dog(String name) {
        super(name);
        this.className = "Пес";
        this.canSwim = true;
        this.runStamina = 500;
        this.swimStamina = 10;
        numberOfDogs += 1;
    }

}
