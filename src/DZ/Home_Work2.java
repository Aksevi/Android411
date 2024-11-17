package DZ;

public class Home_Work2 {
    public static void main(String[] args) {
        System.out.printf("-------------------------------%n");
        System.out.printf("    JAVA PRIMITIVE  TYPES      %n");
        System.out.printf("-------------------------------%n");
        System.out.printf("| %-8s | %-8s | %4s >%n","CATEGORY","  NAME","BITS" );
        System.out.printf("-------------------------------%n");
        System.out.printf("| %-1s | %-8s | %04d \\%n","Floating","double", 64);
        System.out.printf("| %-1s | %-8s | %04d  \\%n","Floating","float", 32);
        System.out.printf("| %-8s | %-8s | %04d   \\%n","Integral","long", 64);
        System.out.printf("| %-8s | %-8s | %04d    \\%n","Integral","int", 32);
        System.out.printf("| %-8s | %-8s | %04d    /%n","Integral","short", 16);
        System.out.printf("| %-8s | %-8s | %04d   /%n","Integral","byte", 8);
        System.out.printf("| %-8s | %-8s | %04d  /%n","Integral","char", 16);
        System.out.printf("| %-8s | %-8s | %04d /%n","boolean","boolean", 1);
    }
}
