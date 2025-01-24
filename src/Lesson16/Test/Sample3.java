package Lesson16.Test;

// 30 1-04
interface Calculate {
    // метод ничего не принимает и возвращает числовое значение
    int calculate();
}

public class Sample3 {


    public static void main(String[] args) {
// локальные переменные на уровне метода
        int x = 10;
        int y = 20;
        Calculate operation = () -> {
//        x = 30; // сейчас переменную нельзя изменить потому что переменные определены внутри метода. чтобы переопределить см Sample2
            return x + y;
        };
        System.out.println(x); // 10
        System.out.println(operation.calculate()); // 30
    }
}


