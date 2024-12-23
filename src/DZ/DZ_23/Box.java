package DZ.DZ_23;

public class Box {
    private double weidth;
    private double heigth;

// конструктор без параметров
    public Box(){}

// конструктор  с параметрами

    public Box(double weidth, double heigth) {
//        this.weidth = weidth;
//        this.heigth = heigth;
        // так как есть гетеры и сетеры то передаем параметры так
        setWeidth(weidth);
        setHeigth(heigth);
    }

// конструктор копирования Box  - копия существующего объекта. он принимает в качестве аргумента объект того же класса Box и копирует его поля
    public Box(Box other){ // Box other - объект из которого копируются значения полей weidth и heigth
//        super(other);// не сработает. потому что super вызывает конструктор родительского класса, а так как Box не наследует ни от кого то super работать не может.
        this.weidth = other.weidth; // this указывает на текущий объект, а other это объект передаваемый в конструктор копирования
         this.heigth = other.heigth;

    }

    // геттеры и сеттеры
    public double getWeidth() {
        return weidth;
    }

    public void setWeidth(double weidth) {
        if (weidth > 0)
        this.weidth = weidth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        if (heigth > 0)
        this.heigth = heigth;
    }

}

