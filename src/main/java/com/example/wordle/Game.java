package com.example.wordle;

import java.util.Scanner;

public class Game {
    Word word;
    Player player;

    public Game() {
        this.word = new Word();
        this.player = new Player();
    }

    public String readInputString(Scanner scan){
        String guess = scan.nextLine().toLowerCase();

        return guess;
    }

    public void startGame(){
        System.out.println("hi the game started");
        Scanner scan=new Scanner(System.in);
        while (!player.isOutOfIndex()){
            System.out.println("write the word");
            String guess=readInputString(scan);
            if (guess.length()!=word.getWord().length()){
                System.out.println("the word is not good");
                continue;
            }
            player.addAttempts(word.getWord(),guess);
            Attempt currentAttempt=player.getAttempts().get(player.getAttempts().size()-1);
            System.out.println("result="+currentAttempt.getResult());
            if (word.checkMatch(guess)){
                System.out.println("you win");
                break;
            }
        }
        if (player.isOutOfIndex()){
            System.out.println("number of attempt out of bound");
        }
        scan.close();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
