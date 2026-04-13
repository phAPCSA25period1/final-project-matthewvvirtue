import java.util.Scanner;

public class HangoutApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your budget: ");
        double budget = scanner.nextDouble();

        System.out.print("Enter the number of friends: ");
        int numFriends = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your preferences (e.g., outdoor, indoor, food): ");
        String preferences = scanner.nextLine();

        System.out.println("Budget: " + budget);
        System.out.println("Number of friends: " + numFriends);
        System.out.println("Preferences: " + preferences);

        //Generate random plan based on inputs

        scanner.close();
    }
}
