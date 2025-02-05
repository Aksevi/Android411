package Lesson16.Maps;
// 34 2-48
import java.util.HashMap;
import java.util.Map;

public class HashMap1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
// .put добавить элемент в map
        map1.put(334455, "Михаил Борисов");
        map1.put(778899, "Ринат Зуев");
        map1.put(664477, "Роман Свиридов");
        map1.put(225566, "Анна Полякова");
        map1.put(115566, "Анна Полякова");
        map1.put(334455, "Ирина Мельник");
        map1.put(null, "Виктор Водник");
        map1.put(337788, null);

        System.out.println(map1);//  порядок вывода не зависит от порядка ввода/ ключи должны быть уникальными. если повторяются то выведет последний добавленный элемент с повторяющимся ключом


    }
}
