/**
 * MyHealthPal class has all methods for calculation based on user input
 *
 *
 */
public class MyHealthPal {
    UserInfo userInfo;
    double bmr;
    double tdee;
    /**
     * MyHealthPal constructor uses the userinfo from the UserInfo class as a parameter
     * @param userInfo
     *
     */
    public MyHealthPal(UserInfo userInfo) {
        this.userInfo = userInfo;
        calculateBMR();
    }
    /**
     * calculateBMR plugs in user info into the equation used for calculation BMR. If and else statement used here to differentiate between male bmr and female bmr
     */
    private void calculateBMR() {
        if (userInfo.gender == 'M') {
            bmr = Math.abs(88.362 + (13.397 * userInfo.weight) + (4.799 * userInfo.height) - (5.677 * userInfo.age));
        } else {
            bmr = 447.593 + (9.247 * userInfo.weight) + (3.098 * userInfo.height) - (4.330 * userInfo.age);
        }
    }
    /**
     * calculateTDEE calculates the actual calorie intake needed for a person based on their goal and their total energy usage.
     * @param goal is equal to a number between 1-3 inclusive. 1 is for maintaining calories, 2 is for deficit, 3 is for surplus. These goals require different equations, so a switch statement is used based on the goal the user wants. If user inputs any of the numbers, the goal will switch between the cases in the method
     */
    public void calculateTDEE(int goal) {
        switch (goal) {
            case 1:
                tdee = (int)(bmr * 1.2); // Maintenance calories
                break;
            case 2:
                tdee = (int)(bmr * 0.8); // Deficit calories for weight loss
                break;
            case 3:
                tdee = (int)(bmr * 1.4); // Surplus calories for weight gain
                break;
            default:
                System.out.println("Invalid option. Exiting program.");
                System.exit(0);
        }
    }
    /**
     *
     * simply returns the TDEE which was calculated in the method above.
     */
    public double getTDEE() {
        return tdee;
    }
}
