https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder

/*******************************************************
 * CS4551 Multimedia Software Systems
 * Spring 2020 Homework #3 Framework
 *******************************************************/

import java.util.Scanner;

public class CS4551_Main {
    public static final String videoFrameName = "../VideoFrames/Walk_%03d.ppm";

    public static void main(String[] args) {

        // the program does not expect command line argument
        // if there is any command line argument, exit the program
        if (args.length != 0) {
            usage();
            System.exit(1);
        }

        // define main variables
        boolean done = false;
        Scanner in = new Scanner(System.in);

        // main menu
        while (!done) {
            int choice = menu(in);
            switch (choice) {
            case 1:
                conductBlockMotionCompensation(videoFrameName, in);
                break;
            case 2:
                conductFastMotionCompensation(videoFrameName, in);
                break;
            case 3:
                done = true;
                break;
            default:
                System.out.println("Invalid command!");

            }
        }
    }

    public static void usage() {
        System.out.println("\nUsage: java CS4551_Zhao\n");
    }

    public static int menu(Scanner in) {
        int choice = 0;
        // TOFIX - add main menu display
        try {
            choice = in.nextInt();
            // myInput.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return choice;
    }

    public static int conductBlockMotionCompensation(String vidName, Scanner in) {
        // TOFIX - add parameter input from user
        int n = 8;
        int p = 8;
        int fast = 0;
        int sub = 0;
        int start = 50;
        int count = 10;
        MotionCompensation coder = new MotionCompensation();
        for (int curNo = start; curNo < start + count; curNo++) {
            String refName = String.format(vidName, curNo - 1);
            String tarName = String.format(vidName, curNo);
            String mvName = String.format("mv_%03d.txt", curNo);
            String resName = String.format("res_%03d.ppm", curNo);
            coder.process(refName, tarName, mvName, resName, n, p, fast, sub);
        }
        return 0;
    }

    public static int conductFastMotionCompensation(String vidName, Scanner in) {
        // TOFIX - add parameter input from user
        int n = 8;
        int p = 8;
        int fast = 1;
        int sub = 0;
        int start = 50;
        int count = 10;
        MotionCompensation coder = new MotionCompensation();
        for (int curNo = start; curNo < start + count; curNo++) {
            String refName = String.format(vidName, curNo - 1);
            String tarName = String.format(vidName, curNo);
            String mvName = String.format("mv_%03d.txt", curNo);
            String resName = String.format("res_%03d.ppm", curNo);
            coder.process(refName, tarName, mvName, resName, n, p, fast, sub);
        }
        return 0;
    }
}
