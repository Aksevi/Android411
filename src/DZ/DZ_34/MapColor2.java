package DZ.DZ_34;
// без отдельного класса . цвет переводится  в верхний регистр при помещении в HashMap стр 27
import java.util.HashMap;
import java.util.Map;

public class MapColor2 {
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
// создаем HashMap/ Key_Value просто имя/ в скобках принимаемые значения - String это текст - принимает текстовые значения из массива . принимает их в два поля - и в ключ и в самот значение цвета -> (red, red)
        Map<String, String> Key_Value = new HashMap<>();
// создаем временную переменную типа String color, проходим по массиву colors и по очереди его элементы кладем в color
        for (String color : colors){
//  Key_Value это наш HashMap, .put - помещает в него значение - временной переменной color(она же ключ) и color как значение. за счет .toUpperCase переводится в верхний регистр red становится RED)
            Key_Value.put(color, color.toUpperCase());
        }
        int index = 1;// индекс для вывода порядкового номера
// выводим результат. создаем временную name типа Map.Entry<String,  String> и проходим по HashMap c именем Key_Value и помещаем по очереди в name элементы из  Key_Value
        for (Map.Entry<String, String> name : Key_Value.entrySet()){
// выводим. index++ передает первоначальное значение (1) и после вывода строки учеличивается на 1 и так до конца цикла
            System.out.println(index++ + ") " + name.getKey() + ": " + name.getValue());
        }

    }
}

