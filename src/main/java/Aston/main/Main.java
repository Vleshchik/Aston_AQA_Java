package Aston.main;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        /*Задание №1*/
        int[] numbers = generateRandomNumbers(100);
        int countEven = countEvenNumbers(numbers);
        System.out.println("Количество чётных чисел: " + countEven);
        System.out.println("_________________________");
        /*Задание №2*/
        List<String> collection = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        int countHigh = countElement(collection, "High");
        System.out.println("Количество элементов 'High': " + countHigh);
        String firstElement = getFirstElement(collection);
        System.out.println("Первый элемент: " + firstElement);
        String lastElement = getLastElement(collection);
        System.out.println("Последний элемент: " + lastElement);
        System.out.println("_________________________");
        /*Задание №3*/
        String[] strings = {"f10", "f15", "f2", "f4", "f4"};
        Arrays.sort(strings);
        System.out.println("Отсортированный массив строк: " + Arrays.toString(strings));
        System.out.println("_________________________");
        /*Задание №5*/
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины (для завершения введите пустую строку):");
        while (true) {
            String login = scanner.nextLine();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }
        System.out.println("Логины, начинающиеся на букву 'f':");
        for (String login : logins) {
            if (login.startsWith("f")) {
                System.out.println(login);
            }
        }
    }
    /*Задание №1*/
    private static int[] generateRandomNumbers(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt();
        }
        return numbers;
    }
    private static int countEvenNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    /*Задание №2*/
    private static int countElement(List<String> collection, String element) {
        return Collections.frequency(collection, element);
    }
    private static String getFirstElement(List<String> collection) {
        if (!collection.isEmpty()) {
            return collection.get(0);
        }
        return "0";
    }
    private static String getLastElement(List<String> collection) {
        if (!collection.isEmpty()) {
            return collection.get(collection.size() - 1);
        }
        return "0";
    }
}