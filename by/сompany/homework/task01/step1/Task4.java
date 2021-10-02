package by.сompany.homework.task01.step1;

/*4. Для данных областей составить линейную программу, которая печатает true,
если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:*/

public class Task4 {
    public static void main(String[] args) {

        double x = 0;
        double y = -1;

        if ((x >= 0 & x <= 2 & y >= 0 & y <= 4)
                | (x <= 0 & x >= -2 & y >= 0 & y <= 4)
                | (x <= 0 & x >= -4 & y <= 0 & y >= -3)
                | (x >= 0 & x <= 4 & y <= 0 & y >= -3)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
