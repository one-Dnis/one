package by.сompany.homework.junit.task1;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        int n = 5;
        int [][] array = new int[n][n];

        makeMatrix(array);
        printMatrix(array);



    }

    public static int[][] makeMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int)Math.pow(j, i + 1);
            }
        }

        return array;
    }

    public static void printMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("[%4d] ", array[i][j]);
            }
            System.out.println();
        }
    }

}
