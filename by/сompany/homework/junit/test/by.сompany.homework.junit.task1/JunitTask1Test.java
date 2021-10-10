package by.сompany.homework.junit.task1;

import org.junit.Assert;
import org.junit.Test;

public class JunitTask1Test {
    @Test
    public void deleteEverySecondElementT001() {
        //тест к первому заданию
        //данный тест считает количество нулей в массиве(result) и сравнивает с ожидаемым количеством нулей(expResult)

        int n = 11;
        int[] array = new int[n];
        int expResult = n / 2;
        int result = 0;

        Task1.fillArrayRandomElements(array);
        Task1.deleteEverySecondElement(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result++;
            }
        }

        Assert.assertEquals(expResult, result);

    }
    //два теста ко второму заданию
    @Test
    public void makeMatrixT001() {

        int n = 5;
        int[][] array = new int[n][n];

        Task2.makeMatrix(array);

        int expResult = array[array.length - 1][array.length - 1];
        int result = (int) Math.pow(array[0][array.length - 1], n);

        Assert.assertEquals(expResult, result);

    }

    @Test
    public void makeMatrixT002() {

        int n = 5;
        int[][] array = new int[n][n];

        Task2.makeMatrix(array);

        int expResult = array[array.length - 1][array.length - 3];
        int result = (int) Math.pow(array[0][array.length - 3], n);

        Assert.assertEquals(expResult, result);

    }


}

