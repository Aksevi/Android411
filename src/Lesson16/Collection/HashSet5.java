package Lesson16.Collection;

import java.util.HashSet;
import java.util.Set;

public class HashSet5 {
    public static void main(String[] args) {
// Set и  HashSet служ классы set - любое имя
        Set<String> set = new HashSet<>();

        set.add("Валентин");
        set.add("Николай");
        set.add("Григорий");
        set.add("Александр");
        set.add("Александр");
// свой порядок мы соблюсти не можем!! выведет по своей логике. индексов как таковых нет
        System.out.println(set); // [Александр, Николай, Валентин, Григорий]
//        System.out.println(set.getClass(2)); // получить по индексу через get не выйдет!!!

        set.add("Марк");
        System.out.println(set); // [Марк, Александр, Николай, Валентин, Григорий]

        set.remove("Александр"); // удаляем не по индексу а по значению
        set.remove("Марк1"); // если элемента нет то ничего не произойдет
        System.out.println(set.size());// 4 - .size() покажет размер
        System.out.println(set.contains("Марк"));// true .contains() true/false есть ли значение

        set.add(null);// null - служ пустое значение
        System.out.println(set);// [Марк, null, Николай, Валентин, Григорий]

        for (String s : set) {
            System.out.println(s);
            
        }

    }
}
