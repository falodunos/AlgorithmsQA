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
public class EvaluationFunction {

    public static void main(String[] args) {
        char[][] board = {
            {'x', '_', 'o'},
            {'_', 'x', 'o'},
            {'_', '_', 'x'}
        };

        System.out.println("Evaluation :: " + evaluate(board));
    }

    private static int evaluate(char[][] b) {

        // evaluating roles
        for (int row = 0; row < 3; row++) {
            if (b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
                if (b[row][0] == 'x') {
                    return +10;
                }
                if (b[row][0] == 'o') {
                    return -10;
                }
            }
        }

        // evaluating columns
        for (int col = 0; col < 3; col++) {
            if (b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == 'x') {
                    return +10;
                }
                if (b[0][col] == 'o') {
                    return -10;
                }
            }
        }

        // evaluating diagonals ...
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[0][0] == 'x') {
                return +10;
            }
            if (b[0][0] == 'o') {
                return -10;
            }
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[0][2] == 'x') {
                return +10;
            }
            if (b[0][2] == 'o') {
                return -10;
            }
        }

        // else return 0 if no match is found!
        return 0;
    }
}
