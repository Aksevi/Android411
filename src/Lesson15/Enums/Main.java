package Lesson15.Enums;

// enum - конструкция вывода определенных значений
enum Seasons { // Season это просто имя
//    WINTER // запятая!
//    SUMMER,
//    SPRING,
//    AUTUMN; // ВСЕГДА в enum ПОСЛЕ ПОСЛЕДНЕГО ЭЛЕМЕНТА ТОЧКА С ЗАПЯТОЙ!!!

    // если нужно с описанием как ниже то надо как стр 10-20
    WINTER("Зима"), // запятая!
    SUMMER ("Лето"),
    SPRING ("Весна"),
    AUTUMN ("Осень");

    private String title;

    Seasons(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
//        return super.toString();
        return "Seasons{" +  "title='" + title + '}';
    }
}



public class Main {
    public static void main(String[] args) {
        // обращаемся к элементу enum
        System.out.println(Seasons.WINTER);
//проходимся циклом и выводим все элементы Seasons
        for (Seasons s : Seasons.values()) {
//            System.out.println(s);
            System.out.println(s.name());
        }

        int ind = Seasons.SUMMER.ordinal(); // смотрим прорядковый номер элемента
        System.out.println(ind); // будет 1 так как отсчет с 0
        int ind1 = Seasons.AUTUMN.ordinal(); // смотрим прорядковый номер элемента
        System.out.println(ind1); // будет 3 так как отсчет с 0

/*        Seasons arg = Seasons.SPRING; // 27 23 min

        switch (arg){
            case WINTER:
                System.out.println("Зима"); break;
            case SUMMER:
                System.out.println("Лето"); break;
            case AUTUMN:
                System.out.println("Осень"); break;
            case SPRING:
                System.out.println("Весна"); break; //выведет только это так как знач arg уже определено в 32 стр
        }*/
    }
}

