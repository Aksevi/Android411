package lesson10.groups;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // ур 21 40 мин

        int n = 10;
        Student students[] = new Student[n]; // массив из n элементов (в нашем случае n = 10)
        // заполнили массив значениями
        students[0] = new Student("Петров", "А.В.", 1);
        students[1] = new Student("Петров", "В.И.", 1);
        students[2] = new Student("Иванов", "М.М.", 1);
        students[3] = new Student("Путин", "В.В.", 2);
        students[4] = new Student("Медведев", "Д.В.", 2);
        students[5] = new Student("Сидоров", "Г.Д.", 3);
        students[6] = new Student("Воропанова", "Д.И.", 3);
        students[7] = new Student("Старцева", "В.Д.", 3);
        students[8] = new Student("Новиков", "В.О.", 3);
        students[9] = new Student("Савинская", "А.Р.", 3);

        Random rd = new Random();
        for (int i = 0; i < students.length; i++) { // перебираем массив студентов по строчкам


            for (int j = 0; j < students.length; j++) {
                students[i].addGrade(rd.nextInt(12) + 1 ); //addGrade - придуманное имя/ здесь получается случайная оценка от 1 до 12 баллов - см метод addGrade. мы его вызываем он заполняет оценки одного студента. потом переходит к следующему и тд

            }

//            do {} while (students[i].addGrade(rd.nextInt(12) + 1 ));    // заменяет предыдущее с 28 до 31 стр. их нужно закомент

        }
        System.out.println("Все студенты: ");
        for (int i = 0; i < students.length; i++) {
            students[i].print(); // print() метод который создаем и указываем сами d student.java

        }
        System.out.println("\nСтуденты с хорошей успеваемостью");
        for (int i = 0; i < students.length; i++) {
            if (students[i].isGood()){ // см student.java
                students[i].print();
            }

        }
    }
}
