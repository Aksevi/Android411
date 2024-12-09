package DZ.dz_20;

import java.util.Scanner;

public class Auto {

    private String model;
    private String year;
    private String marc;
    private String power;
    private String colour;
    private String price;

// конструктор
    Auto() {

    }
// метод
    public Auto(String model, String year, String marc, String power, String colour, String price) {
        this.model = model;
        this.year = year;
        this.marc = marc;
        this.power = power;
        this.colour = colour;
        this.price = price;
    }
// геттеры и сеттеры
    public String getModel() { //  геттер получаем значение
        return model;
    }

    public void setModel(String model) { // сеттер установили
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    // метод printInfo
    public void printInfo(){
        System.out.println("********** Данные автомобиля **********");
        System.out.println("Модель:      " + this.model);
        System.out.println("Год выпуска: " + this.year);
        System.out.println("Марка:       " + this.marc);
        System.out.println("Мощность:    " + this.power);
        System.out.println("Цвет:        " + this.colour);
        System.out.println("Цена:        " + this.price);
        System.out.println("========================================");
    }
}

