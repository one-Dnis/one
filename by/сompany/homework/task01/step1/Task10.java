package by.сompany.homework.task01.step1;

/*10. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):*/

public class Task10 {
    public static void main(String[] args) {

        int n = 10;

        if (n % 2 == 0) {

            for (int k = 1; k <= n / 2; k++) {

                for (int i = 1; i <= n; i++) {
                    System.out.print(i + "\t");
                }

                System.out.println();

                for (int j = n; j >= 1; j--) {
                    System.out.print(j + "\t");
                }

                System.out.println();

            }
        } else {
            System.out.println("Вы ввели нечетное число");
        }

    }
}
