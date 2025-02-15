package Lesson15.exception;
// 29 2-08
public class Test4 {
    public static void main(String[] args) {

        try{
            ex();
        } catch (Exception e) {
            System.out.println(e); //java.lang.RuntimeException: Hello Exception
            System.out.println(e.getMessage()); // Hello Exception
            e.printStackTrace(); // выбрасывает текст в консоли Hello Exception

        }

        System.out.println("Текст ниже"); // отработает но потом выдаст рез-т 11 строки
    }
// класс исключения
    public static void ex() throws RuntimeException{ // RuntimeException служебное имя
        throw new RuntimeException("Hello Exception");

    }
}
