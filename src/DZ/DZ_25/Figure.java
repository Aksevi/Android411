package DZ.DZ_25;

public abstract class Figure {
// за общее свойство берем высоту. у шара это радиус но это та же высота у наc будет
    private double radius;

// конструкторы
    public Figure(double radius) {
        this.radius = radius;
    }
// геттеры и сеттеры
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
// метод вычисления объема
    public abstract double getVolume();
// вывод информации
    public abstract void info();
}
