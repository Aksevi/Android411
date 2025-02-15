package Lesson16.Maps;
//36 0-17
import java.util.Hashtable;

public class HashTable1 {
    public static void main(String[] args) {
        Hashtable<Integer, String> ht1 = new Hashtable<>(4);
        Hashtable<Integer, String> ht2 = new Hashtable<>(2);

        ht1.put(1,"one");
        ht1.put(2,"two");
        ht1.put(3,"three");

        ht2.put(4,"four");
        ht2.put(5,"five");
        ht2.put(6,"six");

        System.out.println("ht1: " + ht1);
        System.out.println("ht2: " + ht2);
    }
}
