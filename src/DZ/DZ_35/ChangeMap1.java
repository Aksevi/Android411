package DZ.DZ_35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeMap1 {
    public static void main(String[] args) {
// создаем исходную Map. принимает String и Integer
        Map<String, Integer> inMap = new HashMap<>();
        // заполняем элементами. строки - ключ, числа - значения
        inMap.put("X", 1);
        inMap.put("Y", 2);
        inMap.put("Z", 3);
//        System.out.println("Исходный " + inMap);
// создаем пустую Map в которую будем помещать перевернутые значения - соответственно принимает она сперва Integer а потом string
//        Map<Integer, List<String>> outMap = new HashMap<>();
        Map<Integer, List<String>> outMap = new HashMap<>();
        int iteration = 1;
        // Map.Entry - служ элемент представляющий одну пару ключ-значение. то есть создали element типа Map.Entry и прошлись по исходной inMap
        for (Map.Entry<String, Integer> element : inMap.entrySet()) {
            String key = element.getKey(); // в каждой итерации помещаем в key ключ из element который принимает значение из inMap
            Integer value = element.getValue();// в каждой итерации помещаем в value значение из element который принимает значение из inMap
            outMap.putIfAbsent(value, new ArrayList<>());//.putIfAbsent проверяет на наличие value и если он есть уже то значение не добавит. а если нет то добавляет value как ключ а в качестве значения ставит новый пустой new ArrayList<>()
            outMap.get(value).add(key);// добавляет значение ключа из inMap в поле значения в outMap
// без создания переменных key и value в 21 - 22 стр
//            outMap.putIfAbsent(element.getValue(), new ArrayList<>());
//            outMap.get(element.getValue()).add(element.getKey());
//            System.out.println("Результат работы цикла for на итерации " + iteration++);
//            System.out.println(outMap);
        }
        System.out.println("Результат");
        System.out.println("Исходный " + inMap);
        System.out.println("Измененный " + outMap);
    }
}
