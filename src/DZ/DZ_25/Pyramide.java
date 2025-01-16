package DZ.DZ_25;

public class Pyramide extends Figure {
     private double baseArea;

    public Pyramide(double radius, double baseArea) {
        super(radius);
        this.baseArea = baseArea;
    }
// метод для вычисления объема. можно без @Override
    @Override
    public double getVolume() {
        double volume = (1.0 / 3.0) * baseArea * getRadius();
        return volume;
    }
// метод для вывода инфы. можно без @Override
    @Override
    public void info() {
        System.out.printf("Фигура: пирамида   | Объем фигуры: %.2f", getVolume());
    }
}
