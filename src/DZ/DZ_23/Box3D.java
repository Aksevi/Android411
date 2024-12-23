package DZ.DZ_23;

public class Box3D extends Box{
    // глубина фигуры
    private double depth;

    // конструктор. так как Box3D наследуется от Box то у него в конструкторе есть параметры Box (weidth и heigth) и параметры Box3D (depth)
    public Box3D(double weidth, double heigth, double depth) {
// super указывает на те параметры какие мы забираем из родительского класса Box
        super(weidth, heigth);
// здесь мы указываем параметр которого нет в родительском классе, (но он есть в дочернем)классе и который надо добавить в конструктор
        setDepth(depth);

        System.out.println("Объект Box3D {ширина = " + weidth + " высота = " + heigth + " глубина = " + depth +"}");

    }

// этот конструктор принимает данные из класса Box в Box 3D
    public Box3D(Box box, double depth){
// ключ super указывает на то, что мы берем из родительского класса Box его параметры
        super(box);
        setDepth(depth);
    }

    // геттеры и сеттеры
    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        if (depth > 0)
        this.depth = depth;
    }
    // метод подсчета объемы фигуры
    public double volume (){
        return getWeidth() * getHeigth() * depth;
    }
}


