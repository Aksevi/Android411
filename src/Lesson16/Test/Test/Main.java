package Lesson16.Test.Test;
// анонимный класс 29 2-40
public class Main {
    public static void main(String[] args) {

        int x = 5, y = 3;
        Calc sum = new Calc();
        sum.calculate(x, y);

/*        CalcElse mul = new CalcElse();
        mul.calculate(x, y);*/

// анонимный класс 29 2-47
        Calc mul = new Calc(){
            @Override
            public void calculate(int a, int b) {
                System.out.println(a * b);
            }
        }; // ; обязательна!!!!!
        mul.calculate(x, y);
    }
}

class Calc{

    public void calculate(int a, int b){

        System.out.println(a + b);
    }
}

/*class CalcElse extends Calc{

    @Override
    public void calculate(int a, int b) {
        System.out.println(a * b);
    }
}*/
