import java.util.Scanner;

public class Guesser {
    static final int MIN = 1;
    static final int MAX = 100;

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) { // start the program
        Guesser game = new Guesser();
        game.run();
    }

    void run() { // Main menu loop
        int choice;

        do {
            menu();
            choice = input.nextInt();

            if (choice == 1) {
                humanGuesser();
            }
            else if (choice == 2) {
                computerGuesser();
            }
            else if (choice == 0) {
                return;
            }
            else {
                System.out.println("Invalid choice. Please enter 0-2.");
            }

        } while (choice != 0);
    } // end run

    void menu() { // display the menu options
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Human Guesser");
        System.out.println("2) Computer guesser");
        System.out.println();
        System.out.print("Please enter 0-2: ");
    } // end menu

    void humanGuesser() { // human guesses a random number
        int number, guess, attempts;

        number = (int)(Math.random() * MAX) + MIN;
        attempts = 0;

        System.out.println("human guesser");

        do {
            attempts++;

            System.out.print(attempts + ") Please enter a number: ");
            guess = input.nextInt();

            if (guess < number) {
                System.out.println("too low...");
            }
            else if (guess > number) {
                System.out.println("too high...");
            }
            else {
                System.out.println("got it!");
                System.out.println();
                System.out.println("Very good!");

                // EXTRA FEATURE: display the number of attempts
                System.out.println("You guessed the number in "
                        + attempts + " attempts!");
            }

        } while (guess != number);
    } // end humanGuesser

    void computerGuesser() { // computer uses binary search
        int low, high, guess, attempts;
        String response;

        low = MIN;
        high = MAX;
        attempts = 0;

        System.out.println("computer guesser");
        System.out.println("Think of a number between 1 and 100.");

        do {
            guess = (low + high) / 2;
            attempts++;

            System.out.println(attempts + ") I guess " + guess);
            System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");

            response = input.next();

            if (response.equalsIgnoreCase("h")) {
                high = guess - 1;
            }
            else if (response.equalsIgnoreCase("l")) {
                low = guess + 1;
            }
            else if (response.equalsIgnoreCase("c")) {
                System.out.println("I got it in " + attempts + " guesses!");
                break;
            }
            else {
                System.out.println("Invalid response. Enter H, L, or C.");
                attempts--;
                continue;
            }
        } while (!response.equalsIgnoreCase("c"));
    } // end computerGUesser
} // end class

