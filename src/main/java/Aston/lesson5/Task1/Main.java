package Aston.lesson5.Task1;

import java.util.Scanner;

public class Main {
    public static  void main (String[] args) {
        Scanner in = new Scanner(System.in);
        /* Пес бежит и плывет*/
        Dog dogRex = new Dog("Рекс");
        dogRex.run(600);
        dogRex.run(10);
        dogRex.swim(3);
        System.out.println("----------------------");
        /* Кот бежит и плывет*/
        Cat catBob = new Cat("Боб", 10);
        catBob.run(300);
        catBob.swim(1);
        System.out.println("----------------------");
        /*кормим кота*/
        catBob.addPlate(15);
        catBob.wellFedCat();
        catBob.feedCat();
        catBob.wellFedCat();
        catBob.feedCat();
        catBob.wellFedCat();
        System.out.println("----------------------");
        /* добавляем еды */
        catBob.info();
        catBob.addFood(20);
        catBob.info();
        System.out.println("----------------------");
        /* кормим котов*/
        Cat[] cats = new Cat[3];
        /*cats[0] = new Cat("Барсик", 15);
        cats[1] = new Cat("Пушок", 10);
        cats[2] = new Cat("Гав", 5);*/

        for (int i = 0; i < cats.length; i++) {
            System.out.print("Введите имя котика: ");
            String name = in.nextLine();
            System.out.print("Введите необходимое котику количество еды: ");
            int foodToSatiety = in.nextInt();
            cats[i] = new Cat(name, foodToSatiety);
            cats[i].info();
            cats[i].feedCat();
            cats[i].wellFedCat();
            System.out.println("----------------------");
        }
        /*количество созданных животных*/
        numberOfAnimals();
    }
    static void numberOfAnimals() {
        System.out.println("Создано животных: " + (Animal.numberOfAnimals));
        System.out.println("Создано котов: " + Cat.numberOfCats);
        System.out.println("Создано собак: " + Dog.numberOfDogs);
    }
}
