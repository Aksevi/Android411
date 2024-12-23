package lesson11.Person;

public class Main {
    public static void main(String[] args) {

// экземпляр класса Human
    Human human = new Human("Иванов", "Иван", 16);
        System.out.println(human);
// экземпляр класса Student
//        Student student = new Student("Петров", "Петр", 18, "математика", "МН_220", 90, 95);
//        System.out.println(student);
//       student.setAttendance(80);
//        System.out.println(student);
// экземпляр класса Teacher
        Teacher teacher = new Teacher("Сидоров", "Федор", 39,"Математика", 95, 10);
        System.out.println(teacher);

        Graduate graduate = new Graduate("Шугани", "Сергей", 25, "Сети", "DS_11", 80, 50, "Защита персональных данных");
        System.out.println(graduate);
 // новый экземпляр класса student/ переводим Иванова из Human в студенты
        Student student1 = new Student(human, "Физика", "A-23", 0, 0);
        System.out.println(student1);

//переводим студента в дипломники
        Student student = new Student("Петров", "Петр", 18, "математика", "МН_220", 90, 95);
        System.out.println(student);
        student.setAttendance(80);
        System.out.println(student);

        Graduate graduate1 = new Graduate(student, "Математические вычисления");
        System.out.println(graduate1);

        Specialist specialist = new Specialist(graduate, 5);
        System.out.println(specialist);
    }

}
