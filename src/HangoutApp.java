import java.util.ArrayList;

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
        UserInterface ui = new UserInterface();

        // Testing the new Scanner logic
        double budget = ui.getValidBudget();
        int friends = ui.getValidFriends();
        String weather = ui.getValidWeather();

        // Testing if the manager can filter based on those inputs
        ArrayList<Activity> options = manager.filterActivities(budget, friends, weather);

        // Printing a simple list to verify
        ui.displaySimpleList(options);
    }
}
