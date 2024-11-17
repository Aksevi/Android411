package storonnee;

import java.util.Scanner;

public class Zub_mas_user {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько строк: ");
        int a = input.nextInt(); // сколько строк будет в массиве
        int[][] mas = new int[a][]; // присваиваем массиву веденное количество строк
        for (int i = 0; i < a; i++) { // пока счетчик i (строки) меньше количества строк a ->
            System.out.print("Сколько элементов в строке " + (i + 1) + ": "); // запрашиваем юзера ->
            int b = input.nextInt(); //  сколько элементов будет в каждой строке
            mas[i] = new int[b];
            for (int j = 0; j < b; j++) { // пока счетчик j (элементы в строке) меньше b ->
                System.out.print("Введите [" + i + "][" + j + "]:");//запрашиваем юзера ->
                mas[i][j] = input.nextInt(); // элементы в каждой строке

            }

        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j]);
            }
            System.out.println();

        }
    }
}
