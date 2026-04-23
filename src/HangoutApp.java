import java.util.ArrayList;
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

        while(budget >0 || budget <200){
            System.out.print("Enter your max budget: ");
            double budget = scanner.nextDouble();
        }

        System.out.print("Enter the number of friends: ");
        int numFriends = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter current weather (Sunny/Rainy): ");
        String weather = scanner.nextLine();

        System.out.println("Checking " + manager.getAllActivities().size() + " total activities...");


        ArrayList<Activity> options = manager.filterActivities(budget, numFriends, weather);

        if (options.isEmpty()) {
            System.out.println("Sorry! No activities match those specific conditions.");
        }
        //elif

        else{
            System.out.println("Found " + options.size() + " matching plans for you:");
            for (Activity a : options) {
                System.out.println(a.getName());
            }
        }

        scanner.close();
    }
}
