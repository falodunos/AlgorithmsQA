/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.*;
import java.lang.*;

/**
 *
 * @author Olugbenga.Falodun
 */
class Solution {

    /**
     * @param {String[]} words
     * @return {String[]}
     */
    public static String[] reconstruct_alphabet(String[] words) {
        String[] result = null;
        // Put your code here
        
        List<Character> list = new ArrayList<>();
        int wordLen = 0;

        for (String word : words) {
            wordLen = word.length() > wordLen ? word.length() : wordLen;
        }

        for (int i = 0; i < wordLen; i++) {
            for (String word : words) {
                if (i < word.length()) {
                    if (!list.contains(word.charAt(i))) {
                        list.add(word.charAt(i));
                    }
                }
            }
        }

        result = new String[list.size()];
        
        int i = 0;
        for (char ch : list) {
            result[i] = Character.toString(ch);
            i += 1;
        }

        // Return the result, do not change the structure
        if (result == null) {
            result = new String[]{};
        }
        return result;
    }
}

class Main {

    public static void main(String args[]) {
        String[] words = {"ccda", "ccb", "cd", "a", "ab", "d"};

        String[] result = Solution.reconstruct_alphabet(words);
        System.out.println(String.join("", result));
    }
}
