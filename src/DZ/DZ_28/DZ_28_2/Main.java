package DZ.DZ_28.DZ_28_2;

import DZ.DZ_28.DZ_28_2.util.Scan;

public class Main  {

// универсальный метод вывода массива
    public static <T> void printArray(T[] array) {
// идем по массиву и по очереди в переменную e кладем элементы массива
        for (T e : array ){
// выводим результат
            System.out.print(e + " ");
        }
        System.out.println();
    }

public static void main (String[] args) {
    System.out.print("Глубина массива чисел: ");

//вводим глубину массива через сканнер
// Scan - класс. getScanner() - метод сканнера в классе Scan. nextInt() - метод объекта scanner принимающий целочисленное значение;
    int size = Scan.getScanner().nextInt();
// создаем массив целых чисел с помощью метода intArray в классе Scan
// объявили переменную intArray типа Integer[], которая получает результат работы метода intArray(size) в классе Scan
    Integer[] intArray = Scan.intArray(size);


    System.out.print("Глубина массива строк: ");
    size = Scan.getScanner().nextInt();
    String[] strArray = Scan.strArray(size);
// вывод результата
    System.out.print("Массив чисел: ");
    printArray(intArray);
    System.out.print("Массив строк: ");
    printArray(strArray);

    }
}