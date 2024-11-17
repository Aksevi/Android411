package lesson4;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

/*
        int mas[] = new int[4]; // массив на 4 значения
        int[] mas2 = new int[5]; // на 5 так тоже верно ставить скобки

        int mas3[];
        mas3 = new int[4];
        int mas[] = new int[] {2, 7, 5, 3};
        int mas[] = {2, 7, 5, 3};*/


/*       int mas[] = new int[4]; // массива на 4 элемента.
        mas[0] = 5; // если массив типа данных int то и значение в нем будет int
        mas[1] = 2;
        mas[2] = 7;
        mas[3] = mas[1] + mas[2];
//        mas[4] = 8; // это значение даст ошибку тк массив создан на 4 элемента - см стр 18

        System.out.println(mas[0]);//  индексация данных вегда нач с 0
        System.out.println(mas[1]);
        System.out.println(mas[2]);
        System.out.println(mas[3]);
        System.out.println(mas.length); // длина массива (кол во элементов)

        int last = mas[mas.length - 1]; // узнаем значение последнего элемента массива
        System.out.println(last);*

        for (int i = 0; i < mas.length; i++) { // выводит значение элементов каждого массива
            System.out.println(mas[i]);

        }*/

/*        int n = 10;
        int[] mas = new int[n];
        System.out.println(mas.length);
        mas[n - 1] = 2; // mas[9] = 2
        mas[n - 2] = 3; //mas[8] = 3
        mas[n / 5] = mas[n - 1] + mas[n - 2]; // mas [2] = mas[9] + mas[8] -> 5
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }*/

/*        int[] array = new int[4];
        System.out.print("-> ");
        array[0] = input.nextInt();
        System.out.print("-> ");
        array[1] = input.nextInt();
        System.out.print("-> ");
        array[2] = input.nextInt();
        System.out.print("-> ");
        array[3] = input.nextInt();

        for (int i = 0; i < array.length; i++) {
            System.out.print("-> ");
            array[i] = input.nextInt();

        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }*/

/*        int n;
        System.out.print("количество элементов массива: ");
        n = input.nextInt();
        int[] array;
        if(n < 5){
            array = new int[n];
            for (int i = 0; i < array.length; i++) {
                System.out.print("-> ");
                array[i] = input.nextInt();
            }

        } else{
            array = new int[n];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }*/

/*        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            System.out.print("-> ");
            array[i] = input.nextInt();

        }
        for (int i = array.length - 1; i >= 0 ; i--) { // выводим эл-ты в обратном порядке
            System.out.print(array[i] + " ");

        }*/

/*        int[] array = {1, 2, 3, 4};
        System.out.println(array);
        System.out.println(Arrays.toString(array)); // смотрим что лежит в массиве без изменений*/


/*        int n, sum = 0; // длина массива  сумма
        int[] array;
        System.out.print("Введи количество элементов: ");
        n = input.nextInt();
        array = new int[n];

        for (int i = 0; i < array.length; i++) { // ограничивает ввод длинной массива который ввел юзер
            System.out.print("-> ");
            array[i] = input.nextInt();

        }
        System.out.println(Arrays.toString(array)); // выводит что лежит в массиве.
        for (int i = 0; i < array.length; i++) { // перебирает элементы массива в поисках отрицательных чисел (i < длины массива)
            if(array [i] < 0){
                sum  += array[i]; // sum = sum + array[i]
            }
        }
        System.out.println("Сумма отрицательных элесентов массива: " + sum);*/



/*        int min;
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) { // ограничивает ввод длинной массива который ввел юзер
            System.out.print("-> ");
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));
        min = array[0];
            for (int i = 0; i < array.length; i++) {
                if(array[i] < min){
                    min = array[i];
                }
            }
        System.out.println("минимальный эллемент в массиве: " +min);*/


/*        int n, sum = 0; // длина массива  сумма
        int[] array;
        System.out.print("Введи количество элементов: ");
        n = input.nextInt();
        array = new int[n];

        for (int i = 0; i < array.length; i++) { // ограничивает ввод длинной массива который ввел юзер
            System.out.print("-> ");
            array[i] = input.nextInt();

        }*/

