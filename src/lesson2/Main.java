package lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);// открытие потока на ввод данных

/*        System.out.print("Вводи число, Бро и жми Enter: ");
        int num = input.nextInt();// запрос ввода пользователем значения
        System.out.println("Вы ввели число: " + num);// вывод значения*/

/*        System.out.print("Имя: ");
        String name = input.nextLine();
        System.out.print("Возраст: ");
        int age = input.nextInt();
        System.out.print("Рост: ");
        float height = input.nextFloat();
        System.out.printf("Имя: %s. Возраст: %d. Рост: %.2f %n", name, age, height);
        System.out.println(name + " " + age);*/

/*        System.out.print("Возраст: ");
        int age = input.nextInt();
        input.nextLine();*/

/*        System.out.print("Рост: ");
        float height = input.nextFloat();
        input.nextLine();
        System.out.print("Имя: ");
        String name = input.nextLine();
        System.out.println(name + " " + height);*/

/*        System.out.println("введи четыре числа:");// просим ввести числа
        System.out.printf("1: ");
        int num1 = input.nextInt();// вводит числа
        System.out.printf("2: ");
        int num2 = input.nextInt();
        System.out.printf("3: ");
        int num3 = input.nextInt();
        System.out.printf("4: ");
        int num4 = input.nextInt();
//        System.out.print("введи четыре числа:");// выводит этот текст
//        System.out.printf("%n 1: %d %n 2: %d %n 3: %d %n 4: %d %n", num1, num2, num3, num4); // выводит числа введенные пользователем (%n выводит каждое число с новой строки)
        int sum1, sum2; // новые переменные для действий
        sum1 = (num1 + num2); // сложение
        sum2 = num3 + num4;// сложение
        System.out.printf("Результат = %.2f", +(double) sum1 / sum2);// выводит на экран результат программы - деление суммы первого и второго чисел на сумму третьего и четвертого. +(double) (можно и float вместо double) переводит результат из целых чисел в дробные чтобы были знаки просле запятой, %.2f ограничивает количество знаков после запятой до двух
        input.close();// закрытие потока на ввод данных*/

/*        int a = 5;
        a += 10; // a = a + 10 = 15 (5 + 10 = 15)
        a -= 2; // a = a - 2 = 13 (15 - 2 = 13)
        System.out.println(a);*/

/*        System.out.println("Найти сумму трех введенных чисел");
        int a, b, c, sum;
        System.out.print(" Введите число 1: ");
        a = input.nextInt();
        System.out.print(" Введите число 2: ");
        b = input.nextInt();
        System.out.print(" Введите число 3: ");
        c = input.nextInt();
        sum = a + b + c;
        System.out.println("Сумма чисел: " + sum);*/

/*        System.out.println("Найти сумму трех введенных чисел");
        int sum;
        System.out.print(" Введите число 1: ");
        sum = input.nextInt();
        System.out.print(" Введите число 2: ");
        sum += input.nextInt();
        System.out.print(" Введите число 3: ");
        sum += input.nextInt();
//        sum = a + b + c;
        System.out.println("Сумма чисел: " + sum);*/

/*        int a = 8;
        int b = 3;
        System.out.println(a == b); //false
        System.out.println(a != b); //true
        System.out.println(a >= b); //true
        System.out.println(a <= b); //false
        System.out.println(a < b); //false
        System.out.println(a > b); //true*/

/*        boolean a1 = 5 > 6 && 4 < 6; // false || true => false
        boolean b1 = 5 > 6 || 4 < 6; // false || true => true
        boolean c1 = 25 > 6 || 5 < 3 && 4 == 4; // true || false && true => true
        boolean d1 = 25 > 6 && 5 < 3 || 4 == 4; // true && false || true => true
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
        System.out.println(d1);*/

/*        boolean a2 = 5 > 3;
        System.out.println(!a2); // 5 больше трех => true => !a2 => true*/

/*        if (условие) {
            команда 1
        } else {
            команда 2
        }*/

/*        int age;
        System.out.print("Введите возраст: ");
        age = input.nextInt();
        if (age >= 18) {
            System.out.println("Доступ разрешен."); // сработает если введенный возрас >=18
            System.out.println("Добро пожаловать");
        } else {
            System.out.println("Пшёл вон, щенок!");// сработает если введенный возрас <=18
            System.out.println("Доступ только с 18 лет");
        }*/

/*        int num1 = 27;
        int num2 = 17;
        if (num1 > num2) {
            System.out.println("Первое число больше второго");
        }
        else if (num1 < num2) {
            System.out.println("Первое число меньше второго");
        } else {
            System.out.println("Числа равны");
        }*/

