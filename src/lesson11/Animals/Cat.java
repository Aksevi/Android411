package lesson11.Animals;

public class Cat extends Animal{
    @Override
    public void voice() {
        super.voice();
    }//24 10 min alt+ins

    public void voice(String name) {
//        super.voice(); // по умолчанию вызовет метод из родит класса
        System.out.println(name + "Мяу!");


    }
}
