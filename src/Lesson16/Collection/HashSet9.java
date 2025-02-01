package Lesson16.Collection;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class HashSet9 {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbers();
            checkDublicates(numbers);
        }catch (Dublicate_Number_Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
// метод ввода данных в массив
    public static List<Integer> readNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество чисел: ");
        int count = scanner.nextInt();
        System.out.println("Введите целые числа: ");
        for (int i = 0; i < count; i++) {
            System.out.print(" -> ");
            int num = scanner.nextInt();
            numbers.add(num);
        }
        return numbers;// см стр 17
    }
// метод проверки на дубликаты/ принимает List<Integer> number и выбрасывает исключение  Dublicate_Number_Exception
    public static void checkDublicates(List<Integer> numbers) throws Dublicate_Number_Exception{

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : numbers) {
            if(uniqueNumbers.contains(num)){
              throw new Dublicate_Number_Exception("Обнаружен дубликат: " + num);
            }
            uniqueNumbers.add(num);
        }
    }
}
// класс исключения. сами придумали он расширяет служ класс  Exception
class Dublicate_Number_Exception extends Exception {
// конструктор
    public Dublicate_Number_Exception(String message) {
        super(message);
    }
}

