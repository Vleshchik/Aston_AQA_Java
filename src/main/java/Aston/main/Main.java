package Aston.main;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        long factorial = calculateFactorial(number);

        System.out.println("Факториал числа " + number + " равен: " + factorial);
    }
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть неотрицательным");
        }
        if (number <= 1) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }

}
