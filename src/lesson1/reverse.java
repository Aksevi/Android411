package lesson1;

public class reverse {
    public static void main(String[] args) {
        int num = 4321; // вданном задании надо сделать так чтобы число 4321 вывелось наоборот - 1234
        int a, b, c, d, res; // временные переменные которым присвоим по цифре из исходного числа
        System.out.println("Исходное число: " + num); // выводим исходное число
        a = num % 10; // при остатке от деления на 10 всегда получаем последнюю цифру из числа
        System.out.println("a:" + a);
        num = num / 10; // делим исходное число 4321 на 10 (=432)чтобы потом остатком от деления на 10 получить значение второй переменной (2)
        System.out.println("Num: " + num);
        b = num % 10;
        System.out.println("b:" + b);
        num = num / 10; //делим измененное исходное число 432 на 10 (43) чтобы потом остатком от деления на 10 получить значение второй переменной (3)
        System.out.println("Num: " + num);
        c = num % 10;
        System.out.println("c:" + c);
        num = num / 10;
        System.out.println("num: " + num);
        d = num % 10;
        System.out.println("d:" + d);
        res =  a * 1000 + b *100 + c * 10 + d; // арифметические действия и конкатенация строк - число а * 1000 (стало первым в 4хзначном числе) затем число b*100 - стало вторым в 4хзначном числе и тд
        System.out.println("Обратное число: " + res);
    }

}
