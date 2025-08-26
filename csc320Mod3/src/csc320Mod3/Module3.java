package csc320Mod3;

import java.util.Scanner;

// Matthew Finney
// A program that will calculate the weekly tax withholding for 
// a customer given weekly income guidelines.

public class Module3 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		// variables
		double income;
		double tax_percentage;
		double tax_witholding;
		
		// get user input
		System.out.print("Enter weekly income: ");
		income = scnr.nextInt();
		
		
		// validate input to prevent negative numbers
		if (income < 0) 
		{
			System.out.println("Error: Income cannot be negative.");
			return;
		}
		
		// determine tax percentage based on income brackets
		if (income < 500) 
			tax_percentage = 0.10;
		else if (income >= 500 && income < 1500) 
			tax_percentage = 0.15;
		else if (income >= 1500 && income < 2500) 
			tax_percentage = 0.20;
		else
			tax_percentage = 0.25;
		
		// calculate tax withholding
		tax_witholding = income * tax_percentage;
		
		// display results
		System.out.printf("Weekly Income: $%.2f\n", income);
		System.out.printf("Tax Percentage: %.0f%%\n", tax_percentage * 100);
		System.out.printf("Tax Withholding: $%.2f\n", tax_witholding);
		
		scnr.close();
	}

}
