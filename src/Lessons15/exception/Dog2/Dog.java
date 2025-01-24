package Lessons15.exception.Dog2;

// основной класс
public class Dog {
    String name;
    // булевые типы принимают true или false
    boolean isCoolarOutOn; // одет ли ошейник
    boolean isLeashPutOn; // одет ли поводок
    boolean isMuzzlePutOn; // одет ли намордник
    // контср только с именем так как принимать надо только имя
    public Dog(String name) {
        this.name = name;
    }
    // метод для ошейника
    public void putCollar(){
        System.out.println("Ошейник надет!");
        isCoolarOutOn = true;
    }
    // метод для поводка
    public void putLeash(){
        System.out.println("Поводок надет!");
        isLeashPutOn = true;
    }

    // метод для намордника
    public void putMuzzle() {
        System.out.println("Намордник надет!");
        isMuzzlePutOn = true;
    }
    // метод выхода на прогулку с потенц исключением которое создали уже
    public void walk() throws DogIsNotReadyException{
        System.out.println("Собираемся гулять");

        if (isCoolarOutOn && isLeashPutOn && isMuzzlePutOn){
            System.out.println(name + " идет гулять!" + " и " + name + " очень рад!");
        }
        else {
            throw new DogIsNotReadyException("Собака " + name + " не готова к прогулке! Проверьте экипировку!");

        }
    }
}