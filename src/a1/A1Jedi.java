package a1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Jedi {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int itemAmount = scan.nextInt();

		// holds number of customers who bought each item
		Map<String, Integer> customersBought = new HashMap<>();
		// itemData is in format item:amount
		Map<String, Integer> itemData = getItemData(itemAmount,
				customersBought);

		int customerAmount = scan.nextInt();
		String[][] itemTally = tallyItems(itemData, customersBought,
				customerAmount);
		printOutput(itemTally);
	}

	/*
	 * Get item data from input and stores as a map
	 * 
	 */
	public static Map<String, Integer> getItemData(int itemAmount,
			Map<String, Integer> customersBought) {

		// LinkedHashMap preserves insertion order
		Map<String, Integer> itemData = new LinkedHashMap<>();

		// read each item into the map
		for (int i = 0; i < itemAmount; i++) {
			String itemName = scan.next();
			// price is never in Jedi
			scan.nextDouble();
			// initial amount of items is 0
			itemData.put(itemName, 0);
			// customersBought references same object in main()
			customersBought.put(itemName, 0);
		}
		return itemData;
	}

	/*
	 * tally the number of purchases and customers per item
	 * 
	 */
	public static String[][] tallyItems(Map<String, Integer> itemData,
			Map<String, Integer> customersBought, int customerAmount) {

		String[][] itemTally = new String[itemData.size()][3];

		for (int i = 0; i < customerAmount; i++) {
			// scan the first last names, never used in Jedi
			scan.next();
			scan.next();
			int customerPurchaseAmount = scan.nextInt();
			
			// array list keeps track of duplicate items
			ArrayList<String> items = new ArrayList<String>();
			for (int j = 0; j < customerPurchaseAmount; j++) {
				
				int itemAmount = scan.nextInt();
				String itemName = scan.next();
				int itemTotal = itemData.get(itemName);

				// update the number of items bought
				itemData.put(itemName, itemTotal + itemAmount);
				
				// only add customer if item is not duplicate
				if(!items.contains(itemName)) {
					items.add(itemName);
					int customerTotal = customersBought.get(itemName);
					customersBought.put(itemName, customerTotal + 1);
				}
			}
		}

		int i = 0;
		for (String key : itemData.keySet()) {
			itemTally[i][0] = key;
			itemTally[i][1] = customersBought.get(key).toString();
			itemTally[i][2] = itemData.get(key).toString();
			i++;
		}

		return itemTally;
	}

	/*
	 * Print output according to specification
	 * 
	 */
	public static void printOutput(String[][] itemTally) {

		for (int i = 0; i < itemTally.length; i++) {
			if (Integer.parseInt(itemTally[i][1]) == 0) {
				System.out.println("No customers bought " + itemTally[i][0]);
			} else {
				System.out.println(itemTally[i][1] + " customers bought "
						+ itemTally[i][2] + " " + itemTally[i][0]);
			}
		}
	}
}
