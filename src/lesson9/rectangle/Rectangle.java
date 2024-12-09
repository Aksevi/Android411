package lesson9.rectangle;


// ур 20 2-35

import java.util.regex.Matcher;

public class Rectangle {
    private int length;
    private int weight;

    // конструктор
    public Rectangle(int length, int weight) {

        this.length = length;
        this.weight = weight;

    }

    // геттеры
    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    // сеттеры
    public void setLength(int length) {
        if (length > 0)
            this.length = length;
    }

    public void setWeight(int weight) {
        if (weight > 0)
            this.weight = weight;
    }

    // метод вычисления площади
    public int getArea() { // getArea имя. любое
        return length * weight;

    }

    public int getPerimetr() {
        return 2 * (length + weight);
    }

    public double getHipotenuse() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(weight, 2));

    }
// метод рисования фигуры из * с заданными сторонами
    public void getFigure() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < weight; j++) {
                System.out.print("*");

            }
            System.out.println();
        }

    }
}











