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

    private void loadStarterActivities() {
        allActivities.add(new Activity("Sunset Cliffs Hike", 0.0, 1, 10, "Sunny", "Outdoor"));
        allActivities.add(new Activity("Belmont Park Rollercoaster", 15.0, 2, 6, "Sunny", "Adventurous"));
        allActivities.add(new Activity("Liberty Public Market", 25.0, 1, 8, "Rainy", "Food"));
        allActivities.add(new Activity("Coronado Ferry Ride", 7.0, 1, 20, "Sunny", "Chill"));
    }

    public void addActivity(Activity a) {
        allActivities.add(a);
    }

    public ArrayList<Activity> getAllActivities() {
        return allActivities;
    }

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
