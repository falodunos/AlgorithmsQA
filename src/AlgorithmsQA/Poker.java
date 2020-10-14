/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

//Compiler version 1.8.0_111
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

class Solution1 {

    /**
     * @param {String[]} hand1
     * @param {String[]} hand2
     * @return {int} winner
     */
    public static int determine_winner(String[] hand1, String[] hand2) {
        int winner = 0;
        // Put your code here to calculate the winner
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K", "A"};
        String[] suits = {"S", "H", "D", "C"};
        List suitList = new ArrayList<String>();
        suitList.addAll(Arrays.asList(suitList));

        Map<String, Integer> mappedValues = new HashMap();
        for (int i = 0; i < values.length; i++) {
            mappedValues.put(values[i], i + 1);
        }

        int hand1V = getRank(hand1, suitList, mappedValues);
        int hand2V = getRank(hand2, suitList, mappedValues);

        winner = hand1V > hand2V ? 1 : 2;
        if (hand1V == hand2V) {
            
        } 

        // Return the result, do not change the structure. winner = 1 -> Player 1 wins, winner = 2 -> Player 2 wins
        return winner;
    }

    static int getRank(String[] hand, List suitList, Map<String, Integer> mappedValues) {
        int sum = 0;
        for (int i = 0; i < hand.length; i++) {
            for (int n = 0; n < hand[i].length(); n++) {
                String ch = Character.toString(hand[i].charAt(n));
                if (!suitList.contains(ch)) {
                    for (Map.Entry<String, Integer> value : mappedValues.entrySet()) {
                        if (ch.equals(value.getKey())) {
                            sum += value.getValue();
                        }
                    }
                }
            }
        }
        return sum;
    }
}

class Poker {

    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        String[] components = sc.nextLine().split(" ");
        String[] hand1 = {"2S", "4D", "2C", "TC", "KS"};
        String[] hand2 = {"AS", "QH", "TH", "9S", "KH"};
//        for (int i = 0; i < 10; i++) {
//            if (i < 5) hand1[i] = components[i];
//            else hand2[i-5] = components[i];
//        }
//        
        int winner = Solution1.determine_winner(hand1, hand2);

//        hand2 = {};
        System.out.printf("Player %d wins", winner);
    }
}
