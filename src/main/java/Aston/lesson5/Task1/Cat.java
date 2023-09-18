package Aston.lesson5.Task1;

public class Cat extends Animal{
    public static int numberOfCats = 0;
    public boolean satiety;
    public static int foodToSatiety;
    public static int plate;
    public Cat(String name, int foodToSatiety) {
        super(name);
        this.className = "Кот";
        this.canSwim = false;
        this.runStamina = 200;
        this.satiety = false;
        this.foodToSatiety = foodToSatiety;
        numberOfCats += 1;
        this.plate = 20;
    }
    void wellFedCat() {
        if (this.satiety == true) {
            System.out.println("Кот " + this.name + " сыт.");
        } else {
            System.out.println("Кот " + this.name + " голоден.");
        }
    }
    public void addPlate(int amountOfFood) {
        this.plate = amountOfFood;

    }

    public void feedCat() {
        if (this.plate >= this.foodToSatiety){
            this.plate -= this.foodToSatiety;
            this.satiety = true;
            System.out.println("Котика " + this.name + " покормили - котик " + this.name + " сыт.");
            System.out.println("Котик " + this.name + " cъел " + this.foodToSatiety + " еды.");
        } else {
            System.out.println("Для котика " + this.name + " недостаточно еды - котик " + this.name + " все еще голоден.");
            this.satiety = false;
        }
    }
    void addFood(int food) {
        this.plate += food;
    }
    void info() {
        System.out.println("В тарелке " + this.plate + " еды.");
    }
}
