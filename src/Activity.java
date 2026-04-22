/**
 * Represents an activity option with cost, group size, weather, and category details.
 *
 * @author Matthew Virtue
 */
public class Activity {
    private String name;
    private double cost;
    private int minPeople;
    private int maxPeople;
    private String weatherType;
    private String category;

    /**
     * Constructs a new Activity.
     *
     * @param name the name of the activity
     * @param cost the estimated cost of the activity
     * @param minPeople the minimum number of people required
     * @param maxPeople the maximum number of people supported
     * @param weatherType the preferred weather for the activity
     * @param category the activity category or type
     */
    public Activity(String name, double cost, int minPeople, int maxPeople, String weatherType, String category) {
        this.name = name;
        this.cost = cost;
        this.minPeople = minPeople;
        this.maxPeople = maxPeople;
        this.weatherType = weatherType;
        this.category = category;
    }

    /**
     * Returns the activity name.
     *
     * @return the activity name
     */
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public String getCategory() {
        return category;
    }
    
    public String toString() {
        return String.format("%s - Cost: $%.2f - Type: %s", name, cost, weatherType);
    }
}
