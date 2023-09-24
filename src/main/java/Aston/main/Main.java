package Aston.main;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        System.out.println("Вес appleBox1: " + appleBox1.getWeight());
        System.out.println("Вес appleBox2: " + appleBox2.getWeight());
        System.out.println("Сравнение appleBox1 и appleBox2: " + appleBox1.compare(appleBox2));
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println("Вес orangeBox: " + orangeBox.getWeight());
        System.out.println("Сравнение appleBox1 и orangeBox: " + appleBox1.compare(orangeBox));
        Box<Apple> appleBox3 = new Box<>();
        appleBox3.addFruit(new Apple());
        appleBox3.addFruit(new Apple());
        appleBox3.addFruit(new Apple());
        System.out.println("Вес appleBox3: " + appleBox3.getWeight());
        appleBox1.transferFruits(appleBox3);
        System.out.println("Вес appleBox1 после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес appleBox3 после пересыпания: " + appleBox3.getWeight());
    }
}
