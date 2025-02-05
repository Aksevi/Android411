package Lesson16.Cityes;
// 34 0-50
public class City implements  Comparable<City>{ // имплементируем и см стр 27
// здесь по сути только переменные name и code - название и код города и конструктор с геттерами для доступа к имени и коду
    private String name;
    private int code;
// констр
    public City(String name, int code) {
        this.name = name;
        this.code = code;
    }
// геттеры
    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return  "name: '" + name + '\'' +
                "; code: " + code +
                ';';
    }
// переопределяем метод Comparable (см стр3)
    @Override
    public int compareTo(City o) {
        return o != null ? name.compareTo(o.getName()) : 0;// сравнение по алфавиту но только для treeset!!!! hashset один фиг сделает как хочет
//        return (o != null && o.getName() != null && name != null) ? name.compareTo(o.getName()) : 0; // так посветовал гпт
    }
}
