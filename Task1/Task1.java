import java.util.Random;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args){

        //declaring variables
        int userGuess, RandomResult;

        //set maximum value as 50
        final int maxValue = 50;

        //takes input value using Scanner class
        Scanner reader = new Scanner(System.in);

        //random instance
        Random randValue = new Random();

        System.out.println("\n\nWelcome to the Number Game..\n.................................");
        System.out.println("\nGame Rules:-..There are only 2 Game Rounds,.and a round consists of 3 attempts..\n");

        //set number of rounds as 2
        for(int numberOfRounds=1; numberOfRounds<3; numberOfRounds++){
        
            //set next random value
            RandomResult = randValue.nextInt(maxValue)+1;

             //set correct status
            boolean guessedCorrectlyStatus = false;
            
            //set number of attempts
            int numberOfAttempts = 0;
            
            //loop until the guessed value is correct
            while(!guessedCorrectlyStatus && numberOfAttempts < 3){
                System.out.print("Guess a number between 1 and 50: ");

                //guess a value by user
                userGuess = reader.nextInt();

                //if the guessed value is greater than random result
                if(userGuess > RandomResult){
                    System.out.println("Your guess is Too High,.Try again..");

                //if the guessed value is less than random result
                }else if(userGuess < RandomResult){
                    System.out.println("Your guess is Too Low, Try again..");

                //if the guessed value is equal to random result    
                }else{
                    System.out.println("Yes, you guessed the number..");
                    guessedCorrectlyStatus = true;
                }
                //increment number of attempts by 1
                numberOfAttempts++;
            }        
        
            if(guessedCorrectlyStatus){
                System.out.println("Congratulations!..The correct number was "+RandomResult+"\n");
            }
            else{
                System.out.println("Sorry!..You ran out of guesses. The correct number was "+RandomResult+"\n");
                System.out.print("Round No: "+numberOfRounds+" is Over..\n");
            }
        }
    }
}
