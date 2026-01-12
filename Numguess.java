import java.util.Random;
import java.util.Scanner;

class Numguess {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Random rand = new Random();
            char choice;
            
            do {
                int number = rand.nextInt(100) + 1; // random number 1 to 100
                int attempts = 5;
                int guess;
                
                System.out.println("\nGuess a number between 1 and 100");
                System.out.println("You have " + attempts + " attempts");
                
                while (attempts > 0) {
                    System.out.print("Enter your guess: ");
                    guess = sc.nextInt();
                    
                    if (guess == number) {
                        System.out.println("Correct! You guessed the number");
                        break;
                    } else if (guess > number) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Too low!");
                    }
                    
                    attempts--;
                    System.out.println("Attempts left: " + attempts);
                }
                
                if (attempts == 0) {
                    System.out.println("Out of attempts!");
                    System.out.println("The number was: " + number);
                }
                
                System.out.print("Play again? (y/n): ");
                choice = sc.next().charAt(0);
                
            } while (choice == 'y' || choice == 'Y');
            
            System.out.println("Thanks for playing!");
        }
    }
}
