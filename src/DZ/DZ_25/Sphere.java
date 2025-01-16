package DZ.DZ_25;

import java.util.regex.Matcher;

public class Sphere extends Figure{

    public Sphere(double radius) {
        super(radius);
    }
// метод для вычисления объема. можно без @Override
    @Override
    public double getVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(getRadius(),3);
        return volume;
    }
// метод для вывода инфы. можно без @Override
    @Override
    public void info() {
        System.out.printf("Фигура: шар        | Объем фигуры: %.2f", getVolume());
        System.out.println();

    }
}
