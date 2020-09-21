package com.github.abigailfails.rockpaperscissors;

public class RockPaperScissors {

    private static boolean didUserWin(String userInput, String computerInput){
        if(input == "ROCK"){
            if
        }
        return false;
    }

    public static void takeUserInput(){
        int inputtedYear;
        boolean isLeap;
        System.out.print("Year: ");
        try {
            Scanner input = new Scanner(System.in);
            inputtedYear = input.nextInt();
            if(inputtedYear != -1) {
                isLeap = isLeapYear(inputtedYear);
                System.out.println(isLeap ? "That is a leap year." : "That is not a leap year." + " Please enter another year to check, or type -1 to exit.");
                takeUserInput();
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a number.");
            takeUserInput();
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Let's play rock, paper, scissors! Type either \"rock\",\"paper\" or \"scissors\"!");
        takeUserInput();
    }

}
