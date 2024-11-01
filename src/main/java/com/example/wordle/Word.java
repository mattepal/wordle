package com.example.wordle;


import kotlin.text.UStringsKt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator;


public class Word {

    public static Map<Integer, String> loadWordsIntoMap(String filePath) {
        Map<Integer, String> wordMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int id = 1; // Iniziamo con ID 1 per la prima parola
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Ignora le righe vuote
                    wordMap.put(id, line.trim());
                    id++;
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file: " + e.getMessage());
        }
        return wordMap;
    }
    private String word;
    private String filePath = "src/main/java/com/example/wordle/wordList.txt"; // Inserisci qui il percorso del file
    private final Map<Integer, String> wordsMap = loadWordsIntoMap(filePath);

    public Word() {
        this.word = getRandomWord();
        System.out.println(word);
    }

    public String getRandomWord() {
        RandomGenerator rnd = RandomGenerator.getDefault();
        int randKey = rnd.nextInt(wordsMap.size()) + 1;
        return wordsMap.get(randKey);
    }
    public boolean isInsideMap(String guess){
        for (Map.Entry<Integer, String> entry: wordsMap.entrySet()) {
            if (guess.equals(entry.getValue())){
                return true;
            }
        }
        return false;
    }
    public String getWord() {
        return word;
    }

    public boolean checkMatch(String guess) {
        return word.equals(guess);
    }
}

