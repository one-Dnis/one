package by.сompany.homework.task01.step1;

/*Даны три действительных числа. Возвести в квадрат те из них,
  значения которых неотрицательны, и в четвертую степень — отрицательные.*/

public class Task5 {
    public static void main(String[] args) {

        double a = -2;
        double b = 5;
        double c = -3;

        if (a >= 0) {
            a = Math.pow(a, 2);
        } else {
            a = Math.pow(a, 4);
        }

        if (b >= 0) {
            b = Math.pow(b, 2);
        } else {
            b = Math.pow(b, 4);
        }

        if (c >= 0) {
            c = Math.pow(c, 2);
        } else {
            c = Math.pow(c, 4);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
