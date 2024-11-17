package lesson6;

import java.util.Scanner;

public class Calculator {
        public static void main(String[] args) {

            // урок 11 1-12 программа калькулятор см в пакете lesson 6 calculator

            double num1 = getNumber();// вызывает метод 1
            double num2 = getNumber();// вызывает метод 1
            char operation = getOperation();// вызывает метод 2
            double result = calc(num1, num2, operation); // вызывает метод 3
            System.out.println("Результат: " + result);// выводит рез-т метода 3

//        System.out.println(operation); // выводит возврат от метода 2, строки 41- 50
//        System.out.println(num1); // выводит возвращенное значение метода 1
//        System.out.println(num2); // выводит возвращенное значение метода 1

    }
    // 1 метод отвечает за ввод числа и проверяет на корректность ввода
    public static double getNumber() { // 1 метод это созданный метод с именем getNumber
        Scanner input = new Scanner(System.in); // сканнер внутри метода чтобы можно было ввести число
        System.out.print("Вводи число: ");
        if (input.hasNextDouble()) { // если вводит число (любое целое или нецелое) то ->
            return input.nextDouble(); // возвращает это число в строку 8
        } else { // если ввел не число то ->
            System.out.println("Ошибка. Давай еще раз");
            return getNumber(); // до тех пор пока не введет цифру. аналог цикла когда метод сам себя вызывает
        }


    }

    // 2 метод выбирает тип операции и проверяет на корректность ввода
    public static char getOperation(){ // 2 метод
        Scanner input = new Scanner(System.in);
        System.out.print("1 - сумма\n2 - разность\n3 -произведение\n4 - частное\nВыбери операцию: ");
        int operationNumber;
        if(input.hasNextInt()) { // проверяет чтобы введенное значение было типа int
        }else {
                System.out.println("Повторите ввод");
                return getOperation(); // рекурсия (функция вызывающая сама себя) пока не введет корректно из этого метода не выйдем
        }
        operationNumber = input.nextInt();
        switch(operationNumber){
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
            default:
                System.out.println("Неверно. Давай еще раз: ");
                return getOperation();
        }

    }

    // 3 метод вызывает методы которые производят операцию
    public static double calc(double num1, double num2, char operation){
            switch(operation){
                case '+':
                    return add(num1, num2); // вызывает метод add 77 стр
                case '-':
                    return sub(num1, num2); // вызывает метод sub 80 стр
                case  '*':
                return  mul(num1, num2); // вызывает метод mul 83 стр
                case '/':
                    return div(num1, num2); // вызывает метод div 86 стр
                default:
                    return Double.NaN; // заглушка потому что без дефаулта не даст сделать
            }
    }
// подметоды 3 метода для выполнения операций
    public static double add(double num1, double num2){ // сложение
           return num1 + num2;
    }
    public static double sub(double num1, double num2){// вычитание
        return num1 - num2;
    }
    public static double mul(double num1, double num2){// умножение
        return num1 * num2;
    }
    public static double div(double num1, double num2){// деление
            if(num2 != 0)
        return num1 / num2;
            else { System.out.println("На ноль не делят, глупец!");
                return  Double.NaN; // заглушка
            }
    }
}
