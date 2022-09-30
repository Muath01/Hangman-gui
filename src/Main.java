import java.util.Scanner;
import java.util.*;


public class Main {

    // lives: O O O
    // Input: x
    // Word: e.ll.
    // Not use: abcd.f

    int live = 3;

    public static void main(String[] args) {

        System.out.println("Starting game");

        int lives = 3;

        Scanner scanner = new Scanner(System.in);
        String[] words = new String[] {"computer", "mouse", "screen"};

//        String randomWord = words[(int) Math.random() * words.length];
        String randomWord = words[(int)(Math.random() * words.length)];
        char[] letters = new char[randomWord.length()];
        System.out.println("here");

        // _ for every unguessed letter
            for (int i = 0; i < letters.length; i++){
                  letters[i] = '_';
              }

        // While loop until no lives are available
        while(lives > 0){
            System.out.print("Lives: ");





            // Number of lives
            for (int i = 0; i < lives; i++){
                System.out.print("o");
            }

            System.out.println();

            System.out.print("Input: ");

            String input = scanner.nextLine();


            char letter = input.charAt(0);


            // Checking guesses.
            boolean isGuessCorrect = false;
            for (int i = 0; i < randomWord.length(); i++){
                char l = randomWord.charAt(i);
                if(l == letter){
                    letters[i] = l;
                    isGuessCorrect = true;
                }
            }

            if(!isGuessCorrect){
                lives--;

            }

            boolean isGameFinished = true;

            System.out.print("Word: ");

            for(int i = 0; i < letters.length; i++){
                if(letters[i] == '_'){
                    isGameFinished = false;
                }
                System.out.print(letters[i]);
            }

            if(isGameFinished){
                System.out.println("You won the Game!");
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