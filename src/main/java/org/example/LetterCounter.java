package org.example;

public class LetterCounter {
    public static void main(String[] args) {
        String text = "This is a sample text to demonstrate letter frequency.";
        text = text.toLowerCase();          // Приводим весь текст к нижнему регистру для упрощения подсчета

        int[] letterCounts = new int[26];   // Массив для хранения количества вхождений каждой буквы
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {     // учитываем только символы букв, без пробелов и знаков препинания
                letterCounts[c - 'a']++;    // Инкрементируем счетчик соответствующей буквы
            }
        }

        // Вывод результатов
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            System.out.println(letter + ": " + letterCounts[i]);
        }
    }
}