//        System.out.println(Arrays.toString(array));
//        for (int i = 1; i < array.length; i++) { // i = 1; i < n (n - размер массива)
//            if(array[i] > array[i - 1]) {
//                System.out.print(array[i] + " ");
//            }

//            System.out.println(Arrays.toString(array)); // то же самое что и предыдущее
//        for (int i = 0; i < array.length - 1; i++) { // i = 0; i < n (n - размер массива)
//            if(array[i] > array[i + 1]) {
//                System.out.print(array[i + 1]);
//            }

//        }

/*        int[] a1 = {1, 2, 3, 4}; // размер массива = 4
        int[] a2 = new int[a1.length + 5]; // + 5 это увеличение размера массива на 5 - размер а2 = а1 = 4, 4 + 5 = 9. теперь в а2 9 элементов = 1, 2, 3, 4 (а1 присвоено) и пять 0 (не присвоено значение)

        for (int i = 0; i < a1.length; i++) {
         a2[i] = a1[i];
        }

        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }*/

/*        double a = Math.random(); // знач случ от 0 до 1 не включая 1
        System.out.println(a);*/


        // (Math.random()) * (max - min)) + min
/*        double a = Math.random() * 3; // от 0 до 3 не включая 3
        System.out.println(a);*/

//        double a = Math.random() * 5 + 2; // math.random() * (7 - 2) + 2 -> math.random() * 5 + 2... (7 - 2) типа интервал от какого до кfкого предела работать рандомайзеру
//        System.out.println(a);
//        double b = 2 + Math.random() * 5; // то же самое что и выше
//        System.out.println(b);



/*        double a = Math.random() * 10 - 5; // -5 до 5  (Math.random()) * (5 - (-5)) + (-5) ->math.random() * 10 - 5
        System.out.println(a);*/

/*        int a = (int) (Math.random() * 3); // обрезаем дробную часть. в скобках потому что сперва формула считается потом к инту преобразуется/ инты и там и там потому что если первой например доубле то будет писать 0 после точки - 2.0 и тд
        System.out.println(a);*/

/*        double a = (Math.random() * (16 - 2) + 2); // знач случ от 16 до 2  включая 2 и 15
        System.out.println(a); //выведет в формате число.0 -> 2.0 и тд
        System.out.println((int)a); //выведет без дробной части
        System.out.printf("%.0f%n",a); //выведет без дробной части*/

//        int a = 3 + (int) (Math.random() * 2); // от 3 до 5
//        System.out.println(a);

//        int a = (int) (Math.random() * (10 + 1)) - 5; // от -5 до 5 включая 5 - 10+1=11 -> 11-5 = 6/ 6 не включается
//        System.out.println(a);

/*        int a = (int) (Math.random() * 7 - 2); // -2 до 5/ (Math.random()) * (max - min)) + min -> math.random * (5 - (-2)) + (-2) ->  max.random() * 7 - 2
        System.out.println(a);*/

/*        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);

        }
        System.out.println(Arrays.toString(array));*/


/*        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 12 + 2);

        }
        System.out.println(Arrays.toString(array));*/

/*        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 31 - 15); // от -15 до 16

        }
        System.out.println(Arrays.toString(array));*/



 /*       int num = 0;
        int sum = 0;
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 40 + 10);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                num++;
            } else {
                sum = sum + array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Кол-во: " + num);
        System.out.println("Сумма: " + sum);*/

/*        int [] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for (int x : numbers){ // то же самое что и выше но короче/ но работает в основном только на вывод элементов
            System.out.print(x + " ");
        }*/

 // урок 9
/*        String[] cities = {"Вологда", "Череповец", "Подюга", "Устюг"};
        String[] cities2 = new String[cities.length + 1]; // увеличили предыдущий массив на 1 элемент
        for (int i = 0; i < cities.length; i++) {
            cities2[i] =  cities[i];
        }
        cities2[cities.length] = "Москва";
        System.out.println(Arrays.toString(cities2));*/

         // урок 9 ArrayList
