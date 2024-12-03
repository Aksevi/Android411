package DZ;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DZ_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Найти корректный адрес электронной почты");

 //      System.out.print("Введи почту и нажми ввод -> "); // работает. при разкоментировании закоментируй строку 17
 //      String text = scanner.nextLine(); // вводим почту

        String text = "123456@i.ru, 123_456@ru.name.ru, login@i.ru, логин-1@i.ru, log-1@i.ru,  login.3@i.ru, login.3-67@i.ru, 1login@ru.name.ru";

        String pattern = "[А-Яа-яA-Za-z0-9-._]+@[A-Za-z_-]+.?[A-Za-z-_]+.[A-Za-z]?[A-Za-z]?";



        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


