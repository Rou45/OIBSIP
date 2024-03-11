package Project;
import java.util.Scanner;
import java.util.Random;

public class numbergame 
{ 
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minrange = 1;
        int maxrange = 100;
        int attemptsLimit = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
        
            int generatedNumber = random.nextInt(maxrange - minrange + 1) + minrange;
            int attempts = 0;
            
            System.out.println("Guess the number between " + minrange + " and " + maxrange + ".");
            
            while (attempts < attemptsLimit)
             {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); 
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations!  You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                attempts++;
            }
            
            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.print("Your current score: " + score + "\n\n");
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + score);
        scanner.close();
    }
}
