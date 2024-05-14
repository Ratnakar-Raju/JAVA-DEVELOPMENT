import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r= new Random();
        int score = 0;
        int round = 1;

        while (true) {
            System.out.println("Round " + round + ":");
            int generatedNumber = r.nextInt(100) + 1;
            int attempts = 10;

            for (int i = 0; i < attempts; i++) {
                System.out.print("Enter your guess (1 to 100): ");
                int Guess = sc.nextInt();

                if (Guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number in " + (i + 1) + " attempts.");
                    score += (11 - i);
                    break;

                } else if (Guess < generatedNumber) {
                    System.out.println("Try again. Your guess is too low.");
                } else {
                    System.out.println("Try again. Your guess is too high.");
                }
            }

            System.out.println("Your score for this round is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
            score = 0;
        }

        System.out.println("Thanks for playing! Your total score is: " + score);
        sc.close();
    }
}