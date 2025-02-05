package Lesson16.Collection;
// 34 2-11
import java.util.PriorityQueue;

public class PriorityQueue13 {
    public static void main(String[] args) {
        PriorityQueue<Integer> task = new PriorityQueue<>();// хранит не только уникальные
        task.add(5);
        task.add(1);
        task.add(9);
        task.add(2);
        task.add(3);
        task.add(3);
        System.out.println(task);//[1, 2, 3, 5, 3, 9]  гарантирует порядок только при извлечении
// .get не работает индексов нет сортировка произвольная приоритет у самого наименьшего

/*        while (!task.isEmpty()){// !task.isEmpty() - пока task не пустой - см !=
//            System.out.println(task.remove());// 1 2 3 3 5 9  удаляет в таком порядке
            System.out.println(task.poll());// poll = remove но remove может выбросить исключение если очередь закончилась/ poll лучше исп вне цикла
        }
        System.out.println(task);//[]*/

        System.out.println(task.peek());//1 возвращает верхушку очереди
        System.out.println(task.element());//1 возвращает верхушку очереди .element = .peek отличия как и  poll и remove
        System.out.println(task);//[1, 2, 3, 5, 3, 9]

    }
}
