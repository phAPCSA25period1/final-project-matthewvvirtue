import java.util.Scanner;

/**
 * Main application for the San Diego hangout planner.
 *
 * Prompts the user for budget, group size, and weather before checking activities.
 *
 * @author Matthew Virtue
 */
public class HangoutApp {
    public static void main(String[] args) {
        PlannerManager manager = new PlannerManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SD Hangout Planner ---");

        System.out.print("Enter your max budget: ");
        double budget = scanner.nextDouble();

        System.out.print("Enter the number of friends: ");
        int numFriends = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter current weather (Sunny/Rainy): ");
        String weather = scanner.nextLine();

        System.out.println("Checking " + manager.getAllActivities().size() + " total activities...");



        scanner.close();
    }
}
