import java.util.Scanner;
import java.io.*;

public class gradeProducer {

    public static int[] hwGrades;
    public static int[] testGrades;
    public static int finalExam;
    public static int attendanceAverage;
    public static Scanner input = new Scanner(System.in);

    public static void run1331() throws FileNotFoundException {
        attendanceAverage = 100;


        int b = 0;
        while (b == 0) {
            System.out.println("*********************************************************");
            System.out.println("What would you like to do? ");
            System.out.println("(1) Change a grade");
            System.out.println("(2) See your current grades");
            System.out.println("(3) See your current averages");
            System.out.println("(4) Go back to list of courses");
            System.out.print("Enter answer: ");
            int change = input.nextInt();
            if (change == 1) {
                System.out.println("*********************************************************");
                System.out.println("Enter the number corresponding to the grade you would like to change: ");
                System.out.println("(1) HW Grade");
                System.out.println("(2) Test Grade");
                System.out.println("(3) Final Exam Grade");
                System.out.print("Enter answer: ");
                int entered = input.nextInt();
                if (entered == 1) {
                    changeHwGrade();
                } else if (entered == 2) {
                    changeTestGrade();
                } else if (entered == 3) {
                    finalExam = changeFinalExam();
                }
            } else if (change == 2) {
                printGrades();
            } else if (change == 3) {
                int hwAvg = hwAverage();
                int testAvg = testAverage();
                finalExam = getFinalExam();

                double overallAvg = (0.18 * (double) hwAvg) + (0.51 * (double) testAvg)
                    + (0.27 * (double) finalExam) + (0.04 * (double) attendanceAverage);

                System.out.println("*********************************************************");
                System.out.println("Your homework average is: \t\t\t" + hwAvg);
                System.out.println("Your test average is: \t\t\t\t" + testAvg);
                System.out.println("Your final exam grade is: \t\t\t" + finalExam);
                System.out.println("Your attendance average is: \t\t\t" + attendanceAverage);
                System.out.println("*********************************************************");
                System.out.println("Your overall course average: \t\t\t" + Math.round(overallAvg));
                System.out.println("*********************************************************");
                System.out.print("Back to menu? (Press any key): ");
                Scanner input = new Scanner(System.in);
                String ans = input.next();

            } else if (change == 4) {
                b = 1;
            }


            else {
                b = 1;
            }
        }
















    }

    public static void changeHwGrade() throws FileNotFoundException {
        System.out.println("*********************************************************");
        int a = 0;
        while (a == 0) {
            File file = new File("Grades.txt");
            Scanner scan = new Scanner(file);
            String firstLine = scan.nextLine();
            String secondLine = scan.nextLine();
            String thirdLine = scan.nextLine();

            System.out.print("Enter homework number (1 - 9): ");
            int ans1 = input.nextInt();

            Scanner trip = new Scanner(firstLine);

            String all = new String("");
            for (int i = 0; i < ans1 + 1; i++) {
                String hw = trip.next();
                if (i == 0) {
                    all = hw;
                } else {
                    all = all + " " + hw;
                }
            }

            String all2 = new String("");
            for (int i = ans1 + 1; i < 11; i++) {
                String hw1 = trip.next();
                if (i == ans1 + 1) {
                    int j = 0;
                } else if (i == ans1 + 2) {
                    all2 = hw1;
                } else {
                    all2 = all2 + " " + hw1;
                }

            }

            System.out.print("Enter the new homework grade: ");
            int ans2 = input.nextInt();

            String yes = all + " " + ans2 + " " + all2;
            PrintWriter outWriter = new PrintWriter(file);
            outWriter.println(yes);
            outWriter.println(secondLine);
            outWriter.println(thirdLine);

            outWriter.close();

            System.out.println("Homework " + ans1 + " is now " + ans2);
            System.out.println("*********************************************************");
            System.out.print("Would you like to change another homework average? (y/n): ");
            String response = input.next();
            if (response.equals("n")) {
                a = 1;
            }
        }
    }

