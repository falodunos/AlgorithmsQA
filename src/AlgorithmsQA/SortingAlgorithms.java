/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.Arrays;

/**
 *
 * @author Olugbenga.Falodun
 */
public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] values = {9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 31};

        sort(values); // perform quick sort operations ...
    }

    private static void sort(int[] array) {
        int begin = 0, end = array.length - 1;
        quickSort(array, begin, end);
    }

    private static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
        System.out.println("arr :: " + Arrays.toString(arr));
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
