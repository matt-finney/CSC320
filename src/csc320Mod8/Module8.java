package csc320Mod8;

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
        System.out.println("Step 1:");
        System.out.println(car1.displayVehicleInfo());
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
      System.out.printf("\nStep 3:\n%s\n\n", car2.removeVehicle());

      // show that the fields have been cleared
      String[] clearedInfo = car2.listVehicleInformation();
      for (String line : clearedInfo)
      {
        System.out.println(line);
      }
      System.out.println();

      // Step 4: Add a new Vehicle
      System.out.printf("\nStep 4:\n%s\n\n", car2.addVehicle("Honda", "Civic", "Black", 2024, 0));
      System.out.println(car2.displayVehicleInfo());

      // Step 5: Update the Vehicle
      System.out.printf("\nStep 5:\n%s\n\n", car2.updateVehicle(null, null, "White", -1, 15000));
      System.out.println(car2.displayVehicleInfo());

      // Step 6: Ask to save to file (Y/N)
      Scanner input = new Scanner(System.in);
      String response = getReponse(input, "Would you like to print the information to a file? (Y/N): ");
      
      
    }

    // Method to keep asking until the user enters 'y', 'n'
    public static String getReponse(Scanner scanner, String prompt)
    {
      while (true) 
      {
        System.out.print(prompt);
        String input = scanner.nextLine();

        try 
        {
          if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))
          {
            return input;
          }
        } 
        catch (NumberFormatException e) 
        {
          System.out.println("Invalid input. Please enter y or n");
        }
      }
    }
}
