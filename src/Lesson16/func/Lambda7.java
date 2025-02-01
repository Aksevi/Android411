package Lesson16.func;
// 31 2-23
import java.util.function.BinaryOperator;

public class Lambda7 {
    public static void main(String[] args) {

        BinaryOperator<Integer> name = (x, y) -> x * y;
        System.out.println(name.apply(3, 2));
        System.out.println(name.apply(3, -2));
    }
}
