/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Olugbenga.Falodun
 */
public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String test = "";
            test += (i % 3) == 0 ? "fizz" : "";
            test += (i % 5) == 0 ? "buzz" : "";
            System.out.println(!test.isEmpty() ? test : i);
        }
    }
}
