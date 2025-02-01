package Lesson16.Collection;
//32 1-00

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayList1 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Валерий");
        arrayList.add("Ирина");
        arrayList.add("Игорь");
        System.out.println(arrayList);

        ArrayList<String> arrayList2 = new ArrayList<>(20);// (20) - на сколько элементов выдел массив. первысить можно дело в скорости работы
        arrayList2.add("Валерий");
        arrayList2.add("Ирина");
        System.out.println(arrayList2);
        System.out.println(arrayList2.size());// покажет 2 так как имен 2

        List<String> arrayList3 = new ArrayList<>();// так тоже можно создавать
        arrayList3.add("Валерий");
        arrayList3.add("Ирина");
        System.out.println(arrayList3);//[Валерий, Ирина]

        ArrayList<String> arrayList4 = new ArrayList<>(arrayList);// в arrayList4 помещаем эл ты массива arrayList
        System.out.println(arrayList4);//[Валерий, Ирина, Игорь]
        arrayList4.add("Владимир");// добавили
        System.out.println(arrayList4);//[Валерий, Ирина, Игорь, Владимир]
        System.out.println(arrayList);//[Валерий, Ирина, Игорь]

        ArrayList arrayList5 = new ArrayList<>();
        arrayList5.add("Василий");// добавляем
        arrayList5.add(7);// добавляем
        arrayList5.add(true);// добавляем
        System.out.println(arrayList5);//[Василий, 7, true]

        System.out.println(arrayList5.get(1)); // -> 7 (получаем доступ к 1 эл-ту массива arrayList5)
        arrayList5.set(1, false);// заменяем 1 эл-т на значение false
        System.out.println(arrayList5);//[Василий, false, true]

        List<String> arrayList6 = new ArrayList<>();
        arrayList6.add("!!!");//добавлляем в arrayList6
        arrayList6.add("???");//добавлляем в arrayList6
        arrayList6.addAll(arrayList);// добавляем в arrayList6 все из arrayList -> [Валерий, Ирина, Игорь]
        arrayList6.addAll(1, arrayList);// добавляем в arrayList6 все из arrayList с индекса 1 -> [!!!, Валерий, Ирина, Игорь, ???, Валерий, Ирина, Игорь]
        System.out.println(arrayList6);//[!!!, ???, Валерий, Ирина, Игорь]

//        arrayList6.removeAll(arrayList);// удаляем добавленные из arrayList элементы
//        System.out.println(arrayList6);//[!!!, ???]

//        arrayList6.retainAll(arrayList);// оставляем только то что добавили из arrayList
//        System.out.println(arrayList6);//[Валерий, Ирина, Игорь, Валерий, Ирина, Игорь]
// 32 1-41
        List<String> myList = arrayList6.subList(0, 3);// переносим в myList элементы из arrayList6 с  индексов 0-3
        System.out.println(myList);//[!!!, Валерий, Ирина]

        myList.add("Борис");// добавляем в myList
        System.out.println(myList);//[!!!, Валерий, Ирина, Борис]
        System.out.println(arrayList6);//[!!!, Валерий, Ирина, Борис, Игорь, ???, Валерий, Ирина, Игорь]  - в старом списке тоже добавился Борис так как создавали myList на основе arrayList6 (см стр 55 - там subList)

        // 32 1-46
/*        // созд массив и в него зyачения arrayList6
        String[] array = arrayList6.toArray(new String[9]); //[9] должно соответсвовать размеру arrayList6 но если меньше то все равно выдаст все элементы
        for (String s : array) {
            System.out.print(s + " "); //!!! Валерий Ирина Борис Игорь ??? Валерий Ирина Игорь
            System.out.print("\n" + array.length); //*/

/*        Collections.sort(arrayList6);// сортирует по алфавиту
        System.out.println(arrayList6);// [!!!, ???, Борис, Валерий, Валерий, Игорь, Игорь, Ирина, Ирина]

        Collections.shuffle(arrayList6);
        System.out.println(arrayList6);// случайно перемешивает например -> [Ирина, Валерий, Валерий, Игорь, Борис, !!!, ???, Игорь, Ирина]*/

/*        Collections.reverse(arrayList6);// развернул
        System.out.println(arrayList6);// [Игорь, Ирина, Валерий, ???, Игорь, Борис, Ирина, Валерий, !!!]*/

        Collections.swap(arrayList6, 0, 2);// меняем местами указанные индексы
        System.out.println(arrayList6);// [Ирина, Валерий, !!!, Борис, Игорь, ???, Валерий, Ирина, Игорь]

        Iterator<String> iterator = arrayList6.iterator();
//      System.out.println(iterator);// java.util.ArrayList$Itr@3feba861
/*        while (iterator.hasNext())// вернет булевое знач если есть след элемент в коллекции. т.е. отработает столько раз сколько элементов в коллеции
        System.out.println(iterator.next());// выдаст первый элемент указанной коллекции*/

                while (iterator.hasNext()){// проверит есть ли след знач
                    iterator.next();// находит это элемент
                    iterator.remove();// удаляет его
                }
        System.out.println(arrayList6);//[]

    }
}

