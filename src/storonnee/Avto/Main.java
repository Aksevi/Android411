package storonnee.Avto;

public class Main {
    public static void main(String[] args) {
        Ford ford = new Ford(" Ford ", " Germany ", 2006, " Red ", 500000);
        System.out.println("Марка авто: " + ford.marc);

        // переназначаем данные
        ford.setMarc("Лада");
        ford.setCountry("Россия");
        ford.setManufacture(2015);
        ford.setColour("Черный");
        ford.setPrice(250000);
        System.out.println("\nНовые данные");
        System.out.println("Автомобиль марки: " + ford.getMarc() + "\nСтрана: " + "Россия" + "\nДата выпуска: " + ford.getManufacture() + "\nЦвет: " + ford.getColour() + "\nСтоимость: " +ford.getPrice());







    }
}
