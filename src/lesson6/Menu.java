package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    static Scanner input  = new Scanner(System.in); // слово static делает input видным во всех методах ниже

    public static void main(String[] args) {

        int size; // размер массива
        System.out.print("размер массива: ");
        size = input.nextInt(); // вводим размер массива
        int[] list = new int[size]; // имя массива - list

        int option;
        do {
            System.out.println("Меню:" );
            System.out.println("1. Ввод элементов массива:" );
            System.out.println("2. Отображение элементов массива:" );
            System.out.println("3. Поиск элементов в массиве:" );
            System.out.println("4. Сортировка массива:" );
            System.out.println("5. Выход" );
            System.out.print("Сделайте выбор: " );
            option = input.nextInt();

            switch (option){
                case 1:
                    inputArray(list); // inputArray название метода стр 37 , list название массива
                    break;
                case 2:
                    displayArray(list); // название метода стр 44
                    break;
                case 3:
                    System.out.print("Введите элемент который хотите найти: ");
                    int item = input.nextInt();
                    int index = searchArray(list, item); // название метода стр 65
                    if (index == -1){
                        System.out.print(">Элемент не найден< " + "\n");
                    } else {
                        System.out.print(">Элемент найден на позиции< " + (index + 1) + "\n"); // так как нумерация с 0 индекса для понимания обычным человеком прибавляем 1
                    } break;
                case 4: // название метода стр 85
                    System.out.println("Отсортированный массив:");
                    sortArray(list);
                    displayArray(list);
                    break;

            }
//            System.out.println("Массив: " + Arrays.toString(list));// содержимое массива
//            System.out.println("Массив: " + list); // адрес массива в памяти
        } while (option != 5);

    }

    // вводим элементы массива.
    public static void inputArray(int[] array) { // тот же list но для удобства назвали array коим он и будет являться везде ниже
        for (int i = 0; i < array.length; i++) {
            System.out.print("->");
            array[i] = input.nextInt();
        }
    }

    // выводим содержимое массива
    public static void displayArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    // ищем переменную по индексу
    public static int searchArray(int[] array, int data){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data){// когда введенное число совпадет с элементом в массиве ->
                return i;// вернет индекс под каким оно находится в массив
            }

        }
        return -1; // если такого элемента нет то выведет это
    }

    // сортируем массив от меньшего к большему
    public static void sortArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) { // минус 1 чтобы не было ошибки
                if(array[j] > array[j + 1]) { // сравнение текущего и след элемента в массиве
                    int temp = array[j];     // меняем две переменные местами через временную переменную 89 -91 стр
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }
            }

        }

    }


}
