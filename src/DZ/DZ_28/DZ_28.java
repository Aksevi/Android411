package DZ.DZ_28;

import java.util.Scanner;

public class DZ_28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// запрашиваем у пользователя глубину массива
        System.out.print("Глубина числового массива: ");
        int n = scanner.nextInt();
// созд массив числовой глубиной n
        Integer[] intArray = new Integer[n];
// в цикле проходимся по массиву и пока i меньше его глубины
        for (int i = 0; i < n; i++) {
// предлагаем ввести элементы массива(например 1, 2 и тд)
            System.out.print("->> ");
// собственно вводим
            intArray[i] = scanner.nextInt();
        }
// запрашиваем у пользователя глубину второго массива
        System.out.print("Глубина строкового массива массива: ");
        int z = scanner.nextInt();
        scanner.nextLine();
// созд массив числовой глубиной z
        String[] stringArray = new String[z];
// в цикле проходимся по массиву и пока i меньше его глубины
        for (int i = 0; i < z; i++) {
// предлагаем ввести элементы массива(например one, two и тд)
            System.out.print("->> ");
// собственно вводим
            stringArray[i] = scanner.nextLine();
        }
// выводим результат
// содержимое первого массива. printArray - универсальный метод. intArray - наш числовой массив
        System.out.print("Массив: ");
        printArray(intArray);

        System.out.println();
// содержимое второго массива. printArray - универсальный метод. stringArray - наш строковый массив
        System.out.print("Массив: ");
        printArray(stringArray);

        }
// универсальный метод вывода. <T> означает что принимает разные типы массивов
        public static <T> void printArray(T[] array){ // T[] array - это массив элементов универсального типа который принимается в этом методе
// в цикле проходим по массиву и выводим его элементы (присваивая их в переменную e) через пробел.
            for (T e: array){
                System.out.print(e + " ");
            }
        }
}


