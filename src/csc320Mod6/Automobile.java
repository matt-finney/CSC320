package csc320Mod6;

public class Automobile 
{
    // instance variables
    private String make;
    private String model;
    private String color;
    private int year;
    private boolean is_running;

    // default constructor
    public Automobile(String make, String model, String color, int year)
    {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.is_running = false;
    }

    // method to remove vehicle by resetting attributes
    public String removeVehicle(String make, String model, String color, int year)
    {
        // check if the vehicle matches the given attributes
        if (matches(make, model, color, year))
        {
            // reset all attributes to default values
            this.make = null;
            this.model = null;
            this.color = null;
            this.year = 0;
            this.is_running = false;

            return "Vehicle removed successfully.";
        }
        else
        {
            return "Vehicle not found.";
        }
    }

    // method to display vehicle information
    public String displayVehicleInfo()
    {
        // check if vehicle information is available
        if (make == null && model == null && color == null && year == 0)
        {
            return "No vehicle information available.";
        }
        return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Running: " + is_running;
    }

    // method to start the vehicle
    public void startEngine()
    {
        if (!is_running)
        {
            is_running = true;
            System.out.println("Vehicle started.");
        }
        else
        {
            System.out.println("Vehicle is already running.");
        }
    }

    // method to stop the vehicle
    public void stopEngine()
    {
        if (is_running)
        {
            is_running = false;
            System.out.println("Vehicle stopped.");
        }
        else
        {
            System.out.println("Vehicle is already stopped.");
        }
    }

    // helper method to check if vehicle matches given attributes
    private boolean matches(String make, String model, String color, int year)
    {
        return safeEquals(this.make, make) &&
               safeEquals(this.model, model) &&
               safeEquals(this.color, color) &&
               this.year == year;
    }

    // helper method to safely compare strings, handling nulls
    private boolean safeEquals(String a, String b)
    {
        if (a == null && b == null) return true; // both null
        if (a == null || b == null) return false; // one is null
        return a.equals(b); // both non-null
    }

    // getters
    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public int getYear()
    {
        return year;
    }

    public boolean getRunState()
    {
        return is_running;
    }
    
    // setters
    public void setMake(String new_make)
    {
        this.make = new_make;
    }

    public void setModel(String new_model)
    {
        this.model = new_model;
    }
    
    public void setColor(String new_color)
    {
        this.color = new_color;
    }
    
    public void setYear(int new_year)
    {
        this.year = new_year;
    }

    public void setRunState(boolean new_is_running)
    {
        this.is_running = new_is_running;
    }
}
