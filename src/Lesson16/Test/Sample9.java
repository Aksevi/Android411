package Lesson16.Test;
// 31 15
// интерфейс с именем P расширяющий класс Human
interface HumanFactory<P extends Human>{
    P create(String firstName, String lastName); // принимает 2 параметра
}
public class Sample9 {
    public static void main(String[] args) {

        HumanFactory<Human> humanHumanFactory = Human::new;// созд экземпляр класса
        Human human = humanHumanFactory.create("Olga", "Pavlova");
        System.out.println(human);

    }
}
// класс Human
class Human {
    String firstName;
    String lastName;
// конструктор
    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
