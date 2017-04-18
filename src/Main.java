//author: Stephanie Broadwell
//lab #7
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] studID = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] studName = {"Jane Doe", "Sam Jackson", "Ryan Gosling", "George Washington", "Alice Evans", "Bob " +
                "Smith", "Albert Jones", "Charlie Rogers", "Tina Turnip", "Leslie Knope"};
        String[] hometown = {"Detroit, MI", "Washington, D.C.", "Miami, FL", "Richmond, VA", "Albany, NY", "Detroit, " +
                "MI", "Denver, CO", "Detroit, MI", "Boston, MA", "Pawnee, IN"};
        String[] favFood = {"Pizza", "Bagels", "Sushi", "Pad Thai", "Baby Back Ribs", "PB&J Sandwiches",
                "Mac'n'cheese with Hot Dogs", "Scrambled Eggs", "Bacon", "Whipped Cream and Waffles"};

        boolean learnClass = true;
        int userNum = 0;
        int tempNum;
        System.out.println("Welcome to our class!");
        do {
            //first do/while loop is looking for the student name using user input and searching the student ID array
            do {
                try {
                    System.out.println("Which student would you like to learn more about? (enter a number between 1-10): ");
                    userNum = scan.nextInt();
                    tempNum = userNum - 1; //tempNum is temporarily changing userNum to # 0-9 to search the arrays
                    //if/else is validating the number is between 1 and 10
                    if (tempNum >= 0 && tempNum <= studID.length) {
                        System.out.print("Student " + userNum + " is " + findStudent(tempNum, studID, studName) + ". ");
                        learnClass = false;
                    }
                    else {
                        System.out.println("That student does not exist. Please try again.");
                    }
                }
                catch (InputMismatchException e) { //catching any input that is not an integer
                    System.out.println("Invalid input. Please enter only numbers between 1-10.");
                    scan.nextLine();
                }
            }
            while (learnClass);

            scan.nextLine();
            //second do/while loop is used to find information on the student chosen
            do {
                try {
                    tempNum = userNum - 1;
                    System.out.println("What would you like to know about " + findStudent(tempNum, studID, studName) +
                            "? (enter 'hometown' or 'favorite food'): ");
                    String learnMore = scan.nextLine();
                    learnMore = learnMore.toLowerCase();
                    //using .contains to allow for the user to input 'hometown'/'town' and 'favorite food'/'food'
                    if (learnMore.contains("town")) {
                        System.out.println(findStudent(tempNum, studID, studName) + " is from " + locateStudent(tempNum,
                                studID, hometown) + ". ");
                        learnClass = false;
                    }
                    else if (learnMore.contains("food")) {
                        System.out.println(findStudent(tempNum, studID, studName) + "'s favorite food is " + foodStudent
                                (tempNum, studID, favFood) + ". ");
                        learnClass = false;
                    }
                    else {
                        System.out.println("That data does not exist. Please try again.");
                        learnClass = true;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input.  Please try again.");
                    scan.nextLine();
                    learnClass = true;
                }
            }
            while (learnClass);

            System.out.println("Would you like to learn about another student? ('yes' or  'no'): ");
            String learnAnother = scan.nextLine();
            learnAnother = learnAnother.toLowerCase();
            if (learnAnother.startsWith("n")) {
                System.out.println("Goodbye!");
                learnClass = false;
            }
            else {
                learnClass = true;
            }
        }
        while (learnClass);
    }
    //using user input (tempNum) to search through the studId and studName arrays and returning the studName once found
    public static String findStudent(int num, int[] idNum, String[] name) {
        String studName = "";
        for (int i = 0; i < idNum.length; i++) {
            if (i == num) {
                studName = name[i];
            }
        }
        return studName;
    }
    //similar to findStudent method, searching through studID and hometown arrays using user input
    //and returning the hometown once found
    public static String locateStudent (int num, int[] idNum, String[] town) {
        String hometown = "";
        for (int i = 0; i < idNum.length; i++) {
            if (i == num) {
                hometown = town[i];
            }
        }
        return hometown;
    }
    //searching for the favorite food of the corresponding student using the user input number (tempNum)
    public static String foodStudent (int num, int[] idNum, String[] food) {
        String favfood = "";
        for (int i = 0; i < idNum.length; i++) {
            if (i == num) {
                favfood = food[i];
            }
        }
        return favfood;
    }
}
