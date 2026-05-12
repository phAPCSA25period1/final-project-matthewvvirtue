import java.util.ArrayList;

/**
 * Main application for the San Diego hangout planner.
 *
 * Prompts the user for budget, group size, and weather before checking activities.
 * Displays filtered activity options that match the user's criteria.
 *
 * @author Matthew Virtue with Gemini
 */
public class HangoutApp {
    /**
     * Main entry point for the application.
     *
     * Initializes the PlannerManager and UserInterface, collects user preferences,
     * filters available activities based on budget, group size, and weather, then
     * displays matching activity options in a formatted dashboard.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        PlannerManager manager = new PlannerManager();
        UserInterface ui = new UserInterface();

        double budget = ui.getValidBudget();
        int friends = ui.getValidFriends();
        String weather = ui.getValidWeather();

        ArrayList<Activity> options = manager.filterActivities(budget, friends, weather);
        ui.displayActivityDashboard(options);
    }
}
