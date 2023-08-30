package Aston.lesson2;

public class Main {
    public static void main(String[] args) {
        printThreeWords();

        checkSumSign(10, -11);

        printColor(100);

        compareNumbers(5, 6);
    }
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static void printColor(int num){
        if (num > 100) {
            System.out.println("Зеленый");
        }else if (num <= 0) {
            System.out.println("Красный");
        } else {
            System.out.println("Желтый");
        }
    }
    public static void checkSumSign(int a, int b) {

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}
