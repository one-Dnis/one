package by.сompany.homework.junit.task1;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        int n = 11;
        int[] array = new int[n];


        deleteEverySecondElement(fillArrayRandomElements(array));

        System.out.println(Arrays.toString(array));

    }

    public static int[] fillArrayRandomElements(int[] array) {

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void deleteEverySecondElement(int[] array) {

        for (int i = 1; i < array.length; i++) {
            array[i] = 0;
            i++;
        }
    }

}
