

package com.company;

import java.util.Scanner;

public class CustomizedValidator extends OOValidator{


    public CustomizedValidator(Scanner sc) {
        super(sc);
    }

    public String getRequiredString(String prompt){

        String s = null;
        do
        {
            System.out.print(prompt);
            s = sc.nextLine();  // read user entry
            if (s.equals(""))
            {
                System.out.println("String cannot be left blank, retry!");
            }
            else if (s.matches(".*\\d.*"))//Checks to see if there is a number within the string
            {
                System.out.println("Invalid, your name cannot have a number!");
            }
        } while (s.equals("") || s.matches(".*\\d.*"));

        return s;
    }



    public String getChoiceString( String prompt, String choiceOne, String choiceTwo ){
        String s = "";
        boolean isChoice = false;

        while(isChoice == false){
            System.out.print(prompt);
            s = sc.nextLine();

            if ((s.equals(choiceOne)) || (s.equals(choiceTwo))){
                isChoice = true;
            }else if (s.equals("")){
                System.out.println("Cant leave the field blank.");
            } else {
                System.out.println("Your choice has to be " + "'" + choiceOne + "'" + " or " + "'" + choiceTwo + "'");
            }

        }

        return s;
    }


}
