package com.example.wordle;


import java.util.Map;
import java.util.random.RandomGenerator;


public class Word {
    private static final Map<Integer, String> wordsMap= Map.of(1, "amore", 2, "tempo", 3, "piano", 4, "caldo", 5, "vento", 6, "luce", 7, "fiore", 8, "campo", 9, "maree", 10, "fuoco");

    private String word;

    public Word() {
        this.word = getRandomWord();
    }
    public String getRandomWord(){
        RandomGenerator rnd= RandomGenerator.getDefault();
        int randKey=rnd.nextInt(wordsMap.size())+1;
        return wordsMap.get(randKey);
    }
    public String getWord() {
        return word;
    }
    public boolean checkMatch(String guess){
        return word.equals(guess);
    }
    public static void main(String[] args) {
        // Creazione di un'istanza di Word e stampa della parola casuale
        Word randomWord = new Word();
        System.out.println("Parola casuale: " + randomWord.getWord());
    }
}
