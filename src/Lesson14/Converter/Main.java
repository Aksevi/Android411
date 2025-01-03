package Lesson14.Converter;

// 26 начало
public class Main {
    public static void main(String[] args) {
    double temp = 21.5; // изначальная температура которую преобразуем
    final int N = 3; // кол-во элементов массива
 //  экз класса Converter в  виде массива
    Converter converter [] = new Converter[N];
    converter[0] = new CelsiusConverter();
    converter[1] = new KelvinConverter();
    converter[2] = new FarenheitConverter();

    for (Converter c : converter){ // проходим по массиву
        System.out.println("t = " + c.getConvertedValue(temp));
          }
    }
}

// интерфейс
interface Converter{
    // объявляем метод. getConvertedValue - название наше, baseValue - наше название переменной
   double getConvertedValue(double baseValue);
}
// созд класс обращающийся к интерфейсу
class CelsiusConverter implements Converter{

// переопределяем метод
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue; // возвращает исходную температуру которую задали в гл классе
    }
}
// созд еще один класс обращающийся к интерфейсу
class KelvinConverter implements Converter{

    // переопределяем метод
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue + 273.15;
    }
}
// созд еще один класс обращающийся к интерфейсу
class FarenheitConverter implements Converter{

    // переопределяем метод
    @Override
    public double getConvertedValue(double baseValue) {
        return 1.8 * baseValue + 32;
    }
}