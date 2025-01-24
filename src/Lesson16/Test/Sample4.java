package Lesson16.Test;

// 30 1-07

interface Calcul {
    // метод ничего не принимает и возвращает числовое значение
    int calculate(int x, int y);
}

public class Sample4 {

    public static void main(String[] args) {

        Calcul operation = (int a, int b) -> {
// 30 - 1-07
            // любые конструкции можно использовать в лямбда выражении
            if (b == 0){
                return 0;
            } else {
                return a / b;
            }
        };
        System.out.println(operation.calculate(20,10));
        System.out.println(operation.calculate(20,0));

    }
}

