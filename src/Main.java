import java.util.Scanner;  // Import the Scanner class

import java.util.*;


public class Main {

    // lives: O O O
    // Input: x
    // Word: e.ll.
    // Not use: abcd.f

    static void displayDashes(char[] letters){
        for (int i = 0; i< letters.length; i++){
            letters[i] = '_';
        }
    }

    static void displayLives(int lives){
        for (int i = 0; i< lives; i++){
            System.out.print("o");
        }
        System.out.println();
    }

    static boolean checkGuesses(String randomWord, boolean isGuessCorrect, char letter, char[] letters, int gameLives){
        isGuessCorrect = false;
        for (int i = 0; i < randomWord.length(); i++){
            char l = randomWord.charAt(i);
            if(l == letter){
                letters[i] = l;
                isGuessCorrect = true;
                return true;
            }
        }

        if(!isGuessCorrect){
            gameLives--;
            return false;
        }
        return false;
    }


    public static void main(String[] args) {

        System.out.println("Starting game");
        int lives = 3;


        Scanner scanner = new Scanner(System.in);
        String[] words = new String[] {"computer", "mouse", "screen"};

        String randomWord = words[(int)(Math.random() * words.length)];
        char[] letters = new char[randomWord.length()];
        System.out.println("here");

        displayDashes(letters);


        // While loop until no lives are available
        while(lives > 0){
            System.out.print("Lives: ");



            displayLives(lives);

//            System.out.println();

            System.out.print("Input: ");

            String input = scanner.nextLine();


            char letter = input.charAt(0);


            boolean isGuessCorrect = false;

            checkGuesses(randomWord, isGuessCorrect, letter, letters, lives);
            if (!checkGuesses(randomWord, isGuessCorrect, letter, letters, lives)){
                lives--;
            };

            boolean isGameFinished = true;

            System.out.print("Word: ");

            for(int i = 0; i < letters.length; i++){
                if(letters[i] == '_'){
                    isGameFinished = false;
                }
                System.out.print(letters[i]);
            }

            if(isGameFinished){
                System.out.println("\nYou won the Game!");
                break;
            }
            System.out.println();

            if(lives == 0){
                System.out.println("You lost, the word was: " + randomWord);
            }



            System.out.println("-------------------");

        }
        System.out.println("Exiting game");


    }
}