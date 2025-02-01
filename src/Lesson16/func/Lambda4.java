package Lesson16.func;
// 31 2 часа
import java.util.Scanner;
import java.util.function.Supplier;

public class Lambda4 {
    public static void main(String[] args) {
/*        String t = "one";
// ничего не принимает поэтому скобки пустые ()
        Supplier<String> supplier = () -> t.toUpperCase(); // в верхн регистр
        System.out.println(supplier.get());*/

        Supplier<User> userName = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("имя: ");
            String name = scanner.nextLine();
            return new User(name);
        };

        User user1 = userName.get();
        User user2 = userName.get();
        System.out.println("имя 1: " + user1.getName());
        System.out.println("имя 2: " + user2.getName());
    }
}

class User {
    private String name;
// конструктор
    public User(String name) {
        this.name = name;
    }
// геттер
    public String getName() {
        return name;
    }
}
