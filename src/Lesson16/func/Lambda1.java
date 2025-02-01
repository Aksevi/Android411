package Lesson16.func;

import java.util.function.Predicate;

public class Lambda1 {
    public static void main(String[] args) {
//        Predicate<Integer> isPositive = x -> x > 0; // true или false/ isPositive просто имя
//        System.out.println(isPositive.test(5));//true
//        System.out.println(isPositive.test(0));//false
//        System.out.println(isPositive.test(-5));//false
// 31 53 является ли строка палиндромом
        Predicate<String> isPalindrome = str -> { // 12-17 лямбда выражение
// StringBuilder (служ) - изменяемая строка  / .reverse().toString разворот строки
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed); // равны ли строки или нет. результат true или false

        };
        String word1 = "Мадам";
        String word2 = "радар";
        boolean res = isPalindrome.test(word1);
        boolean res2 = isPalindrome.test(word2);
        System.out.println(word1 + " это палиндром: " + res);
        System.out.println(word2 + " это палиндром: " + res2);
    }
}
