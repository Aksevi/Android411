package DZ;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DZ_19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Введи номер и нажми ввод -> ");
//        String phone = scanner.nextLine();

        String phone = "+7 499 456-45-78, +74994564578, 7 (499) 456 45 78, 7 (499) 456-45-78, +7 499 456-45-58888";

//        String pattern = "\\+?7\\s*\\(?[0-9]{3}\\)?\\s*[\\d\\s*\\-*]{7,9}";
//        String pattern = "^\\+?7\\s*\\(?[0-9]{3}\\)?\\s*\\-*[0-9\\-*\\s*]{7,9}$";

        String pattern = "\\+?7\\s*\\(?[0-9]{3}\\)?\\s*\\-*[0-9]{3}\\s*\\-*[0-9]{2}\\s*\\-*[0-9]{2}";



        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phone);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
