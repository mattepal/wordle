package com.example.wordle;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int MAX_ATTEMPT=6;
    private List<Attempt> attempts;

    public Player() {
        attempts=new ArrayList<>();
    }
    public boolean addAttempts(String word,String guess){
        attempts.add(new Attempt(guess,word));
        if (attempts.size()<=MAX_ATTEMPT){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOutOfIndex(){
        if(attempts.size()>=MAX_ATTEMPT){
            return true;
        }
        return false;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

}
