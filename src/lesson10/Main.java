package lesson10;

public class Main {
    public static void main(String[] args) {

// ур 22 29 мин
 // создаем экземпляр класса
        Calculation obj = new Calculation();
// обращаемся к obj (экземпляру класса) и вызываем метод calculate и передаем туда любые два числа

        // перегрузка метода по количеству параметров. то есть можно создать несколько методов с одинаковым названием но они должны отличаться по кол-ву параметров
        obj.calculate(1,2);
        obj.calculate(1,2, 3);

        // перегрузка метода по типу параметров. Nо есть можно создать несколько методов с одинаковым названием но по типу параметров
        obj.calculate(2.5,3.4);

        // перегрузка метода по порядку указания параметров.
        obj.calculate(2.5,2);
        obj.calculate(2,2.5);

    }
}
// создаем класс Calculation
class Calculation{
// создаем метод calculate
    public void calculate(int a, int b){
        System.out.println("Сумма двух целых чисел: " + (a + b));
    }
// дублируем метод, но добавляем в него 3ю переменную с
    public void calculate(int a, int b, int c){
        System.out.println("Сумма трех целых чисел: " + (a + b + c));
    }
// дублируем метод но изменяем тип данных с int на double
    public void calculate(double a, double b){
        System.out.println("Сумма двух вещественных чисел: " + (a + b));
    }
    // дублируем метод но изменяем тип данных с int на double
    public void calculate(double a, int b){
        System.out.println("В результате вещественное число: " + (a + b));
    }

    public void calculate(int a, double b){
        System.out.println("В результате целое число: " + (int)(a + b)); // (int)(a + b) - преобразуем результат к типу данных int т.е отбросится дробная часть
    }
}