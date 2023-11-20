public class UserInfo {
    double weight;
    double height;
    int age;
    char gender;
    /**
     * This UserInfo constructor creates an object containing the user's info
     * @param weight - users weight
     * @param height - users height
     * @param age - users age
     * @param gender - users gender
     */
    public UserInfo(double weight, double height, int age, char gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }
    /**
     * toString() method displays user information that was inputed by user for confirmation
     */
    public String toString() {
        return "Here is your data that you inputted. Make sure it is correct. If not, restart the program.\n Weight: " + weight + "\n Height: " + height + "\n Age: "+ age;
    }
}
