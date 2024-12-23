package DZ.DZ_23;

public class Main {
    public static void main(String[] args) {

// экз класса Box3D
        Box3D box3D = new Box3D(5.0, 3.0, 2.0);


//        System.out.println("Ширина: " + box3D.getWeidth());
//        System.out.println("Высота: " + box3D.getHeigth());
//        System.out.println("Глубина: " + box3D.getDepth());
        System.out.println("Объем: " + box3D.volume() + "\n");

        // переназначаем значения переменных
        box3D.setWeidth(10.0);
        box3D.setHeigth(5.0);
        box3D.setDepth(7.0);
        System.out.println("Новые значения");
        System.out.println("Ширина: " + box3D.getWeidth());
        System.out.println("Высота: " + box3D.getHeigth());
        System.out.println("Глубина: " + box3D.getDepth());
//        System.out.println("Объект Box3D {ширина = 10.0, высота = 5.0, глубина 7.0}");
        System.out.println("Объект Box3D {ширина = " + box3D.getWeidth() + " высота = " + box3D.getHeigth() + " глубина = " + box3D.getDepth() +"}");
        System.out.println("Объем: " + box3D.volume());


    }
}
