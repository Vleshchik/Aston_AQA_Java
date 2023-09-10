package Aston.lesson5.Task1;

public class Animal {
    public String name;
    public int runStamina;
    public int swimStamina;
    public String className;
    public boolean canSwim;

    public Animal(String name) {
        this.name = name;
    }

    void run(int barrier) {
        if (this.runStamina >= barrier) {
            System.out.println(this.className + " " + this.name + " пробежал " + barrier + " м.");
        } else{
            System.out.println(this.className + " " + this.name + " не преодолел препятствие.");
        }
    }

    void swim(int barrier) {
        if (this.swimStamina >= barrier) {
            System.out.println(this.className + " " + this.name + " проплыл " + barrier + " м.");
        } else {
            System.out.println(this.className + " " + this.name + " не преодолел препятствие.");
        }
    }

}

