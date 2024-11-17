package storonnee;

import java.util.Scanner;

public class price {
                    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                System.out.println("Рассчитать стоимость товара за килограмм");
                double sum, weight, price2; // sum - цена за кг, weght - вес упаковки, price2 - цена упаковки
                System.out.print("Введите вес упаковки в граммах: ");
                weight =  input.nextInt();
                System.out.print("Введите цену упаковки в рублях: ");
                price2 =  input.nextInt();
                sum = (price2/weight)*1000;
                System.out.printf("Цена за килограмм: %.2f", sum);

            }
        }


