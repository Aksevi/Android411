package Lesson16.Test.Test2;

// 30  2 мин
// интерфейс
interface CalcInterface { // функциональный интерфейс
//    void calculate(int a, int b);
    int calculate(int a, int b);
}

// основной класс Main
public class Main {
    public static void main(String[] args) {

        int x = 5, y = 3;
/*// создаем экземпляр интерфейса CalcInterface. по факту это - анонимный класс
            CalcInterface sum = new CalcInterface() { // серым подсвечивается но это норм!
// переопределяем метод  calculate
                @Override
                public void calculate(int a, int b) {
                    System.out.println(a + b);
                }
            }; // ; обязательна!!!*/

// аналог строк 14 - 21 (если там навести на серый  new CalcInterface() то предложит заменить на lambda. Заменил)) )
        // принцип работы - ур 30 13 мин. При вызове метода calculate (sum.calculate(x, y)) то что в (см основной класс main) x (5) поgадает в а, то что в y (3) - в b/ назвать везде иксом и игреком нельзя потому что одной области видимости. a и b можно назвать как угодно кроме x и y. a и b в стр стр 26 27 30 - это интовые a и b из интерфейса CalcInterface стр 7
//        CalcInterface sum = (a, b) -> System.out.println(a + b);
//        CalcInterface mul = (a, b) -> System.out.println(a * b);

// сперва создаем переменную sum класса  CalcInterface затем -> 37 -39 стр
        CalcInterface sum = (a, b) -> (a + b);
        CalcInterface sub = (a, b) -> (a - b);
        CalcInterface mul = (a, b) -> (a * b);

//        sum.calculate(x, y); // sum это имя переменной
//        mul.calculate(x, y); // mul это имя переменной
// вызываем метод  calculate   для sum
       int res =  sum.calculate(x, y); // sum это имя переменной, объект типа данных CalcInterface
       int res2 =  sub.calculate(x, y); // sum это имя переменной, объект типа данных CalcInterface
       int res3 =  mul.calculate(x, y); // sum это имя переменной, объект типа данных CalcInterface
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
    }
}

