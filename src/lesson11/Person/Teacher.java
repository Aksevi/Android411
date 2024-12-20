package lesson11.Person;

public class Teacher extends Human{

    // свойства класса Teacher
    private String speciality; // специальность
    private double rating; // рейтинг
    private int level; // уровень

    // конструктор через alt+ins так как Teacher наследуется от Human то в конструкторе Students есть параметры и из Teacher и из Human
    public Teacher(String lastName, String firstName, int age, String speciality, double rating, int level) {
        super(lastName, firstName, age);
//        this.speciality = speciality;
//        this.rating = rating;
//        this.level = level;
        setSpeciality(speciality);
        setLevel(level);
        setRating(rating);
        System.out.println("TeacherConstructor:\t"+ Integer.toHexString(hashCode()));
    }

// геттеры и сеттеры

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "speciality='" + speciality + '\'' +
                ", rating=" + rating +
                ", level=" + level +
                '}';
    }
}
