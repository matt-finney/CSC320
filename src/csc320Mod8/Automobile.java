package csc320Mod8;

public class Automobile 
{
    // instance variables
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // default constructor
    public Automobile()
    {
        try 
        {
            this.make = null;
            this.model = null;
            this.color = null;
            this.year = 0;
            this.mileage = 0; // default mileage to 0
        } catch (Exception e) 
        {
            System.out.println("Error in default constructor: " + e.getMessage());
        }
    }

    // parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage)
    {
        try
        {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
        } catch (Exception e)
        {
            System.out.println("Error in parameterized constructor: " + e.getMessage());
        }
    }

    // add a new vehicle (overrites existing vehicle)
    public String addVehicle(String make, String model, String color, int year, int mileage)
    {
        // try catch block to handle if vehicle already exists
        try
        {
            if (matches(make, model, color, year))
            {
                // update existing vehicle attributes
                this.mileage = mileage;
                return "Vehicle updated successfully.";
            }
            else
            {
                // create new vehicle
                this.make = make;
                this.model = model;
                this.color = color;
                this.year = year;
                this.mileage = mileage;
                return "New vehicle added successfully.";
            }
        } catch (Exception e)
        {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // method to remove vehicle by resetting attributes
    public String removeVehicle(String make, String model, String color, int year)
    {
        // try catch block to handle if vehicle not found
        try 
        {
            // check if the vehicle matches the given attributes
            if (matches(make, model, color, year))
            {
                // reset all attributes to default values
                this.make = null;
                this.model = null;
                this.color = null;
                this.year = 0;
                this.mileage = 0;
                return "Vehicle removed successfully.";
            }
            else
            {
                return "Vehicle not found.";
            }
        } catch (Exception e) 
        {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // update some/all vehicle attributes
    public String updateVehicle(String make, String model, String color, int year, int new_mileage)
    {
        try 
        {
            if (make!= null) this.make = make;
            if (model!= null) this.model = model;
            if (color!= null) this.color = color;
            if (year != 0) this.year = year;
            if (new_mileage != 0) this.mileage = new_mileage;
            return "Vehicle updated successfully.";
        } catch (Exception e) 
        {
            return "Failed to update vehicle: " + e.getMessage();
        }
    }

    // method to display vehicle information
    public String displayVehicleInfo()
    {
        // try block to handle if vehicle info is not available
        try 
        {
            // check if vehicle information is available
            if (make == null && model == null && color == null && year == 0)
            {
                return "No vehicle information available.";
            }
        } catch (Exception e) 
        {
            return "Failed to display vehicle information: " + e.getMessage();
        }
        return "Make: " + make + ", Model: " + model + ", Color: " + color + ", Year: " + year + ", Mileage: " + mileage;
    }

    // helper method to check if vehicle matches given attributes
    private boolean matches(String make, String model, String color, int year)
    {
        try 
        {
            if (make == null || model == null || color == null) 
            {
                throw new IllegalArgumentException("Make, model, and color cannot be null.");
            }
        } catch (IllegalArgumentException e) 
        {
            return false; // if any attribute is null, it is considered not a match
        }
        return safeEquals(this.make, make) &&
               safeEquals(this.model, model) &&
               safeEquals(this.color, color) &&
               this.year == year;
    }

    // helper method to safely compare strings, handling nulls
    private boolean safeEquals(String a, String b)
    {
        try 
        {
            if (a == null && b == null) return true; // both null
            if (a == null || b == null) return false; // one is null
            return a.equals(b); // both non-null
        } catch (Exception e) 
        {
            return false; // in case of any exception, consider not equal
        }
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

    public int getMileage()
    {
        return mileage;
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

    public void setMileage(int new_mileage)
    {
        this.mileage = new_mileage;
    }
}
