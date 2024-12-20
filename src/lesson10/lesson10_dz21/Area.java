package lesson10.lesson10_dz21;

import javax.swing.plaf.PanelUI;

public class Area {

// перемененная для подсчета количества вызванных методов
        private static int count;

// площадь треугольника по формуле герона
        public static double triangleArea1(int a, int b, int c){
                double p = (a + b + c) / 2.; // точка после 2 нужна для приведения результата к вещественному числу (с значениями после запятой)
// увеличивает значение count на 1
                count++;
                return Math.sqrt(p * (p - a) *(p - b) * (p - c));
        }

        // площадь треугольника через основание и высоту
        public static double triangleArea2(int a, int h){ // a - основание h высота
// увеличивает значение count на 1
                count++;
                return 0.5 * a * h;
        }

        public static int sqrtArea(int a){
                count++;
                return a * a;
        }

        public static int rectangleArea(int a, int b) {
                count++;
                return a * b;
        }
// метод вызова переменной count. считает сколько раз методы вызваны. то есть если в Main скопировать sout с вызвовм методов то даже если там ничего не менять то есть вызвать например  System.out.println("Площадь треугольника по формуле Герона (3, 4, 5): " + Area.triangleArea1(3, 4, 5))  хоть десять раз то счетчик покажет что метод вызвали 10 раз
        public static int getCount(){
               return count;
        }

}


