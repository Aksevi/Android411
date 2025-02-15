package Lesson15.Generics;

import java.util.ArrayList;

// 27 2 -28
public class Sample2 {
    public static void main(String[] args) {
        PrintList<Integer> pl = new PrintList<>();
        for (int i = 0; i < 10; i++) {
            pl.add(i);
        }
        System.out.println(pl);

//        pl.printlist(true);
        pl.printlist(false);


    }
}

class PrintList<T>{
    private ArrayList<T> list; // список ArrayList. <T> - generic

    public PrintList() {
        this.list = new ArrayList<T>();
    }

    public void add(T data){
        list.add(data);
    }

    public void printlist(boolean isOdd){
        if (isOdd){
            for (int i = 1; i < list.size(); i += 2) { // ищем нечетные начинаем с 1-го элемента и берем каждый второй элемент
                System.out.print(list.get(i) + " "); // вывод нечетных комменти 15 стр
            }
        } else {
            for (int i = 0; i < list.size(); i +=2 ) { // ищем нечетные начинаем с 0-го элемента и берем каждый второй элемент
                System.out.print(list.get(i) + " "); // вывод четных комменти 14 стр
            }
        }

    }
// можно убрать. чисто для инфы
    @Override
    public String toString() {
        return "PrintList" + list;
    }
}