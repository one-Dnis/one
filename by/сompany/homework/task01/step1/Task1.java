package by.сompany.homework.task01.step1;

/*1. Составить линейную программу, печатающую значение true, если указанное
     высказывание является истинным, и false — в противном случае:

   Сумма двух первых цифр заданного четырехзначного числа
   равна сумме двух его последних цифр.*/

public class Task1 {
    public static void main(String[] args) {

        int number = -7584;

        number = Math.abs(number); //всё вроде работает и без модуля, но мало ли)

        int firstDigital = number / 1000;
        int secondDigital = (number - (firstDigital * 1000)) / 100;
        int thirdDigital = (number - (firstDigital * 1000) - (secondDigital * 100)) / 10;
        int fourDigital = (number - (firstDigital * 1000) - (secondDigital * 100) - (thirdDigital * 10));

        if ((firstDigital + secondDigital) == (thirdDigital + fourDigital)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }


}
