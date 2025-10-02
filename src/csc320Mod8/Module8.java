package csc320Mod8;

public class Module8 
{
    public static void main(String[] args) 
    {
      // Step 1: Default Constructor
      try 
      {
        // call default constructor
        Automobile car1 = new Automobile();
        System.out.println(car1.displayVehicleInfo());
      } catch (Exception e) 
      {
        System.out.println("An error occurred: " + e.getMessage());
      }
      
      // Step 2: Parametereized Constructor
      Automobile car2 = new Automobile("Toyota", "Camry", "Blue", 2020, 15000);
      // list info and loop through array
      String[] info = car2.listVehicleInformation();
      for (String line : info) 
      {
          System.out.println(line);
      }

      // Step 3: Remove Vehicle
      // returns success or failure message
      System.out.printf("\n%s\n\n", car2.removeVehicle());
      
      // show that the fields have been cleared
      String[] clearedInfo = car2.listVehicleInformation();
      for (String line : clearedInfo)
      {
        System.out.println(line);
      }
    }
}
