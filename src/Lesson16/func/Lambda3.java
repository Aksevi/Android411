package Lesson16.func;

import java.util.Date;
import java.util.function.Function;
//31 1-45
public class Lambda3 {
    public static void main(String[] args) {
// приходит Integer возвращается String
        Function<Integer, String> covert = x -> String.valueOf(x) + " долларов";
        System.out.println(covert.apply(5));

        Function<Double, Long> function = d -> Math.round(d);
        System.out.println(function.apply(5.7));
    }
}

