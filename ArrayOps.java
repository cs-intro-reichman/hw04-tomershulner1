public class ArrayOps {
    public static void main(String[] args) {
    }
    
    public static int findMissingInt (int [] array) {
        int[] is_missing = new int[array.length + 1];
        int missing = 0;
        for(int i = 0; i < array.length; i++) {
            int current_num = array[i];
            is_missing[current_num] = 1;
        }
        for (int i = 0; i < is_missing.length; i++) {
            if(is_missing[i] == 0) {
                missing = i;
            }
        }
        return missing;
    }

    public static int secondMaxValue(int [] array) {
        // Find the first max value
        int current_max = maxValue(array);
        // Remove the current maximum value from the array
        int[] new_arr = removeValueOnce(array, current_max);
        // Find the second max value
        current_max = maxValue(new_arr);
        return current_max;
    }

    public static boolean containsTheSameElements(int [] array1, int [] array2) {
        // Check the first array
        for (int i = 0; i < array1.length; i++) {
            if (!(isInArray(array2, array1[i]))) {
                return false;
            }
        }
        for (int i = 0; i < array2.length; i++) {
            if (!(isInArray(array1, array2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int [] array) {
        boolean result = true; // The final result of the function
        boolean decreasing = false; // if the array is decreasing
        boolean increasing = false; // if the array is increasing 

        // Iterate over the array until it's known if the array is increasing or decreasing
        int index = 0;
        while (!decreasing && !increasing) {
            if (array[index] > array[index + 1]) decreasing = true;
            else if (array[index] < array[index + 1]) increasing = true;
            index++;
        }
        
        // Iterate over the array from the index stopped and keep checking if the increasing or decreasing
        for (int i = index; i < array.length - 1; i++) {
            if (decreasing) {
                if (array[i] < array[i + 1]) result = false;
            }
            if (increasing) {
                if (array[i] > array[i + 1]) result = false;
            }
        }

        return result;
    }

    public static boolean isInArray(int [] array, int value) {
        boolean exsist = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                exsist = true;
                break;
            }
        }
        return exsist;
    }
    
    public static int maxValue(int [] array) {
        /*
            Function to return the max value of a given array
            */
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int[] removeValueOnce(int[] array, int value_to_remove) {
        /*
            Function to remove a given value from an array
            */
        int[] new_arr = new int[array.length - 1];
        int current_index = 0;
        boolean deleted = false;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] == value_to_remove) && !deleted) {
                deleted = true;
                continue;
            }
            else {
                new_arr[current_index] = array[i];
                current_index++;
            }
        }
        
        return new_arr;
    }

}
