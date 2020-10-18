/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
QUESTION: How to prints all possible permutations of "TURING"?
 */
package AlgorithmsQA;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Olugbenga.Falodun
 */
public class WordPermutation {

    public static void main(String[] args) {
        String str = "TURING";
        int n = str.length() - 1;
        List list = new ArrayList<String>();
        permute(str, 0, n, list);
        System.out.println("List :: " + list.toString());
    }

    private static void permute(String str, int startIndex, int endIndex, List list) {
        if (startIndex == endIndex) {
            list.add(str);
        } else {
            for (int i = startIndex; i <= endIndex; i++) {
                str = swapChar(str, startIndex, i);
                permute(str, startIndex + 1, endIndex, list);
                str = swapChar(str, startIndex, i);
            }
        }
    }

    private static String swapChar(String str, int startIndex, int nextIndex) {
        char[] charArray = str.toCharArray();
        if (charArray[startIndex] != charArray[nextIndex]) {
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[nextIndex];
            charArray[nextIndex] = temp;
        }
        return String.valueOf(charArray);
    }
}
