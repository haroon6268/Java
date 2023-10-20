/**
 * Comparing Orders
 *
 * This project takes in arrays an inputs, and sorts the data
 *_____________________________________________________
 * Haroon Almadani
 * Oct 15 2023
 * CMSC-255-001
 */



import java.util.Scanner;

public class OrderComparison {
    public static void main(String[] args){

        String[] companyNames = {"Kroger", "Petsmart", "Ikea", "Lowes", "Target", "Ramen Spot", "Plaza Art", "Microsoft"};
        double[] volumePerOrder = {62.9, 59.6, 92.2, 74.0, 51.7, 42.8, 35.9, 46.9};
        double[] weightPerOrder = {421.3, 713.6, 950.4, 667.8, 794.2, 276.4, 46.2, 110.4};
        double[] profitPerOrder = {1294.96, 7339.17, 6259.38, 4983.74, 8483.47, 1738.55, 524.91, 9066.42};


        double avgVolume = calcAvg(volumePerOrder);
        double avgWeight = calcAvg(weightPerOrder);
        double volumeHigh = findHighValue(volumePerOrder);
        double profitsLow = findLeastValue(profitPerOrder);
        String[] leastTwoWeight = findLeastTwo(companyNames, weightPerOrder);
        String[] highTwoVolume = findHighestTwo(companyNames, volumePerOrder);




        System.out.printf("The average order volume is: %.2f", avgVolume);
        System.out.printf("\nThe average order weight is: %.2f", avgWeight);
        System.out.printf("\nThe highest volume order is: %.2f", volumeHigh);
        System.out.printf("\nThe least profitable order is: $%.2f", profitsLow);
        System.out.print("\nThe companies whose orders have the highest two volumes are:\n");
        for(String x:highTwoVolume)
            System.out.println("    " + x);

        System.out.print("The companies whose orders have the lowest two weights are:\n");
        for(String x:leastTwoWeight)
            System.out.println("    " + x);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a company:");
        String company = input.nextLine().trim();
        boolean foundCompany = findCompany(companyNames, company);


        if (foundCompany) System.out.println(company + " is a company in the array.");

        else System.out.println(company + " is not a company in the array.");


    }

    public static double calcAvg(double[] values){
        //Create a loop that adds each value to a total double variable, then divide by length of array
        double total = 0;
        for (double x:values){
            total += x;
        }
        return total/values.length;
    }

    public static double findHighValue(double[] values) {
        //Create a double variable max
        double max = 0;
        //create a for loop, if x is > than max, set x to max;
        for (double x : values) {
            if (x > max) {
                max = x;
            }

        }
        return max;
    }

    public static double findLeastValue (double[] values){
        //Create a double var min
        double min = values[0];
        //Create a forloop. If x < min, min = x;
        for (double x:values){
            if (x < min)
                min = x;
        }
        return min;
    }

    public static String[] findHighestTwo(String[] names, double[] values) {
        //Create a max and max2 int var
        int max1 = 0;
        int max2 = 1;

        //create a loop. If max1 is less than values[i], max1= i
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[max1]) {
                max1 = i;
            }
        }
        //create a loop, if i != max1 and max2 is less than i, max2 = i;
        for (int i = 0; i < values.length; i++) {
            if (i != max1 && values[i] > values[max2]) {
                max2 = i;
            }
        }
        String[] companyNames = {names[max1], names[max2]};
        return companyNames;
    }

        public static String[] findLeastTwo (String[]names,double[] values){
            //create min and min2 int var
            int min1 = 0;
            int min2 = 1;
            //create a loop. If min1 is greater than values[i], min1= i
            for (int i = 0; i < values.length; i++) {
                if (values[i] < values[min1])
                    min1 = i;
            }
            //create a loop, if i != min1 and min2 is greater than i, max2 = i;
            for (int i = 0; i < values.length; i++) {
                if (i != min1 && values[i] < values[min2])
                    min2 = i;
            }
            String[] companyNames = {names[min1], names[min2]};
            return companyNames;
        }

    public static boolean findCompany(String[] names, String company){
        for(String x: names){
            if(x.equals(company))
                return true;
        }
        return false;
    }
}
