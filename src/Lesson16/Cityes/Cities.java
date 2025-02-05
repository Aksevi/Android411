package Lesson16.Cityes;
// 34 0-50 создаем список городов. если код четный то в hashset если нечетный то в treeset
public class Cities {
    public static void main(String[] args) {
        System.out.println("создаем список городов. если код четный то в hashset если нечетный то в treeset \n");

// экз класса (коллекции) SetCity
        SetCity cities = new SetCity();
// добавляем города  ..метод .addCity см в  SetCity
        cities.addCity("Москва", 495);
        cities.addCity("Санкт-Петербург", 812);
        cities.addCity("Омск", 183);
        cities.addCity("Томск", 712);
        cities.addCity("Пенза", 312);
        cities.addCity("Новосибирск", 955);
        cities.addCity("Новгород", 554);

        System.out.println("Количество городов " + cities.size() + "\n");

        System.out.println(cities); // выводим cities которая есть экз класса SetCity

        System.out.println("##########################################################");
        cities.removeCityByFilter(0, 5);
        System.out.println("Количество городов " + cities.size() + "\n");
        System.out.println(cities);
        System.out.println("##########################################################");
        System.out.println("Печать городов в порядке убывания: ");
        cities.printReverseSort();


    }
}
