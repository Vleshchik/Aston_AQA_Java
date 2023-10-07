package Aston.main;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*Задание №1*/
        int[] numbers = generateRandomNumbers(100);
        long count = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("Количество четных чисел: " + count);
        System.out.println("_________________________");
        /*Задание №2*/
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        // 2.1. Подсчет количества вхождений строки "High"
        long count_2 = collection.stream()
                .filter(str -> str.equals("High"))
                .count();
        System.out.println("Количество вхождений строки \"High\": " + count_2);

        // 2.2. Определение первого элемента коллекции
        String firstElement = collection.stream()
                .findFirst()
                .orElse("0");
        System.out.println("Первый элемент коллекции: " + firstElement);

        // 2.3. Возвращение последнего элемента коллекции
        String lastElement = collection.stream()
                .reduce((first, second) -> second)
                .orElse("0");
        System.out.println("Последний элемент коллекции: " + lastElement);
        System.out.println("_________________________");
        /*Задание №3*/
        String[] strings = {"f10", "f15", "f2", "f4", "f4"};
        Arrays.sort(strings);
        System.out.println("Отсортированный массив строк: " + Arrays.toString(strings));
        System.out.println("_________________________");
        /*Задание №5*/
        List<String> logins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логины (пустая строка для завершения):");
        String login;
        while (!(login = scanner.nextLine()).isEmpty()) {
            logins.add(login);
        }
        List<String> filteredLogins = logins.stream()
                .filter(str -> str.startsWith("f"))
                .collect(Collectors.toList());
        System.out.println("Логины, начинающиеся на букву 'f':");
        for (String filteredLogin : filteredLogins) {
            System.out.println(filteredLogin);
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
}