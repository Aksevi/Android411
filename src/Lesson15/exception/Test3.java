package Lesson15.exception;

import java.util.Scanner;

// 29 37 min
public class Test3 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
// оборачиваем то место где могут быть некорректные значения
        try {
            a = getNumber("первое число:");
            b = getNumber("второе число:");
        }catch (NumberFormatException e){
            System.out.println("значение некорректно");
        }

        System.out.print("Результат: " + (a + b));
    }

    public static int  getNumber(String message) throws NumberFormatException{ // message - имя просто
        Scanner input = new Scanner(System.in);
        System.out.print(message + " ");
        String s = input.nextLine();
        return Integer.parseInt(s);
    }
}
