package com.company;

import java.util.Scanner;

public class OOValidator {
    public  Scanner sc;

    public OOValidator(Scanner sc){
        this.sc = new Scanner(System.in);
    }

    public int getInt( String prompt ){
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public int getIntWithinRange( String prompt, int min, int max ){
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(prompt);
            if (i < min)
                System.out.println(
                        "Error! Number must be greater " + i + ".");
            else if (i > max)
                System.out.println(
                        "Error! Number must be less than  " + i + ".");
            else
                isValid = true;
        }
        return i;
    }

    public double getDouble( String prompt ){
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public double getDoubleWithinRange( String prompt, double min, double max ){
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(prompt);
            if (d < min)
                System.out.println(
                        "Error! Number must be greater than " + d + ".");
            else if (d > max)
                System.out.println(
                        "Error! Number must be less than " + d + ".");
            else
                isValid = true;
        }
        return d;
    }


}
