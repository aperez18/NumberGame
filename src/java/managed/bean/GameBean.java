package managed.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.NumberService;

@Named
@SessionScoped
public class GameBean implements Serializable {

    private final String GUESS_HIGH = "Your guess was too high.";
    private final String GUESS_LOW = "Your guess was too low.";
    private final String GUESS_CORRECT = "Congratulations, you guessed correct!";
    
    private int guess;
    private int correct;
    private int incorrect;
    private boolean home=true;
    private boolean newGame=false;
    private boolean quit=false;
    private boolean inputGuess=false;
    private boolean guessFound=false;
    private String result="";
    @Inject
    private NumberService ns;
    
    /**
     * Creates a new instance of GameBean
     */
    public GameBean() {
        incorrect=0;
        correct=0;
    }
    
    public String wrongGuess(){
        guessFound=true;
        incorrect++;
        return null;
    }
    
    public String correctGuess(){
        ns = ns.getNumberService();
        guessFound=true;
        newGame=true;
        quit=true;
        inputGuess=false;
        correct++;
        return null;
    }
    
    public String startGame(){
        ns = ns.getNumberService();
        home=false;
        newGame=true;
        quit=true;
        inputGuess=true;
        return null;
    }
    
    public String quitGame(){
        
        home=true;
        newGame=false;
        quit=false;
        inputGuess=false;
        return null;
    }
    
    public String submitGuess(){
        switch(ns.processGuess(guess)){
            case -1: result = GUESS_LOW; wrongGuess();
            case 0: result = GUESS_CORRECT; correctGuess();
            case 1: result = GUESS_HIGH; wrongGuess();
        }
        return null;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public boolean isNewGame() {
        return newGame;
    }

    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean isInputGuess() {
        return inputGuess;
    }

    public void setInputGuess(boolean inputGuess) {
        this.inputGuess = inputGuess;
    }

    public boolean isGuessFound() {
        return guessFound;
    }

    public void setGuessFound(boolean guessFound) {
        this.guessFound = guessFound;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public NumberService getNs() {
        return ns;
    }

    public void setNs(NumberService ns) {
        this.ns = ns;
    }
}
