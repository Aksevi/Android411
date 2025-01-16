package DZ.DZ_28.DZ_28_1;

import java.util.Scanner;

public class Main {

// универсальный метод вывода
        public static <T> void printArray(T[] array) {
            for (T e : array) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
// метод Scanner
    public static  Scanner getScanner(){
                return new Scanner(System.in);
            }
            public static void main(String[] args) {
            Scanner scanner = getScanner();
                System.out.print("Введи глубину массива чисел: ");
                int size = scanner.nextInt();
                 Integer [] intArray = new Integer[size];

                for (int i = 0; i < size; i++) {
                    System.out.print("--> ");
                    intArray[i] = scanner.nextInt();

                }
//                System.out.print("Массив чисел: ");
//                printArray(intArray);

                System.out.print("Введи глубину строкового массива: ");
                size = scanner.nextInt();
                scanner.nextLine();
                String[] strArray = new String[size];


                for (int i = 0; i < size; i++) {
                    System.out.print("--> ");

                    strArray[i] = scanner.nextLine();

                }
                System.out.print("Массив чисел: ");
                printArray(intArray);
                System.out.print("Массив строк: ");
                printArray(strArray);
        }
    }

