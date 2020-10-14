/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

/**
 *
 * @author Olugbenga.Falodun
 */
public class NewTest {
    public static void main(String[] args) {
        System.out.println(add(2.3, 5.7));
    }

    private static int add(double a, double b) {
        
        int sum = 0;
        String[] aa = Double.toString(a).split("\\.");
        String[] bb = Double.toString(b).split("\\.");
        
        sum += Integer.parseInt(aa[0]) + 
                Integer.parseInt(bb[0]) + del(aa, a) + del(bb, b);
        
        return sum;
    }
    
    private static int del(String[] arr, double x) {
        return (x - Integer.parseInt(arr[0])) >= 0.5 ? 1 : 0;
    }
}
