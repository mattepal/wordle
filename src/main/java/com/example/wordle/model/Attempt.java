package com.example.wordle.model;

public class Attempt {
    private final String guess;
    private final String result;

    public Attempt(String guess, String word) {
        this.guess = guess;
        this.result = checkGuess(word);
    }

    private String checkGuess(String word) {
        StringBuilder result = new StringBuilder();
        int[] letterCount=new int[26];
        for (char c: word.toCharArray()){
            letterCount[c-'a']++;
        }
        for (int i = 0; i <guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                result.append("G");
                letterCount[guess.charAt(i)-'a']--;
            } else{
                result.append(" ");
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (result.charAt(i)==' ') {
                if (word.contains(String.valueOf(guess.charAt(i))) && letterCount[guess.charAt(i)-'a']>0) {
                    result.setCharAt(i,'Y');
                    letterCount[guess.charAt(i)-'a']--;
                } else {
                    result.setCharAt(i,'R');
                }
            }
        }
        return result.toString();
    }

    public String getGuess() {
        return guess;
    }

    public String getResult() {
        return result;
    }
}
