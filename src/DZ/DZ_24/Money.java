package DZ.DZ_24;

import java.sql.SQLOutput;

public class Money {
    public static void main(String[] args) {

//        Student student = new Student("Виктор ", "Невзоров", "Гр111", 5);
//        Aspirant aspirant1 = new Aspirant("Александр", "Невзоров", "Гр222", 4.5, "Work1");
//        Aspirant aspirant2 = new Aspirant("Антон ", "Бобров", "Гр333", 5, "Work2");
//        student.showInfo();
//        System.out.println();
//        aspirant1.showInfo();
//        System.out.println();
//        aspirant2.showInfo();

        Student student[] = new Student[3];
        student[0] = new Student("Виктор", "Невзоров", "Гр111", 5);
        student[1] = new Aspirant("Александр", "Невзоров", "Гр111", 5, "Work1");
        student[2] = new Aspirant("Антон", "Бобров", "Гр111", 5, "Work2");
        for (Student a : student){
            a.showInfo();
        }


    }
}
// родит класс
class Student {
     String firstname; // имя
     String lastname; // фамилия
     String group; // группа
     double grade; // оценка
     int base; // стипендия
// конструктор
    public Student(String firstname, String lastname, String group, double grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
        this.grade = grade;
        this.base = (grade == 5) ? 1000 : 800;
    }

// вывод инфы
    public void showInfo(){
//        System.out.print(firstname + lastname + ", " + "группа " + group + ", ");
//        System.out.print("сумма стипендии: " + base);
        System.out.println(firstname + " " + lastname + ", " + "группа " + group + ", сумма стипендии: " + base);

    }
}

// дочерний класс
class Aspirant extends Student{
    String themeWork; // тема работы
// конструктор
    public Aspirant(String firstname, String lastname, String group, double grade, String themeWork) {
        super(firstname, lastname, group, grade);
        this.base = (grade == 5) ? 2000 : 1800;
        this.themeWork = themeWork;
    }
// переопределение метода showInfo
    @Override
    public void showInfo() {
//        super.showInfo();
        System.out.println(firstname + " " + lastname + ", " + " группа " + group + ", тема работы: " + "'" + themeWork + "'" + ", сумма стипендии: " + base);
//        System.out.print(firstname + " " + lastname + ", " + " группа " + group + ", ");
//        System.out.print("тема работы: " + themeWork + ", ");
//        System.out.print("сумма стипендии: " + base);
    }
}




/*
package DZ.DZ_24;

import java.sql.SQLOutput;

public class Money {
    public static void main(String[] args) {
        Student obj1 = new Student();
//        System.out.print("Стипендия студента: ");
        System.out.print("Виктор Вербов, " + "группа " + obj1.group + ", " + "сумма стипендии: ");
        printSalary(obj1);

        Aspirant obj2 = new Aspirant();
        System.out.print("Александр Невзоров, " + "группа " + obj2.group + ", " + "сумма стипендии: ");
        printSalary(obj2);

    }
    public static void printSalary(Student obj) {
        System.out.println(obj.salary());
    }
}

// родит класс
class Student{
    String group = "Gr111"; // группа
    int marc; // оценка
    private static double stipend = 1000; // стипендия если ср балл 5

    public double salary(){ // начисление стипендии
        return stipend;
    }
}
// наслед  класс
class Aspirant extends Student{
    String group = "Gr222";
    String themeWork; // тема дипломной работы
    @Override
    public double salary() {
        return super.salary() + 1000; // стипендия аспиранту при среднем балле 5
    }
}*/
