package model;

import java.io.Serializable;

public class NumberService implements Serializable {
    private int answer;
    
    public NumberService(){
    }
    
    public NumberService getNumberService(){
        return new NumberService();
    }
    
    public void generateRandomAnswer(){
        answer = 1 + (int)(Math.random() * ((10 - 1) + 1));
    }
    
    public int processGuess(int guess){
        if(guess == answer){
            return 0;
        }else if(guess<answer){
            return -1;
        }else if(guess>answer){
            return 1;
        }else{
            throw new IllegalArgumentException();
        }
    }
}