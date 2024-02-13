//author: Sara Russert
//date: 12 February 2024
//file: SpringData.java

// import statements for scanner class and file IO
import java.util.Scanner;
import java.io.*;

public class SpringData {
   public static void main (String[] args) throws IOException {
      
      // constant for the acceleration due to gravity on earth
      final double GRAV_EARTH = 9.81;
      
      // vor to contain the force calculation
      double force = 0;
      
      // variables for names of both files
      String inFileName = "springData.csv";
      String outFileName = "forceData.csv";
      
      // variable to contain the substring array from one line of the file
      String[] oneLine = new String[2];
      
      // open the file to read
      File dataFile = new File(inFileName);
      Scanner inFile = new Scanner(dataFile);
      
      // open the file to write
      PrintWriter outFile = new PrintWriter(outFileName);
      
      // keep track of line num
      int counter = 0;
      
      // loop to read lines from the file
      while (inFile.hasNext()) {
      
         // read the next line from the file
         String dataLine = inFile.nextLine();
         
         // split the line into an array on the comma
         oneLine = dataLine.split(",");
         
         // print the line read
         System.out.println(dataLine);
         
         // skip the first line since it is the header
         if (counter == 0) 
            outFile.println(dataLine + ",Force (Newtions)");
         else {
            // calculate force
            force = Double.parseDouble(oneLine[1]) * GRAV_EARTH;
            
            // print the force rounded to four decimal places
            System.out.print("When the mass is " + oneLine[1] + ", ");
            System.out.printf("the force == %.4f\n", force);
            
            // write the current line, plus the force to the outfile
            outFile.println(dataLine + "," + force);
            
         }
         // increment the counter so the header and body are handled correctly
         counter++;
      }
      
      // close the files
      inFile.close();
      outFile.close();
   
   }
}