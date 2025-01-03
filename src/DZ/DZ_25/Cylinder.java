package DZ.DZ_25;

public class Cylinder extends Figure {
    private double heigth;

    public Cylinder(double radius, double heigth) {
        super(radius);
        this.heigth = heigth;
    }

    @Override
    public double getVolume() {
        double volume = Math.PI * Math.pow(getRadius(), 2) * heigth;
        return volume;
    }

    @Override
    public void info() {
        System.out.printf("Фигура: цилиндр    | Объем фигуры: %.2f", getVolume());
        System.out.println();
    }
}
