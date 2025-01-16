package Lessons15.Enums;
// 27 1-03
public class Test {
// enum можно как в главном классе так и за пределами создавать
    enum Lenth{
        KM("Километр", 1000),
        M("Метр", 1),
        DM("Дециметр", 0.1),
        CM("Сантиметр", 0.01),
        MM("Миллиметр", 0.001);
// так как в КМ два значения то и переменных - две
        String name;
        double d;
// конструктор
        Lenth(String name, double d) {
            this.name = name;
            this.d = d;
        }

// переопределяем метод для вывода того что в скобках в стр 6
    @Override
    public String toString() {
        return name; // выведет Километр
    }

    double coefficient (Lenth inp){
            return d / inp.d; // inp.d относится к циклу for c l2 то есть значение d всегда постоянно а конвертация - d делит на тот элемент, что с каждой итерацией приходит в l2. например 1 Метр (d = 1) = 0.001 Километр (d = 1000) -> 1/1000 = 0.001
    }
}

    public static void main(String[] args) {
        for (Lenth l1 : Lenth.values()){
            for (Lenth l2 : Lenth.values()){
                if (l1 != l2)
            System.out.println("1 " + l1 + " = " + l1.coefficient(l2) + " " + l2);
            }
            System.out.println();
        }



    }
}
