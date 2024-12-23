package storonnee.Avto;

public class Ford extends Avto{
    String colour;
    int price;

    public Ford(String marc, String country, int manufacture, String colour, int price) {
        super(marc, country, manufacture);
//        this.colour = colour;
//        this.price = price;
        setColour(colour);
        setPrice(price);
        System.out.println("Автомобиль марки " + marc + "\nСтрана "+ country + "\nДата выпуска " + 2006 + "\nЦвет " + colour + "\nстоимость " + 500000);
       }
 // конструктор принимает данные из родительского класса Avto
       public Ford(Avto avto, String colour, int price){
        super(avto);
        setColour(colour);
        setPrice(price);
       }
// геттеры и сеттеры
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
