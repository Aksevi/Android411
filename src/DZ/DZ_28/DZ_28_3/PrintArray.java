package DZ.DZ_28.DZ_28_3;

public class PrintArray {

    public static <T> void Display(T[]array){
        for (T e : array){
            System.out.print(e + " ");
        }
        System.out.println();
    }
}
