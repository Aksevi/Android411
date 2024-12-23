package storonnee.Animals;

public class Dog extends Animals {
     String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    @Override
    public void speak(){
        System.out.println(name + ", он лает");
    }
}
