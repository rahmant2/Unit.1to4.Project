import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Get user information
        System.out.print("Enter your weight in lbs: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in inches: ");
        double height = scanner.nextDouble();
        System.out.print("Enter your age in years: ");
        int age = scanner.nextInt();
        System.out.print("Enter your gender (M/F): ");
        char gender = scanner.next().charAt(0);
        UserInfo userInfo = new UserInfo(weight, height, age, gender);
        System.out.println();
        System.out.println(userInfo);
        System.out.println();
        MyHealthPal calorieCalculator = new MyHealthPal(userInfo);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Select your goal:\n1. Maintain\n2. Lose Weight\n3. Gain Weight");
        int goal = scanner.nextInt();
        calorieCalculator.calculateTDEE(goal);
        System.out.println();
        System.out.println("Your TDEE is: " + calorieCalculator.getTDEE() + " calories per day");
        System.out.println();
        System.out.println("You will now track your food for the day. LOADING...");
        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
// Food tracking loop
        double totalCalories = 0;
        double totalProtein = 0;
        double totalCarbs = 0;
        double totalFats = 0;
        while (true) {
            System.out.print("Enter the food name (or 'exit' to finish tracking): ");
            String foodName = scanner.next();
            if (foodName.equals("exit")) {
                break;
            }
            System.out.print("Enter the amount of calories: ");
            double calories = scanner.nextDouble();
            totalCalories += calories;
            System.out.print("Enter the amount of protein in grams: ");
            double protein = scanner.nextDouble();
            totalProtein += protein;
            System.out.print("Enter the amount of carbs in grams: ");
            double carbs = scanner.nextDouble();
            totalCarbs += carbs;
            System.out.print("Enter the amount of fats in grams: ");
            double fats = scanner.nextDouble();
            totalFats += fats;
        }
        System.out.println("\nSummary:");
        System.out.println("Total calories consumed: " + totalCalories);
        System.out.println("Total protein consumed: " + totalProtein + " grams");
        System.out.println("Total carbs consumed: " + totalCarbs + " grams");
        System.out.println("Total fats consumed: " + totalFats + " grams");
// Feedback based on user's goal
        if (goal == 1) {
            if (totalCalories == calorieCalculator.getTDEE()) {
                System.out.println("You are maintaining weight.");
            } else {
                System.out.println("You might want to pick up the fork.");
            }
        } else if (goal == 2) {
            if (totalCalories < calorieCalculator.getTDEE()) {
                System.out.println("Great job! You are on track to lose weight.");
            } else {
                System.out.println("Be mindful of your calorie intake. You might not lose weight.");
            }
        } else if (goal == 3) {
            if (totalCalories > calorieCalculator.getTDEE()) {
                System.out.println("Great job! You are on track to gain weight.");
            } else {
                System.out.println("Ensure you are consuming enough calories to gain weight.");
            }
        }
        scanner.close();
    }
}


