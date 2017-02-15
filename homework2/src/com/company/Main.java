/*
* Name: Alex Kozlowski
* Assignment: a2
* Assignment Name: Input validator class hierarchy
* Due Date: February 16, 2017
*
* This program validates integer, double and string values, it will return errors if the user input does not correspond
* to the required information needed.
*
*/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        System.out.println("Welcome to the Validation Tester Application!\n");

        while (choice.equals("y")) {

            CustomizedValidator customizedValidator = new CustomizedValidator(sc);

            System.out.println("Integer Value Test: ");
            int intValue = customizedValidator.getIntWithinRange("Enter a integer within range of -100 and 100: ", -100, 100);

            System.out.println("\nDouble Value Test: ");
            double doubleValue = customizedValidator.getDoubleWithinRange("Enter any number between -100 and 100: ", -100, 100);

            System.out.println("\nRequired String Test: ");
            String name = customizedValidator.getRequiredString("Enter your name: ");

            System.out.println("\nString Choice Test: ");
            String stringChoice = customizedValidator.getChoiceString("Please select one (y/n): ", "y", "n");

            choice = customizedValidator.getChoiceString("\nWould yon like to try again? (y/n): ", "y", "n");

        }

    }
}
