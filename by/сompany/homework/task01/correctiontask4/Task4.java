package by.сompany.homework.task01.correctiontask4;

import java.util.Scanner;

/*4. Для данных областей составить линейную программу, которая печатает true,
если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:*/
//исправлено
//дополнено

public class Task4 {
    public static void main(String[] args) {

        coordinateInput();

    }

    public static void coordinateInput() {

        double coordinateX;
        double coordinateY;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координату X");
        System.out.print("> ");

        if (scanner.hasNextDouble()) {

            coordinateX = scanner.nextDouble();
            System.out.println("Введите координату Y");
            System.out.print("> ");
            coordinateY = scanner.nextDouble();
            scanner.close();

            System.out.println(isThePointInTheShadedArea(coordinateX, coordinateY));

        } else {
            System.out.println("неверный формат, пожалуйста используйте только цифры");
            System.out.println();
            coordinateInput();
        }

    }

    public static boolean isThePointInTheShadedArea(double x, double y) {

        if ((x >= 0 & x <= 2 & y >= 0 & y <= 4)
                | (x <= 0 & x >= -2 & y >= 0 & y <= 4)
                | (x <= 0 & x >= -4 & y <= 0 & y >= -3)
                | (x >= 0 & x <= 4 & y <= 0 & y >= -3)) {

            return true;

        } else {

            return false;

        }
    }
}
