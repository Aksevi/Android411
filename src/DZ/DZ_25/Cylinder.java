package DZ.DZ_25;

public class Cylinder extends Figure {
    private double heigth;

    public Cylinder(double radius, double heigth) {
        super(radius);
        this.heigth = heigth;
    }
// метод для вычисления объема. можно без @Override
    @Override
    public double getVolume() {
        double volume = Math.PI * Math.pow(getRadius(), 2) * heigth;
        return volume;
    }
// метод для вывода инфы. можно без @Override
    @Override
    public void info() {
        System.out.printf("Фигура: цилиндр    | Объем фигуры: %.2f", getVolume());
        System.out.println();
    }
}
