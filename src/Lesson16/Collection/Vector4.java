package Lesson16.Collection;

import java.util.Vector;

// 33 33 min
public class Vector4 {
    public static void main(String[] args) {
//Vector служ класс
        Vector<String> vector = new Vector<>();
        vector.add("Сергей");
        vector.add("Михаил");
        vector.add("Николай");
        vector.add("Виктор");
        System.out.println(vector);

        System.out.println(vector.firstElement());// первый элемент
        System.out.println(vector.lastElement());// посл элемент

        vector.remove(2);//удаляем по индексу
        System.out.println(vector);
        System.out.println(vector.get(1));// выводим  элемент по  индексу

    }
}
