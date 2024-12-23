package storonnee.Animals;

public class Cat extends Animals{
    String colour;

    public Cat(String name, int age, String colour) {
        super(name, age);
        this.colour = colour;
    }
    @Override
    public void speak(){
        System.out.println(name + ", он мяукает");
    }
}
