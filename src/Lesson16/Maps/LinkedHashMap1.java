package Lesson16.Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 35 2-45
public class LinkedHashMap1 {
    public static void main(String[] args) {
//        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
// 35 2-50
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(1, "obj1");
        linkedHashMap.put(15, "obj15");
        linkedHashMap.put(4, "obj4");
        linkedHashMap.put(38, "obj38");

        System.out.println(linkedHashMap);// как создали так и вывел.

        System.out.println(linkedHashMap.get(4));// доступ по ключу
        System.out.println(linkedHashMap.get(1));
        System.out.println(linkedHashMap);//

    }
}
