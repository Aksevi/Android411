package Lesson16.Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 33 2-07 убираем дубликкаты из массива
public class HashSet8 {
    public static void main(String[] args) {
        int[] arr = {2,5,2,7,8,8,10};
        System.out.println("Исходный массив: " + Arrays.toString(arr));//Исходный массив: [2, 5, 2, 7, 8, 8, 10]

// удалим дубликаты с помощью HashSet. он удалит повторные элементы так как хранит только уникальные
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println("HashSet : " + set);//HashSet : [2, 5, 7, 8, 10]

// созд новый массив
        int[] uniqueArr = new int[set.size()];
        int i = 0;
        for (int num : set){// num - временная переменная. идем по set типа HashSet
            uniqueArr[i++] = num;// добавляем элемент в индекс и увеличиваем индекс на 1

        }
        System.out.println("массив без дубликатов: " + Arrays.toString(uniqueArr));


    }
}
