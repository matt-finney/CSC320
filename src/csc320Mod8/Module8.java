package csc320Mod8;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Scanner;

public class Module8 
{
    public static void main(String[] args) 
    {
      // Step 1: Default Constructor
      try 
      {
        // call default constructor
        Automobile car1 = new Automobile();
        System.out.printf("Step 1: %n%s%n%n", car1.displayVehicleInfo());
      } catch (Exception e) 
      {
        System.out.println("An error occurred: " + e.getMessage());
      }
      
      // Step 2: Parametereized Constructor
      Automobile car2 = new Automobile("Toyota", "Camry", "Blue", 2020, 15000);
      // list info and loop through array
      String[] info = car2.listVehicleInformation();
      System.out.println("Step 2:");
      for (String line : info) 
      {
        System.out.println(line);
      }

      // Step 3: Remove Vehicle
      // returns success or failure message
      System.out.printf("%nStep 3:%n%s%n%n", car2.removeVehicle());

      // show that the fields have been cleared
      String[] clearedInfo = car2.listVehicleInformation();
      for (String line : clearedInfo)
      {
        System.out.println(line);
      }
      System.out.println();

      // Step 4: Add a new Vehicle
      System.out.printf("%nStep 4:%n%s%n%n", car2.addVehicle("Honda", "Civic", "Black", 2024, 0));
      System.out.println(car2.displayVehicleInfo());

      // Step 5: Update the Vehicle
      System.out.printf("%nStep 5:%n%s%n%n", car2.updateVehicle(null, null, "White", -1, 15000));
      System.out.println(car2.displayVehicleInfo());

      // Step 6: Ask to save to file (Y/N)
      Scanner input = new Scanner(System.in);
      // ask the user
      String response = getReponse(input, "Would you like to print the information to a file? (Y/N): ");
      String file_path = "C:\\Temp\\Autos.txt";
      // decide to write to file
      if (response.equalsIgnoreCase("y"))
      {
        System.out.print(writeToFile(file_path, car2));
      }
      else
      {
        System.out.println("No file will be created.");
      }

      // close scanner resource
      input.close();
    }
    
    // Helper method to write to file
    public static String writeToFile(String file_path, Automobile car)
    {
      try
      {
        Path parent = java.nio.file.Paths.get(file_path).getParent();
        // make sure parent directory exists before writing
        java.nio.file.Files.createDirectories(parent);
      
        // overwrite mode
        try (PrintWriter writer = new PrintWriter(new FileWriter(file_path, false)))
        {
          // write the car's information to the file
          writer.print(car.displayVehicleInfo());

          return "Vehicle information written to " + file_path + " successfully.\n";
        }
      }
      catch (Exception e)
      {
        return "Failed to write file: " + e.getMessage();
      }
    }

    // Helper mhod to keep asking until the user enters 'y', 'n'
    public static String getReponse(Scanner scanner, String prompt)
    {
      while (true) 
      {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        try 
        {
          if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))
          {
            return input;
          }
          else
          {
            throw new IllegalArgumentException("Invalid input");
          }
        } 
        catch (IllegalArgumentException e) 
        {
          System.out.println("Invalid input. Please enter y or n");
        }
      }
    }
}
