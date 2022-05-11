package org.vashonsd;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public ArrayList<String> words;

    public hangman(ArrayList<String> words){
        this.words=words;
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public void setWords(ArrayList<String> words){
        this.words = words;
    }

    public void addWord(String word){
        words.add(word);
    }

    public void removeWord(int i){
        words.remove(i);
    }

    public void run(){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String theWord = words.get(rand.nextInt(words.size()));
        int guessesLeft = 6;
        int correctGuess;
        ArrayList<Character> wordPicture = new ArrayList<>();
        for(int i = 0; i < theWord.length(); i++){
            wordPicture.add('_');
        }
        String head = "";
        String body = "";
        String leftLeg = "";
        String rightLeg = "";
        String leftArm = "";
        String rightArm = "";
        String picture;
        while(true){
            picture = ("\n________\n|      |\n|      " + head + "\n|      " + leftArm + "" + body + "" + rightArm + "\n|     " + leftLeg + " " + rightLeg + "\n|_______");
            System.out.print("Word: ");
            for(char i : wordPicture){
                System.out.print(i);
            }
            System.out.println(picture);
            char guess = input.next().charAt(0);
            int j = 0;
            int temp = 0;
            for(int i = 0; i < theWord.length(); i++){
                if(guess == theWord.charAt(i)){
                    wordPicture.set(i, guess);
                    temp++;
                }
            }
            if(temp == 0){
                j++;
            }
            if(j != 0){
                guessesLeft -=1;
            }
            correctGuess = 0;
            for(char i : wordPicture){
                if(i != '_'){
                    correctGuess++;
                }
            }
            if(correctGuess == theWord.length()){
                System.out.print("Word: ");
                for(char i : wordPicture){
                    System.out.print(i);
                }
                System.out.println(picture);
                System.out.println("You win!");
                break;
            }
            if(guessesLeft == 5){
                head = "O";
            }
            else if(guessesLeft == 4){
                body = "|";
            }
            else if(guessesLeft == 3){
                leftLeg = "/";
            }
            else if(guessesLeft == 2){
                rightLeg = "\\";
            }
            else if(guessesLeft == 1){
                rightArm = "\\";
            }
            else if(guessesLeft == 0){
                leftArm = "/";
                picture = ("________\n|      |\n|      " + head + "\n|     " + leftArm + "" + body + "" + rightArm + "\n|     " + leftLeg + " " + rightLeg + "\n|_______");
                System.out.println("The word was " + theWord + "!");
                System.out.println(picture);
                System.out.println("You lose!");
                break;
            }
        }
    }
}
