package lesson9;


// ур 20 10 мин ООП (объектно ориентированное программирование) объяснение 29 мин
public class Program {
    public static void main(String[] args) {


/*        Person p1 = new Person(); // создаем экземпляр р1 класса Person и выделяем под нее память. конструктор его стр 29
        p1.displayInfo();
       p1.name = "Ирина"; // присваиваем name в р1 значение
        p1.age = 28; // присваиваем age в р1 значение
        System.out.println(p1.name);
        System.out.println(p1.age);
        Person p2 = new Person("Валентин"); // создаем экземпляр p2 класса Person и выделяем под нее память и к Person p1 он отношения не имеет. конструктор его стр 34
        p2.displayInfo(); //

        Person p3 = new Person("Марина", 25); // создаем экземпляр p3 класса Person и выделяем под нее память и к Person p1 он отношения не имеет. конструктор его стр 38
        p3.displayInfo(); //


    }
}

class Person {  // отдельный класс в классе Program. Person это просто имя любое
    String name;
    int age;

//сколько экземпляров столько конструкторов с соответствующим количеством переменных кроме первого

    public Person(){ // конструктор класса Person. у него без параметров поэтому сами инициируем стр 7
       name = "неизвестно";
       age = 18;
    }

    public Person(String n){ // конструктор класса Person стр 13
        name = n;
    }

    public Person(String n, int a){ // конструктор класса Person стр 16
        name = n;
        age = a;
    }

    void displayInfo() { // displayInfo просто имя метода любое
        System.out.printf("Name: %s%nAge: %d%n", name, age);
    }
}*/


        //49 мин

/*        Person p1 = new Person(); // создаем экземпляр р1 класса Person и выделяем под нее память. конструктор его стр 29
        p1.displayInfo();
        p1.name = "Ирина"; // присваиваем name в р1 значение
        p1.age = 28; // присваиваем age в р1 значение
        System.out.println(p1.name);
        System.out.println(p1.age);
        Person p2 = new Person("Валентин"); // создаем экземпляр p2 класса Person и выделяем под нее память и к Person p1 он отношения не имеет. конструктор его стр 34
        p2.displayInfo(); //

        Person p3 = new Person("Марина", 25); // создаем экземпляр p3 класса Person и выделяем под нее память и к Person p1 он отношения не имеет. конструктор его стр 38
        p3.displayInfo(); //


    }
}

class Person {  // отдельный класс в классе Program. Person это просто имя любое
    String name;
    int age;

// инициализатор 56 мин
//    {
//        name = "неизвестно";
//        age = 18;
//    }

//сколько экземпляров столько конструкторов с соответствующим количеством переменных кроме первого

    public Person(){ // конструктор класса Person. у него без параметров поэтому сами инициируем стр 7
      this("неизвестно", 18); //ключ слово 20 ур 50 мин
    }

    public Person(String n){ // конструктор класса Person стр 13
        this(n, 18);
//        this.name = n;
    }

    public Person(String n, int a){ // конструктор класса Person стр 16
      this.name = n;
      this.age = a;
    }

    void displayInfo() { // displayInfo просто имя метода любое
        System.out.printf("Name: %s%nAge: %d%n", name, age);
    }
}*/


// 20 1 час закрытые свойства


//        Person p1 = new Person();
//        p1.displayInfo();
//        p1.name = "Ирина"; // присваиваем name в р1 значение
//        p1.age = 28; // присваиваем age в р1 значение
//        System.out.println(p1.name);
//        System.out.println(p1.age);*/
//        Person p2 = new Person("Валентин"); // создаем экземпляр p2 класса Person и выделяем под нее память и к Person p1 он отношения не имеет. конструктор его стр 34
//        p2.displayInfo();

        int a = 225;
        Person p3 = new Person("Марина", a);
//        p3.setName ("Валерий");
//        System.out.println(p3.getName());
//        p3.setAge(258);
        p3.displayInfo();

    }
}

class Person {
    private String name;
  private  int age;

    {
        name = "неизвестно";
        age = 18;
    }

    public Person(){
        this("неизвестно", 18); //ключ слово 20 ур 50 мин
    }

    public Person(String n){ // конструктор класса Person
        this(n, 18);
//        this.name = n;
    }

    public Person(String name, int age){ // конструктор класса Person
//        this.name = n;
//        this.age = a;
        setName(name);
        setAge(age);
    }
// геттер и сеттер 1-15
    public String getName(){// getName просто любое имя
        return name;
    }
    public void setName(String name) {//setName просто имя

    this.name = name;
}
public int getAge(){
        return age;
}

    public void setAge(int age) {
        if (age > 0 && age < 110) // закрываем некорректные данные
        this.age = age;
    }

    void displayInfo() { // displayInfo просто имя метода любое
        System.out.printf("Name: %s%nAge: %d%n", name, age);
    }
}


// ур 20 1-51 пакет







