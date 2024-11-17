package storonnee;

import java.util.Scanner;

public class Etazh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Покажет на каком этаже квартира");
        float N, K1, K2, K, Q, E; // N - количество этажей, K1 - первая кв. в подъезде, K2 - последняя кв. в подъезде, K - искомая квартира, Q - кол-во кв. на этаже, E - этаж
        System.out.print("Введите количество этажей: ");
        N =  input.nextInt();
        System.out.print("Введите номер первой квартиры: ");
        K1 =  input.nextInt();
        System.out.print("Введите номер последней квартиры: ");
        K2 =  input.nextInt();
        System.out.print("Введите номер искомой квартиры: ");
        K =  input.nextInt();
        Q = (K2 - K1 + 1) / N;
        E = (K - K1 + 1) / Q;
//        System.out.println(E);
//        System.out.println(Q);
                System.out.printf("Квартира " + (int)K + " находится на " + (int) Math.ceil(E) + " этаже");

    }
}
