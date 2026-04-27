import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application for the San Diego hangout planner.
 *
 * Prompts the user for budget, group size, and weather before checking activities.
 *
 * @author Matthew Virtue
 * @coauthor Gemini
 */
public class HangoutApp {
    public static void main(String[] args) {
        PlannerManager manager = new PlannerManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SD Hangout Planner ---");

        System.out.print("Enter your max budget (Max $200): ");
        double budget = scanner.nextDouble();

        while (budget < 0 || budget > 200) {
            System.out.print("Invalid budget. Please enter an amount between $0 and $200: ");
            budget = scanner.nextDouble();
        }

        System.out.print("Enter the number of friends (Max 15): ");
        int numFriends = scanner.nextInt();

        while (numFriends < 1 || numFriends > 15) {
            System.out.print("Invalid group size. Please enter 1-15 friends: ");
            numFriends = scanner.nextInt();
        }
        scanner.nextLine();

        System.out.print("Enter current weather (Sunny/Rainy): ");
        String weather = scanner.nextLine();

        while (!weather.equals("Sunny") && !weather.equals("Rainy")) {
            System.out.print("Please enter exactly 'Sunny' or 'Rainy': ");
            weather = scanner.nextLine();
        }

        System.out.println("Checking " + manager.getAllActivities().size() + " total activities...");


        ArrayList<Activity> options = manager.filterActivities(budget, numFriends, weather);

        if (options.isEmpty()) {
            System.out.println("Sorry! No activities match those specific conditions.");
        }
        
        else{
            System.out.println("Found " + options.size() + " matching plans for you:");
            for (Activity a : options) {
                System.out.println(a.getName());
            }
        }

        scanner.close();
    }
}
