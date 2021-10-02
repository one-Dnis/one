package by.сompany.homework.task01.step1;

/*8. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.*/

import java.util.Random;

public class Task8 {
    public static void main(String[] args) {

        int[] a;
        int n = 10;
        int k = 3;
        int sum = 0;

        a = new int[n];

        Random random = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);

            if (a[i] % k == 0) {
                sum = sum + a[i];
            }
        }

        System.out.println("сумма элементов кратных к = " + sum);


    }
}
