package DZ.DZ_34;
// с отдельным классом Color в котором сразу переводится цвет в верхний регистр
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapColor {
    public static void main(String[] args) {
// массив
//        String[] colors = {"red", "orange", "aqua", "pink", "gray", "blue", "white", "black", "yellow", "brown"}; // можно так
// а можно и  так
        String[] colors = new String[10];
        colors[0] = "red";
        colors[1] = "orange";
        colors[2] = "aqua";
        colors[3] = "pink";
        colors[4] = "gray";
        colors[5] = "blue";
        colors[6] = "white";
        colors[7] = "black";
        colors[8] = "yellow";
        colors[9] = "brown";
// создаем HashMap/ Key_Value просто имя. в скобках принимаемые значения - String это текст и Color - это значения типа класс Color
        Map<String, Color> Key_Value = new HashMap<>();

// создаем временную переменную  типа String, проходим по массиву colors и по очереди его элементы кладем в color
        for (String color : colors){
//  Key_Value это наш HashMap, .put - помещает в него значение - временной переменной color(она же ключ) и новый созданный класс Color который хранит значение color в верхнем регистре.(при вызове new Color(red) в конструктор передается red и там за счет .toUpperCase  переводится в RED)
            Key_Value.put(color, new Color(color));
        }
        int index = 1;// индекс для вывода порядкового номера
// выводим результат. создаем временную name типа Map.Entry<String, Color> и проходим по HashMap c именем Key_Value и помещаем по очереди в name элементы из  Key_Value
        for (Map.Entry<String, Color> name : Key_Value.entrySet()){

// выводим. index++ передает первоначальное значение (1) и после вывода строки увеличивается на 1 и так до конца цикла
            System.out.println(index++ + ") " + name.getKey() + ": " + name.getValue());
        }

    }
}
// класс Color
class Color{
    private String name;
// конструктор
    public Color(String name) {
        this.name = name.toUpperCase();
    }
// переопределенный метод класса Color
    @Override
    public String toString() {
        return name;// возвращает name которое уже toUpperCase
    }
}