/*        int age = 25;
        boolean isYoung = age >= 18;
        boolean isOld = age <= 65;
        if (isYoung && isOld){
            System.out.println("Вы допущены к работе.");
        } else {
            System.out.println("Иди отдыхай.");
        }*/

/*        int age = 25;
        if (age >= 18 && age <= 65){
            System.out.println("Вы допущены к работе.");
        } else {
            System.out.println("Иди отдыхай.");
        }*/

/*        int age = 75;
        if (age < 18 || age > 65){
            System.out.println("Иди отдыхай");
        } else {
            System.out.println("Вы допущены к работе");
        }*/

/*        System.out.println("Проверить, является треугольник равносторонним, разносторонним или равнобедренным");
        int a, b, c;
        System.out.print("Введите первую сторону треугольника: ");
        a = input.nextInt();
        System.out.print("Введите вторую сторону треугольника: ");
        b = input.nextInt();
        System.out.print("Введите третью треугольника: ");
        c = input.nextInt();
        if (a == b && a == c && b == c) {
            System.out.println("Треугольник равносторонний");
        }
        else  if (a == b || b == c || a == c) {
            System.out.println("Треугольник равнобедренный");
        } else {
            System.out.println("Треугольник разносторонний");
        }*/

/*        int day, time;
        System.out.print("Введите день недели (цифрами): ");
        day = input.nextInt();
        if (day >= 1 && day <= 5) {
            System.out.print("Рабочий день. \nВведите время: ");
            time = input.nextInt();
            if (time >= 9 && time <= 18){
                System.out.println("Открыто");
            } else {
                System.out.println("Закрыто. откроется в 9-00");
            }
        } else if (day == 6 || day == 7) {
            System.out.println("Выходной день");
        } else {
            System.out.println("Такого дня недели нет");
        }*/

/*        int n;
        System.out.print("Ведите количество ворон: ");
        n = input.nextInt();
        if (n >= 0 && n<= 9) {
            System.out.print("На ветке ");
            if (n == 1) {
                System.out.println( n + " ворона");
            } else if (n >= 2 &&  n <= 4) {
                System.out.println(n + " вороны");
            } else { // } else if (n >= 5 && n <= 9 || n == 0){   то же самое получится с этим кодом
                System.out.println(n + " ворон");
            }
        } else {
            System.out.println("Ошибка ввода данных");
        }*/


/*        int day;
        System.out.print("Введите день недели (цифрами): ");
        day = input.nextInt();
        if (day >= 1 && day <= 5) {
            System.out.print("Рабочий день -  ");
            if (day == 1) System.out.println("понедельник");
            if (day == 2) System.out.println("вторник");
            if (day == 3) System.out.println("среда");
            if (day == 4) System.out.println("четверг");
            if (day == 5)  System.out.println("пятница");
        }   else if (day == 6 || day == 7){
                System.out.print("Выходной день - ");
                if (day == 6) System.out.println("суббота");
                if (day == 7) System.out.println("воскресенье");
        } else {
            System.out.println("Такого дня нет");
        }*/

/*        int number, res;
        number = 5;
        res = number >= 0 ? number : -number;
        System.out.println(res);*/

/*        int age;
        System.out.print("введите возраст: ");
        age = input.nextInt();
        System.out.println(age >= 18 && age <= 65 ? "приятного просмотра" : "Вы не можете смотреть это");*/

/*        int a  = 10, b = 20;
        System.out.println(a == b ? "a == b" : a > b ? "a > b" : "b > a");*/

//        int n = true ? false ? 10 : 20 : 30;
//        System.out.println(n); // 20 -   true ? (false ? 10 : 20) : 30;

/*        int a = 10, b = 0;
        System.out.println(b == 0 ? "на ноль не делят" : (float) a / b); // проверяет проверку на ноль. если делят то ошибку выдает если не на ноль то результат*/

/*        int n;
        System.out.println("\tВыбор цвета светофора\n1 1 (11) - красный, 2 (22) - желтый, 3 (33) - зеленый");
        n = input.nextInt();
        switch (n) {
            case 1:
            case 11:
                System.out.println("Stop");
                break;
            case 2:
            case 22:
                System.out.println("Ready");
                break; // прерывает выполнение программы после выполнения кейса 2. без него выдало бы тело 2 и все что после него
            case 3:
            case 33:
                System.out.println("Go");
            default:
                System.out.printf("Uncorrect number of colour"); // работает если введена не та цифра. стоять default может где угодно в теле switch
        }*/


