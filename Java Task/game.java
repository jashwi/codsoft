import java.util.Scanner;
import java.util.Random;
public class game {public static void main(String[] args) {
        playGame();
    }
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
         do {
            NumberGame(scanner);
             System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
            } while (true);
         System.out.println("Thanks for playing!");
        scanner.close();
    }
     public static void NumberGame(Scanner scanner) {
        Random random = new Random();
        int totalAttempts = 0;
        System.out.println("Let's get started with the Number Game!");
        int attempts = getAttempts(scanner);
        System.out.println("You've chosen to play with " + attempts + " attempts.");
        totalAttempts += playRound(scanner, random, attempts);
        System.out.println("\nGame over! You finished the game with a total of... " + totalAttempts + " attempts.");
        System.out.println("Average number of attempts per game: " + (double) totalAttempts / attempts);
    }
    public static int getAttempts(Scanner scanner) 
    {
        System.out.print("How many attempts do you want to play? ");
        return scanner.nextInt();
    }
     public static int playRound(Scanner scanner, Random random, int maxAttempts) {
        int secretNumber = random.nextInt(100) + 1;
        int attempts;
        for (attempts = 1; attempts <= maxAttempts; attempts++) {
            int userGuess;
            do {
                System.out.print("Guess the number between 1 and 100: ");
                userGuess = scanner.nextInt();
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                }
                 if (userGuess > 100) {
                    System.out.println("Warning: Please choose a number between 1 and 100.");
                }
            }
             while (userGuess < 1 || userGuess > 100);
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                break;
            } else {
                String message = (userGuess < secretNumber) ? "Your guess is too low. Please give it another try." : "Your guess is too high. Give it another shot.";
                System.out.println(message);
            }
        }
        if (attempts > maxAttempts) {
            System.out.println("Oops! You've run out of tries. The correct number was..." + secretNumber + ".");
        }
        return attempts;
    }
}
