package lesson11.Person;

public class Specialist extends Graduate {

    private int grade; // оценка по диплому
// конструктор 23 1-49
    public Specialist(String lastName, String firstName, int age, String speciality, String group, double rating, double attendance, String subject, int grade) {
        super(lastName, firstName, age, speciality, group, rating, attendance, subject);
        this.grade = grade;
    }
// еще конструктор
    public Specialist(Graduate graduate, int grade){
        super(graduate);
        this.grade = grade; // добавляем только новые данные

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()  + " Specialist {" +
                "grade = " + grade +
                '}';
    }
}


