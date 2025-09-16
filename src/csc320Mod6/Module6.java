package csc320Mod6;

public class Module6 {
    public static void main(String[] args) {
        // Create an Automobile object
        Automobile myCar = new Automobile("Toyota", "Camry", "Blue", 2020);

        // Display vehicle information 
        System.out.println(myCar.displayVehicleInfo());

        // Start the engine 
        myCar.startEngine();

        // Attempt to remove the vehicle with wrong attributes 
        String result = myCar.removeVehicle("Toyota", "Camry", "Red", 2020);
        System.out.println(result);

        // Attempt to remove the vehicle with correct attributes 
        result = myCar.removeVehicle("Toyota", "Camry", "Blue", 2020);
        System.out.println(result);

        // Display vehicle information after removal (should indicate no info))
        System.out.println(myCar.displayVehicleInfo());

        // Attempt to remove the vehicle again (should not be found)
        result = myCar.removeVehicle("Toyota", "Camry", "Blue", 2020);
        System.out.println(result);
    }
}