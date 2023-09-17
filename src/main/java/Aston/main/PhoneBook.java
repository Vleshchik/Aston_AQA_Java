package Aston.main;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;
    String surname;
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(lastName, numbers);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "1234567890");
        phoneBook.add("Петров", "9876543210");
        phoneBook.add("Иванов", "5555555555");
        phoneBook.add("Иванов", "1233219090");
        phoneBook.add("Сидоров", "9808017872");
        phoneBook.add("Васечкин", "5257049911");

        // Поиск номера телефона по фамилии
        String surname = "Иванов";
        List<String> surnameNumbers = phoneBook.get(surname);
        System.out.println("Номера телефона для фамилии " + surname +": ");
        for (String number : surnameNumbers) {
            System.out.println(number);
        }
    }
}
