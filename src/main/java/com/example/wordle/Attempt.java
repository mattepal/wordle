package com.example.wordle;

public class Attempt {
    private String guess;
    private String result;

    public Attempt(String guess, String word) {
        this.guess = guess;
        this.result = checkGuess(word);
    }

    private String checkGuess(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == word.charAt(i)) {
                result.append("G");
            } else if (word.contains(String.valueOf(guess.charAt(i)))) {
                result.append("Y");
            } else {
                result.append("R");
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
