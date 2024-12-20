package DZ.dz_20;

import lesson9.personal_data.Human;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

//        Auto a1 = new Auto("X7 M50i", "2021", "BMW", "530 л.с.", "White", "1079000");
        Auto a1 = new Auto("", "", "", "", "", "");
// пробуем выбор действия
        int option;
        do {
            System.out.println("Меню:");
            System.out.println("1 - Показать данные.");
            System.out.println("2 - Ввести данные.");
            System.out.println("0 - Выход.");
            System.out.print("Нажмите нужную цифру -> ");

            option = input.nextInt();

            switch (option){

                case 1:
                a1.printInfo();
                break;

                case 2:

                    input.nextLine(); // очищаем буфер. без него будет глюк с пропуском ввода модели
                    System.out.print("Введи модель автомобиля -> ");
                    String model = input.nextLine();
                    a1.setModel(model);
                    System.out.print("Введи год выпуска -> ");
                    String year = input.nextLine();
                    a1.setYear(year);
                    System.out.print("Введи марку автомобиля -> ");
                    String marc = input.nextLine();
                    a1.setMarc(marc);
                    System.out.print("Введи мощность двигателя в л.с. -> ");
                    String power = input.nextLine();
                    a1.setPower(power);
                    System.out.print("Введи цвет автомобиля -> ");
                    String colour = input.nextLine();
                    a1.setColour(colour);
                    System.out.print("Введи цену -> ");
                    String price = input.nextLine();
                    a1.setPrice(price);
                    System.out.println("Данные сохранены. возврат в меню.");
                    break;

                case 0:
                    System.out.println("Выход из программы");
//  завершение работы программы
                    return;

                default:
                    System.out.println("Неверный выбор. Давай еще раз.");
            }
// обеспечивает возварт в меню
       } while (true);


// это нужно если без меню с выбором действий
//        System.out.print("Введи модель автомобиля -> ");
//        String model = input.nextLine();
//        a1.setModel(model);
//        System.out.print("Введи год выпуска -> ");
//        String year = input.nextLine();
//        a1.setYear(year);
//        System.out.print("Введи марку автомобиля -> ");
//        String marc = input.nextLine();
//        a1.setMarc(marc);
//        System.out.print("Введи мощность двигателя в л.с. -> ");
//        String power = input.nextLine();
//        a1.setPower(power);
//        System.out.print("Введи цвет автомобиля -> ");
//        String colour = input.nextLine();
//        a1.setColour(colour);
//        System.out.print("Введи цену в рублях -> ");
//        String price = input.nextLine();
//        a1.setPrice(price);*/
//        System.out.println("Год выпуска: " + a1.getYear());
//        a1.printInfo();
//        System.out.println("Модель: " + a1.getModel());
// методы сканеров
    }
    public static int scannerInput() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        return n;
    }
    public static String scannerInputText() {
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        return n;
    }
}