/*        int day = 0, month, year;
        System.out.println("введите месяц числом: ");
        month = input.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                System.out.println("Введите год: ");
                year = input.nextInt();
                if(year %4 == 0){
                    day = 29;
                } else {
                    day = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            default:
                System.out.println("Такого месяца нет");

        }
        if (month >= 1 && month <= 12) {
            System.out.println("количество дней: " + day);
        }*/

    /*    int month;
        System.out.println("введите номер месяца: ");
        month = input.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Нет такого месяца");
        }*/

/*        int month;
        System.out.println("введите номер месяца: ");
        month = input.nextInt();
        switch (month) {
            case 1, 2, 12 -> System.out.println("Зима");
            case 3, 4, 5 -> System.out.println("Весна");
            case 6, 7, 8 -> System.out.println("Лето");
            case 9, 10, 11 -> System.out.println("Осень");
            default -> System.out.println("Нет такого месяца");
        } // новый синтаксис того, что  в задаче выше*/

/*        int month;
        System.out.println("введите номер месяца: ");
        month = input.nextInt();
        String s = switch (month) { // ввели строковое значение String и присвоили иму значение switch, те сократили код на несколько sout
            case 1, 2, 12 -> s = "Зима";
            case 3, 4, 5 -> s = "Весна";
            case 6, 7, 8 -> s = "Лето";
            case 9, 10, 11 -> s = "Осень";
            default -> s = "Нет такого месяца";
        }; // обязательно ; в этом варианте!!!
        System.out.println(s);// новый синтаксис того, что  в задаче */

/*        System.out.println("Введите балл по 12 бальной системе оценивания: ");
        int num = input.nextInt();
        System.out.print("Ваш балл по 5 бальной системе оценивания: ");
        switch((num >= 1 && num <= 3) ? 2
                :(num >= 4 && num <= 6) ? 3 : (num >= 7 && num <= 9) ? 4 : (num >= 10 && num <= 12) ? 5 : 0) {
            case 2 -> System.out.println(2);
            case 3 -> System.out.println(3);
            case 4 -> System.out.println(4);
            case 5 -> System.out.println(5);
            case 0 -> System.out.println("Такого значения нет");
        }*/


/*        int i = 5;
        while (i > 0) {
            System.out.println(i);
            i--;
        }*/

/*        int i = 20;
        while (i > 0) {
            System.out.println(i);
//            i = i / 5;
            i = i - 2;
        }*/

/*        System.out.println("Ищем сумму чисел введеных пользователем");
        int  n, sum = 0; // сумма сперва 0 тк на момент присвоения сумма была равна 0
        System.out.println("введите число: ");
       while (input.hasNextInt()){ // hasNextInt проверяет чтобы вводимые значения были целочисленными
           System.out.println("Введите еще число: ");
           n = input.nextInt();
           sum +=n; // sum = sum + n
       }
        System.out.println("Сумма введенных чисел: " + sum);*/


/*        System.out.println("ищем сумму нечетных чисел в диапазоне, котрый указал пользователь");
        int start, finish, sum = 0; //start начало диапазона, finish - конец диапазона, sum - сумма (равна 0 так как изначально до ввода чисел она равно нулю)
        System.out.print("введите начало диапазона: ");
        start = input.nextInt();
        System.out.print("введите конец диапазона: ");
        finish = input.nextInt();
        while (start <= finish) {
            if(start % 2  != 0) // ищем только нечетные числа остаток от деления на 2 не равен 0, аналогично будет % 2 == 1
            sum += start;
            start++; // start здесь как переменная счетчик и увеличиваем ее на 1 так как намм нужен диапазон вводимых чисел

        }
        System.out.println("сумма нечетных чисел: " + sum);*/

/*        int i = 0;
        do{
            System.out.println("i = " + i);
            i++;
        } while (i > 5); //в случае с do... while ; после условия while обязательна*/

/*        System.out.println("введи любое количество положительных  и отриц чисел до тех пор пока не введет 0 и ищем сумму отриц чисел");
        int num, sum = 0, count = 0; // num число sum сумма count колво введ чисел. num  и count равны 0 тк еще не введены
        float average; //среднее арифметическое
        do {
            System.out.print("введите число: ");
            num = input.nextInt();
            if (num < 0) { // ищем отриц числа
                sum += num; // sum = sum + num
                count++; // count = count + 1
            }
        } while (num != 0); // пока не ввели 0
        average = (float) sum / count; // ищем среднее арифметическое преобразуя в нецелое число
        System.out.printf("среднее арифметическое отрицательных чисел:  %.2f", +average); // выводим рез-т с ограничением до 2 знаков после запятой*/

