package lesson11;
 // ур 22 1-54
public class Test {
    public static void main(String[] args) {
// создаем экземпляр класса Line
        Line l1 = new Line();
        // присваиваем значения переменным color и width. так как  Line наследуется от Properties то у него есть доступ к свойствам родительского класса (к Properties)
//        l1.color = "red";
//        l1.width = 5;
// присваимваем значения координатам x и y класса Line
//        l1.x1 = l1.y1 = 0;
//        l1.x2 = l1.y2 = 10;
 // вызываем метод  showProp
        l1.show();
// вызываем метод  show
//        l1.show();
//        l1.showId();
        System.out.println(l1.id);
        l1.id = 5;
        l1.showId();

    }
}
// у каждой геометрической фигуры есть общие свойства. они состоят из линий(отрезков) которые имеют толщину и цвет
// родительский класс
class Properties {

    int width; // толщина линии
    String color; // цвет линии
    protected int id = 1;

// конструктор Properties без  параметров
    public Properties() {
        System.out.println("Конструктор Properties");
    }

// еще один конструктор Properties с параметрами
    public Properties(int width, String color) {
        this.width = width;
        this.color = color;
        System.out.println("Конструктор Properties (width, color)");
    }

    // метод отображающий свойства
    void show(){
        System.out.println("Ширина - " + width + " px, Цвет - " + color);
    }
}
// дочерний класс линии наследуемый от родительского класса
class Line extends Properties {
    // координаты точек линии
    double x1, y1;
    double x2, y2;
    int id = 2;

    // конструктор Line
    public Line() {
    // вызываем конструктор Properties  с параметрами
        super(10, "yellow"); // super - ключ слово которое делает обращение к родительскому классу. к какому обратится - зависит от параметров в скобках. в данном случае обращается к тому который содержит 2 параметра width, color
        System.out.println("Конструктор Line");

    }

    // метод показывающий значение координат точек x и y
    @Override // аннотация, что метод переопределен ур 22 2-24
    void show (){
        super.show(); // вызываем метод show (42 стр) у родительского класса Properties
        System.out.println("Координаты линии - x1: " + x1 + ", x2: " + x2 + ", y1: " + y1 + ", y2: " + y2);
    }

// метод вызова переменной id/ значение из вложенного класса и из родительского (super.id)
    void showId(){
        System.out.println("id = " + id
                //+ ", super.id = " + super.id
                );
    }

}
// класс треугольника наследуемый от родительского класса
class Triangle extends Properties{
    double x1, y1;
    double x2, y2;
    double x3, y3;
}
