package lesson11;
// ур 22 1-45
public class Main {
    public static void main(String[] args) {
        int a = 20, b = 10;
        // создаем класс
        MyCalculation calc = new MyCalculation();
        calc.addition(a, b);
        calc.subtraction(a, b);
        calc.multiplication(a, b);
    }
}
