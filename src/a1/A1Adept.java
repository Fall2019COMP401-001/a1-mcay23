package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // get number of items (first input)
        int itemAmount = scan.nextInt();
        Map<String, Double> itemData = getItemData(itemAmount);

        // get number of customers
        int customerAmount = scan.nextInt();

        String customerNames[] = new String[customerAmount];
        double totals[] = new double[customerAmount];

        for (int i = 0; i < customerAmount; i++) {
            String name = scan.next() + " " + scan.next();
            customerNames[i] = name;
            int customerPurchaseAmount = scan.nextInt();
            totals[i] = getTotal(itemData, customerPurchaseAmount);
        }
        printOutput(customerNames, totals);
    }

    /*
     * Get item:price data from input and stores as a map
     * 
     */
    public static Map<String, Double> getItemData(int itemAmount) {

        Map<String, Double> itemData = new HashMap<>();

        // read each item into the map
        for (int i = 0; i < itemAmount; i++) {
            String itemName = scan.next();
            double itemPrice = scan.nextDouble();
            itemData.put(itemName, itemPrice);
        }
        return itemData;
    }

    /*
     * Reads input and calculates total for each customer
     * 
     */
    public static double getTotal(Map<String, Double> itemData,
            int customerPurchaseAmount) {
        double customerTotal = 0;
        for (int i = 0; i < customerPurchaseAmount; i++) {
            int itemAmount = scan.nextInt();
            String itemName = scan.next();
            customerTotal += itemAmount * itemData.get(itemName);
        }
        return customerTotal;
    }

    /*
     * Prints the output with the correct form calls getMaxIndex(),
     * getMinIndex(), getAverage()
     * 
     */
    public static void printOutput(String customerNames[], double totals[]) {
        int maxIndex = getMaxIndex(totals);
        int minIndex = getMinIndex(totals);
        double average = getAverage(totals);
        // format everything to 2 decimal places
        System.out.print("Biggest: " + customerNames[maxIndex] + " (");
        System.out.printf("%.2f", totals[maxIndex]);
        System.out.println(")");
        System.out.print("Smallest: " + customerNames[minIndex] + " (");
        System.out.printf("%.2f", totals[minIndex]);
        System.out.println(")");
        System.out.print("Average: ");
        System.out.printf("%.2f", average);
        System.out.println();
    }

    /*
     * Get the index containing the maximum total number
     * 
     */
    public static int getMaxIndex(double totals[]) {

        int maxIndex = 0;
        for (int i = 0; i < totals.length - 1; i++) {
            if (totals[i + 1] > totals[maxIndex]) {
                maxIndex = i + 1;
            }
        }
        return maxIndex;
    }

    /*
     * Get the index containing the minimum total number
     * 
     */
    public static int getMinIndex(double totals[]) {

        int minIndex = 0;
        for (int i = 0; i < totals.length - 1; i++) {
            if (totals[i + 1] < totals[minIndex]) {
                minIndex = i + 1;
            }
        }
        return minIndex;
    }

    /*
     * Get the average of an array of doubles
     * 
     */
    public static double getAverage(double totals[]) {
        double total = 0.0;
        for (int i = 0; i < totals.length; i++) {
            total += totals[i];
        }
        double average = total / totals.length;
        return average;
    }
}
