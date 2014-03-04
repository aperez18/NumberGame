package model;

import java.io.Serializable;

public class NumberService implements Serializable {
    private int answer;
    
    public NumberService(){
        answer = 1 + (int)(Math.random() * ((10 - 1) + 1));
    }
    
    public NumberService getNumberService(){
        return new NumberService();
    }
    
    public int getAnswer(){
        return answer;
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