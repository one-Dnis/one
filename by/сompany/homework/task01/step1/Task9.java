package by.сompany.homework.task01.step1;

/*9. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
     Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого.*/

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {

        int[] firstArray = {21, 22, 23, 24, 25, 26, 27};
        int[] secondArray = {11, 12, 13, 14};

        int k = 3;


        //у 3-го элемена индекс 2
        int divideNumber = firstArray[k - 1];

        int[] resultArray = new int[firstArray.length + secondArray.length];

        //заполняем resultArray до разделительного элемента первого массива включительно
        for (int i = 0; i < k; i++) {

            resultArray[i] = firstArray[i];

            //заполняем resultArray после разделительного элемента вторым массивом
            if (divideNumber == firstArray[i]) {
                for (int j = 0; j < secondArray.length; j++) {
                    resultArray[j + k] = secondArray[j];
                }

            }

        }

        //возвращаемся к первому массиву и заполняем то что осталось
        for (int i = 0; i < (resultArray.length - secondArray.length - k); i++) {
            resultArray[i + k + secondArray.length] = firstArray[i + k];
        }

        System.out.println(Arrays.toString(resultArray));
    }
}
