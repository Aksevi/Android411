package Lessons15.generics_programm;
// 28 2-07
public class FigureStatistic <T extends Figure> {
    // созд переменную (массив)
    T[] arr;

    // констр
    public FigureStatistic(T[] arr) {
        this.arr = arr;
    }
// сумма площадей

    public double getSumArea() {
        double result = 0;

        for (int i = 0; i < arr.length; i++) {
            result += arr[i].getArea(); // .getArea считает площадь элемента массива по индексу i
        }
        return result;
    }

    // макс знач площадей
    public double getMaxArea() {
        double maxArea = Double.MIN_VALUE; // переменная с мин значением

        for (int i = 0; i < arr.length; i++) {
            if (maxArea < arr[i].getArea()) { // в цикле сравниваем знач с минимальным и если оно больше то перезаписываем мимнимальное
                maxArea = arr[i].getArea();
            }

        }
        return maxArea;
    }

    // мин знач площадей
    public double getMinArea() {
        double minArea = Double.MAX_VALUE; // переменная с макс значением

        for (int i = 0; i < arr.length; i++) { // в цикле сравниваем знач с макс и если оно меньше то перезаписываем максимальное
            if (minArea > arr[i].getArea()) {
                minArea = arr[i].getArea();
            }

        }
        return minArea;
    }
}
