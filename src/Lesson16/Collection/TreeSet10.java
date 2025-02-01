package Lesson16.Collection;
// 33 2-41
import java.util.Set;
import java.util.TreeSet;

public class TreeSet10 {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(8);
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(3);
        System.out.println(treeSet);//[1, 3, 5, 7, 8]

//        treeSet.get(3); // индексов нет!!!

        treeSet.remove(3);// удаление по значению
        System.out.println(treeSet);//[1, 5, 7, 8]

        System.out.println(treeSet.contains(5));//true проверка есть ли такое значение
        System.out.println(treeSet.contains(2));//false проверка есть ли такое значение
    }
}
