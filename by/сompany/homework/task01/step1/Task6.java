package by.сompany.homework.task01.step1;

/*6. Написать программу нахождения суммы большего и меньшего из трех чисел.*/

public class Task6 {
    public static void main(String[] args) {

        int a = 2;
        int b = -4;
        int c = 5;

        int min;
        int max;

        //не путь джедая

        min = Math.min(a, Math.min(b, c));

        max = Math.max(a, Math.max(b, c));

        System.out.println("минимальное число - " + min);
        System.out.println("максимальное число - " + max);


        //путь джедая

        if (a > b & a > c) {
            max = a;
            if (b > c) {
                min = c;
            } else {
                min = b;
            }
        } else if (b > a & b > c) {
            max = b;
            if (a > c) {
                min = c;
            } else {
                min = a;
            }
        } else {
            max = c;
            if (a > b) {
                min = b;
            } else {
                min = a;
            }
        }

        System.out.println("минимальное число по пути джедая - " + min);
        System.out.println("максимальное число по пути джедая - " + max);


    }
}
