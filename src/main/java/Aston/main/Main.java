package Aston.main;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Создание массива с набором слов
        String[] words = {"apple", "banana", "orange", "apple", "lemon", "banana", "kiwi", "orange", "grape", "apple"};

        // Создание списка уникальных слов
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        // Вывод списка уникальных слов
        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        // Подсчет количества повторений каждого слова
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : uniqueWords) {
            wordCount.put(word, Collections.frequency(Arrays.asList(words), word));
        }

        // Вывод количества повторений каждого слова
        System.out.println("Количество повторений слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
