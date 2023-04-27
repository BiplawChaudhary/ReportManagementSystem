package ReportManagementSystem;

//---------IMPORTS--------
import java.util.Scanner;


public class MainMethod{
    //-------------Functions--------------------------
    //Function to add student's marks
    public static void addStudentMarks(){
        //Creaing the scanner object to read system input
        Scanner scan = new Scanner(System.in);

        System.out.println("\t-----Add Students Marks----\n");

        //Reading the number of student to be added
        System.out.printf("Enter the number of students to add: ");
        int num = scan.nextInt();

        //Array to store the result of each student
        String [] calMarksheet = new String[num];

        //Creating an object  of Student Class
        Subjects sub = new Subjects();
        //Creating an object of fileHandler Class
        FileHandler fHand = new FileHandler();

        //Reading and storing marks for each subject
        for(int i=0;i<num;i++){
            //Reading the marks for each student
            sub.readData();
            //Calcaulating and Formatting the output
            sub.formatStringData();
            //Storing the output in array
            String result = sub.getOutString();
            calMarksheet[i] = result;

            //Resetting the output String
            sub.resetFormatString();
            //Writing the returned string to the file
            fHand.writeInFile(result);
        }

        //Displaying the result
        for(int i=0;i<num;i++){
            System.out.println(calMarksheet[i] + "\n\n");
        }

        // //Closing the scanner
        // scan.close();


    }

    //Function to show student's Marksheet
    public static void showStudentsMarks(){
        System.out.println("\t-----Show Students Data-----");

        //Creating an object of the file handler
        FileHandler fHand = new FileHandler();

        //----------Reading from user the roll no. to search for
        //Creating the scanner object
        Scanner scan = new Scanner(System.in);

        //Reading the roll no to be search 
        System.out.printf("\nEnter the roll number to be searched for: ");
        String roll = scan.next();

        //Searching for the given data and then storing the result
        String result = fHand.readFileData();

        //Splitting marksheeet of each student using @ symbol which is used in txt file as a split character.
        String [] resultEach = result.split("@");

        //Varibale to store if search result found for not
        boolean found = false;
        //IF the result is found then it will be stored in the varaible below
        String foundResult = "";

        //Iterating each value in the text
        for(String each: resultEach){
            //Checking to see if the roll number is in the text file
            if(each.contains(roll)){
                //If found then set to true
                found = true;
                // Then append the result to the variable
                foundResult += each;
            }
        }

        // If the student is found
        if(found){
            System.out.println(foundResult);
        }
        //If not found
        else{
            System.out.println("NOT FOUND");
        }

        // if(result != " "){
        //     System.out.println(result);
        // }
        // else{
        //     System.out.println("STUDENT NOT FOUND");
        // }

        return;

        
    }
    //--------------------------------------------------

    // -------------------------The main method---------
    public static void main(String[] args) {
         // printing the message
         System.out.println("\t\t------RESULT MANAGEMENT SYSTEM-------");
         System.out.println("Faculty: BSc. CSIT 2nd Semester\n");
        
         
        //Creaing the scanner object to read system input
        Scanner scan = new Scanner(System.in);

         //Asking the user what to do
         boolean run = true; //Setting the continuous run variable
        //  Continuously run below code till the user chooses to exit
         while(run){
            // Displaying the user menu
            System.out.println("-----MENU------");
            System.out.println("1. Add Student's Marks");
            System.out.println("2. Show Students Marksheet");
            System.out.println("3. Exit");

            // Reading the user's choice of task
            System.out.printf("Enter your choice: ");
            int choice = scan.nextInt();

            // Performing task based on user input
            switch (choice) {
                //If user selects to add student then this case is triggered
                case 1:
                    addStudentMarks();
                    break;
                
                //If user asks to show the students marksheet this case is triggered
                case 2:
                    showStudentsMarks();
                    break;

                // If chooses to exit
                case 3:
                    run = false;
                    break;

                default:
                    System.out.println("ERROR!!! Please Select the correct Option.");
                    break;
            }

            // //Closing the scanner
            // scan.close();

         }//End of while loop

    
    }//End of Main method   

}//End of class scope
