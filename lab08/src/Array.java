public class Array {
    public static void main(String[] args) {
        String[] tokens = args[0].split(",");

        String[] customerName = new String[8];

        for (int i = 0; i < tokens.length; i++) {
            customerName[i] = tokens[i];
        }
        displayNames(customerName);
        customerName[6] = customerName[4];
        customerName[7] = customerName[5];
        customerName[4] = "Rick";
        customerName[5] = "Jessica";
        displayNames(customerName);
        displayNames(reverseNames(customerName));

        for (int i = 0; i < customerName.length; i++) {
            if (customerName[i] != null && customerName[i].equals("Rick")) {
                for (int j = i; j < customerName.length - 1; j++) {
                    customerName[j] = customerName[j + 1];
                    i--;
                }
                customerName[customerName.length - 1] = null;
            }
        }
        displayNames(customerName);
        //No instances of Rick still existed
        //They existed before after shifting up the array, it skips over it
        //Decreasing i by 1 after every shift fixed the problem
    }



    public static void displayNames(String[] names) {
        for (String x : names)
            System.out.println(x);
        //null is printed out for last 2 positions
        //It is null because no value has been assigned to it
        System.out.println("");
    }

    public static String[] reverseNames(String[] names) {
        for (int i = 0; i < names.length / 2; i++) {
            String temp = names[i];
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = temp;
        }
        String[] newArray = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            newArray[i] = names[i];
        }
        return newArray;
    }

    public static void reverseNames2(String[] names) {
        for (int i = 0; i < names.length / 2; i++) {
            String temp = names[i];
            names[i] = names[names.length - i - 1];
            names[names.length - i - 1] = temp;
        }
    }

}
