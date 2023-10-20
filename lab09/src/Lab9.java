public class Lab9 {

    public static void main(String[] args) {
        int [][] addTo10Input = {
                {  6,  3,  2,  0,  4},
                { 34, 53,  0, 23,  1},
                {  0, 23, 54, 11,  7}
        };

        double [][] findAvgInput = {
                {  5, 4.5,  6.8},
                {  6,  0,  3.4},
                { 7,  8.4,  2.3}
        };

        double [][] findAvgInputLarge = {
                { 6.7,  23.8,  0,  5.9,  12.8,  45.7},
                {  0,  36.8,  13.5,  6.7,  54.9,  67.4},
                {  37.4,  2.5,  39.8,  0,  2.4,  43.6},
                {  44.6,  76.5,  4.5, 2.4,  0, 54.6},
                {  5.4,  76.3,  6.5, 28.5,  54.7,  0},
                {  19.4,  0,  5.3,  65.4,  93.5,  3.5}
        };

        addTo10 (addTo10Input);
        System.out.println();
        findAverage (findAvgInput);
        System.out.println();
        findAverage (findAvgInputLarge);
        }

    public static void addTo10 (int [][] array) {
        //Loop through each row of the array
        //Loop through each column
        //Add each value to a int called total
        //if value is equal to 0 save index
        // multiply the total by -1, then insert it into saved index
        int total = 0;
        int value;
        int columnIndex = 0;
        int to10 = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                value = array[i][j];
                total += value;
                if (value == 0) {
                    columnIndex = j;
                }
            }
            if (columnIndex >= 0) {
                to10 = 10 - total;
                array[i][columnIndex] = to10;
                columnIndex = -1;

            }
            total = 0;
        }
    }

    public static void findAverage (double [][] array) {
        // declare columnAverage rowAverage and total doubles
        //create for loop to loop through every single value
        // if value is equal to 0, create a loop to loop through its column and calculated the average
        // then loop through the row and calculate the average
        // if the column average is greater than the row average: set the value to columm average else row average
        double columnAverage;
        double rowAverage;
        double total = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if(array[i][j] == 0){
                    for(int column = 0; column < array[i].length; column++){

                        total += array[i][column];

                    }

                    columnAverage = total / array[i].length;
                    total = 0;

                    for(int row = 0; row < array.length; row++){
                        total += array[row][j];
                    }

                    rowAverage = total / array.length;
                    total = 0;
                    if (rowAverage > columnAverage)
                        array[i][j] = rowAverage;
                    else
                        array[i][j] = columnAverage;
                }
            }
        }
    }

    public static void printArray (double[][] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println(array[i][j]);
            }
        }
    }


}