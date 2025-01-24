package Lesson16.Test;

// 30 1-10
// дженерики в лямбда
// интерфейс Calc2 принимает любой тип данных (<T>)
interface Calc2 <T> {
    // метод возвращает любой тип данных и принимает любой тип данных
    T calculate(T x, T y);
}

public class Sample5 {
    public static void main(String[] args) {
// созд экземпляр класса Calc 2
        Calc2<Integer> operation1 = (x, y) -> x + y;// и хотим чтобы сложил 2 числа. поэтому в <> укажем Integer (x, y) -значит принимает x и y,  и возвращает сумму a и b
        System.out.println(operation1.calculate(20,10));// 30

        Calc2<String> operation2 = (x, y) -> x + y;// и хотим чтобы сложил 2 строки. поэтому в <> укажем String (x, y) -значит принимает x и y,  и возвращает сумму(объединение) x и y
        System.out.println(operation2.calculate("Hello","World"));// HelloWorld

    }
}
