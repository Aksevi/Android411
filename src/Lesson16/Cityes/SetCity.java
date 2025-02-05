package Lesson16.Cityes;
// 34 0-50
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetCity {
// создаем списки has и tree
    private Set<City>  hash = new HashSet<>();
    private Set<City>  tree = new TreeSet<>();

//34 1-45 метод подсчета городов
    public int size(){
        return hash.size() + tree.size();// сложили размеры
    }

// метод проверки кода  на четность
    private boolean isEven(int code){
        return code %2 == 0; // проверка на четность
    }

// метод  addCity в него приходят имя и код города/ boolean потому как либо тру либо фалсе - попал город или не попал в списки
    public boolean addCity(String name, int code){
        boolean result = name.length() > 0 && code > 0; // имя и код должны быть > 0
        if (result){ // если result > 0 - то есть вернулся
            if (isEven(code)){ // если код четный
                hash.add(new City(name, code)); // добавляем в hash
            } else { // если нечетный
                tree.add(new City(name, code));// добавляем в tree
            }
        }
        return result;// возвращаем результат работы метода addCity
    }

// 34 1-50 метод удаления городов по признаку
    public void removeCityByFilter(int minAmountSymbol, int maxAmountSymbol){
// удаляем из hash
        hash.removeIf(x ->x.getName().length() < minAmountSymbol || x.getName().length() > maxAmountSymbol);// если временная x больше minAmountSymbol (0) и меньше maxAmountSymbol(5) - см Cities - там определили диапазон вызывая метод removeCityByFilter
        tree.removeIf(x ->x.getName().length() < minAmountSymbol || x.getName().length() > maxAmountSymbol);// если временная x
    }
// 34 1-58 метод сортировки городов в обратном порядке
    public void printReverseSort(){
// новый  TreeSet  и в него суем все эл-ты из  tree
        TreeSet<City> treeSet = new TreeSet<>(tree);
        treeSet.addAll(hash);// и в него все из hash добавляем
// итератор создаем и разворачиваем списрок
//        System.out.println(treeSet);
        Iterator<City> iterator = treeSet.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
// переопределенный метод вывода
    @Override
    public String toString() {
// StringBuilder изменяемая строка с именем sb
        StringBuilder sb = new StringBuilder("Список городов с четным кодом (HashSet): \n");
        for (City city : hash){ // проходим по списку hash
            sb.append(city).append("\n");// добавляем (.append) в строку новые элементы
        }

        sb.append("\n").append("Список городов с нечетным кодом (TreeSet): \n");
        for (City city : tree) { // проходим по списку tree
            sb.append(city).append("\n");// добавляем (.append) в строку новые элементы
        }
        return sb.toString();// изменяемую строку sb преобразуем в toString
    }
}
