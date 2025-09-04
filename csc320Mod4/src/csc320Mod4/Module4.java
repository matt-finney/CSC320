package src.csc320Mod4;

import java.util.Scanner;

/* CSC320 Module 4
 * Matthew Finney
 * A program that utilizes a while-loop to read a set of five 
 * floating-point values from user input. Prints the following data:
 * Total
 * Average
 * Maximum
 * Minimum
 * Interest on total at 20%
 */

public class Module4 
{
	public static void main(String[] args) 
	{
		// declare and init variables
		double total = 0;
		double max = Double.NEGATIVE_INFINITY;
		double min = Double.POSITIVE_INFINITY;
		double average, total_interest;
		
		// read input, filter input to ignore commas and white spaces
		Scanner input = new Scanner(System.in);
		input.useDelimiter("[,\\s]+");
		System.out.print("Enter a set of 5 floating point values (e.g: 2.4, 1.1, 3.0...): ");
		
		// create count variables
		int count = 0;
		int error_count = 0;
		
		// loop as long as the count is less than 5 and there is still input to read
		// exit loop if the user enters 3 invalid inputs
		while (count < 5 && input.hasNext())
		{
			if (error_count < 3)
			{
				if (input.hasNextDouble())
				{
					// create a new value with the user's number
					// compare and store the min and max number against the user's number
					double value = input.nextDouble();
					if (count == 0 || value < min)
					{
						min = value;
					}
					if (count == 0 || value > max)
					{
						max = value;
					}
					// add to total and count after iteration
					total += value;
					count++;
				}
				else
				{
					System.out.print("Invalid input. Please enter floating point numbers: ");
					error_count++;
					input.next();
				}
			}
			else
			{
				break;
			}
		}
		
		// only display output if the user entered 5 numbers
		// loop will break at 3 errors and output exit message
		if (count == 5)
		{
			average = total / 5;
			total_interest = total * 0.2;
			
			System.out.println();
			System.out.printf("Total = %.2f\n", total);
			System.out.printf("Average = %.2f\n",  average);
			System.out.printf("Min = %.2f\n", min);
			System.out.printf("Max = %.2f\n", max);
			System.out.printf("Total interest at 20% = %.2f\n", total_interest);
		}	
		else
		{
			System.out.println("Too many invalid inputs. Exiting program.");
		}
		input.close();
	}
}
