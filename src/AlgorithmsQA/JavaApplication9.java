/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olugbenga.Falodun
 */
public class JavaApplication9 {

    /* The name of the class has to be Test. */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int[] p1 = {1, 5, 7, 8, 5, 5, 10, 12, 1, 4, 5, 1000};
        int[] p2 = {1000, 123, 8, 5, 5, 18, 12, 8, 878, 1};
        int[] p3 = {8, 12};
        int m, n, q;
        m = p1.length;
        n = p2.length;
        q = p3.length;


        /* YOUR  CODE HERE */

        int minValueOfMandN = m <= n ? m : n;

        if (0 <= q && q <= 100) {
            if (q <= minValueOfMandN) {
                Arrays.sort(p1);
                Arrays.sort(p2);

                int min = p1[0] < p2[0] ? p1[0] : p2[0];
                int large = p1[p1.length - 1] > p2[p2.length - 1] ? p1[p1.length - 1] : p2[p2.length - 1];

                List<Integer> p1List = new ArrayList<>();
                List<Integer> p2List = new ArrayList<>();
                List<Integer> list = new ArrayList();

                for (int p : p1) {
                    if (isValid(p)) {
                        p1List.add(p);
                    }
                }
                for (int p : p2) {
                    if (isValid(p)) {
                        p2List.add(p);
                    }
                }

                for (int i = min; i <= large; i++) {
                    if (p1List.contains(i) && p2List.contains(i)) {
                        list.add(i);
                    }
                }
                int counter = 0;
                for (int i = 0; i < p3.length; i++) {
                    if (list.contains(p3[i])) {
                        counter += 1;
                    }
                }
                int result = 0;
                int combSize = list.size() - counter;
                for (int i = 1; i <= combSize; i++) {
                    result += getFactoria(combSize) / (getFactoria(combSize - i) * getFactoria(i));
                }
                result += 1;
                System.out.println(result);
            }
        }

    }

    static boolean isValid(int value) {
        return 0 <= value && value <= 10000;
    }

    static int getFactoria(int n) {
        if (n == 0) {
            return 1;
        } else {
            return (n * getFactoria(n - 1));
        }
    }
}
