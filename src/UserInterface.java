import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Handles user interaction and input validation for the hangout planner application.
 *
 * Provides methods to collect and validate user preferences including budget, group size,
 * and weather conditions. Also displays the filtered activity results in a formatted dashboard.
 *
 * @author Matthew Virtue with Gemini
 */
public class UserInterface {

    /**
     * Prompts the user to enter a valid weather preference.
     *
     * Repeatedly asks the user for input until a valid weather option ("Sunny" or "Rainy") is provided.
     *
     * @return the user's weather preference as a String ("Sunny" or "Rainy")
     */
    public String getValidWeather() {
        Scanner scanner = new Scanner(System.in);
        String weather = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter weather (Sunny/Rainy): ");
            weather = scanner.nextLine();

            if (weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Rainy")) {
                isValid = true;
            } else {
                System.out.println("Error: We only support 'Sunny' or 'Rainy' right now.");
            }
        }
        return weather;
    }

    /**
     * Prompts the user to enter a valid group size.
     *
     * Repeatedly asks the user for input until a valid integer between 1 and 15 is provided.
     * Handles InputMismatchException for non-integer inputs.
     *
     * @return the user's group size as an integer between 1 and 15
     */
    public int getValidFriends() {
        Scanner scanner = new Scanner(System.in);
        int friends = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter number of friends (1-15): ");
                friends = scanner.nextInt();

                if (friends >= 1 && friends <= 15) {
                    isValid = true;
                } else {
                    System.out.println("Error: Group size must be between 1 and 15.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a whole number.");
                scanner.nextLine();
            }
        }
        return friends;
    }

    /**
     * Prompts the user to enter a valid budget.
     *
     * Repeatedly asks the user for input until a valid number between 0 and 200 is provided.
     * Handles InputMismatchException for non-numeric inputs.
     *
     * @return the user's budget as a double value between 0 and 200
     */
    public double getValidBudget() {
        Scanner scanner = new Scanner(System.in);
        double budget = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter your max budget (0-200): ");
                budget = scanner.nextDouble();

                if (budget >= 0 && budget <= 200) {
                    isValid = true;
                } else {
                    System.out.println("Wait, that's out of range. Stay between $0 and $200.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (e.g., 20.50).");
                scanner.nextLine();
            }
        }
        return budget;
    }

    /**
     * Displays a formatted dashboard of available activities.
     *
     * Shows matching activities in a table format with columns for activity name, cost, and vibe level.
     * If no matching activities are found, displays a "No matches found" message.
     *
     * @param matches an ArrayList of Activity objects to display
     */
    public void displayActivityDashboard(ArrayList<Activity> matches) {
        if (matches.isEmpty()) {
            System.out.println("\n[!] No matches found.");
            return;
        }

        String[][] grid = new String[matches.size()][3];
        for (int i = 0; i < matches.size(); i++) {
            Activity a = matches.get(i);
            grid[i][0] = a.getName();
            grid[i][1] = String.format("$%.2f", a.getCost());
            grid[i][2] = (a.getCost() == 0) ? "FREEBIE" : (a.getCost() > 30 ? "PREMIUM" : "SOLID PLAN");
        }

        System.out.println("\n================= SD HANGOUT DASHBOARD =================");
        System.out.printf("| %-25s | %-10s | %-15s |\n", "ACTIVITY", "COST", "VIBE");
        System.out.println("+---------------------------+------------+-----------------+");

        for (int r = 0; r < grid.length; r++) {
            System.out.printf("| %-25s | %-10s | %-15s |\n", grid[r][0], grid[r][1], grid[r][2]);
        }
        System.out.println("========================================================");
    }
}





