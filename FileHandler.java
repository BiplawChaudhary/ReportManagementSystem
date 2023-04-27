package ReportManagementSystem;

//-------IMPORTS----
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.plaf.FileChooserUI;

public class FileHandler {
    //Function to write in file
    public void writeInFile(String marksheet){
        // System.out.println("\t\t---------Calling Result ----"); //Debug
        // Handing the Exception
        try{
            // Creating the handler with appending option enabled
            FileWriter fReader = new FileWriter("marks.txt", true);
            //writing to the file
            fReader.write(marksheet);
            //Closing the file file handler
            fReader.close();
        }
        catch(IOException err){
            System.out.println("ERROR while Writing!! "+ err);
        }
        // return;
    }

    public String readFileData(){
        //Creating a string builder to build a string from read character.
        StringBuilder stringBuilder = new StringBuilder();

        //Creating a string to store the build string as String
        String fileContents = "";


        //Creating a file handler
        try{
            FileReader reader = new FileReader("marks.txt");
            //Initalizing the character to store read ASCII from file
            int character;

            // Till we reach End of FIle
            while ((character = reader.read()) != -1) {
                // Appending read characters to Stringbuilder which builds string from read character
                stringBuilder.append((char) character);
            }


            // COnverting the contents of String Builder to String DataType
            fileContents += stringBuilder.toString();

        // System.out.println(fileContents);
            reader.close();
        }
        catch(IOException err){
            System.out.println("ERROR! " + err);
        }
        // Returning the fileCOntents as String to the caller
        return fileContents;
    }
}
