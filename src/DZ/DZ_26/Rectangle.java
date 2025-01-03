package DZ.DZ_26;

public class Rectangle implements Resize{
    private int width;
    private int heigth;

// конструктор

    public Rectangle(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
    }

// переопределяем методы
    @Override
    public void resizeWidth(int width) {
        this.width = width;
    }

    @Override
    public void resizeHeigth(int heigth) {
        this.heigth = heigth;

    }
    public void display(){
        System.out.println("Width: " + width + " Heigth: " + heigth);
    }
}


