package by.сompany.homework.task01.step1;

/*2. Вычислить значение выражения по формуле
         (все переменные принимают действительные значения):

          представим что тут формула) */

public class Task2 {
    public static void main(String[] args) {


        double a = 1;
        double b = 2;
        double c = 3;
        double result;

        double numerator = b + Math.sqrt(Math.pow(b, 2) + 4 * a * c);
        double denominator = 2 * a;

        if (denominator != 0) {

            result = (numerator / denominator) - Math.pow(a, 3) * c + Math.pow(b, -2);
            System.out.println(result);

        } else {
            System.out.println("Деление на нуль");
        }

    }
}
