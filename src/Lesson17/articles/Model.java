package Lesson17.articles;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// класс Model  отвечает за все статьи/ тут они по сути все хранятся
public class Model {
 // 36 2-17
    private Map<String, Article> articles; // тут хранятся все статьи . ключ - строковый (String) а значение - какая то определенная статья (Article - экз класса Article) со всеми ее свойствами

 // 37 1-48
    private String dbName;// переменная для реализ сохранения


//36 2-18 конструктор. изменяем его. убираем все параметры из скобок так как в момент создания Model туда еще нечего передавать.
    public Model() {
        this.dbName = "db.txt";// добавляем переменную для сохр в конструктор 37 1-48
        // но articles нужно инициализировать то есть какое то значение сразу передать. поэтому вместо \this.articles = articles;\ делаем так:
        this.articles = loadData();// метод загрузки сохр данных при запуске
        //new LinkedHashMap<>();
    }
//36 2-25 создаем метод с любым названием
    public void addArticle(Map dictArticle){
// 36 2 -27 реализуем метод
        Article article = new Article(dictArticle);// созд новую статью  - обращаемся к типу данных Article созд переменную article и передаем в нее то что приходит в dictArticle. а приходят в нее данные через конструктор класса Article(см ниже)
// так как пользователь может создать несколько статей то обращаемся к articles (выше стр 10) который создан для хранения неск статей
        articles.put((String) dictArticle.get("название"), article);// ключом здесь будет dictArticle.get("название")ОБЯЗАТЕЛЬНО преобразовать к String!!!, значением вся статья article
//        System.out.println(article);
    }

//36 2-38 метод получения всех статей (см Controller стр 48) почему Collection см начало 37 ур
    public Collection  getAllArticles(){
        return articles.values();// возвращаем только значения из Map(ключи не возвращаем)
    }
// 37 0-30  метод получения отдельной статьи для вывода
    public Map getSingleArticle(String userTitle){
        Article article = articles.get(userTitle);
        Map<String, String> dictArticle = new LinkedHashMap<>();// LinkedHashMap чтобы сохр в том порядке в каком ввели
        dictArticle.put("название", article.getTitle());
        dictArticle.put("автор", article.getAuthor());
        dictArticle.put("количество страниц", article.getPage());
        dictArticle.put("описание", article.getDescription());
        return dictArticle;
    }

// 37 1-07 метод удаления той статьи название которой ввел пользователь
    public Article removeArticle(String userTitle) {
        return articles.remove(userTitle);
    }
 // 37 1-50   метод сохранения
    public void saveData(){
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dbName))){
             oos.writeObject(articles);// articles - все статьи тут лежат см стр 13
             File file = new File("db.txt");
             System.out.println("Файл сохраняется сюда " + file.getAbsolutePath());
         } catch (Exception ex){
             System.out.println(ex.getMessage());

         }
    }
 // 37 2-02 метод загрузки из файла если есть
    public LinkedHashMap loadData(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbName))){
          return (LinkedHashMap) ois.readObject();
        }catch (Exception ex){
            return new LinkedHashMap();// если нет то созлает при запуске LinkedHashMap()
        }
    }

}
// 36 2-13 можем хранить не одну, а несколько статей поэтому создаем вспомогательный класс который будет отвечать за отдельную статью
class Article implements Serializable { // implements Serializable yнеобходимо для реализации сохранений
    private String title; // название статьи
    private String author; // автор статьи
    private String page; // кол во страниц
    private String description; // описание статьи

// 36 2-16
// конструктор. его немного переделали - так как статья которую создал пользователь хранится в Map article (см класс Controller) то вместо этого набора переменных - (String title, String author, String page, String description) - делаем так
        public Article(Map dictArticle) { // dictArticle  это имя оно по сути то же самое что и аrticle
 // 36 2-21
        this.title = (String) dictArticle.get("название");// через этот конструктор получаем в качестве ключа \title\ а в качестве значения то что ввел пользователь при вводе названия
        this.author = (String) dictArticle.get("автора");// через этот конструктор получаем в качестве ключа \author\ а в качестве значения то что ввел пользователь при вводе автора
        this.page = (String) dictArticle.get("количество страниц");
        this.description = (String) dictArticle.get("описание");
    }
// 36 2-23 геттеры

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPage() {
        return page;
    }

    public String getDescription() {
        return description;
    }
// переопределяем метод to String только для title и author и изменим его
    @Override
    public String toString() {
        return title + " (" + author + ')';
    }
}

