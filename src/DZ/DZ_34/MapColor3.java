package DZ.DZ_34;
// с отдельным методом ввода размера  массива и его элементов. цвет в верхний регистр переводится про помещении элементов в HashMap
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapColor3 {
    public static void main(String[] args) {

        String[] colorArray = inputArray();

        Map<String, String> Key_Value = new HashMap<>();
        for (String color : colorArray){
            Key_Value.put(color, color.toUpperCase());
        }
        int index = 1;
        for (Map.Entry<String, String> name : Key_Value.entrySet()){
            System.out.println(index++ + ") " + name.getKey() + ": " + name.getValue());
        }

    }

    public static String[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Размер массива: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            System.out.print("--> ");
            array[i] = scanner.nextLine();

        }
        return array;

    }

}















