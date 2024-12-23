package storonnee.Avto;

public class Avto {

    String marc;
    String country;
    int manufacture;

    public Avto(){}
// конструктор
    public Avto(String marc, String country, int manufacture) {
//        this.marc = marc;
//        this.country = country;
//        this.manufacture = manufacture;
        setMarc(marc);
        setCountry(country);
        setManufacture(manufacture);
    }

 // класс копирования

    public Avto(Avto other){
        this.marc = other.marc;
        this.country = other.country;
        this.manufacture = other.manufacture;


    }

    // геттеры и сеттеры
    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getManufacture() {
        return manufacture;
    }

    public void setManufacture(int manufacture) {
        this.manufacture = manufacture;
    }


}
