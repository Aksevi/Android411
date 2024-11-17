package storonnee;

import java.util.Scanner;

public class Kvadrat {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//       size, i, j; // size сторона квадрата вводимая пользователем, i и j счетчики сторон квадрата
        System.out.print("Введите размер одной стороны квадрата: ");
        int size = input.nextInt();
        if (size < 2) {
            System.out.println("размер не должен быть меньше 2.");
            return;
        }
        for(int i = 0; i < size; i++){ // Верхняя граница
                System.out.print("+ ");
                }
            System.out.println();

        for(int i = 0; i < size - 2; i++) { // Боковые границы и пустота внутри
            System.out.print("+"); // Левая граница

            for (int j = 0; j < (size - 2) * 2 + 1; j++) { // Пустое пространство внутри. логика - контур печатаем - значит уже 2 крайние символы из пустоты вычитаем, плюс каждый пробел это тоже символ и после него тоже нужен пробел (как между символами +): пустота = сторона квадрата минус 2 крайних символа (например сторона = 8 значит пустота 8-2 = 6 и по обе стороны от 6 пробелов тоже пробел - 6*2)
                System.out.print(" ");
            }
            System.out.println("+"); // правая граница
        }

            for (int i = 0; i < size; i++) { // Нижняя граница
                System.out.print("+ ");
            }

        



        }
    }

