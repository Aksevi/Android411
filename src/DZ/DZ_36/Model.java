package DZ.DZ_36;

import java.io.*;
import java.util.*;

import static DZ.DZ_36.View.inputActors;

public class Model {
//список films где хранятся ВСЕ фильмы - читай массив. Map - потому что с ключами и значениями. ключ - строковый (String) а значение - какой то определенный фильм
    private Map<String, Film> films;

//    конструктор. изменяем его. убираем все параметры из скобок так как в момент создания Model туда еще нечего передавать.
    private String film_Base;
    public Model() {
        this.film_Base = "film_base.txt";
//но films нужно инициализировать то есть какое то значение сразу передать. поэтому вместо \this.films = articles;\ делаем так:
        this.films = loadData();// LinkedHashMap<>();
    }
// метод добавления фильма в каталог
    public void addFilm(Map dictFilm){
        Film film = new Film(dictFilm);// созд новый фильм  - обращаемся к типу данных Film созд переменную film и передаем в нее то что приходит в dictFilm. а приходят в нее данные через конструктор класса Film(см ниже)
        films.put((String) dictFilm.get("название фильма"), film); // ключом здесь будет dictFilm.get("название")ОБЯЗАТЕЛЬНО перобразовать к String!!!, значением все данные из film
    }
// метод получения всех фильмов(всего каталога)
    public Collection getAllFilms(){
        return films.values();
    }
// метод получения одного конкретного фильма
    public Map getSingleFilm(String userFilm){
        Film film =  films.get(userFilm);
        Map<String, String> dictFilm = new LinkedHashMap<>();
        dictFilm.put("название фильма", film.getTitle());
        dictFilm.put("жанр", film.getGenre());
        dictFilm.put("режиссер", film.getDirector());
        dictFilm.put("год выпуска", film.getYear());
        dictFilm.put("длительность", film.getLength());
        dictFilm.put("студия", film.getStudio());

        dictFilm.put("актеры", String.valueOf(film.getActors()));// в таком виде тк актеры у нас в списке List идут

        return  dictFilm;
    }
// метод удаления фильма
    public Film removeFilm(String userTitle){
        return films.remove(userTitle);
    }
// метод сохранения  каталога при выходе (q)
    public void saveData(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(film_Base))){
            oos.writeObject(films);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
// метод загрузки  каталога при запуске программы
    public LinkedHashMap loadData(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(film_Base))){
            return (LinkedHashMap) ois.readObject();
         }catch (Exception ex){
            return new LinkedHashMap<>();
        }
    }
}
// вспомогательный класс который отвечает за один конкретный фильм (всю информацию о нем)
class Film implements Serializable {
    private String title;// название
    private String genre;//жанр
    private String director;// режисер
    private String year;// год
    private String length;// длительность
    private String studio;// студия
    private List<String> actors = inputActors();// актеры

// конструктор для List<String> actors
    public Film(List<String> actors) {
        this.actors = actors;

    }

//конструктор. dictFilm - просто имя. по сути это то же что и film
    public Film(Map dictFilm) {
        this.title = (String) dictFilm.get("название фильма");// через этот конструктор получаем в качестве ключа \title\ а в качестве значения то что ввел пользователь при вводе названия/ ниже - принцип такой же
        this.genre = (String) dictFilm.get("жанр");
        this.director = (String) dictFilm.get("режиссер");
        this.year = (String) dictFilm.get("год выпуска");;
        this.length = (String) dictFilm.get("длительность");
        this.studio = (String) dictFilm.get("студия");


    }
// геттеры
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public String getLength() {
        return length;
    }

    public List<String> getActors() {
        return actors;
   }

    public String getStudio() {
        return studio;

    }

    // переопределенный метод. можно изменить
    @Override
    public String toString() {
        return "Фильм: " +
                "\nНазвание: " + title +
                "\nЖанр: " + genre +
                "\nРежиссер: " + director +
                "\nГод выпуска: " + year +
                "\nДлительность: " + length +
                "\nСтудия: ' " + studio +
                "\nАктеры: " + actors;
    }
}

