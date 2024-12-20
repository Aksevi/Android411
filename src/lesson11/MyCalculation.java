package lesson11;
// ур 22 1-45
//extends означает что класс MyCalculation будет иметь доступ к свойствам и методам класса Calculation
public class MyCalculation extends Calculation{
    public void multiplication(int x, int y){
        z = x * y;
        System.out.println("Произведение: " + z);
    }

}
