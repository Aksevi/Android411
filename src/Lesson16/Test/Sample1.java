package Lesson16.Test;
// 30 51 мин

interface Printable{
// ничего не возвращает  просто печатает  строку поэтому void просто

//   void print(String s, String t); // это для работы с 20 и 21 строкой 8, 9, 15 и 16 комментируй
//    void print(String st); // это для работы с 15 и 16строкой. 7, 9, 20 и 21 комментируй
    void print(); // это для работы с 17 и 18 строкой. 7, 8, 20 и 21 комментируй
}

public class Sample1 {
    public static void main(String[] args) {
// на один параметр можно круглые скобки не ставить
//        Printable printable = s -> System.out.println(s);
//        printable.print("Hello, Java!");
        Printable printable = () -> System.out.println("Hello, Java!");  // если в метод интерфейса(9 стр) ничего не приходит то пишем так
        printable.print();
// если больше 1 принимаемого аргумента то скобки обязательны
//        Printable printable = (n, m) -> System.out.println(n + m);
//        printable.print("Hello, ", "Java!");
    }
}
