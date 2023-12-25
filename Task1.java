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

        //set correct status
        boolean guessedCorrectlyStatus = false;

        //set number of attempts
        int numberOfAttempts = 0;

        //set next random value
        RandomResult = randValue.nextInt(maxValue)+1;

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
            System.out.println("Congratulations!..The correct number was "+RandomResult);
        }
        else{
            System.out.println("Sorry!..You ran out of guesses. The correct number was "+RandomResult);
        }
        System.exit(0);
    }
}
