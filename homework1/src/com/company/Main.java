

package com.company;
/*
* Name: Alex Kozlowski
* Assignment: a1
* Assignment Name: Date to words conversion
* Due Date: February 2, 2017
*
* This program will take in a date in number format and convert it into an equivalent word form.
*
*/
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Date Converter!");
        System.out.println("(To quit type quit)\n");

        for (;;){
            String date = Validator.getString(Validator.sc, "Enter the date in format mm/dd/yyyy: ");

            if (date.equalsIgnoreCase("quit")){
                System.out.println("\nThanks for using the Date to text converter!");
                break;
            }
            String dateParts[] = date.split("/");

            int mouth ;
            int day ;
            int year ;

            if (dateParts.length !=3){
                System.out.println("Invalid format, please try again: ");
                continue;
            }
            try {
                mouth = Integer.parseInt(dateParts[0]);
                day = Integer.parseInt(dateParts[1]);
                year = Integer.parseInt(dateParts[2]);


            }catch (NumberFormatException ex){
                System.out.println("Bad input, try again: ");
                continue;
            }

            DateConverter converter = new DateConverter(mouth,day,year);

            converter.printDate();

        }
    }
}
