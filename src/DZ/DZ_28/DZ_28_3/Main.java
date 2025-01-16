package DZ.DZ_28.DZ_28_3;

public class Main {

    public static void main(String[] args) {

// запрашиваем глубину массива
        System.out.print("Глубина массива чисел: ");
// вводим глубину через отдельный метод сканера -> ScanHelp -отдельный класс сканера\\getScanner() -метод в классе ScanHelp \\nextInt() - принимает целочисленное значение;
        int size = ScanHelp.getScanner().nextInt();

        Integer[] intArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            System.out.print("---> ");

            intArray[i] = ScanHelp.getScanner().nextInt();

        }

        System.out.println("Глубина массива строк: ");
         size = ScanHelp.getScanner().nextInt();
         ScanHelp.getScanner().nextLine();
         String[] strArray = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("---> ");
            strArray[i] = ScanHelp.getScanner().nextLine();
        }
// вывод результата отдельным методом
        System.out.print("Массив чисел: ");
//  PrintArray - отдельный класс\\Display - метод класса PrintArray\\ (intArray) - массив чисел;
        PrintArray.Display(intArray);

        System.out.print("Массив строк: ");
        PrintArray.Display(strArray);


    }
}
