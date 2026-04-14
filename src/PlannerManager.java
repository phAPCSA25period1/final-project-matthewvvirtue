import java.util.ArrayList;

public class PlannerManager {
    private ArrayList<Activity> allActivities;

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
}
