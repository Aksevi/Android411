package Lesson16.func;
// 31 2-14
import java.util.function.UnaryOperator;

public class Lambda6 {
    public static void main(String[] args) {

        UnaryOperator<Integer> name = x -> x * x;
//        UnaryOperator<String> name1 = x -> x + x;
        System.out.println(name.apply(5));
//        System.out.println(name1.apply("Hello "));

        UnaryOperator<String> name3 = s -> s.toUpperCase();
        System.out.println(name3.apply("Java code"));
    }
}
