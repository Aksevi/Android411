package lesson11.Person;
// ур 22 2-32
public class Human {

    //  эти свойства есть у всех
    private String lastName; // фамилия
    private String firstName; // имя
    private int age; // возраст



    public Human(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        System.out.println("Human Constructor:\t" + Integer.toHexString(hashCode())); // Integer.toHexString(hashCode()) создаст 16ричное представление хэш кода объекта
    }

// так как все свойства закрыты (private) то нужны геттеры и сеттеры

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//alt+ins -> toString() создаем метод toString ур 22 2-43

    @Override
    public String toString() {
        return "Human{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
