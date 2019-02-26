import java.util.Scanner;
import java.io.*;

// Make an option to add a class
// Make it lead to a file creator that will let you add a class
// and edit the lines
// The list of classes would be pulling from a file or the name of the classes
// which you could use as parameters for the generic methods
// Generic methods would make all of this so much easier
// make the main methods take in a parameter of the name of the file
// Use if else statements to control how many times the loops run
// Use counter to keep up with (num) thing in main method
// MOST IMPORTANT: Test in a seperate class
// Have an average calculator class that takes in a int param
// where the int corresponds with if statements that are specifically
// made to handle whatever kinda averaging you want to happen.


public class GradesMain {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        gradeProducer first = new gradeProducer();
        Grades1552 second = new Grades1552();
        int b = 0;

        while (b == 0){
            System.out.println("*********************************************************");
            System.out.println("What class would you like to see?");
            System.out.println("(1) CS 1331");
            System.out.println("(2) MATH 1552");
            System.out.println("(3) PHYS 2211");
            System.out.println("(4) Exit Program");
            System.out.print("Enter answer: ");
            int ans = scan.nextInt();
            if (ans == 1) {
                first.run1331();
            } else if (ans == 2) {
                second.run1552();
            } else if (ans == 3) {
                tryThis();
            } else if (ans == 4) {
                System.exit(0);
            }
        }

    }

    public static void tryThis() {
        int[] num = new int[3];
        num[0] = 5;
        num[1] = 5;
        num[2] = 4;

        int a = num[0];
        int b = num[1];
        int c = num[2];
        System.out.print("Original order: ");
        System.out.println(a + " " + b + " " + c);

        int lowest = a;

        if (c < b) {
            lowest = c;
            num[1] = c;
            num[2] = b;
        }
        a = num[0];
        b = num[1];
        c = num[2];

        if (b < a) {
            lowest = b;
            num[0] = b;
            num[1] = a;
        }

        System.out.print("Corrected order: ");
        System.out.println(num[0] + " " + num[1] + " " + num[2]);

    }
}