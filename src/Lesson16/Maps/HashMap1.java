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
//        map1.put(334455, "Ирина Мельник");// перезапишет уже имеющееся значение если ключ повторится
        map1.put(null, "Виктор Водник");
        map1.put(337788, null);
        map1.putIfAbsent(334455, "Ирина Мельник");// .putIfAbsent проверяет на наличие ключа и если он есть уже то значение не добавит

        System.out.println(map1);//  порядок вывода не зависит от порядка ввода/ ключи должны быть уникальными. если повторяются то выведет последний добавленный элемент с повторяющимся ключом

        System.out.println(map1);
        System.out.println(map1.get(778899));// доступ по ключу
        System.out.println(map1.get(448899));// доступ по ключу. если ключа нет то выдаст null
        map1.remove(778899); // удаление по ключу
        System.out.println(map1.get(778899));// null (доступ по ключу. значение удалено)
        System.out.println(map1.containsValue("Роман Свиридов"));// .containsValue содержит ли значение. выдаст true или false
        System.out.println(map1.containsValue("Ринат Зуев"));// .containsValue содержит ли значение. выдаст true или false
        System.out.println(map1.containsKey(778899));// .containsKey содержит ли ключ. выдаст true или false
        System.out.println(map1.keySet());// .keySet() - [null, 334455, 664477, 337788, 225566, 115566] -проверка всех ключей
        System.out.println(map1.values());// .values() - [Виктор Водник, Михаил Борисов, Роман Свиридов, null, Анна Полякова, Анна Полякова] -проверка всех значений


    }
}
