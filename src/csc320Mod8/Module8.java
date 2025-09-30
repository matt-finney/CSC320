package csc320Mod8;

public class Module8 
{
    public static void main(String[] args) 
    {
        try 
        {
          Automobile car1 = new Automobile();
          System.out.println(car1.displayVehicleInfo());
        } catch (Exception e) 
        {
          System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
