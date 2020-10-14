/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Olugbenga.Falodun
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] values = {9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 31};
        Arrays.sort(values);
        System.out.println("values  :: " + Arrays.toString(values));
        System.out.println(search(values, 0, values.length - 1, 30));
    }

    private static int search(int[] array, int min, int max, int key) {
        if (max >= min) {

            int mid = (int) (max + min) / 2;
            if (array[mid] == key) {
                return mid;
            }

            if (array[mid] > key) {
                return search(array, min, mid - 1, key);
            }
            return search(array, mid + 1, max, key);
        }
        return -1;
    }
    

}
