/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
    Question: 
You Are Given An Array Of Arrays A. Your Task Is To Group The Arrays A[i] By Their Mean Values, So That Arrays With Equal Mean Values Are 
    In The Same Group, And Arrays With Different Mean Values Are In Different Groups. Each Group Should Contain A Set Of Indices (i, J, Etc), 
    Such That The Corresponding Arrays (a[i], A[j], Etc) All Have The Same Mean. 
You are given an array of arrays a. Your task is to group the arrays a[i] by their mean values, so that arrays with equal mean values are in the 
    same group, and arrays with different mean values are in different groups.

Each group should contain a set of indices (i, j, etc), such that the corresponding arrays (a[i], a[j], etc) all have the same mean. 
    Return the set of groups as an array of arrays, where the indices within each group are sorted in ascending order, and the groups are sorted in 
    ascending order of their minimum element.

Example

For
a = [[3, 3, 4, 2],
     [4, 4],
     [4, 0, 3, 3],
     [2, 3],
     [3, 3, 3]]
the output should be

meanGroups(a) = [[0, 4],[1],[2, 3]]

mean(a[0]) = (3 + 3 + 4 + 2) / 4 = 3;
mean(a[1]) = (4 + 4) / 2 = 4;
mean(a[2]) = (4 + 0 + 3 + 3) / 4 = 2.5;
mean(a[3]) = (2 + 3) / 2 = 2.5;
mean(a[4]) = (3 + 3 + 3) / 3 = 3.

There are three groups of means: those with mean 2.5, 3, and 4. And they form the following groups:

Arrays with indices 0and 4 form a group with mean 3;
Array with index 1 forms a group with mean 4;
Arrays with indices 2 and 3 form a group with mean 2.5.
Note that neither

meanGroups(a) = [[0, 4],
                 [2, 3],
                 [1]]
nor
meanGroups(a) = [[0, 4],
                 [1],
                 [3, 2]]

will be considered as a correct answer:

In the first case, the minimal element in the array at index 2 is 1, and it is less then the minimal element in the array at index 1, which is 2.
In the second case, the array at index 2 is not sorted in ascending order.
For
a = [[-5, 2, 3],
     [0, 0],
     [0],
     [-100, 100]]
the output should be

meanGroups(a) = [[0, 1, 2, 3]]

The mean values of all of the arrays are 0, so all of them are in the same group.

Input/Output

[execution time limit] 3 seconds (java)
[input] array.array.integer a
An array of arrays of integers.

Guaranteed constraints:
1 ≤ a.length ≤ 100,
1 ≤ a[i].length ≤ 100,
-100 ≤ a[i][j] ≤ 100.

[output] array.array.integer
An array of arrays, representing the groups of indices
*/


package AlgorithmsQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Olugbenga.Falodun
 */
public class ArrayMeanGroups {
    public static void main(String[] args) {
        int a[][] = {{3, 3, 4, 2}, {4, 4},
        {4, 0, 3, 3}, {2, 3}, {3, 3, 3}};

        Map<Double, String> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            double mean = computeMean(a[i]);
            if (map.containsKey(mean)) {
                map.put(mean, map.get(mean) + "-" + i);
            } else {
                map.put(mean, Integer.toString(i));
            }
        }
        List lst = new ArrayList<ArrayList<Integer>>();

        for (Map.Entry<Double, String> item : map.entrySet()) {
            List innerList = new ArrayList<Integer>();
            for (String x : item.getValue().split("-")) {
                innerList.add(Integer.valueOf(x));
            }
            Collections.sort(innerList);
            lst.add(innerList);
        }

        System.out.println("sorted :: " + Arrays.toString(sort(lst).toArray()));
    }

    private static List sort(List<List> lst) {
        int smallset;
        for (int i = 0; i < lst.size(); i++) {
            smallset = (int) lst.get(i).get(0);
            for (int j = i + 1; j < lst.size(); j++) {
                int item = (int) lst.get(j).get(0);
                if (item < smallset) {
                    List temp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, temp);
                }
            }
        }
        return lst;
    }

    private static double computeMean(int[] arr) {
        double sum = 0;

        for (int a : arr) {
            sum += a;
        }
        return sum / arr.length;
    }

}
