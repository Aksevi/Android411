package Lesson16.Maps;

import java.util.ArrayList;
import java.util.HashMap;

//35 1-35
public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> bookPhone = new HashMap<>();
// вызов метода (пока просто добавление без вывода)
         addNumber("Зотов", 778899, bookPhone);
         addNumber("Зотов", 112233, bookPhone);
         addNumber("Калинкин", 449988, bookPhone);
         addNumber("Романов", 889922, bookPhone);
         addNumber("Зотов", 445577, bookPhone);
         addNumber("Калинкин", 116655, bookPhone);
         printBook(bookPhone);

    }
// метод добавл номеров
    public static  void addNumber(String key, int value, HashMap <String, ArrayList<Integer>> bookPhone){ //

        if(bookPhone.containsKey(key)){// если ключ есть
            bookPhone.get(key).add(value);// обращ по ключу и добавляем значение

        } else {// еслии ключа нет
            ArrayList<Integer> numberList = new ArrayList<>();// то созд массив и добавляем ключ
            numberList.add(value);
            bookPhone.put(key, numberList);
        }
    }
// метод вывода
    public static void printBook(HashMap <String, ArrayList<Integer>> bookPhone){
        for (var item : bookPhone.entrySet()){ // var - динамическая переменная (служ) - какой тип данных придет такого типа она и будет. item - имя этой переменной
            String phones = "";// изначально строка пустая
            int i = 1;// сколько изначально элементов в списке
            for (int el : item.getValue()){
                phones = phones + el + ", ";
//                phones = phones + el + (item.getValue().size() == i ? "" : ", ");// убираем запятую в конце строки 35 2-20
//                i++;
            }

            System.out.printf("%s: %s%n", item.getKey(), phones);
// подумать!!!! как убрать запятую
            System.out.printf("%s: %s%n", item.getKey(), phones.length());

        }
    }
}
