/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.*;

/**
 *
 * @author Olugbenga.Falodun
 */
// A Java program for Dijkstra's single source shortest path algorithm. 
// The program is for adjacency matrix representation of the graph 
class ShortestPath {

    int getIndexOfNextNode(Map<Integer, Integer> costs, List visited) {
        int min = Integer.MAX_VALUE, nextNode = -1;

        for (Map.Entry<Integer, Integer> cost : costs.entrySet()) {
            if (!visited.contains(cost.getKey()) && cost.getValue() <= min) {
                min = cost.getValue();
                nextNode = cost.getKey();
            }
        }

        return nextNode;
    }

    void dijkstra(int wizards[][], int src) {
        int knownCosts[] = new int[wizards.length];

        ArrayList<Integer> visited = new ArrayList<>();
        Map<Integer, Integer> costs;

        int[] minPath = null;
        int minCost = 0;

        for (int i = 0; i < wizards.length; i++) {
            knownCosts[i] = Integer.MAX_VALUE;
        }

        knownCosts[src] = 0; // distance from source to source is 0
        visited.add(0);

        int currentNode = src;
        for (int node = 0; node < wizards.length; node++) {
            if (currentNode != -1) {
                int[] neighbours = wizards[currentNode];
                int cost;
                costs = new HashMap();

                for (int i = 0; i < neighbours.length; i++) {
                    if (!visited.contains(neighbours[i])) {
                        int diff = currentNode - neighbours[i];
                        cost = diff * diff;
                        costs.put(neighbours[i], cost);
                        if (cost < knownCosts[neighbours[i]]) {
                            knownCosts[neighbours[i]] = cost;
                        }
                    }
                }
                currentNode = getIndexOfNextNode(costs, visited);
                if (currentNode != -1) {
                    visited.add(currentNode);
                }
            }
        }
        
        minPath = new int[visited.size()];
        for (int i = 0; i < visited.size(); i++) {
            minPath[i] = visited.get(i);
        }
        
        System.out.println(" minPath " + Arrays.toString(minPath));
        System.out.println(" minCost " + computeMinCost(minPath));
    }

    int computeMinCost(int[] minPath) {
        int sum  = 0, diff;
        for (int i = 0; i < minPath.length-1; i++) {
            diff = minPath[i] - minPath[i+1];
            sum += diff*diff;
        }
        return sum;
    }
    
    
    public static void main(String[] args) {
        int graph[][] = new int[][]{{1, 2, 3}, {8, 6, 4}, {7, 8, 3}, {8, 1}, {6}, {8, 7}, {9, 4}, {4, 6}, {1}, {1, 4}};

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
