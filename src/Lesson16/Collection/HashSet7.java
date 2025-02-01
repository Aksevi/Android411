package Lesson16.Collection;
// 33 1-47 ищем макс знач
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSet7 {
    public static void main(String[] args) {
        Set<Integer> num = new HashSet<>();
        num.add(43);
        num.add(31);
        num.add(23);
        num.add(54);
        num.add(21);
        System.out.println(num);//[21, 54, 23, 43, 31]

        Integer max = null; // макс знач равно null. null это ничего, пустое значение
        for (Integer item : num) {// item любое имя
            if (max == null) {
                max = item;// max = 21
            } else if (max < item) {
                max = item;

            }
        }
        System.out.println("Максимальное значение: " + max);
// Collections.min() - тот же HashSet в облегченной версии
        System.out.println("Минимальное значение: " + Collections.min(num));// Collections.min(num) - минима знач. можно и так
    }
}