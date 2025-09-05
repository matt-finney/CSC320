package csc320Mod3;

import java.util.Scanner;

/* 
 * Matthew Finney
 * Collects income for weeks 1-4 and sums their witholding amounts to display
 * as well as average weekly withholding
 * https://github.com/matt-finney/CSC320
 */ 

public class Module3 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// variables
		final int NUM_WEEKS = 4;
		double income = 0;
		double tax_percentage;
		double tax_witholding;
		double avg_week_withholding;
		
		// get income for weeks 1-4
		for (int i = 1; i <= NUM_WEEKS; ++i) 
		{
			income += getIncomeForWeek(input, i);
		}
		
		// get tax percentage based on income brackets
		tax_percentage = getTaxPercentage(income);
		
		// get tax withholding
		tax_witholding = getTaxWithholding(income, tax_percentage);

		// get average weekly withholding
		avg_week_withholding = getAverageIncome(income, NUM_WEEKS);
		
		// display results
		printResults(income, tax_percentage, tax_witholding, avg_week_withholding);

		input.close();
	}
	
	// get the income for a given week
	// validate input to prevent negative numbers
	public static double getIncomeForWeek(Scanner input, int week_num) 
	{
		double income;
		while (true) 
		{
			System.out.printf("Enter income for week %d: ", week_num);
			income = input.nextDouble();
			if (income >= 0) 
			{
				return income;
			} 
			else 
			{
				System.out.println("Income cannot be negative. Please try again.");
			}
		}
	}

	// calculate tax withholding based on income and tax percentage
	public static double getTaxWithholding(double income, double tax_percentage) 
	{
		return income * tax_percentage;
	}

	public static double getAverageIncome(double income, int num_weeks)
	{
		return income / num_weeks; 
	}

	// determine tax percentage based on income brackets
	public static double getTaxPercentage (double income) 
	{
		if (income < 500) 
			return 0.10;
		else if (income >= 500 && income < 1500) 
			return 0.15;
		else if (income >= 1500 && income < 2500) 
			return 0.20;
		else
			return 0.30;
	}

	public static void printResults(double income, double tax_percentage, double tax_withholding, double avg_weekly_withholding) 
	{
		System.out.printf("\nMonthly Income: $%.2f\n", income);
		System.out.printf("Month's Tax Percentage: %.0f%%\n", tax_percentage * 100);
		System.out.printf("Month's Tax Withholding: $%.2f\n", tax_withholding);
		System.out.printf("Average Weekly Withholding: $%.2f\n", avg_weekly_withholding);
	}
}
