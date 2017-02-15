package com.company;

/**
 * Created by Alex's PC on 1/25/2017.
 */
public class DateConverter {
    private int month;
    private int day;
    private int year;

    public DateConverter(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String monthToText(){

        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default:
                return "Invalid Month: ";
        }
    }

    public String  dayToText(){

        return number2words2(day);
    }

    public String yearToText(){
        int century = year / 100;
        int secondPart = year % 100;

        String centuryText = number2words(century);
        String secondPartText = number2words(secondPart);

        if (secondPart < 10){
            return centuryText + " zero " + secondPartText;
        }else {
            return centuryText + " " + secondPartText;
        }
    }

    private String number2words( int number ) {
        // convert to text a number 0 through 99


        if (number < 20) {
            // 0, 1, 2, 3, ..., 19
            return zero2nineteen[number];

        } else if (number % 10 == 0) {
            // 20, 30, 40, ... 90
            return decades[number / 10 - 2];
        } else {
            // 21, 22, 23, 24, ... 29, 31, 32, ..., 99
            return decades[number / 10 - 2] + " " + zero2nineteen[number % 10];
        }

    } //number2words

    private String number2words2( int number ) {
        // convert to text a number 0 through 99

        if ( number < 20 ) {
            // 0, 1, 2, 3, ..., 19
            return forDays[ number ];

        } else if ( number % 10 == 0 ) {
            // 20, 30, 40, ... 90
            return decades[ number / 10 - 2 ];
        } else {
            // 21, 22, 23, 24, ... 29, 31, 32, ..., 99
            return decades[ number / 10 - 2 ] + " " + forDays[ number % 10 ];
        }
    } //number2words2


    private static final String[] zero2nineteen = {
            "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] forDays = {
            " ","first","second","third","fourth","fifth", "sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth","fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth"
    };

    private static final String[] decades = {
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
            "eighty", "ninety"
    };

    //Arrays set up for months with 31 day and months with 30 days
    private static int[] monthsWith31Day = {1,3,5,7,8,10,12};
    private static int[] monthWith30Days = {4,6,9,11};

    //checks to see if the month is in a array
    private static int checkMonth(int[] arr, int month){

        for (int i =0; i<arr.length;i++){
            if (arr[i] == month){
                return 1;
            }
        }
        return 0;
    }

    //checks the value of the day and compares it with the month to see if there are that many days in that month
    public int checkDay(){
        if(checkMonth(monthsWith31Day,month ) == 1){
            if (day > 31){
                return 1;
            }
        }
        else if (checkMonth(monthWith30Days,month) == 1){
            if (day > 30){
                return 2;
            }
        }
        else if (checkMonth(monthsWith31Day,month) != 1){
            return 3;
        }
        return 0;
    }

    //prints out an error message if the day exceeds the month if not it with print the date to words
    public void printDate(){

        if (checkDay() == 1){
            System.out.println("There are only 31 days in " + monthToText() + " please try again: ");
        }
        else if (checkDay() == 2){
            System.out.println ("There are only 30 days in " + monthToText() + " please try again: ");
        }
        else if (checkDay() == 3){
            System.out.println("There are only 28 days in " + monthToText() + " please try again: ");
        }
        else
            System.out.println(monthToText()+ " " + dayToText() + ", " + yearToText());
    }


}