    public static void changeTestGrade() throws FileNotFoundException {
        System.out.println("*********************************************************");
        int a = 0;
        while (a == 0) {
            File file = new File("Grades.txt");
            Scanner scan = new Scanner(file);
            String firstLine = scan.nextLine();
            String secondLine = scan.nextLine();
            String thirdLine = scan.nextLine();


            System.out.print("Enter the test number (1 - 3): ");
            int ans1 = input.nextInt();

            Scanner trip = new Scanner(secondLine);

            String all = new String("");
            for (int i = 0; i < ans1 + 1; i++) {
                String hw = trip.next();
                if (i == 0) {
                    all = hw;
                } else {
                    all = all + " " + hw;
                }
            }

            String all2 = new String("");
            for (int i = ans1 + 1; i < 5; i++) {
                String hw1 = trip.next();
                if (i == ans1 + 1) {
                    int j = 0;
                } else if (i == ans1 + 2) {
                    all2 = hw1;
                } else {
                    all2 = all2 + " " + hw1;
                }

            }

            System.out.print("Enter the test grade: ");
            int ans2 = input.nextInt();

            String yes = all + " " + ans2 + " " + all2;
            PrintWriter outWriter = new PrintWriter(file);
            outWriter.println(firstLine);
            outWriter.println(yes);
            outWriter.println(thirdLine);

            outWriter.close();

            System.out.println("Test " + ans1 + " is now " + ans2);
            System.out.println("*********************************************************");
            System.out.print("Would you like to change another test average? (y/n): ");
            String response = input.next();
            if (response.equals("n")) {
                a = 1;
            }
        }
    }

    public static int changeFinalExam() throws FileNotFoundException {
        System.out.println("*********************************************************");
        System.out.print("Enter the new final exam grade: ");
        int ans1 = input.nextInt();

        File file = new File("Grades.txt");
        Scanner scan = new Scanner(file);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();

        Scanner trip = new Scanner(thirdLine);

        String all = new String("");
        for (int i = 0; i < 2; i++) {
            String hw = trip.next();
            if (i == 0) {
                all = hw;
            } else {
                all = all + " " + hw;
            }
        }

        String yes = all + " " + ans1;

        PrintWriter outWriter = new PrintWriter(file);
        outWriter.println(firstLine);
        outWriter.println(secondLine);
        outWriter.println(yes);

        outWriter.close();



        System.out.println("The new final exam grade is: " + ans1);
        return ans1;
    }


    public static int hwAverage() throws FileNotFoundException {

        File file = new File("Grades.txt");
        Scanner scan = new Scanner(file);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();

        Scanner trip = new Scanner(firstLine);
        int num1 = 0;
        for (int i = 0; i < 11; i++) {
            String num = trip.next();
            if (i == 0 || i == 1) {
                int j = 0;
            } else {
                num1 = num1 + Integer.parseInt(num);
            }
        }


        num1 = num1 / 9;
        return num1;


    }

    public static int testAverage() throws FileNotFoundException {

        File file = new File("Grades.txt");
        Scanner scan = new Scanner(file);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();

        Scanner trip = new Scanner(secondLine);
        int num1 = 0;
        for (int i = 0; i < 5; i++) {
            String num = trip.next();
            if (i == 0 || i == 1) {
                int j = 0;
            } else {
                num1 = num1 + Integer.parseInt(num);
            }
        }


        num1 = num1 / 3;
        return num1;



    }

    public static int getFinalExam() throws FileNotFoundException {
        File file = new File("Grades.txt");
        Scanner scan = new Scanner(file);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();
        Scanner trip = new Scanner(thirdLine);
        int num1 = 0;
        for (int i = 0; i < 3; i++) {
            String num = trip.next();
            if (i == 0 || i == 1) {
                int j = 0;
            } else {
                num1 = Integer.parseInt(num);
            }
        }

        return num1;
    }

    public static void printGrades() throws FileNotFoundException {
        File file = new File("Grades.txt");
        Scanner scan = new Scanner(file);
        String firstLine = scan.nextLine();
        String secondLine = scan.nextLine();
        String thirdLine = scan.nextLine();
        System.out.println("*********************************************************");
        System.out.println(firstLine);
        System.out.println(secondLine);
        System.out.println(thirdLine);

        System.out.print("Back to menu? (Press any key): ");
        Scanner input = new Scanner(System.in);
        String ans = input.next();
    }


}