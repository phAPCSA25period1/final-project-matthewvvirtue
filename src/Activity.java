public class Activity {
    private String name;
    private double cost;
    private int minPeople;
    private int maxPeople;
    private String weatherType;
    private String category;

    public Activity(String name, double cost, int minPeople, int maxPeople, String weatherType, String category) {
        this.name = name;
        this.cost = cost;
        this.minPeople = minPeople;
        this.maxPeople = maxPeople;
        this.weatherType = weatherType;
        this.category = category;
    }

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
