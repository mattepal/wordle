package com.example.wordle;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.random.RandomGenerator;


public class Word {
  /*
    public static Map<Integer, String> elenco(){
        Map<Integer, String> wordMap = new HashMap<>();
        wordMap.put(1, "acqua");
        wordMap.put(2, "amore");
        wordMap.put(3, "campo");
        wordMap.put(4, "cielo");
        wordMap.put(5, "fuoco");
        wordMap.put(6, "luce");
        wordMap.put(7, "piano");
        wordMap.put(8, "porta");
        wordMap.put(9, "tavolo");
        wordMap.put(10, "vento");
        wordMap.put(11, "zuppa");
        wordMap.put(12, "barca");
        wordMap.put(13, "botte");
        wordMap.put(14, "carro");
        wordMap.put(15, "corpo");
        wordMap.put(16, "cuore");
        wordMap.put(17, "dente");
        wordMap.put(18, "ferro");
        wordMap.put(19, "fiume");
        wordMap.put(20, "frase");
        wordMap.put(21, "gioco");
        wordMap.put(22, "globo");
        wordMap.put(23, "isola");
        wordMap.put(24, "lente");
        wordMap.put(25, "legno");
        wordMap.put(26, "libro");
        wordMap.put(27, "nervo");
        wordMap.put(28, "neve");
        wordMap.put(29, "notte");
        wordMap.put(30, "ombra");
        wordMap.put(31, "pasta");
        wordMap.put(32, "penna");
        wordMap.put(33, "pesce");
        wordMap.put(34, "cacca");
        wordMap.put(35, "pizzo");
        wordMap.put(36, "ruota");
        wordMap.put(37, "sasso");
        wordMap.put(38, "scena");
        wordMap.put(39, "scopo");
        wordMap.put(40, "sfera");
        wordMap.put(41, "sigla");
        wordMap.put(42, "sonno");
        wordMap.put(43, "spada");
        wordMap.put(44, "strada");
        wordMap.put(45, "tenda");
        wordMap.put(46, "tempo");
        wordMap.put(47, "tesla");
        wordMap.put(48, "vento");
        wordMap.put(49, "verde");
        wordMap.put(50, "vuoto");
        return wordMap;
    }
*/
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
    private String filePath = "C:\\Users\\User\\IdeaProjects\\wordle\\src\\main\\java\\com\\example\\wordle\\wordList.txt"; // Inserisci qui il percorso del file
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

    public String getWord() {
        return word;
    }

    public boolean checkMatch(String guess) {
        return word.equals(guess);
    }
}

