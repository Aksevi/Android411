package DZ.DZ_25;

public class Pyramide extends Figure {
     private double baseArea;

    public Pyramide(double radius, double baseArea) {
        super(radius);
        this.baseArea = baseArea;
    }

    @Override
    public double getVolume() {
        double volume = (1.0 / 3.0) * baseArea * getRadius();
        return volume;
    }

    @Override
    public void info() {
        System.out.printf("Фигура: пирамида   | Объем фигуры: %.2f", getVolume());
    }
}
