package csc320Mod4;

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
 * https://github.com/matt-finney/CSC320
 */

public class Module4 
{
	public static void main(String[] args) 
	{
		final int NUM_VALUES = 5;
		final double INTEREST_RATE = 0.20;
		Scanner input = new Scanner(System.in);
		input.useDelimiter("[,\\s]+");
		
		// store user input in an array
		double[] values = getUserValues(NUM_VALUES, input);

		// perform calculations
		double total = calculateTotal(values);
		double average = calculateAverage(values);
		double max = getMax(values);
		double min = getMin(values);
		double interest = calculateInterest(total, INTEREST_RATE);
		
		printResults(total, average, max, min, interest);
		
		input.close();
	}

	// gets user input and stores it in an array
	public static double[] getUserValues(int num_values, Scanner input)
	{
		// array to hold user input
		double[] values = new double[num_values];
		int count = 0;
		Scanner line_scanner;

		// continue prompting until there are enough values
		while (count < num_values) 
		{
			System.out.printf("Enter %d value(s): ", num_values - count);
			String line = input.nextLine();
			
			// skip empty lines
			if (line.trim().isEmpty())
			{ 
				continue;
			}

			// parse the line for numbers
			line_scanner = new Scanner(line);
			line_scanner.useDelimiter("[,\\s]+");

			// read numbers from the line
			while (line_scanner.hasNext() && count < num_values) 
			{
				// check if the next token is a valid double
				// if not skip it and print a message
				if (line_scanner.hasNextDouble()) 
				{
					values[count] = line_scanner.nextDouble();
					count++;
				} 
				else 
				{
					System.out.println("Invalid input");
					line_scanner.next();
				}
			}
			line_scanner.close();
		}
		return values;
	}

	// iterates through the array to calculate the total
	public static double calculateTotal(double[] values)
	{
		double total = 0;
		for (int i = 0; i < values.length; i++)
		{
			total += values[i];
		}
		return total;
	}

	// calculates the average using the total divided by the number of values
	public static double calculateAverage(double[] values)
	{
		double total = calculateTotal(values);
		return total / values.length;
	}

	// iterates through the array to find the maximum value
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

	// iterates through the array to find the minimum value
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

	// calculates interest
	public static double calculateInterest(double total, double rate)
	{
		return total * rate;
	}

	// prints the results in two decimal places
	public static void printResults(double total, double average, double max, double min, double interest)
	{
		System.out.println();
		System.out.printf("Total = %.2f\n", total);
		System.out.printf("Average = %.2f\n",  average);
		System.out.printf("Min = %.2f\n", min);
		System.out.printf("Max = %.2f\n", max);
		System.out.printf("Total interest at 20%% = %.2f\n", interest);
	}
}
