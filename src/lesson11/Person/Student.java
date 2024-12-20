package lesson11.Person;
// ур 22 2-50
public class Student extends Human { // наследуем  Students от класса Human

    // свойства класса Student
    private String speciality; // специальность
    private String group;// группа
    private double rating;// рейтинг
    private double attendance;// посещаемость

// конструктор - так как Student наследуется от Human то в конструкторе Students есть параметры и из Students и из Human
    public Student(String lastName, String firstName, int age, String speciality, String group, double rating, double attendance) {
        super(lastName, firstName, age); // super отправляет к конструктору родительского класса Human
//        this.speciality = speciality;
//        this.group = group;
//        this.rating = rating;
//        this.attendance = attendance;

//аналог стр 14-17 нужен если есть сеттеры и геттеры!
        setSpeciality(speciality);
        setGroup(group);
        setRating(rating);
        setAttendance(attendance);
        System.out.println("StudentConstructor:\t" + Integer.toHexString(hashCode()));
    }
// геттеры и сеттеры
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return super.toString() + " Student{" +
                "speciality='" + speciality + '\'' +
                ", group='" + group + '\'' +
                ", rating=" + rating +
                ", attendance=" + attendance +
                '}';
    }
}
