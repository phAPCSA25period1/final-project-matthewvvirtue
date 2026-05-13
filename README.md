# 🌴 San Diego Hangout Planner

## What This Software Does

**San Diego Hangout Planner** is an interactive application that helps friends find the perfect activity to do together in San Diego. Users input their **budget**, **group size**, and **current weather**, and the app filters through a curated list of activities to suggest options that match their criteria.

The app displays results in a formatted dashboard showing activity names, costs, and "vibe levels" (whether it's a freebie, solid plan, or premium experience).

---

## Who It's For

**Target User:** Groups of friends in San Diego (1–15 people) looking to plan a hangout without guesswork.

**Problem Solved:** Instead of scrolling through endless options or arguing about what fits the budget and weather, users get instant, personalized recommendations based on their constraints.

---

## How to Run the Program

### Steps

1. **Navigate to the project directory:**
   cd /workspaces/final-project-matthewvvirtue


2. **Compile the Java files:**
   javac -d bin src/*.java

3. **Run the application:**
   java -cp bin HangoutApp

4. **Follow the prompts:**
   - Enter your maximum budget (e.g., `50` for $50)
   - Enter the number of people in your group (1–15)
   - Enter the weather (`Sunny` or `Rainy`)
   - View the filtered activities in the dashboard

---

## Technical Overview

### Main Classes

| **Class        |
| **HangoutApp** | Driver class with `main()` method. Orchestrates user input, filtering, and display. |
| **Activity** | Encapsulates a single activity with properties: name, cost, min/max group size, weather type, and category. |
| **PlannerManager** | Manages the activity database (ArrayList). Provides filtering logic based on budget, group size, and weather. |
| **UserInterface** | Handles all user input and output. Validates user entries and displays results in a formatted 2D dashboard. |

### Key Data Structures

- **`ArrayList<Activity> allActivities`** — Dynamic list of all available activities (no size limit)
- **`String[][] grid`** — 2D array used in `displayActivityDashboard()` to format and display filtered activities (rows = activities, columns = name/cost/vibe)

### Program Logic

1. **Initialization:** PlannerManager loads 15 pre-defined San Diego activities
2. **Input Collection:** UserInterface prompts for budget, group size, and weather with validation
3. **Filtering:** PlannerManager iterates through activities and checks three conditions:
   - Cost ≤ user's budget
   - User's group size within activity's min/max range
   - Activity's weather type matches user's selection
4. **Display:** UserInterface formats matching activities into a 2D table and prints a styled dashboard

### Filtering Algorithm

```
for each activity in allActivities:
    if (activity.cost <= budget) AND
       (people >= activity.minPeople) AND
       (people <= activity.maxPeople) AND
       (activity.weather matches user's weather):
        add to results
return results
```

---

## Class Diagram

```
┌─────────────────────┐
│    HangoutApp       │
│  (driver program)   │
└──────────┬──────────┘
           │ uses
      ┌────┴────┐
      ▼         ▼
┌──────────────┐  ┌──────────────────┐
│PlannerManager│  │  UserInterface   │
├──────────────┤  ├──────────────────┤
│allActivities │  │Scanner, output   │
│filterActiv...│  │getValidBudget()  │
│getAllActiv..│  │getValidFriends() │
└──────┬───────┘  │getValidWeather() │
       │ manages  │displayActivity..│
       ▼          └──────────────────┘
  ┌─────────┐
  │ Activity│
  ├─────────┤
  │ name    │
  │ cost    │
  │minPeople│
  │maxPeople│
  │weatherTy│
  │category │
  └─────────┘
```

---

## Sample Output

```
Enter your max budget (0-200): 50
Enter number of friends (1-15): 4
Enter weather (Sunny/Rainy): Sunny

================= SD HANGOUT DASHBOARD =================
| ACTIVITY                  | COST       | VIBE            |
+---------------------------+------------+-----------------+
| Sunset Cliffs Hike        | $0.00      | FREEBIE         |
| Belmont Park Rollercoaster| $15.00     | SOLID PLAN      |
| Coronado Ferry Ride       | $7.00      | SOLID PLAN      |
========================================================
```

---

## Known Limitations & Future Improvements

### What Works Well ✅
- Clean, intuitive user interface with robust input validation
- Efficient filtering using a single loop through activities
- Encapsulated Activity class with proper getters/setters
- Handles edge cases (no matches found, invalid inputs)
- Well-documented code with Javadoc comments
- Multiple interacting classes demonstrating OOP principles
- 2D array used meaningfully for formatted output

### Limitations ⚠️
- **Limited weather options:** Only "Sunny" and "Rainy" (could expand to Cloudy, Windy, etc.)
- **Fixed activity list:** Activities are hardcoded; no ability to save/load from a file
- **No persistence:** Program doesn't remember user preferences or previous searches
- **Basic filtering:** Can't filter by activity category or other preferences
- **Text-based UI:** No graphical interface

### Future Improvements 🚀
- **File I/O:** Load/save activities from a CSV or JSON file for easier updates
- **Advanced filtering:** Allow users to filter by category (Outdoor, Food, Adventurous, etc.)
- **Ratings system:** Let users rate activities to improve recommendations
- **Cost breakdown:** Show estimated cost per person
- **Database integration:** Connect to a real database of San Diego activities
- **GUI:** Build a graphical interface using JavaFX or Swing
- **User profiles:** Save favorite activities or activity history
- **Real-time data:** Integrate weather API for actual current conditions
- **Distance/location filtering:** Show activities by proximity to user's location
