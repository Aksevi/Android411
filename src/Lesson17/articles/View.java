package Lesson17.articles;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// 36 1-17
public class View {

    // класс View  будет отвечать за визуальное взаимодействие с пользователем. здесь он будет выбирать вариант действий и вводить свой выбор
    Scanner input = new Scanner(System.in); // сканнер для ввода

// метод для вывода выбора пользователя. Возвращает строковое значение/ вызывать его будем через Controller
    public String waitUserAnswer(){
        System.out.println("============ Ввод пользовательских данных ============");
        System.out.println("Действие со статьями:");
        System.out.println("1 - Создание статьи" +
                "\n2 - просмотр статей" + "\n3 - Просмотр определенной статьи" + "\n4 - удаление статьи" +
                "\nq - выход из программы");
        System.out.print("Выберите вариант действия: ");
// запрашиваем выбор варианта действий. создаем строковую переменную
        String userAnswer = input.nextLine(); // так как String то nextLine
        System.out.println("======================================================");
        return userAnswer;

    }
// 36 1-59 метод создания статьи. тип данных Map потому что будет ключ(например "автор статьи") и само значение (например его имя)
    public Map addUserArticle(){
        Map<String, String> dictArticle = new LinkedHashMap<>();
// кладем в карту Map dictArticle ключи и значения
        dictArticle.put("название", "");//"название" это ключ, значение еще не ведено поэтому пустая строка ("")
        dictArticle.put("автора", "");
        dictArticle.put("количество страниц", "");
        dictArticle.put("описание", "");
        System.out.println("============ Создание статьи ============");
// задействуем ключи текущего элемента. В этом цикле пользователь выбирает пункт меню и далее по циклу идем - ввел название -> запрос автора -> запрос количества страниц и тд
        for (Map.Entry<String, String> el : dictArticle.entrySet()){// Map.Entry - идем по коллекции и кладем в переменную el ее значения
            System.out.print("Введите " + el.getKey() + " статьи: ");// выводим, где el.getKey() - ключ элемента
            dictArticle.put(el.getKey(), input.nextLine());// пользователь вводит значение в соответсвии с ранее выбранным ключом
        }
        System.out.println("======================================================");
        return dictArticle;
    }

// 36 2-40

    public void showAllArticles (Collection articles){
        System.out.println("=================== Список статей ===================");
// для вывода элементов используем цикл
        for (var element : articles){ // var - переменная любого типа
            System.out.println(element);
        }

        System.out.println("=====================================================");
    }
// 37 0-25
    public String getUserArticle(){
        System.out.println("=================== Ввод названия статьи ===================");
        System.out.print("-> ");
        String user_article = input.nextLine();// переменная куда вводят статью которую вывести
        System.out.println("=====================================================");
        return user_article;
    }
 // 37 0-38 метод // показа конкретной  статьи со всеми значениями
    public void showSingleArticle(Map article){
        System.out.println("=================== Просмотр статьи ===================");
        for (var el : article.entrySet()){
            System.out.println(el);
        }
        System.out.println("=====================================================");
    }

// 37 0-50 метод обработки исключения из Controller
    public void showIncorrectTitleError(String articleTitle){// articleTitle - это то что в Controller в стр 60 приходит в вывод ошибки. грубо говоря ввел несуществующую статью она и попадает в метод обработки ошибок
        System.out.println("=================== Сообщение об ошибке ===================");
        System.out.println("Статьи с названием " + articleTitle + " не существует");
        System.out.println("=====================================================");
    }
//37 1-11
    public  void removeSingleArticle(Article title){
        System.out.println("=================== Удаление статьи ===================");
        System.out.println("Статья " + title + " была удалена");


        System.out.println("=====================================================");
    }

    public void showIncorrectAnswerError(String answer){
        System.out.println("=================== Сообщение об ошибке ===================");
        System.out.println("Варианта " + answer + " не существует");
        System.out.println("=====================================================");
    }
}
