import java.util.Scanner;
import java.util.regex.Pattern;
public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = "";
        do {
            System.out.println("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.isEmpty());
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt){
        int retInt = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();
                done = true;
            }
            else {
                String trash = pipe.nextLine();
                System.out.println("You entered " + trash + ".\nThat is not a correct input. Try again.");
            }
        }while(!done);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt){
        double retDouble = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                done = true;
            }
            else {
                String trash = pipe.nextLine();
                System.out.println("You entered " + trash + ".\nThat is not a correct input. Try again.");
            }
        }while(!done);
        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retRangeInt = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()){
                retRangeInt = pipe.nextInt();
                if (retRangeInt >= low && retRangeInt <= high){
                    done = true;
                }
                else {
                    System.out.println("The number you entered was not in the correct range. Try again.");
                }
            }
            else {
                String trash = pipe.nextLine();
                System.out.println("You entered " + trash + ".\nThat is not a correct input. Try again.");
            }
        }while (!done);
        return retRangeInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double retRangeDouble = 0;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()){
                retRangeDouble = pipe.nextDouble();
                if (retRangeDouble >= low && retRangeDouble <= high){
                    done = true;
                }
                else {
                    System.out.println("The number you entered was not in the correct range. Try again.");
                }
            }
            else {
                String trash = pipe.nextLine();
                System.out.println("You entered " + trash + ".\nThat is not a correct input. Try again.");
            }
        }while (!done);
        return retRangeDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean retYN = false;
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            String retYNInit = pipe.nextLine();
            if (retYNInit.equalsIgnoreCase("Y")){
                retYN = true;
                done = true;
            }
            else if (retYNInit.equalsIgnoreCase("N")){
                done = true;
            }
            else {
                System.out.println("\nYour input is invalid. Try again.");
            }
        }while (!done);
        return retYN;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String retRegEx = "";
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ": ");
            retRegEx = pipe.nextLine();
            if (Pattern.matches(regEx, retRegEx)){
                done = true;
            }
            else {
                System.out.println("Follow this pattern with your input: " + regEx + "\nTry Again.");
            }
        }while(!done);
        return retRegEx;
    }

    public static void prettyHeader(String msg){
            int headerWidth = 60;
            int msgLength = msg.length();

            if (msgLength > headerWidth - 6) {
                msg = msg.substring(0, headerWidth - 9) + "...";
                msgLength = msg.length();
            }

            int sideStars = (headerWidth - msgLength - 6) / 2;

            for (int i = 0; i < headerWidth; i++) {
                System.out.print("*");
            }
            System.out.println();

            System.out.print("***");
            for (int i = 0; i < sideStars; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i < sideStars; i++) {
                System.out.print(" ");
            }
            if (msgLength % 2 != 0) {
                System.out.print(" ");
            }
            System.out.println("***");

            for (int i = 0; i < headerWidth; i++) {
                System.out.print("*");
            }
            System.out.println();
    }
}
