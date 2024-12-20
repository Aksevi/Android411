package storonnee._Alex;

import java.util.Scanner;

public class Main {
    static Daya_Car dataCar = new Daya_Car("X7 M50i", "2021", "BMW", "530", "Red", "6090909");
    public static void main(String[] args) {
        try {
            programMenu ();
        } finally {
            dataCar.getTextPrint( 6);
        }
    }
    public static void programMenu (){
        int number;
        do {
            dataCar.getTextPrint( 1);
            dataCar.getTextPrint( 2);
            number = scannerInput();
            if (number > 0 && number < 4) {
                switch (number) {
                    case 1:
                        dataCar.getPrintInfoCar();
                        break;
                    case 2:
                        dataCar.getPrintInfoCar();
                        editDataTable();
                        break;
                    case 3:
                        return;
                    default:
                        break;
                }
            } else
                dataCar.getTextPrint( 4);
        } while (number > 0 && number < 3);
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
    public static void editDataTable(){
        int number;
        do {
            dataCar.getTextPrint(3);
            number = scannerInput();
            switch (number) {
                case 1:
                    dataCar.getTextPrint(5);
                    dataCar.setNameCar(scannerInputText());
                    break;
                case 2:
                    dataCar.getTextPrint(5);
                    dataCar.setAgeCreate(scannerInputText());
                    break;
                case 3:
                    dataCar.getTextPrint(5);
                    dataCar.setManufacturer(scannerInputText());
                    break;
                case 4:
                    dataCar.getTextPrint(5);
                    dataCar.setPowerEngine(scannerInputText());
                    break;
                case 5:
                    dataCar.getTextPrint(5);
                    dataCar.setColorCar(scannerInputText());
                    break;
                case 6:
                    dataCar.getTextPrint(5);
                    dataCar.setPriceCar(scannerInputText());
                    break;
                default:
                    if (number == 7)
                        break;
                    else {
                        dataCar.getTextPrint(4);
                        editDataTable();
                    }
            }
        } while (number > 0 && number <= 6);
    }
}

