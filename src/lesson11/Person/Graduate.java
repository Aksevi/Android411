package lesson11.Person;

public class Graduate extends Student {

 private String subject;

    public Graduate(String lastName, String firstName, int age, String speciality, String group, double rating, double attendance, String subject) {
        super(lastName, firstName, age, speciality, group, rating, attendance);
        setSubject(subject);
        System.out.println("GraduateConstructor:\t" + Integer.toHexString(hashCode()));
    }
 // ур 23 51
    public Graduate(Student student, String subject) {
        super(student); //
        setSubject(subject);
        System.out.println("GraduateConstructor:\t" + Integer.toHexString(hashCode()));
    }
// конструктор копирования для specialist
    public Graduate(Graduate other){
        super(other);
        this.subject = other.subject; // см стр 5
    }
 // геттеры и сеттеры
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + "Graduate{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
