package Lesson5;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/*        float num = 5.25f;
        System.out.println(Math.round(num)); // округляет и убирает после точки
        System.out.println(Math.floor(num)); //округление вниз
        System.out.println(Math.ceil(num)); //округление вверх
        System.out.println(Math.sqrt(4)); // нахождение корня кв из числа
        System.out.println(Math.pow(4, 3)); // возведение в степень первое число во второе
        System.out.println(Math.PI); // число Пи*/

// длина окружности
/*        System.out.print("Введите радиус: ");
        int radius = input.nextInt();
        System.out.printf(" Длина окружности: %.2f", 2 * Math.PI * radius); // %.2f округляет до 2 символов после точки. остальное - формула длины окружности*/

// гипотенузу ищем
/*        System.out.print("Введите катет а: ");
        int a = input.nextInt();
        System.out.print("Введите катет b: ");
        int b = input.nextInt();


        System.out.printf("Гипотенуза : %.2f",Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)));*/
// пишем свой метод ур 10 2:40

/*        hello("Irina"); // вызываем наш метод hello
        hello("Igor"); // вызываем наш метод hello
        getSum(2, 5); // переменные с 32 по 38 не видны строке 41 так как в разных областях видимости (в других фигурных скобках)
        int a = 1;
        int b = 7;
        getSum(a, b); // getSum - это метод и с ним работает код дальше
        int n = 3;
        int m = 6;
        getSum(n, m);
    }

    public static void  getSum(int a, int b){
        System.out.println(a + b);



    public static void hello(String name){ // метод пишем с маленькой. классы с большой
        System.out.println("Hello, " + name + "!");*/

//        урок 11 начало выводим чередующиеся символы 9 раз

/*        symbolDraw(9, '+', '-');
        symbolDraw(7, 'X', '0');
    }

        public static void symbolDraw(int count, char a, char b){
            for (int i = 0; i <count; i++){
                if (i%2 == 0) // выводим четные символы остаток от деления на 2 = 0
                System.out.print(a);
                else// выводим нечетеные символы
                    System.out.print(b);
            }
            System.out.println();*/

/*       int a = 30;
       int b = 45;
        System.out.println(" перед вызовом метода: \na = " + a + "\nb = " + b);
        swapFunk(a, b);
        System.out.println(" после вызова метода: \na = " + a + "\nb = " + b);
    }
    public static void swapFunk(int a, int b){
        System.out.println(" До замены: \na = " + a + "\nb = " + b);
        int c = a; // меняем переменные местами за счет переменной c -> эти изменения не влияют за пределы фигурных скобок
        a = b;
        b = c;
        System.out.println(" После замены: \na = " + a + "\nb = " + b);*/

// урок 11 42 минута
/*        int a = 11;
        int b = 6;
        int c = min(a, b);
        System.out.println("Минимальное значение: " + c);
    }

        public static int min(int n1, int n2){ // min это придуманное название метода n1 = 11, n2 = 6
        int minCh;
        if(n1 > n2){
            minCh = n2;
        } else {
            minCh = n1;
        }
            System.out.println("Hello");
        return   minCh; // return возвращает значение в строку 83 c = min(a,b)*/

// урок 11 55 минута юзер вводит а и b и если a > b то вычитаем  если a < b то складываем
/*        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();
        System.out.println("Результат " + res(a, b));
    }

    public static int res(int a, int b) { // этот метод выполняет действия и возвращает результат в строку 102
        if (a > b)
            return a - b;
        else
            return a + b;*/

// урок 11 1:11 выводим от 1 до 11 в кубе
/*        for (int i = 1; i < 11; i++) {
            System.out.println(i + " в кубе = " + cub(i));
        }
      }
        public static int cub(int a){
            return a * a * a;*/

