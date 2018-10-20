/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oliver
 */
public class Sort {
    
    /**
     * sorts the array in ascending order
     * @param toSort - the unsorted integer array
     * @return - the sorted integer array
     */
    public static int[] bubbleSort(int[] toSort){
        int tempVal;//used when swpping to elements 
        boolean swap;//used to work out when the array has been sorted
        int n = 0;
        
        do {//iterate through the array until it is sorted
            swap = false;//reset the flag
            n++;
            for (int i = 0; i < toSort.length - 1; i++) {//iterate through each element. length - 1 ensures no out of bounds problems
                //output(toSort);//use this to see how the array changes as it is sorted
                if (toSort[i] > toSort[i + 1]) {//if the one element is greater than the next
                    swap = true;//a swap will occur
                    tempVal = toSort[i + 1];//store the current value the element at index i + 1
                    toSort[i + 1] = toSort[i];//move the larger value forwards
                    toSort[i] = tempVal;//put the smaller value back
                }
            }
        }while (swap == true);
        
        return toSort;//return the sorted array
        
    }
    
    /**
     * method that sorts an integer array in ascending order
     * @param toSort - the unsorted array
     * @return the sorted array
     */
    public static int[] selectionSort(int[] toSort){
        int smallest;
        int tempVal;//used when swapping records
        int index;
        int i;//loop variable
        
        for(i = 0; i < toSort.length - 2; i++){
            smallest = i;
            for(index = i + 1; index < toSort.length; index++){
                if(toSort[index] < toSort[smallest]){
                    smallest = index;
                }
            } 
            //swap records
            tempVal = toSort[index];
            toSort[index] = toSort[smallest];
            toSort[smallest] = tempVal;
        }
        return toSort;
    }
    
    /**
     * Method that calls a private method to sort an array
     * Set up like this so a return statement can be used as the actual sorting method is recursive -
     *  - so a return statement can't be used as this terminates the method after only one pass through the array
     * @param array the unsorted array
     * @return the sorted array
     */
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }
    
    /**
     * swaps the positions of 2 items in an integer array
     * @param array the array which contains the items to be swapped
     * @param ptr1 one item to be swapped 
     * @param ptr2 the other item to be swapped 
     */
    private static void swap(int[] array, int ptr1, int ptr2) {
        int tempVal;
        tempVal = array[ptr1];
        array[ptr1] = array[ptr2];
        array[ptr2] = tempVal;
    }

    private static void quickSort(int[] array, int first, int last) {
        int left = first;
        int right = last;
        int pivot = array[(first + last)/2];
                
        while(left <= right){//if?
            while(array[left] < pivot){
                left++;
            }
            while(array[right] > pivot){
                right--;
            }
            
            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        
        if(first < right){
            quickSort(array, first, left -1);
        }
        if(left < last){
            quickSort(array, right + 1, last);
        }
    }
}
