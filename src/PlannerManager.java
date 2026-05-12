import java.util.ArrayList;

/**
 * Manages the list of activities available for the hangout planner.
 *
 * @author Matthew Virtue
 */
public class PlannerManager {
    private ArrayList<Activity> allActivities;

    /**
     * Creates a PlannerManager and loads the starter activity list.
     */
    public PlannerManager() {
        allActivities = new ArrayList<>();
        loadStarterActivities();
    }

    /**
     * Loads the initial set of activities into the planner.
     *
     * Populates the activity list with various San Diego attractions including
     * outdoor activities, indoor attractions, budget-friendly options, and
     * premium experiences suitable for different weather conditions and group sizes.
     */
    private void loadStarterActivities() {
        // Original Activities
        allActivities.add(new Activity("Sunset Cliffs Hike", 0.0, 1, 10, "Sunny", "Outdoor"));
        allActivities.add(new Activity("Belmont Park Rollercoaster", 15.0, 2, 6, "Sunny", "Adventurous"));
        allActivities.add(new Activity("Liberty Public Market", 25.0, 1, 8, "Rainy", "Food"));
        allActivities.add(new Activity("Coronado Ferry Ride", 7.0, 1, 20, "Sunny", "Chill"));

        // NEW ADDITIONS (Made by ai):
        // Low Budget / Free
        allActivities.add(new Activity("Balboa Park Botanical Building", 0.0, 1, 15, "Sunny", "Chill"));
        allActivities.add(new Activity("La Jolla Cove Seal Watching", 0.0, 1, 12, "Sunny", "Outdoor"));
        allActivities.add(new Activity("Old Town Scavenger Hunt", 0.0, 2, 10, "Sunny", "Adventurous"));

        // Rainy Day Options (Indoor)
        allActivities.add(new Activity("Fleet Science Center", 22.0, 1, 10, "Rainy", "Chill"));
        allActivities.add(new Activity("K1 Speed Indoor Karting", 30.0, 2, 8, "Rainy", "Adventurous"));
        allActivities.add(new Activity("Coin-Op Game Room", 15.0, 1, 10, "Rainy", "Food"));
        allActivities.add(new Activity("Punch Bowl Social", 20.0, 3, 15, "Rainy", "Adventurous"));

        // Higher Budget / Group Activities
        allActivities.add(new Activity("San Diego Zoo", 70.0, 1, 15, "Sunny", "Outdoor"));
        allActivities.add(new Activity("Mission Bay Jet Skiing", 90.0, 2, 4, "Sunny", "Adventurous"));
        allActivities.add(new Activity("Petco Park Padres Game", 45.0, 1, 20, "Sunny", "Outdoor"));
    }


    /**
     * Adds a new activity to the list of available activities.
     *
     * @param a the Activity object to be added
     */
    public void addActivity(Activity a) {
        allActivities.add(a);
    }

    /**
     * Returns all available activities in the planner.
     *
     * @return an ArrayList containing all Activity objects
     */
    public ArrayList<Activity> getAllActivities() {
        return allActivities;
    }

    /**
     * Filters activities based on budget, group size, and weather preferences.
     *
     * Returns a list of activities where the cost does not exceed the maximum budget,
     * the group size falls within the activity's minimum and maximum people limits,
     * and the weather type matches the user's preference.
     *
     * @param maxBudget the maximum amount the user is willing to spend
     * @param people the number of people in the group
     * @param weather the preferred weather condition ("Sunny" or "Rainy")
     * @return an ArrayList of activities that match all the specified criteria
     */
    public ArrayList<Activity> filterActivities(double maxBudget, int people, String weather) {
    ArrayList<Activity> matches = new ArrayList<>();

    for (Activity a : allActivities) {

        boolean budgetFit = a.getCost() <= maxBudget;
        boolean sizeFit = (people >= a.getMinPeople() && people <= a.getMaxPeople());
        boolean weatherFit = a.getWeatherType().equalsIgnoreCase(weather);

        if (budgetFit && sizeFit && weatherFit) {
            matches.add(a);
        }
    }
    return matches;
    }
}
