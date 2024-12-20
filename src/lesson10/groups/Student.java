package lesson10.groups;

public class Student {

    // ур 21 40 мин

    private String name;
    private String initials;
    private int group;
    private int marks[]; // массив с оценками
    private int nMark;

    // конструктор alt+ins
    public Student(String name, String initials, int group) {
        this.name = name;
        this.initials = initials;
        this.group = group;
        this.marks = new int[5]; // устанавливаем размер массива из 5 элементов
        this.nMark = 0;
    }

    public boolean addGrade(int grade) { // grade это оценка
        if (nMark >= 5) // 5 это длина массива(кол-во элементов)
            return false;
        this.marks[nMark] = grade; // marks это массив. nMark это индекс элемента массива
        nMark++;
        return true;

    }
    public void print(){
        System.out.printf("%-16s %-8s", name, initials);// форматируем вывод. s строковое значение. -16 и -8 это отступы
        System.out.printf("Группа: %-4d Оценки: ", group); // форматируем вывод. d цифровое значение.
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ") ;

        }
        System.out.println();
    }
    // метод вывода студентов с хорошими оценками
    public boolean isGood(){
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 1 && marks[i] <= 5)

            return false;
        }

        return true;
    }
}
