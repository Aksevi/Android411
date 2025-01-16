package DZ.DZ_28.DZ_28_2.util;

import java.util.Scanner;

public class Scan {
        private static final Scanner scanner =  new Scanner(System.in);

// метод для получения объекта Scanner
        public static Scanner getScanner() {
            return scanner;
        }
// Метод для ввода числового массива
        public static Integer[] intArray(int size){ // size - размер массива
            Integer[] array = new Integer[size];
// идем в цикле по массиву и пока i меньше size просим вводить элементы массива
            for (int i = 0; i < size; i++) {
                System.out.print("-->> ");
// ввод элементов через сканнер
                array[i] = scanner.nextInt();
            }
// возвращаем результат (массив заполненный)
            return array;
        }

// Метод для ввода строкового массива
        public static String[] strArray(int size){ // size - размер массива
            String[]array = new String[size];
            scanner.nextLine();// очистка буфера
// идем в цикле по массиву и пока i меньше size просим вводить элементы массива
            for (int i = 0; i < size; i++) {
                System.out.print("-->> ");
// ввод элементов через сканнер
                array[i] = scanner.nextLine();
            }
// возвращаем результат (массив заполненный)
            return array;
        }
    }

