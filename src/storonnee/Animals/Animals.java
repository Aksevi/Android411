package storonnee.Animals;

public class Animals {
    String name;
    int age;

    public Animals(){}

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void speak(){
        System.out.println("Это животное по имени");
    }
}
