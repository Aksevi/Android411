package Lesson16.Test;
// 31 27
@FunctionalInterface // аннотация не дающая создать больше одного метода в интерфейсе если это требуется. раскоментирй стр 6 и будет ошибка
interface Operation{
    int execute(int x, int y); // метод типа int с именем execute принимающий интовые значения
//    String concat(String a, String b);// метод типа String с именем concat принимающий строковые значения
}

public class LambdaApp {
    public static void main(String[] args) {
        Operation func = action(1); // переменная func типа данных интерфейса Operation/ func работает с методом action то есть 1 значит case 1
        int a = func.execute(6, 5);
        System.out.println(a);

        int b = action(2).execute(8, 2); // то же самое что и стр 10 - 11 но с выбором case 2
        System.out.println(b);
    }

// статич метод возвращает тип данных интерйфейса Operation и принимает int значение
    private static Operation action(int number){
      switch (number){
          case 1: return (x, y) -> x + y;
          case 2: return (x, y) -> x - y;
          case 3: return (x, y) -> x * y;
          default: return (x, y) -> 0;
      }
    }
}
