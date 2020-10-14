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
public class Test {

    public static void main(String[] args) {
        int[] values = {9, 31, 38, 5, 62, 44, 38, 17, 19, 38, 50, 31};
        testDuplicates(values, values.length);

//        printRepeated(values);
        testFunction();
    }

    private static void testDuplicates(int[] inputVector, int n) {
        HashSet<Integer> set = new HashSet();
        HashMap<Integer, Integer> map = new HashMap();
        List<Integer> duplicateList = new ArrayList<>();

        int num;
        boolean canProceed = n >= 0 && n <= 1000;

        if (canProceed) {
            for (int i = 0; i < inputVector.length; i++) {
                num = inputVector[i];
                if (!set.add(num)) {
                    if (!duplicateList.contains(num)) {
                        duplicateList.add(num);
                    }
                }
            }

            Collections.sort(duplicateList);
            String duplicates = "";

            if (duplicateList.isEmpty()) {
                System.out.println(0);
            } else {
                for (int item : duplicateList) {
                    duplicates += " " + item;
                }
                System.out.println(duplicates.trim());
            }
        }
    }

    public static void printRepeated(int[] input) {
        List<Integer> out = getRepeated(input);
        if (out.isEmpty()) {
            System.out.println(0);
        } else {
            for (int s : out) {
                System.out.print(s + " ");
            }
        }
    }

    public static List<Integer> getRepeated(int[] input) {
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            int s = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[i] == input[j]) {
                    s++;
                }
                if (s == 2) {
                    if (!out.contains(input[i])) {
                        out.add(input[i]);
                    }
                    break;
                }
            }
        }
        Arrays.sort(out.toArray());
        return out;
    }

    private static void testFunction() {
        String inputString = "*389*301*3123263211";
        String values[] = inputString.split("[*]");
        
        String strAmount = values[3].trim().substring(0, values[3].length());
        
        System.out.println("strAmount " + strAmount);

        String[] splitShortCode = inputString.split("[*]");
        String smartcard = splitShortCode[3].trim();
        
        System.out.println("smartcard " + smartcard);
    }
}
