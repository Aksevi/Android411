package DZ;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Написать слово \"копеек\" в правильном формате (диапазон от 1 до 99)");

        int n, lastdigit;
        System.out.print("Ведите число от 1 до 99: ");
        n = input.nextInt();
        lastdigit = n%10;// n%10; // находим последнюю цифру из введенного числа
        if (n < 1 || n > 99) {
            System.out.println("число вне диапазона");
        } else if (lastdigit == 1 && n != 11){
            System.out.println(n + " копейка");
        } else if (lastdigit >=2 && lastdigit <=4 && (n < 12 || n > 14)){
            System.out.println(n + " копейки");
        } else  {
            System.out.println(n + " копеек");
        }


        input.close();






      }

    }


//        int n;
//        n = input.nextInt();
//        System.out.println(n%10); // находим последнюю цифру из введенного числа