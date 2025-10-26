package Exc;
import java.util.Scanner;

public class Ex_Guess_The_No {

    static class Game {
        private final int number; // Random number to guess

        // Constructor: generate random number between 1 and 100
        public Game() {
            number = (int) (Math.random() * 100) + 1;
            System.out.println("🎲 A number between 1 and 100 has been generated! Try to guess it.");
        }

        // Method to check the guess
        public boolean checkGuess(int guess) {
            if (guess == number) {
                System.out.println("🎉 Correct! You guessed the number!");
                return true;
            } else if (guess > number) {
                System.out.println("📉 Too high! Try a smaller number.");
            } else {
                System.out.println("📈 Too low! Try a bigger number.");
            }
            return false;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Game game = new Game();

        int attempts = 7; // increased attempts for a bigger range
        boolean guessed = false;

        while (attempts > 0) {
            System.out.print("\nEnter your guess (1–100): ");
            int guess = scn.nextInt();

            if (game.checkGuess(guess)) {
                guessed = true;
                break;
            }

            attempts--;
            if (attempts > 0) {
                System.out.println("❌ Wrong guess. Attempts left: " + attempts);
            }
        }

        if (!guessed) {
            System.out.println("\n💔 Out of attempts! The correct number was: " + game.getNumber());
        }

        scn.close();
    }
}
