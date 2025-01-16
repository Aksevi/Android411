package Lessons15.Generics;
// 27 1-55
public class Main {
    public static void main(String[] args) {

        Integer[] intArray = {2, 1, 5, 3, 4};
        Double[] doubleArray = {3.3, 2.2, 1.1, 4.4,};
        Character[] charArray = {'G', 'e', 'n', 'e', 'r', 'i', 'c'};
// вывод результата метода printArray
        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);

    }

    // выносим цикл в отдельный метод
    // <T> это generic - делает обобщенный метод для разных типов данных. без нее пришлось бы три метода одинаковых с разным типом данных. не работает с примитивными типами - только с обертками Integer и тд
    public  static <T> void printArray(T[] inputArray){ // <T> (T это имя можно как хочешь, но принято называть Т)
        for (T element: inputArray){
            System.out.printf("%s ",element);
        }
        System.out.println();
    }
}
