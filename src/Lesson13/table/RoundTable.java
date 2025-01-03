package Lesson13.table;

public class RoundTable extends Table {

    public RoundTable(double radius) {
        super(radius);
    }

    @Override
    public void calcArea() {
        //%n в комбинации printf дает перенос на новую строку
        System.out.printf("Радиус: %.0f%nПлощадь: %.2f%n", getRadius(), Math.PI * Math.pow(getRadius(), 2));
    }
}