/*        ArrayList<String> cities = new ArrayList<>();
        cities.add("Вологда");
        cities.add("Череповец");
        cities.add("Подюга");
        cities.add("Устюг");
//        cities.add("Москва"); // добавит в конец
        cities.add(1,"Москва"); // добавит на место 1 (тк с 0 начинается все в яве)
        System.out.println(cities);
        System.out.println(cities.get(2)); // обращаемся по индексу к нужному пункту (в данном случае Череповец)
        cities.set(2, "Курск"); // заменяем Череповец на Курск
        System.out.println(cities.size());// аналог length в массивах

        cities.remove(1); // удаляем элемент по индексу 1
        cities.remove("Подюга"); // удаляем элемент по  значению*/

//        for (String city : cities){ // ограничиваем коллекцию city списком cities
//            System.out.print(city + "\t"); // выодим по одному города из коллекции через табуляцию - выдаст без квадратных скобок
//        }

/*        for (int i = 0; i < cities.size(); i++) {
            System.out.print(cities.get(i) + "\t");

        }*/

/*        System.out.println("\n" + cities.indexOf("Устюг")); // показывает индекс в котором находится город (4)
        if(cities.contains("Устюг")) {
//            System.out.println(cities.contains("Устюг")); // проверяет есть ли такой город напишет true
            System.out.println("ArrayList содержит Устюг");// выдаст текстом
        }*/
// вводим список и удаляем указанный по индексу ур 9  1 ч. 45 мин
/*        int n, k;
        ArrayList<Integer> mas = new ArrayList<>(); // int не можем так как примитивный. только через обертку
        System.out.println("введите элементы списка: ");
        while((n = input.nextInt()) > 0) { // в n вводят значение до тех пор пока не введут 0 или иеньше 0
            mas.add(n); // добавляет в массив введенные значения
        }
        System.out.println(mas);
        System.out.print("Введите индекс: ");
        k = input.nextInt(); // вводят значение которое надо удалить
        mas.remove(k); // удалчет введенное значение
        System.out.println(mas);*/

        //    ур 9  1 ч. 51 мин

/*        int max,ind;
        ArrayList<Integer> mas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mas.add((int) (Math.random() * 100)); // от 0 до 100
        }
        for (int m : mas) { // m переменная ограниченная размерами массива
            System.out.print(m + "\t"); // вывели значения которые рандомно в массиве сформировались
        }
        max = mas.get(0); // в переменную max кладем элемен с нулевым индексом (самый первый) из массива
        for (int i = 0; i < 10; i++) { // находим элемент с максимальным индексом. i < 10 потому что индексов в массиве 10 (с 0 до 9 включительно)
            if(mas.get(i) > max) { // если число по индексу i (в цикле for выше) больше max то
                max = mas.get(i); // перезаписываем его значение в max
            }
        }
        System.out.println("\nMax: " + max);
        ind = mas.indexOf(max);// индекс (положение) текущего максимального элемента
//        System.out.println(ind);
        mas.remove(ind); // удаляем элемент по значению max
//        mas.remove(mas.indexOf(max)); //аналог записи строк 338 и 340 тогда ind не объявляем
//        System.out.println(mas);
        mas.add(0,max);
        for(int m : mas){
            System.out.print(m + "\t");
        }*/

// ур 9 2:20
    /*    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3)); // созд массив на 3 элемента
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11,22,33)); // созд массив на 3 элемента
        ArrayList<Integer> c = new ArrayList<>(); // пустой массив
        System.out.println(a);
        System.out.println(b);

        for (int i = 0; i < a.size(); i++) { // ограничили число иттераций длиной массива. а и b равны по длине поэтому пофиг длиной какого массива ограничивать
            c.add(a.get(i));
            c.add(b.get(i));
        }
               System.out.println(c);*/

