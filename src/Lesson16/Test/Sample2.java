package Lesson16.Test;
// 30 57 MIN

interface Calc {
    // метод ничего не принимает и возвращает числовое значение
    int calculate();
}
public class Sample2 {
    // статические переменные за пределами класса
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {
// в Calc нет принимаемых арг поэтому пустые скобки
//    Calc operation = () -> x + y;
// если нужно чтобы лямбда выражение записывалось больше одной строки, то добавляем фигурные скобки, пишем return и после закрывающей } ставим ;
        Calc operation = () -> {
            x = 30;
            return x + y;
        };
        System.out.println(x); // x=10 потому что эта строка не видит стр 14-21 (вне скобок фигурных находится)
        System.out.println(operation.calculate());// 30 (x+y)
    }
}
