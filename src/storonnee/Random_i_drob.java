package storonnee;

public class Random_i_drob {
    public static void main(String[] args) {
        double a = (Math.random() * (16 - 2) + 2); // знач случ от 16 до 2  включая 2 и 15
        System.out.println(a); //выведет в формате число.0 -> 2.0 и тд
        System.out.println((int)a); //выведет без дробной части
        System.out.printf("%.0f%n",a); //выведет без дробной части
    }
}
