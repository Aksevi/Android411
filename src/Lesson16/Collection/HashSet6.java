package Lesson16.Collection;
// 33 1-17
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet6 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        a.addAll(Arrays.asList(1,2,3,4,5,6,7));
        b.addAll(Arrays.asList(5,6,7,8,9));

        System.out.println(a);//[1, 2, 3, 4, 5, 6, 7]
        System.out.println(b);//[5, 6, 7, 8, 9]

// объединяем элементы
    HashSet<Integer> union = new HashSet<>(a); // новый элемент для объединения чтобы исходники не перезаписались
        System.out.println("union изначально: " + union);//union изначально: [1, 2, 3, 4, 5, 6, 7]

        union.addAll(b); // объединение двух сетов a и b. только неуникальных. дубликаты убрал
        System.out.println("union после объединения: " + union);//union после объединения: [1, 2, 3, 4, 5, 6, 7, 8, 9]

// нахождение общих элементов их двух сетов
        HashSet<Integer> intersect = new HashSet<>(a);
        intersect.retainAll(b);// общие элементы из двух сетов
        System.out.println("intersect (общие элементы): " + intersect);//intersect(общие элементы): [5, 6, 7]

// есть в первом но нет во втором сете
        HashSet<Integer> subtract = new HashSet<>(a);
        subtract.removeAll(b);
        System.out.println("subtract (остались те которые есть в 1 нет во 2 сете): " + subtract);//subtract (остались те которые есть в 1 нет во 2 сете): [1, 2, 3, 4]

    }
}
