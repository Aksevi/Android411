package lesson10.numbers;

// ур 21 2-40

public class Numbers {

    // ищем макс знач
    public static int max(int a, int b, int c, int d) {
        // созд врем переменную и сравниваем через нее цифры чтобы узнать макс
        int mx = a;
        if (b > mx) mx = b;
        if (c > mx) mx = c;
        if (d > mx) mx = d;
        return mx;
    }

    // ищем миним знач
    public static int min(int... num) { // принимаем любое кол-во элементов получился  массив/ можно сделать как и с максом без массива
        int mn = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] < mn) {
                mn = num[i];
            }
        }
        return mn;

    }

    // ищем среднее арифметическое
    public static double average(int a, int b, int c, int d) {
        return (a + b + c + d ) / 4.0;

// то же самое но через массив
/*        public static double average(int... num) {
        int av = 0;
            for (int i = 0; i < num.length; i++) {
                av =  av + num[i];
            }
            return av / num.length;*/
    }
    // ищем факториал  числа 5
    public static int factorial (int n){ // 5! = 1 * 2 * 3 * 4 * 5
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
                return fact;
    }

}
