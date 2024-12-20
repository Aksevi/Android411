package lesson10;

// ур 22 46 мин класс внутри класса
public class Sample {
    public static void main(String[] args) {

 // создаем экземпляр (имя его out) наружного класса
        Outer out = new Outer("внешний"); // out - переменная наружного класса  Outer и передаем в переменную name значение "внешний"
        System.out.println(out.name); // обращаемся к свойству name экземпляра out класса Outer

        System.out.println(out.inner.innerName); // out это экземпляр внешнего класса inner - экземпляр вложенного класса. то есть здесь мы обращаемся к innerName которая находится в классе Inner. урок 22 1-02
        System.out.println(Outer.Inner.age); // к статическому свойству  без создания экземпляра класса. то есть здесь обращаемся к age которая лежит в Inner, который в свою очередь лежит в Outer
        Outer.Inner.info(); // обращаемся к методу info
//  к методу func так не обратится так как он динамический. нужно - через экземпляр
        out.inner.func();
    }
}
// наружный класс Outer
class Outer {
    String name;
    Inner inner; // указываем тип данных Inner и создаем переменную типа данных inner

// конструктор класса Outer
    public Outer(String name) {
        this.name = name;
        inner = new Inner("внутренний"); // в конструкторе присваиваем переменной inner значение new Inner.по факту - создаем экземпляра класса

    }
    // вложенный класс Inner
    class Inner {
        // статическое свойство
        static int age;
        // динамическое свойство
        String innerName;
    // статический инициализатор свойства age
        static{
            age = 18;
        }
// конструктор класса Inner / в конструкторе только динамическое свойство создается
        public Inner(String innerName) {
            this.innerName = innerName;
        }
// статический метод для просмотра промежуточных результатов
       public static void info(){
           System.out.println("Статический метод");
       }
// динамический метод во вложенном классе для просмотра промежуточных результатов
       public void func(){
           System.out.println("Метод во вложенном классе");
       }
    }
}