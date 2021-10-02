package by.сompany.homework.task01.step1;

/*3. Вычислить периметр и площадь прямоугольного треугольника
     по длинам а и b  двух катетов.*/


public class Task3 {
    public static void main(String[] args) {

        double a = 10;
        double b = 20;
        double c;

        double s;
        double p;

        if (a > 0 & b > 0) {

            c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            p = a + b + c;

            s = (a * b) / 2;

            System.out.println("периметр треугольника: " + p);
            System.out.println("площать треугольника: " + s);

        } else {
            System.out.println("Одна из сторон равна нулю");
        }


    }
}
