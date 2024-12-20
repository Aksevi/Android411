package lesson11.Person;

public class Main {
    public static void main(String[] args) {

// экземпляр класса Human
    Human human = new Human("Иванов", "Иван", 16);
        System.out.println(human);
// экземпляр класса Student
        Student student = new Student("Петров", "Петр", 18, "математика", "МН_220", 90, 95);
        System.out.println(student);

        Teacher teacher = new Teacher("Сидоров", "Федор", 39,"Математика", 95, 10);
        System.out.println(teacher);
    }
}
