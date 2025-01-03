package DZ.DZ_25;

import java.util.regex.Matcher;

public class Sphere extends Figure{

    public Sphere(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(getRadius(),3);
        return volume;
    }

    @Override
    public void info() {
        System.out.printf("Фигура: шар        | Объем фигуры: %.2f", getVolume());
        System.out.println();

    }
}