//  11 урок 1:11 (1:44 разбор работы)
/*        int n = 5; // ограничиваем цикл 5
        for (int i = 0; i <= n; i++) { // увеличение работает 1 по 5 строки вкл
            printLine(1, i);
        }
        for (int i = n - 1; i > 0; i--) { // уменьшение работает от 6 до 9 строки
            printLine(1, i);
        }
    }

        public static void printLine(int start, int end){ // сам метод осуществляющий вычисления
            for (int i = start; i <= end ; i++) {
                System.out.print(i + " ");
            }
            System.out.println();*/

/*        sum(1, 2, 3);
        sum(1, 2, 3, 4, 5);
        sum();
    }

    public static void sum(int ...num) {
        int res = 0;
        for(int n: num){
            res += n;
            }
        System.out.println(res);*/


// ур 11 2-04
/*sum_str("Сумма двух чисел: ",  20, 10);
sum_str("Сумма трех чисел: ", 20, 10, 3);
sum_str("Сумма: ");
    }

    public static void sum_str(String message, int... num) {
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            res += num[i];
        }
        System.out.print(message);
        System.out.println(res);*/

//11 урок 2-15

/*        find_num(2, 7, 0, 3, 1, 5, -13);
        find_num(2, 7, 0, 3, 1, 5, -13, 13);
        find_num(26);
        find_num(99, 99, 100, 34, -39);
        find_num(99, 39, 99, 100, 34);


   }
    public static void find_num(int... v){ // v это элемент массива
        int max = 0;
        for (int j : v) { // в j по очереди помещаются все элементы  v
            if (j % 13 == 0 && j > 0) { // проверяем кратность 13
                if (max < j) // проверка что число положительное
                    max = j;
            }
        }
        System.out.println(max == 0 ? "не найдено" : max);*/

// 11 2-35

/*        System.out.println(ch(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(ch(3, 6, 1, 9, 5));
    }

        public static ArrayList ch(int... args){ // ch это просто имя!!
            ArrayList<Integer> mas = new ArrayList<>();

        float sum = 0;
        int count = 0; // количество элементов - читай длинна коллекции = args.length
        float average; // ср. арифм
        for (int i : args){
            sum += i;
            count++;
        }
        average = sum / count;
            System.out.print("Среднее арифметическое: " + average + "\n"); // \n перенос на строку
//            System.out.println();//  перенос на строку
            for(int i : args){
                if (i < average){
                mas.add(i);
                 }
            }
            return mas;*/

// 12 начало разбор дз 11

        System.out.println("Фигура: \n1 - Прямоугольник\n2 - Круг\n3 - Треугольник");
        int figure = input.nextInt();
        if(figure == 1){
            rectangle();
        } else if (figure == 2){
           krug();
        } else if (figure == 3){
            triangle();
        }
        else{
            System.out.println("ошибка");
       }


   } public static void rectangle(){ // 1
        Scanner input = new Scanner(System.in);
        System.out.print("ширина: ");
        float w = input.nextInt();
        System.out.println("высота: ");
        float h= input.nextInt();
        System.out.printf("площадь: %.2f ",  w * h);
    }

    public static void krug(){ // 2
        Scanner input = new Scanner(System.in);
        System.out.print("радиус: ");
        float r = input.nextInt();
        System.out.printf("площадь: %.2f ",  Math.PI * r * r);

    }

    public static void triangle(){ // 2
        Scanner input = new Scanner(System.in);
        System.out.print("Основание: ");
        float base = input.nextFloat();
        System.out.print("Высота: ");
        float height = input.nextFloat();
        System.out.printf("площадь: %.2f ", 0.5 * base * height);


 // ур 11 24 мин ищем наибольшие числа в массиве

/*        int[] num1 = {3, 8, 9, 4, 1, 2, 5}; // 1
        int[] num2 = {1, 2 , 4};// 2

        System.out.println(max(num1)); // 1 
        System.out.println(max(num2));// 2
    }
    public static int max(int[] mas){
        int mx = mas[0]; // новая переменная с нулевым индексом и представили что она имеет макс знач
        for (int i = 0; i < mas.length; i++) {
            if (mx < mas[i]){
                mx = mas[i];
            }
        }
        return mx;*/
    }




}
