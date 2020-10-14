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
public class Minimax {
 
    public static void main(String[] args) {
        int scores[] = {3, 5, 2, 9, 12, 5, 23, 23};
        int n = scores.length; 
        int h = log2(n);
        System.out.println("Optimal Value :: " + 
                getOptimalValue(0, 0, true, scores, h));
    }
    
    /**
     * depth - current depth in tree
     * nodeIndex - current node index in scores[]
     * isMax - true is current move is of maximizer else false
     * scores[] - stores leaves of game tree
     * h - maximum height of Game tree
     * @return 
     */
    private static int getOptimalValue(int depth, int nodeIndex, boolean isMax,
            int[] scores, int h) {
        if (depth == h) 
            return scores[nodeIndex];
        
        if (isMax) {
            return Math.max(getOptimalValue(depth+1, nodeIndex*2, false, scores, h), 
                    getOptimalValue(depth+1, nodeIndex * 2 + 1, false, scores, h));
        } else {
            return Math.min(getOptimalValue(depth+1, nodeIndex*2, true, scores, h), 
                    getOptimalValue(depth+1, nodeIndex * 2 + 1, true, scores, h));
        }
    }
    
    private static int log2(int n) {
        return n == 1 ? 0 : 1 + log2(n/2);
    }
}