// если длина массивов разная
 /*       ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3)); // созд массив на 3 элемента
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11,22,33, 55, 66)); // созд массив на 6 элементов
        ArrayList<Integer> c = new ArrayList<>(); // пустой массив
        System.out.println(a);
        System.out.println(b);

        for (int i = 0; i < a.size(); i++) { // ограничили число иттераций длиной массива. а и b равны по длине поэтому пофиг длиной какого массива ограничивать
            c.add(a.get(i));
            c.add(b.get(i));
        }
        for (int i = a.size(); i < b.size(); i++) {
            c.add(b.get(i));

        }
        System.out.println(c);*/

// ур 9 2:40 двумерный массив
/*        int[][] num = {{0, 1, 2, 3},// 0 три массива внутри одного массива
                       {4, 5, 6, 7}, // 1
                       {8, 9, 10, 11} // 2
        }; 
        System.out.println(num[1][3]);// выводим 7
        for (int i = 0; i < num.length; i++) { // выведет  вложенные списки массива одной частью
            System.out.println(Arrays.toString(num[i]));
        }

        for (int i = 0; i < num.length; i++) { // наружный список (0 1 2 )
            for (int j = 0; j < num[i].length; j++) { // внутренний список (0 1 2 3)
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();

        }*/

// урок 10 4 минута заполняем массив значениями

/*        int n = 5;
        char[][] graph = new char[n][n];
//        for (int i = 0; i < graph.length; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }
        for (int i = 0; i < graph.length; i++) { // можно graph.length заменить на переменную n
            for (int j = 0; j < graph[i].length; j++) { // можно graph[i].length заменить на переменную n
                graph[i][j] = '*';
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }*/

        // пишем прогу рандомно заполняющую двумерный массив 3х4 цифрами от -20 до 10 и ищет количество отрицат эл-тов

/*        int n = 4, m = 3, count = 0;
        int[][] mas = new int[n][m];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int) (Math.random() * 31) - 20;
            }
        }
        for (int i = 0; i < mas.length; i++) { // этот блок форов выводит элементы массива
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + "\t\t");
                if(mas[i][j] < 0){ // ищем отрицательные числа
                    count++; // считаем отрицат числа
                }
            }
            System.out.println();
        }
        System.out.println("отрицательных чисел: " + count);*/

        // ищем в двумерном массиве строку с миним суммой элементов 10 урок 39 минута

/*        int[][] mas = new int[3][5];
        int pos = 0; // фиксирует номер строки в котрой минимальная сумма
        int sum = 0;
        int minsum = Integer.MAX_VALUE; // так как ищем минимальную сумму то сравниваем ее с самым максимальным числом на начальном этапе. этот метод как раз и определяет максимальное значение типа int
        for (int i = 0; i < mas.length; i++) {  // 442-449 строки наполняют массив значениями
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int)(Math.random() * 100); // от 0 до 100 диапазон
                System.out.print(mas[i][j] + "\t\t");

            }
            System.out.println();
        }
        for (int i = 0; i < mas.length; i++) { //
            for (int j = 0; j < mas[i].length; j++) {
                sum += mas[i][j]; // сумма элементов находится одной строки в каждой итерации
            }
            if(minsum > sum){ // проверили больше ли minsum чем sum. на начальном этапе minsum = макс значение. (100)
                minsum = sum;// если minsum > sum то перезаписываем значение minsum на sum
                pos = i;
            }
            System.out.println("Сумма элементов " + (i + 1) + " строки: " + sum); // i + 1 для читабельности. так как в программировании строки с 0 а для человека понятнее с 1. поэтому для вывода прибавляем к строке 1
            sum = 0; // обнуление суммы для того чтобы дать возможнлсть искать сумму след строк в след итерациях иначе он просто начнет полученную в первой итерации сумму к следующим
        }
        System.out.println("Строка с минимальной суммой элементов, " + minsum + " имеет номер: " + (pos + 1));*/





        // урок 10 зубчатый массив 46 мин
        // ввод элементов в зубчатый массив с клавы
                /*int[][] mas = new int[3][];
        mas[0] = new int[2];
        mas[1] = new int[3];
        mas[2] = new int[4];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print("-> "); // ограничивать пользователя условием ввода не надо - больше чем позволит цикл не введет - тк в массиве 3 строки
                mas[i][j] = input.nextInt(); // юзер вводит элементы в массив
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {

                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }*/

