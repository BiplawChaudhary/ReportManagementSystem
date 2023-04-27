package ReportManagementSystem;
//----------IMPORTS-----------
import java.util.Scanner;


public class Subjects {
     //Variables to Store marks
     private double oop, ds, math, stat, mp;
     //Varibale to store name
     private String name;
     //Varibale to store roll Number
     private int rollNo;
     //Variable formatted to store in text file
     String outString = "";

     ////--------------------FUNCTIONS-----------------------------------
     ///Function to foramt the given string data
     public void formatStringData(){
        //Adding it to output string
        outString += "#------------------------------------------\n";
        outString += "Name: " + this.name+ "\n";
        outString += "Roll No: " + Integer.toString(rollNo) +"\n";
        outString += "Faculty: BSc. CSIT 2nd Semester" + "\n";
        outString += "\t-------------Marksheet------\n";
        outString += "S.N.\t\tSubject\t\tFull Marks\t\tMarks Obt.\n";
        outString += "1.\t\tOOP\t\t100\t\t" + Double.toString(oop) + "\n";
        outString += "2.\t\tDS\t\t100\t\t" + Double.toString(ds) + "\n";
        outString += "3.\t\tMath\t\t100\t\t" + Double.toString(math) + "\n";
        outString += "4.\t\tStat\t\t100\t\t" + Double.toString(stat) + "\n";
        outString += "5.\t\tMP\t\t100\t\t" + Double.toString(mp) + "\n\n";
        outString += "  \t\tTotal\t\t500\t\t"+Double.toString(calculateTotal()) +"\n";

        outString += "Division: " + calculateDivision() + "\n";
        outString += "Percentage: " + Double.toString(calcualtePercent())+ "\n";
        outString += "#------------------------------------------ @\n";
     }

     


    //Creaing the scanner object to read system input
    Scanner scan = new Scanner(System.in);


     //Function to read Data
    public void readData(){
        System.out.println("\n\nEnter Student's Data.");

        // Reading Roll No.
        System.out.printf("Enter Roll No.: ");
        this.rollNo = scan.nextInt();

        // /Reading Name
        System.out.printf("Enter the name: ");
        this.name = scan.next();

        //---------Reading Marks----
        //For OOP
        System.out.printf("\nEnter the marks in Object Oriented Programming: ");
        this.oop = scan.nextDouble();
       
        // For DS
        System.out.printf("\nEnter the marks in Discrete Structure: ");
        this.ds = scan.nextDouble();
      
        // For Stat
        System.out.printf("\nEnter the marks in Stat-I: ");
        this.stat = scan.nextDouble();
      
        // For maths
        System.out.printf("\nEnter the marks in Mathematics-II: ");
        this.math = scan.nextDouble();

        // For Mp
        System.out.printf("\nEnter the marks in Mircoprocessor: ");
        this.mp = scan.nextDouble();
 
    }//End

    //Function to calculate total
    public double calculateTotal(){
        double sum = math + mp + stat + oop + ds;
        return sum;
    }

    //Function to calcualte the percent 
    public double calcualtePercent(){
        double percent = (calculateTotal()/500) *100;
        return percent;
    }


    //Function that returns division of the students
    public String calculateDivision(){
        double percent = calcualtePercent();
        String division;

        if(percent>80.0){
            division = "Distinction";
        }
        else if(percent>60.0 && percent <= 80.0){
            division = "First Division";
        }
        else if(percent>40.0 && percent <= 60.0){
            division = "Second Division";
        }
        else if(percent>20.0 && percent <= 40.0){
            division = "Third Division";
        }
        else{
            division = "Failed";
        }
        return division;
    }

    //Function to get the string to be stored in file
    public String getOutString(){
        return outString;
    }

    public void resetFormatString(){
        outString = "";
        
    }

}//End of class scope
