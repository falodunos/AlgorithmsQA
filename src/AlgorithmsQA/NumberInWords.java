/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Olugbenga.Falodun
 */
public class NumberInWords {

    private static final String[] unitsAndTens = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tenMultiples = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] placeValues = {"", "", "hundred", "thousand", "million", "billion", "trillion"};

    public static void main(String[] args) {
        int num = 1050;
        System.out.println("converted :: " + convert(num));
    }

    private static String convert(int num) {
        String word = "";
        int len = String.valueOf(num).length();
        for (int i = len - 1; i >= 0; i--) {
            int placeValue = i;

            int divisor = (int) Math.pow(10, i);
            int remainder = num % divisor;
            int dividend = num / divisor;

            num = remainder;

            if (placeValue >= 2) {
//                if (placeValue >= 2 && placeValue < 5) {
//                } else {
//                }
                word += unitsAndTens[dividend] + " " + placeValues[placeValue] + " ";
            } else {
                if (dividend * divisor >= 20) {
                    word += " " + tenMultiples[dividend];
                } else {
                    word += " " + unitsAndTens[dividend];
                }
            }
        }
        return word;
    }
}
