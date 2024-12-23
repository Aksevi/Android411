package lesson11.shapes;

public class Figure {
    private String color;

// конструктор без параметров нужен всегда если классы наследуем.
public Figure(){}

// конструктор
    public Figure(String color) {
        this.color = color;
    }
// геттеры и сеттеры
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
