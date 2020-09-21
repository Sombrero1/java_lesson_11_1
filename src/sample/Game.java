package sample;

import javafx.scene.text.Text;

import java.awt.*;
import java.util.Random;

public class Game {
    private int answerGame;
    private int value;
    public Game(){
        Random rnd=new Random();
        answerGame=rnd.nextInt(20);//число от 0 до 20

    }

    public boolean tryGuess(int ans, Text hint){
        if(ans==answerGame) {
            System.out.println("WIN");
            hint.setText("< Угадал! >");
            return true;
        }
        value++;
        if(ans>answerGame) {
            hint.setText("==Загаданное число меньше==\nПопыток осталось:" + (3-value));
            return false;
        }

        if(ans<answerGame) {
            hint.setText("==Загаданное число больше==\nПопыток осталось:" + (3-value));
            return false;
        }
        return false;
    }

    public int getValue() {
        return value;
    }
}

