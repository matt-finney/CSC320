package csc320Mod5;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Matthew Finney
 * Develop a Java program that will store data in the form of monthly temperature for a year. 
 * Store the month and temperature in two different arrays. 
 * Your program should prompt the user for the month to be viewed and display both the month and average temperature. 
 * If "year" is entered, the output for your program should provide the temperature for each 
 * month along with the yearly average as well as the highest and lowest monthly averages. 
 * Use the looping and decision constructs in combination with the arrays to complete this assignment.
 * 
 * https://github.com/matt-finney/CSC320
 */

/*
    * display menu
    * have 1 / 2 set or get
    * have user select 1 or 2
    * clear console
    * 
    * set menu
    * set will ask user for month number or name or go back to display menu
    * clear console
    * ask user temperature
    * clear console
    * go back to set menu
    * 
    * 
    * get menu
    * get will ask user for a month, type name, or go back to display menu
    * clear console
    * display month and temperature
    * clear console
    * display year and average temperature if year is entered
    * 
    */
public class Module5
{
    // Two arrays to carry the months and temperatures associated
    // Declared outside of main method to be accessed in other methods
    public static final String[] MONTHS = 
    {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    public static double[] temperatures = new double[12];

    public static void main(String[] args) 
    {
        // Populate the temperatures array
        Arrays.fill(temperatures, Double.NaN);
        
        Scanner input = new Scanner(System.in);
        
        // Keep looping the main menu until user exits
        boolean running = true;
        while (running)
        {
            // display main menu and get user choice
            int main_menu_choice = mainMenu(input);
            switch (main_menu_choice) 
            {    
                // Go to set temperatures menu
                case 1:
                    clearScreen();
                    // Keep looping the set temperature menu until user goes back to main menu
                    boolean in_setting_menu = true;
                    while (in_setting_menu)
                    {
                        // Get user choice from set temperature menu and decide action
                        int setting_choice = setTemperatureMenu(input);
                        switch (setting_choice) 
                        {
                            // set month temp and add temperatures
                            case 1:
                                addTemperatures(input);
                                System.out.println();
                                break;
                            // back to main menu
                            case 2:
                                in_setting_menu = false;
                                break;
                            // exit program from set temp menu
                            case 3:
                                System.out.println("Exiting...");
                                System.exit(0);
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }
                    break;
                // go to get temperatures menu
                case 2:
                    clearScreen();
                    // Keep looping the get temperature menu until user goes back to main menu
                    boolean in_getting_menu = true;
                    while (in_getting_menu)
                    {
                        // Get user choice from get temperature menu and decide action
                        int getting_choice = getTemperatureMenu(input);
                        switch (getting_choice)
                        {
                            // get month temp and display temperatures
                            case 1:
                                displayTemperatures(input);
                                break;
                            // back to main menu
                            case 2:
                                in_getting_menu = false;                               
                                break;
                            // exit program from get temp menu
                            case 3:
                                System.out.println("Exiting...");
                                System.exit(0);
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }
                    break;
                // exit program from main menu
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                System.out.println("Invalid option.");
            }
        }
    }

    // Menus
    public static int mainMenu(Scanner input)
    {
        clearScreen();
        System.out.println("----------Main menu----------");
        System.out.println("1: Set Month's Temperature");
        System.out.println("2: Get Month's Temperature");
        System.out.println("3: Exit program");
        System.out.println();
        return getValidInt(input, "Enter choice (1-3): ");
    }

    public static int setTemperatureMenu(Scanner input)
    {
        clearScreen();
        System.out.println("-------Set Temperature------");
        System.out.println("1: Enter a Month name or number to set: ");
        System.out.println("2: Go back to main menu: ");
        System.out.println("3: Exit program");
        System.out.println();
        return getValidInt(input, "Enter choice (1-3): ");
    }

    public static int getTemperatureMenu(Scanner input)
    {
        System.out.println("-------Get Temperature------");
        System.out.println("1: Enter a Month name or number to display: ");
        System.out.println("2: Go back to main menu: ");
        System.out.println("3: Exit program");
        System.out.println();
        return getValidInt(input, "Enter choice (1-3): ");
    }

    // Method to keep asking until the user enters a valid integer
    public static int getValidInt(Scanner scanner, String prompt) 
    {
        int number;
        // keep asking until a valid number is entered
        while (true) 
        {
            // prompt user
            System.out.print(prompt);
            String input = scanner.nextLine();
            try 
            {
                // try to parse input as an int
                number = Integer.parseInt(input);
                if (number > 0)
                {
                    // if successful, return the number
                    return number;
                }
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Method to keep asking until the user enters a valid double
    public static double getValidDouble(Scanner scanner, String prompt) 
    {
        double number;
        while (true) 
        {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try 
            {
                number = Double.parseDouble(input);
                return number;
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Method to keep asking until the user enters 'y', 'n', or 'year'
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
                else if (input.equalsIgnoreCase("year"))
                {
                    return input;
                }
                else if (input.equalsIgnoreCase("b"));
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

    // Method to keep asking until the user enters 1-12 or a month's name
    public static int getMonthChoice(Scanner scanner, String prompt)
    {
        int month;
        while (true) 
        {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("year"))
            {
                // special 'year' case from the get temperature's menu
                return -1;
            }
            else if (input.equalsIgnoreCase("b"))
            {
                // special case for exiting menu while setting temperatures
                return -2;
            }
            // try to parse input as an int first
            try 
            {
                month = Integer.parseInt(input);
                // return if number is 1 - 12 
                if (month > 0 && month < 13)
                {
                    return month;
                }
                else
                {
                    System.out.println("Invalid input. Enter a number 1 - 12");
                    continue;
                }
            } 
            catch (NumberFormatException ignored) 
            {
                // not a number, continue to check if month name was entered
            }

            // check if user entered month name
            for (int i = 0; i < MONTHS.length; i++)
            {
                if (input.equalsIgnoreCase(MONTHS[i]))
                {
                    return i + 1;
                }
            }
            System.out.println("Invalid input. Enter 1 - 12 or a month name.");
        }
    }

    // Method to get average of an array
    public static double getAverage(double[] values)
    {
        double sum = 0;
        double average = 0;
        int count = 0;
        
        for (int i = 0; i < values.length; i++)
        {
            // only include valid numbers in the average calculation
            if (!Double.isNaN(values[i]))
            {
                sum += values[i];
                count++;
            }
        }
        average = sum / count;

        return average;
    }

    // Method to get min number in an array
    public static double getMin(double[] values)
	{
		double min = Double.POSITIVE_INFINITY;

		for (int i = 0; i < values.length; i++)
		{
			if (values[i] < min)
			{
				min = values[i];
			}
		}
		return min;
	}

    // Method to get max number in an array
    public static double getMax(double[] values)
	{
		double max = Double.NEGATIVE_INFINITY;

		for (int i = 0; i < values.length; i++)
		{
			if (values[i] > max)
			{
				max = values[i];
			}
		}
		return max;
	}

    // Method to add temperatures to the array
    public static void addTemperatures(Scanner input)
    {
        // get month choice from user
        int month_choice = getMonthChoice(input, "Enter month name or number: ");
        if (month_choice > 0 && month_choice <= 12)
        {
            String response = null;
            // check if month already has a temperature set 
            if (Double.isNaN(temperatures[month_choice - 1]))
            {
                // if not, get temperature, set it, and ask user if they want to enter more
                temperatures[month_choice - 1] = getValidDouble(input, "Enter the temperature for " + MONTHS[month_choice - 1] + ": ");
                response = getReponse(input, "Would you like to keep entering temperatures? (y/n): ");
                // 
                if (response.equalsIgnoreCase("y"))
                {
                    boolean enter_temperature_mode = true;
                    while (enter_temperature_mode)
                    {
                        month_choice = getMonthChoice(input, "\nEnter month name/number or type \'b\' to return: "); 
                        // exit if users types 'b' (-2) and make sure user didnt type 'year' (-1)
                        if (month_choice == -2)
                        {
                            enter_temperature_mode = false;
                        }
                        else if (month_choice == -1)
                        {
                            System.out.println("Invalid input.");
                        }
                        else if (month_choice > 0 && month_choice <= 12) 
                        {
                            temperatures[month_choice - 1] = getValidDouble(input, "Enter the temperature for " + MONTHS[month_choice - 1] + ": ");
                        }
                        else
                        {
                            System.out.println("Invalid input.");
                        }

                    }
                }           
            }
            else
            {
                // if month already has a temperature, ask user if they want to overwrite it
                System.out.printf("There is currently a temperature for %s of %.1f°F%n", MONTHS[month_choice - 1], temperatures[month_choice-1]);
                response = getReponse(input, "Would you like to overwrite? (y/n): ");
                if (response.equalsIgnoreCase("y"))
                {   
                    temperatures[month_choice - 1] = getValidDouble(input, "Enter the new temperature for " + MONTHS[month_choice - 1] + ": ");
                }
                else if (response.equalsIgnoreCase("n")) 
                {
                    System.out.println("Returning to the Set Temperature menu...\n");
                    setTemperatureMenu(input);
                }
            }
        }
    }

    // Method to display temperatures
    public static void displayTemperatures(Scanner input)
    {
        // get month choice from user
        String response = null;
        int month_choice = getMonthChoice(input, "Enter month (1-12 or \'year\'): ");
        if (month_choice > 0 && month_choice <= 12)
        {
            // check if month has a temperature set
            if (Double.isNaN(temperatures[month_choice - 1]))
            {
                // if not, ask user if they want to set one
                System.out.printf("There is currently no temperature for %s", MONTHS[month_choice - 1]);
                response = getReponse(input, ", would you like set one? (y/n): ");
                // if yes, get temperature and set it
                if (response.equalsIgnoreCase("y"))
                {
                    temperatures[month_choice - 1] = getValidDouble(input, "Enter the temperature for " + MONTHS[month_choice - 1] + ": ");
                    // confirm temperature set and press b to return
                    System.out.printf("The temperature for %s has been set to %.1f°F%n", MONTHS[month_choice - 1], temperatures[month_choice - 1]);
                    response = getReponse(input, "\nPress \'b\' to return: ");
                    if (response.equalsIgnoreCase("b"))
                    {
                        clearScreen();
                    }
                    else
                    {
                        System.out.println("Invalid option.");
                    }
                }  
                // if no, return to get temperature menu 
                else if (response.equalsIgnoreCase("n"))
                {
                    clearScreen();
                }
            }
            else
            {
                // if month has a temperature, display it
                System.out.printf("Temperature for %s: %.1f°F%n%n",MONTHS[month_choice - 1],temperatures[month_choice - 1]);
                // press b to return
                response = getReponse(input, "Press \'b\' to return: ");
                if (response.equalsIgnoreCase("b"))
                {
                    clearScreen();
                }
                else
                {
                    System.out.println("Invalid option.");
                }
            }
        }
        // special case for displaying the whole year's temperatures
        else if (month_choice == -1)
        {
            // display all months and their temperatures
            System.out.println("\nShowing temperatures for the year: ");
            for (int i = 0; i < MONTHS.length; i++)
            {
                // don't display NaN values
                if (Double.isNaN(temperatures[i]))
                {
                    System.out.printf("%s:     \t----%n", MONTHS[i]);

                }
                else
                {
                    System.out.printf("%s:     \t%.1f°F%n", MONTHS[i],  temperatures[i]);
                }
            }

            // display avg, min, max temps
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            double average = getAverage(temperatures);
            min = getMin(temperatures);
            max = getMax(temperatures);

            System.out.printf("%nLowest temperature: %.1f°F%n", min);
            System.out.printf("Highest temperature: %.1f°F%n", max);
            System.out.printf("Average temperature: %.1f°F%n", average);
            System.out.println();

            // Hang on the screen until user presses 'b' to go back
            response = getReponse(input, "Press \'b\' to return: ");
            if (response.equalsIgnoreCase("b"))
            {
                clearScreen();
            }
            else
            {
                System.out.println("Invalid option.");
            }
        }
        else if (month_choice == -2)
        {
            System.out.println("Invalid input");
        }
    }

    // Method to clear the terminal screen for clarity
    public static void clearScreen() 
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}