// просто зубчатый массив с уже заполненными значениями
/*//        int[][] mas = new int[3][];
//        mas[0] = new int[]{1, 2};
//        mas[1] = new int[]{3, 4, 5};
//        mas[2] = new int[]{6, 7, 8, 9};

//        int[][] mas = new int[][]{{1, 2},{3, 4, 5},{6, 7, 8, 9}}; // то же самое что и выше
        int[][] mas = {{1, 2},{3, 4, 5},{6, 7, 8, 9}}; // то же самое что и выше

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {

                System.out.print(mas[i][j] + "\t");

            }
            System.out.println();
        }*/

// урок 10 1:10 созд зубч массив и заполнить его значениями от 0 до 15
/*        int[][] mas = new int[5][];
        int count = 0;
//        mas[0] = new int[1];
//        mas[1] = new int[2];
//        mas[2] = new int[3];
//        mas[3] = new int[4];
//        mas[4] = new int[5];
        for (int i = 0; i < mas.length; i++) { // можно так (425-426) а не как  в 420-424 строках
            mas[i] = new int[i + 1]; // потому что в каждой след строке на 1 больше. то есть в 0 строке 1 элемент (i = 0 + 1), в 1 - 2 и тд пока длина не кончится
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                // ниже до 436 строки идут не обязательные а скорее для себя
//                System.out.print(mas[i][j] + "\t");
//            }
//                        System.out.println();
//        }
//        for (int i = 0; i < mas.length; i++) { // перебор списков
//            for (int j = 0; j < mas[i].length; j++) { // перебор элементов в списке // //
                mas[i][j] = count++;
                System.out.print(count + "\t");
            }
            System.out.println();
        }*/

     //   10 урок 1:37 делаем наоборот от предыд задачи

/*        int[][] mas = new int[5][];
        int count = 10;
//        mas[0] = new int[1];
//        mas[1] = new int[2];
//        mas[2] = new int[3];
//        mas[3] = new int[4];
//        mas[4] = new int[5];
        for (int i = 0; i < mas.length; i++) { // можно так (425-426) а не как  в 420-424 строках
            mas[i] = new int[mas.length - i]; // потому что в каждой след строке на 1 больше. то есть в 0 строке 1 элемент (i = 0 + 1), в 1 - 2 и тд пока длина не кончится
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                // ниже до 436 строки идут не обязательные а скорее для себя
//                System.out.print(mas[i][j] + "\t");
//            }
//                        System.out.println();
//        }
//        for (int i = 0; i < mas.length; i++) { // перебор списков
//            for (int j = 0; j < mas[i].length; j++) { // перебор элементов в списке // //
                mas[i][j] = count++;
                System.out.print(count + "\t");
            }
            System.out.println();
        }*/

        // треугольник паскаля 10 урок 1:45

/*        int n = 5;
        int tp[][] = new int[n][];
        for (int i = 0; i < tp.length; i++) {
            tp[i] = new int[i + 1];
            tp[i][0] = 1; // заполняем 1 левую сторону
            tp[i][i] = 1; // заполняем 1 правую сторону
            for (int j = 1; j < i; j++) {
                tp[i][j] = tp[i - 1][j - 1] + tp[i - 1][j];

            }
        }
        for (int i = 0; i < tp.length; i++) {
            for (int j = 0; j < tp.length - i; j++) {
                System.out.print("  "); // пробелы для выравнивания сторон треугольника
            }
            for (int j = 0; j < tp[i].length; j++) {
                System.out.print(tp[i][j] + "   ");

            }
            System.out.println();
        }*/






    }
}