/*        System.out.println("является ли введенное значение палиндромом");
        int num, copy, revers_num = 0; // num введенное число copy - временная переменная для числа, revers_num обратное число. copy нужна чтобы не потерять введенное число так как ьы будем ешл изменять
        System.out.print("введи число: ");
        num = input.nextInt(); // 321
        copy = num; // 321 сохраняем в copy введенное число
//        System.out.println("num: " + num);
//        System.out.println("copy: " + copy);
        do{
//            System.out.println(copy);
            revers_num *= 10; // reverse_num = reverse_num * 10 = 0 * 10 => 0
            revers_num += copy % 10; // reverse_num +copy % 10 = 0 + 1
           copy /= 10; // каждый шаг цикла делим введенное число на 10 и записываем его в copy ()321
        }while (copy > 0); // пока число больше 0
        System.out.println("число " + num + (num == revers_num ? " ":" не ") + "палиндром" );*/

/*        int i = 0;
        while (i < 10) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            if(i == 5){
                break;
            }
            i++;
        }
        System.out.println("Цикл завершен");*/

/*        int i = 0;
        while (true){
            System.out.println(i);
            if(i == 5) { // без этого - бесконечный цикл будет
                break;
            }
            i++;
        }*/

/*        int n;
        while(true){
            System.out.println("введите положительное число: ");
            n = input.nextInt();
            if(n < 0) {
                break;
            }

        }*/

/*        System.out.println("поиск произведения положительных и отрцательных чисел вводимых пользователем, пока не введется 0");
        int n = 0, res = 0; // n вводимое число, res произведение.изначально они равны 0 (не вводились еще)
        while (true) {
            System.out.print("введите любое число: ");
            n = input.nextInt();
            if (n == 0)
                break; // если ввел 0 то прерывание кода (на 0 не умножают). Если любое другое число - идем дальше
            if (res == 0) // если ввел не 0 идем сюда. res == 0 (изначально) значит идем дальше
                res++; // прибавляем к res 1
            res *= n; // умножаем res (уже равен 1) на n
        }
        System.out.println("Произведение чисел: " + res);
        input.close();*/

/*        int i = 1;
        while (i < 5){
            System.out.println("внешний цикл: i = " + i);
            int j = 1;
            while(j < 4){
                System.out.println("\tВнутренний цикл: j = " + j);
                j++;
            }
            i++;
        }*/

/*        int i = 1;
        while(i < 10){
            int j = 1;
            while (j < 10) {
                System.out.print(i + " * " + j + " = " + i * j + "\t\t");
                j++;
            }
            System.out.println(); // добавили перенос на другую строчку перед изменением i на 1
            i++;
        }*/

/*        System.out.println("вывести на экран прямоугольник из символов");
        int i = 0;
        while (i < 3) {
            int j = 0;
            while (j < 6) {
                System.out.print("^");
                j++;
            }
            System.out.println();
            i++;
        }*/

/*        int i = 0;
        while (i < 5) {
            int j = 0;
            while (j < 16) {
                if(i % 2 == 0) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" - ");
                }
                j++;
            }
            System.out.println();
            i++;
        }*/


/*        int i=0;
        while (i<5){
            int j=0;
            while (j<5){
                System.out.print(i==j ? "+" : " ");
                j++;
            }
            System.out.println();
            i++;}*/

    // for(инициализация переменной; условие; шаг цикла)

/*    for (int i = 0; i < 5; i++){
        System.out.println(i);
    }*/

/*        System.out.println("сколько чисел введено");
        int count = 0;
        for(int i = 0; i < 6; i++){ //не больше 6 символов можно ввести
            System.out.print("=> ");
            if(input.hasNextInt()){
                count++;
            }
            input.nextLine();
        }
        System.out.println("Вы ввели чисел: " + count);*/

/*        int n;
        System.out.print("введите количество символов: ");
        n = input.nextInt();
        System.out.print("посчитал: ");

        for (int i = 0; i < n; i++) {

            System.out.print(" * ");
        }*/

        /*        String symbol;
        int n, orient;
        System.out.print("количетво символов:  ");
        n = input.nextInt();
        System.out.print("тип символа: ");
        symbol = input.next();
        System.out.print("0 - по горизонтали\n1 - по вертикали: ");
        orient = input.nextInt();

        for (int i = 0; i < n; i++) {
            if (orient == 1) {
                System.out.print(symbol);
            } else {
                System.out.println(symbol + " ");
            }
        }*/

/*        int n;
        System.out.print("введите число: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++){ // i не ноль потому что делить на 0 нельзя
            if(n % i == 0)
            System.out.print(i + " ");
        }*/



        for (int i = 10; i < 100; i++) {
            if(i / 10 == i % 10){
                System.out.print(i + " ");

            }

        }






    }

}