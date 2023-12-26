import java.util.Scanner;

public class Task2{

    private static int total = 0;
    private static double average;
    static char grade;

    public static void main(String[] args){

        String arr1[] = {"Maths","Stat","OOP","Programming","Fundamentals"};

        String outOfBoundStatus = "Please enter valid marks between 0 and 100";

        System.out.println("\n\nSTUDENT GRADE CALCULATOR\n...............................");
        System.out.println("PLEASE ENTER YOUR MARKS\n");

        Scanner reader = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            System.out.print("Enter marks for "+arr1[i]+" : ");

            double subjectMarks = reader.nextDouble();

            if(subjectMarks < 0 || subjectMarks > 100){
                System.out.println(outOfBoundStatus);
                i--;
            }else{
                total += subjectMarks;
            }
        }
        average = total / 5;
        if(average >= 75 ){
            grade = 'A';
        }else if(average >= 65){
            grade = 'B';
        }else if(average >= 55){
            grade = 'C';
        }else if(average >= 35){
            grade = 'S';
        }else{
            grade = 'F';
        }
        System.out.println("\nTotal Marks: "+total+"\nAverage Percentage: "+average+"%\nGrade: "+grade+"\n");
    }
}
