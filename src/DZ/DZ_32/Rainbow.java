package DZ.DZ_32;

import java.util.*;

public class Rainbow {
    public static void main(String[] args) {

// экземпляры класса RainbowList
        RainbowList colour0 = new RainbowList(0, "Красный");
        RainbowList colour1 = new RainbowList(1, "Оранжевый");
        RainbowList colour2 = new RainbowList(2, "Жёлтый");
        RainbowList colour3 = new RainbowList(3, "Зелёный");
        RainbowList colour4 = new RainbowList(4, "Голубой");
        RainbowList colour5 = new RainbowList(5, "Синий");
        RainbowList colour6 = new RainbowList(6, "Фиолетовый");


// создаем список ArrayList класса RainbowList
//        LinkedList<RainbowList> name = new LinkedList<>();
        ArrayList<RainbowList> name = new ArrayList<>();
// добавляем в этот список значение экземпляров класса
        name.add(colour0);
        name.add(colour1);
        name.add(colour2);
        name.add(colour3);
        name.add(colour4);
        name.add(colour5);
        name.add(colour6);

        System.out.println("Список: " + name);// выводим список в [ ]
        System.out.println();

// создаем итератор ListIterator<RainbowList> который позволяет перемещаться по списку ArrayList<RainbowList> с начального индекса (0)
        ListIterator<RainbowList> listIterator = name.listIterator();
//перебор списка в прямом направлении. listIterator.hasNext() проверяет наличие след элемента,  listIterator.nextIndex() получает след элемент. listIterator.next() сдвигает итератор вперед и возвращает текущий элемент.  .colour берет значение цвета из класса RainbowList
        System.out.println("Список итераторов в прямом направлении: ");
        while (listIterator.hasNext()){
            System.out.println("Index = " + listIterator.nextIndex()  + ", Element = " + listIterator.next());
        }

        System.out.println();

        System.out.println("Список итераторов в обратном направлении: ");
// перебор списка в обратном направлении. listIterator.hasPrevious() проверяет есть ли предыдущий элемент, listIterator.previousIndex()  получает предыдущий элемент. listIterator.previous() сдвигает итератор назад и возвращает текущий элемент. .colour  берет значение цвета из класса RainbowList
        while (listIterator.hasPrevious()) {
//            System.out.println("Index = " + listIterator.previousIndex() + ", Element = " + listIterator.previous().colour);
            System.out.println("Index = " + listIterator.previousIndex() + ", Element = " + listIterator.previous());
        }
    }
}
// класс RainbowList
class RainbowList {
// переменные класса
    String colour;
    int index;

// конструктор
    public RainbowList(int index, String colour) {
        this.colour = colour;
        this.index = index;
    }

// метод класса RainbowList
    @Override
    public String toString() {

        return colour; // то что вернет метод
    }

}






