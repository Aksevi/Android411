package lesson1;

public class Main {
    public static void main(String[] args) {
/*        System.out.println("Hello world!"); // строчный комментарий
        System.out.println();
        System.out.println("The Last Of Us");
        System.out.print("Hello");
        System.out.print("World");*/

/*        int a; // объявление переменной
        a = 10; // присвоение значения переменной
        System.out.println(a);*/

/*        int b = 20; // инициализация переменной
        System.out.println(b);
        int c, d;
        c = 5;
        d = 6;
        System.out.println(c);
        System.out.println(d);*/

/*        int e = 50, f = 100;
        System.out.println(e);
        System.out.println(f);
        int a = 10;
        System.out.println(a);
        a = 20;
        System.out.println(a);*/

/*        final int WEEK = 7;
        System.out.println(WEEK);*/

/*        final int WEEK;
        WEEK = 7;
        System.out.println(WEEK);*/

/*        boolean flag = true;
        System.out.println(flag);  // true | false
        System.out.println(true);
        System.out.println(false);
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);*/

/*        char ch = '+';
        System.out.println(ch);
        char ch1 = 43;
        System.out.println(ch1);
        System.out.println(Character.SIZE);
        System.out.println(Character.BYTES);*/

/*        byte a = 127;
        System.out.println(a);
        System.out.println(Byte.BYTES);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);*/

/*        short a = 3;
        System.out.println(a);
        System.out.println("Hello" + " " + "World");  // конкатенация (сложение строк)

        System.out.println("Переменная типа int занимает " + Integer.BYTES + " Байта памяти (" + Integer.SIZE + " бита памяти)," + " и принимает значение в диапазоне от " + Integer.MIN_VALUE + " до " + Integer.MAX_VALUE);*/

/*        long a = 5;
        System.out.println(a);*/

/*        float a = 8.5F;
        double b = 8.5;
        System.out.println(a);
        System.out.println(b);*/

/*        int a = 15;
        int b = 3;
        int c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        c = a;
        a = b;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = a + b; // 15 + 3 = 18
        b = a - b; // 18 - 3 = 15
        c = a - b; // 18 - 15 = 3
        System.out.println("a = " + a);
        System.out.println("b = " + b);*/

/*        int a = 512;
        System.out.println(a);

        System.out.println(((Object) 512).getClass().getSimpleName());*/

/*        int num16 = 0x12;
        int num8 = 022;
        int num2 = 0b10010;
        System.out.println(num16);
        System.out.println(num8);
        System.out.println(num2);
        num8 = num16 + num2;
        System.out.println(num8);*/

/*        int x = 123_456;
        int y = 567_123__456;
        double z = 234_567.789__102;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);*/

/*        double d1 = 0.512;
        double d2 = .512;
        double d3 = 512;
        float f1 = 0.512F;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(f1);
        System.out.println(((Object).512f).getClass().getSimpleName());*/

/*        char ch1 = '+';
        char ch2 = 43;
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(((Object)'+').getClass().getSimpleName());*/

 /*       String text = "Hel lo Wor ld!";
        System.out.println(text);
        System.out.println("Hello World!".getClass().getSimpleName());
        String text1 = """
               Привет
                М и р!!!
               """;*/

/*        var numberOne = '+';
        System.out.println(numberOne);*/

/*        System.out.println("   Hello \n\"World!!!\"");*/

/*        System.out.println("Путь к каталогу D:\\folder\\file.txt");*/

/*        System.out.print("2 + 2 = 5");
        System.out.print("\b");
        System.out.print("4");  // 2 + 2 = 5 (\b - удаляет последгий символ - 5 и заменяет на 4) 4*/

/*        System.out.print("Hello World!!!");
        System.out.print("\r");
        System.out.print("Новый текст "); // Hello World \r Новый текст
        System.out.println("5 + 3 = ");
        System.out.println(5 + 3);*/

/*        double a = 5.4;
        int b = 3;
        System.out.printf("a = %f; | b = %d", a, b);*/



/*        String name = "Ирина";
        int age = 25;
        float height = 1.7f;
        System.out.printf("Меня зовут %s. Мне %d лет. Мой рост %.2f\n", name, age, height);
        System.out.printf("%8d%n", 123); //_____123
        System.out.printf("%4d%5d%n", 123, 456); // _123__456
        System.out.printf("%6.2f%n", 123.4567); // 123,45
        System.out.printf("%-6s%5d%n", "num =", 456); //num =___456*/

/*        System.out.print("Вы все дураки \n и не лечитесь");
        System.out.print("\r");
        System.out.print("но ценные");*/

/*        System.out.println(5 + 2);
        System.out.println("Сумма:" + 5 + 2); // 5 и 2 воспринял как строку потому что слева слово сумма  в кавычках и является строковым значением и произошла конкатенация (объединение) значений. чтобы посчитал как сумму 5+2 нужно 5 и 2 в скобки залючить
        System.out.println("Сумма:" + (5 + 2)); // оператор отрабатывает сперва то что в скобках потом остальное как в математике
        System.out.println(5 - 2);
        System.out.println("Разность: " + (5 - 2));
        System.out.println(5 * 2);
        System.out.println("Произведение: "  + 5 * 2); // произведение и деление в приоритете над сложением и вычитанием. то есть тут сперва 5*2 а потом уже прибавляется строковое значение
        System.out.println("Частное: " + 5 / 2); // если делим целые числа то дробная часть отбрасывается. чтобы получить нецелое число ставим после одного из делимых чисел точку (см. ниже)
        System.out.println("Частное: " + 5 / 2.);
        System.out.println("Частное: " + 5. / 2);
        int a = 5;
        int b = 2;
        double c;
        c = a / b;
        System.out.println(c);
        System.out.println(5 % 2);*/

/*        int num = 4321; // вданном задании надо сделать так чтобы число 4321 вывелось наоборот - 1234
        int a, b, c, d, res; // временные переменные которым присвоим по цифре из исходного числа
        System.out.println("Исходное число: " + num); // выводим исходное число
        a = num % 10; // a = 1 - при остатке от деления на 10 всегда получаем последнюю цифру из числа
        System.out.println("a:" + a);
        num = num / 10; // делим исходное число 4321 на 10 (=432)чтобы потом остатком от деления на 10 получить значение второй переменной (2)
        System.out.println("Num: " + num);
        b = num % 10;
        System.out.println("b:" + b);
        num = num / 10; //делим измененное исходное число 432 на 10 (43) чтобы потом остатком от деления на 10 получить значение второй переменной (3)
        System.out.println("Num: " + num);
        c = num % 10;
        System.out.println("c:" + c);
        num = num / 10;
        System.out.println("num: " + num);
        d = num % 10;
        System.out.println("d:" + d);
        res =  a * 1000 + b *100 + c * 10 + d; // арифметические действия и конкатенация строк - число а * 1000 (стало первым в 4хзначном числе) затем число b*100 - стало вторым в 4хзначном числе и тд
        System.out.println("Обратное число: " + res);*/

/*        int a = 8;
        a++; // 9
        System.out.println(a);
        int b = 8;
        ++b; // 9
        System.out.println(b);*/

/*        int a = 8;
        int b = ++a; // логика работы кода - а=8 затем самым первым действием выполняется префиксный инкремент (потому что он префиксный) ++ увеличивает значене а на 1 (=9) и после этого вычисляет значение b (b = ++a)
        System.out.println(a);
        System.out.println(b);*/

/*        int a = 8;
        int b = a++; // так как инкремент постфиксный то он выполняется последним действием. сперва сохраняется значение b (=a=8), затем вычисляется значение a (a++ = 8+ = 9)
        System.out.println(a);
        System.out.println(b);*/

/*        int a = 1;
        int b = 1;
        int c = a++ + 3; // постфиксный инкремент работает последним. то есть a=1 прибавляется к 3 -> с=4 и только после этого а увеличит свое знаечени постфиксным инкрементом (а++ = 1+1=2)
        int d = ++b + 3; // так как префиксный инкремент то сперва b+1 (=2), потом к b+3 (2+3=5)
        System.out.println(a); // 2
        System.out.println(b); // 2
        System.out.println(c); // 4
        System.out.println(d); // 5*/

/*        int a = 2;
        int b = a++; // b = 2, a = 3
        int c = b + 3 + a; // c = 2 + 3 + 3
        System.out.println(c); // 8*/

/*        int a = 2;
        int b = ++a; // b = 3, a = 3
        int c = b + 3 + a; // c =  + 3 +
        System.out.println(c); // 9*/

/*        int a = 1;
        int b = 2;
        int c = a + 5 * ++b; // c = 1 + 5 * 3
        System.out.println(c); // 16*/

/*        int a = 1;
        int b = 2;
        int c = (a + 5) * ++b; // c = (1 + 5) * 3
        System.out.println(c); // 18*/

        // ПРЕОБРАЗОВАНИЕ БАЗОВЫХ ТИПОВ ДАННЫХ

/*        int x = 5;
        byte y = (byte)x; // указываем в какой тип данных преобразуем Х. без этого не сработает так как int занимает больше места чем byte
        System.out.println(y);*/

/*        byte x = 5;
        int y = x;
        System.out.println(y); // сработало потому что byte меньше int занимает памяти. влезло типа*/

/*        int x = 987654321;
        double y = x;
        System.out.println(y);*/

/*        int x = 258;
        byte y = (byte) x;
        System.out.println(y); // 2  byte меньше int поэтому усекает число 258 до 2*/

/*        long x = 5;
        int y = (int)x;
        System.out.println(y);*/

/*        double x = 18.9845;
        int y = (int) x;
        System.out.println(y); // 18, так как вещественное число преобразуем в целое*/

/*        double x = 18.9876;
        int y = (int)Math.round(x); // с помощью объекта Math и метода round округление в большую сторону по законам математики
        System.out.println(y); // 19*/

/*        System.out.println("Написать программу  нахождения суммы, произведения и среднего значения  трех чисел: 5, 3, 7");
        int a = 5, b = 3, c = 7;
        int sum = 5 + 3 + 7;
        int product = 5 * 3 * 7;
        int midle = (5 + 3 + 7)/ 3;
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
        System.out.println("Среднее значение: " + (float)midle); // float преобразует  переменную middle в дробное число чтобы в результате получилось тоже дробное число (5.0) это нужно для того чтобы в случае иных вводных числах дробная часть в среднем значении не отбрасывалась*/

/*        System.out.println("написать программу находжения суммы, произведения и среднего значения трех чисел 5, 4, 7");
        int a = 5, b = 4, c = 7;
        System.out.println("сумма: " + (a + b + c));
        System.out.println("произведение: " + (a * b * c));
        System.out.printf("среднее значение = %.2f", (double)(a + b + c)/ 3); // double преобразует  среднее значение в дробное число чтобы в результате получилось тоже дробное число (5.33) это нужно для того чтобы в случае иных вводных числах дробная часть в среднем значении не отбрасывалась. %.2f ограничивает число знаков после запятой до 2х оператор system.out.printf нужен для того чтобы  %.2f не выдал ошибку*/

/*        int a = 5;
        double b = 4.7;
        double c = a + b;
        System.out.println(c); // если работаем с разными типами данных то результат преобразуется в тот тип который занимает больше памяти. int (целое число) занимает меньше, double (дробное число) больше - результат = double (дробное число) */

/*        int d = 'a' + 3; // 97 (a в кодировке юникод) + 3
        System.out.println(d); // char = 2 байта( несмотря на то что переменная объявлена в int одинарные кавычки ' ' (означают что это символ в кодировке юникод) = char )  занимет меньше памяти чем int (4 байта), результат преобразуется в int*/

    }
}