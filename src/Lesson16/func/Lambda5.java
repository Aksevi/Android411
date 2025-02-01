package Lesson16.func;
// 31 2-09
import java.util.function.Consumer;

public class Lambda5 {
    public static void main(String[] args) {

        Consumer<Integer> printer = x -> System.out.println(x + " рублей");
        printer.accept(700);

        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello world");
    }
}
