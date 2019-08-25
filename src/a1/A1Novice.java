package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int customerAmount = scan.nextInt();

		// indexing for the following arrays follow the same customer for each
		// index
		// [first]
		String customerNames[][] = new String[customerAmount][2];

		// [no. of purchases]
		int customerPurchaseAmount[] = new int[customerAmount];

		// [total of each customer]
		double totals[] = new double[customerAmount];

		for (int i = 0; i < customerAmount; i++) {

			customerNames[i][0] = scan.next();
			customerNames[i][1] = scan.next();
			customerPurchaseAmount[i] = scan.nextInt();

			// initialize totals
			totals[i] = 0.0;
			for (int k = 0; k < customerPurchaseAmount[i]; k++) {

				int amount = scan.nextInt();
				// item name is not used in Novice
				String item = scan.next();
				double price = scan.nextDouble();
				totals[i] += amount * price;

			}
		}
		String formattedNames[] = formatNames(customerNames);
		printOutput(formattedNames, totals);
	}

	/*
	 * 
	 * Formats first and last names into F. Last
	 * 
	 */
	public static String[] formatNames(String customerNames[][]) {

		String formattedNames[] = new String[customerNames.length];

		for (int i = 0; i < customerNames.length; i++) {

			formattedNames[i] = "";
			formattedNames[i] += customerNames[i][0].charAt(0);
			formattedNames[i] += ". ";
			formattedNames[i] += customerNames[i][1];

		}
		return formattedNames;
	}

	/*
	 * 
	 * Prints the output of the program name: total
	 * 
	 */
	public static void printOutput(String formattedNames[], double totals[]) {

		for (int i = 0; i < formattedNames.length; i++) {
			System.out.print(formattedNames[i] + ": ");
			// format to 2 decimal places
			System.out.printf("%.2f", totals[i]);
			System.out.println();
		}
	}
}
