/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Olugbenga.Falodun
 */
public class Wizards {

    /**
     * @param {number} src
     * @param {number} dest
     * @param {number[][]} wizards
     * @return {[[] = minCost, [] = minPath]}
     */
    public static int[][] distance_path(int src, int dest, int[][] wizards) {
        int result[][] = new int[2][];
        int minCost = 0;
        int[] minPath = null;
        // Put your code here to calculate minCost and minPath
        Map<String, Integer> map = new HashMap();

        String path = "";
        int cost = 0;

        int index = wizards[0][0];
        int prevIndex;
        for (int level = 0; level < wizards.length; level++) {
//            System.out.println("level  " + level);
            if ("".equals(path)) {
                path = "0";
            }

            int rowLenght = wizards[level].length;

            for (int n = 0; n < rowLenght; n++) {
                if (index > level) {
                    if (index < rowLenght) {
                        if (index != 9) {
                            int temp = wizards[level][index];
                            if (temp > index) {
                                path += Integer.toString(index);
                                index = temp;
                            }
                        } else {
                            path += Integer.toString(index);
                        }
                        System.out.println("path  " + path);
                    }
                }
            }
//            System.out.println("path  " + path);
//            System.out.println(path);

//            for (int j = 0; j < wizards[i].length; j++) {
//                if (path[j] == null) {
//                    path[j] = "0";
//                }
//            int newIndex = wizards[i][j];
//            path[j] = path[j] + newIndex;
//            while (newIndex != 9) {
//                path[j] = path[j] + newIndex;
//                newIndex = wizards[newIndex][j];
//            }
//            System.out.println(Arrays.toString(path));
//            }
        }

        // Return the result, do not change the structure
        result[0] = new int[]{minCost};
        if (minPath == null) {
            minPath = new int[]{};
        }
        result[1] = minPath;
        return result;
    }

    public static void main(String[] args) {
        int numberOfWizards = 10;

        int[][] matrix = {{1, 2, 3}, {8, 6, 4}, {7, 8, 3}, {8, 1}, {6},
        {8, 7}, {9, 4}, {4, 6}, {1}, {1, 4}};

        int src = 0;
        int dest = 9;
        int[][] result = Wizards.distance_path(src, dest, matrix);

//        List<List<Integer>> wizards = new ArrayList<>();
//        Map<String, Integer> map = new HashMap();
//        
//        for (Integer[] datum: data) {
//            List<Integer> list = new ArrayList<>();
//            list.addAll(Arrays.asList(datum));
//            wizards.add(list);
//        }
//        System.out.println("wizards " + wizards.toString());
    }

}

class Route {

    int wizard;
    int from;
    int cost;

    public Route(int wizard, int from, int cost) {
        this.wizard = wizard;
        this.from = from;
        this.cost = cost;
    }
}
