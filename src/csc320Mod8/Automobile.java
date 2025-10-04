package csc320Mod8;
import java.time.LocalDate;

public class Automobile 
{
    // instance variables
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // private helper method
    private void resetVehicle()
    {
        this.make = null;
        this.model = null;
        this.color = null;
        this.year = LocalDate.now().getYear(); // default to current year
        this.mileage = 0; // default mileage to 0
    }

    // default constructor
    public Automobile()
    {
        try 
        {
            resetVehicle(); // initialize to default values
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
            // create new vehicle
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "New vehicle added successfully.";
        } catch (Exception e)
        {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // method to remove vehicle by resetting attributes
    public String removeVehicle()
    {
        // try catch block to handle if vehicle not found
        try 
        {
            // reset all attributes to default values
            resetVehicle();
            return "Vehicle removed successfully.";
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
            if (year != -1) this.year = year; // -1 means ignore
            if (new_mileage != -1) this.mileage = new_mileage; // -1 means ignore
            return "Vehicle updated successfully.";
        } catch (Exception e) 
        {
            return "Failed to update vehicle: " + e.getMessage();
        }
    }
    
    // method that returns a String[] of vehicle attributes
    public String[] listVehicleInformation()
    {
        try
        {
            // check if vehicle information is available
            if (make == null && model == null && color == null && year == 0)
            {
                return new String[] {"No vehicle information available."};
            }
            return new String[]
            { 
                "Make: " + make,
                "Model: " + model,
                "Color: " + color,
                "Year: " + year,
                "Mileage: " + mileage
            };
        } catch (Exception e)
        {
            return new String[] {"Failed to list vehicle information: " + e.getMessage()};
        }
    }

    // method to display vehicle information
    public String displayVehicleInfo()
    {
        // try block to handle if vehicle info is not available
        try 
        {
            String[] info = listVehicleInformation();
            StringBuilder sb = new StringBuilder();
            for (String line : info) 
            {
                sb.append(line).append("\n");
            }
            return sb.toString().trim();
        } catch (Exception e) 
        {
            return "Failed to display vehicle information: " + e.getMessage();
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
