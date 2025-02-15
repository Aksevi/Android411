package Lesson16.Maps;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 35 0-54
public class HashMap3 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(new Key1("Виталий"), 20);
        map.put(new Key1("Александр"), 30);
        map.put(new Key1("Виталий"), 40);
        map.put(new Key1("Александра"), 25);

        System.out.println();
        System.out.println("Значение для ключа 'Виталий' : " + map.get((new Key1("Виталий"))));
        System.out.println("Значение для ключа 'Александр' : " + map.get((new Key1("Александр"))));
        System.out.println("Значение для ключа 'Александра' : " + map.get((new Key1("Александра"))));
// 35 1-20 см объяснение этой строки
        Map<Integer, String> map2 = new HashMap<>(16, 0.75f);

    }
}

class Key1 {
    String key;
// констр
    public Key1(String key) {
        this.key = key;
    }
// переопр метод alt + ins и изменяем его
    @Override
    public boolean equals(Object o) {

        return key.equals(((Key1) o).key);// ((Key1) o).key -преобразуем Object o к типу данных Key1
    }

    @Override
    public int hashCode() {
        int hash = key.charAt(0); //.charAt(0) вернет из строки символ с индекса 0(первый символ)
        System.out.println("hashCode для ключа: " + key + " = " + hash);
        return hash;
    }
}


