package lesson10.rand;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

// ур 21 21 мин
        Random rand = new Random(); // rand (любое имя)- экземпляр класса Random и у него (экземпляра) вызываем любое значение/ Random это готовый класс который  рандомное значение выводит
        int min = 5;
        int max = 10;

        int cnt = 30;
        for (int i = 0; i < cnt; i++) {
//            System.out.println(rand.nextBoolean());
//            System.out.println(rand.nextDouble());
//            System.out.println(rand.nextInt(max)); // от 0 до max не включая
//            System.out.println(rand.nextInt(max - min) + min); // от минимального до макс знач не включая max
//            System.out.println(rand.nextInt(max - min + 1) + min); // от минимального до макс знач включая max
            System.out.println(rand.nextInt(min, max + 1)); // от минимального до макс знач включая max АНАЛОГИЧНО ПРЕДЫДУЩЕМУ

        }

    }
}
