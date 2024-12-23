package lesson12;

import java.sql.SQLOutput;

public class Base {
    public static void main(String[] args) {

        Manager obj1 = new Manager();
        System.out.println("Зарплата менеджера: ");
        printSalary(obj1);

        Secretary obj2 = new Secretary();
        System.out.println("Зарплата секретаря: ");
        printSalary(obj2);

    }
    public static void printSalary(Employee obj){ //  Employee род класс а obj просто должность или имя сотрудника
        System.out.println(obj.salary());
    }
}
// родит класс Сотрудник
class Employee{
    private static int base = 10000; // базовая ставка зп

    public int salary(){ // выплата ставки сотруднику
        return base;
    }
}
// класс Менеджер наслед от Сотрудника
class Manager extends Employee{
    @Override
    public int salary() {
        return super.salary() + 20000; // ставка + надбавка за должность
//        return base + 20000; // то же самое
    }
}

class Secretary extends Employee{
    @Override
    public int salary() {
        return super.salary() + 10000; // ставка + надбавка за должность
    }
}