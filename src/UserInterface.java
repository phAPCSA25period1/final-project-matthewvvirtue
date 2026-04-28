import java.util.Scanner;

public class UserInterface {

    public String getValidWeather() {
        Scanner scanner = new Scanner(System.in);
        double budget = -1;
        boolean isValid = false;

        while (!isValid){
            try{
                System.out.print("Enter your max budget (Max $200): ");
                double budget = scanner.nextDouble();
                if (budget >= 0 && budget <= 200) {
                    isValid = true;
                }
                else {
                    System.out.println("Error: Please stay between $0 and $200.");
                }
            }


        }







        
}
