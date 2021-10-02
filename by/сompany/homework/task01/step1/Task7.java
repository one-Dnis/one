package by.сompany.homework.task01.step1;

/*7. Составить программу для вычисления значений функции  F(x) на отрезке [а, b] с шагом h.
   Результат представить в виде таблицы, первый столбец которой – значения  аргумента,
   второй - соответствующие значения функции:*/

public class Task7 {
    public static void main(String[] args) {

        double a;
        double b;
        double h;
        double y;

        a = 8;
        b = 14;
        h = 1;

        System.out.println("-------------------------");
        System.out.printf("|\t%4s\t|\t%4s\t|\n", "x", "y");
        System.out.println("-------------------------");

        for (double x = a; x <= b; x = x + h) {
            y = Math.pow(Math.sin(x), 2) - Math.cos(2 * x);
            System.out.printf("|\t%4.1f\t|\t%4.1f\t|\n", x, y);
        }
        System.out.println("-------------------------");
    }
}
