package Aston.lesson5.Task1;

public class Cat extends Animal{
    public static int numberOfCats = 0;
    {
        numberOfCats += 1;
    }
    public boolean satiety;
    public int foodToSatiety;
    public Cat(String name, int foodToSatiety) {
        super(name);
        this.className = "Кот";
        this.canSwim = false;
        this.runStamina = 200;
        this.satiety = false;
        this.foodToSatiety = foodToSatiety;
    }

    void swim(int barrier) {
        System.out.println("Коты не умеют плавать.");
    }
    void wellFedCat() {
        if (this.satiety == true) {
            System.out.println("Кот " + this.name + " сыт.");
        } else {
            System.out.println("Кот " + this.name + " голоден.");
        }
    }
    void feedCat() {
        if (Plate.amountOfFood >= this.foodToSatiety){
            Plate.amountOfFood -= this.foodToSatiety;
            this.satiety = true;
            System.out.println("Котика " + this.name + " покормили - котик " + this.name + " сыт.");
        } else {
            System.out.println("Для котика " + this.name + " недостаточно еды - котик " + this.name + " все еще голоден.");
            this.satiety = false;
        }
    }
}
