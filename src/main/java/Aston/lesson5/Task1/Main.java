package Aston.lesson5.Task1;

import java.io.OptionalDataException;
import java.util.Arrays;

public class Main {
    public static  void main (String[] args) {
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
        Plate plate = new Plate(20);
        catBob.wellFedCat();
        catBob.feedCat();
        catBob.wellFedCat();
        catBob.feedCat();
        catBob.wellFedCat();
        System.out.println("----------------------");
        /* добавляем еды */
        plate.info();
        plate.addFood(20);
        plate.info();
        System.out.println("----------------------");
        /* кормим котов*/
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик", 15);
        cats[1] = new Cat("Пушок", 10);
        cats[2] = new Cat("Гав", 5);
        for (int i = 0; i < cats.length; i++) {
            cats[i].feedCat();
            cats[i].wellFedCat();
            System.out.println("----------------------");
        }
        /*количество созданных животных*/
        numberOfAnimals();
    }
    static void numberOfAnimals() {
        System.out.println("Создано животных: " + (Cat.numberOfCats + Dog.numberOfDogs));
        System.out.println("Создано котов: " + Cat.numberOfCats);
        System.out.println("Создано собак: " + Dog.numberOfDogs);
    }
}
