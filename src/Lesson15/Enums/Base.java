package Lesson15.Enums;

import java.util.regex.Pattern;

// 27 43 min
enum RegEx{
    // по регулярным выражениям см дз чтобы вспомнить в каком уроке рассматривали
    UPPER ("[A-Z]+"),
    LOWER("[a-z]+"),
    NUMBER("[+-]?[0-9]+"); // ищет + - и любые цифры [0-9] ? значит может быть может не быть. + любое количество


    private final Pattern pattern; // Pattern  так как с регулярными выражениями работаем

    RegEx(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
    // проверяем совпадения
    public boolean test (final String input){ // boolean потому что либо true либо false
        return pattern.matcher(input).matches();

    }
}

public class Base {
    public static void main(String[] args) {

        System.out.println(RegEx.UPPER.test("ABC")); // вызываем метод test для элемента UPPER класса enum
        System.out.println(RegEx.LOWER.test("abc")); // вызываем метод test для элемента LOWER класса enum
        System.out.println(RegEx.NUMBER.test("+123")); // вызываем метод test для элемента NUMBER класса enum

    }
}
