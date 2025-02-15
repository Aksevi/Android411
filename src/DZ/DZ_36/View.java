package DZ.DZ_36;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    Scanner input = new Scanner(System.in);

    // метод получения выбора пользователя
    public String waitUserAnswer() {
        System.out.println("============ Редактирование данных каталога фильмов ============");
        System.out.println("Действие с фильмами:");
        System.out.println("1 - добавить фильм" + "\n2 - каталог фильмов" + "\n3 - просмотр определенного фильма" + "\n4 - удаление фильма" + "\nq - выход из программы");
        System.out.print("Выберите действие: ");
        String userAnswer = input.nextLine();
        System.out.println("======================================================");
        return userAnswer;
    }

    // метод создания фильма в каталоге. тип данных Map потому что будет ключ(например "название фильма") и само значение (само название которое ввел пользователь)
    public Map addUserFilm() {
        Map<String, String> dictFilm = new LinkedHashMap<>();
        dictFilm.put("название фильма", "");//"название" это ключ,  значение еще не ведено поэтому пустая строка ("")
        dictFilm.put("жанр", "");
        dictFilm.put("режиссер", "");
        dictFilm.put("год выпуска", "");
        dictFilm.put("длительность", "");
        dictFilm.put("студия", "");
        dictFilm.put("актеры", "");
        System.out.println("============ Добавление фильма ============");
// задействуем ключи текущего элемента. В этом цикле пользователь выбирает пункт меню и далее по циклу идем - ввел название -> запрос режиссера -> запрос года выпуска и тд
        for (Map.Entry<String, String> temp : dictFilm.entrySet()) {
            System.out.print(temp.getKey() + ": ");
            dictFilm.put(temp.getKey(), input.nextLine());
        }
        System.out.println("======================================================");
        return dictFilm;
    }

    // метод показа всего каталога. в качестве аргументов - Collection
    public void showAllFilms(Collection films) {
        System.out.println("=================== Каталог фильмов ===================");
// для вывода элементов используем цикл
        for (var element : films) { // var - переменная любого типа
            System.out.println(element);
        }
        System.out.println("=====================================================");
    }

    public String getUserFilm() {
        System.out.println("=================== Ввод названия фильма ===================");
        System.out.print("-> ");
        String user_film = input.nextLine();
        System.out.println("=====================================================");
        return user_film;
    }

    public void showSingleFilm(Map film) {
        System.out.println("=================== Просмотр фильма ===================");
        for (var el : film.entrySet()) {
            System.out.println(el);
        }
        System.out.println("=====================================================");

    }

    public void showIncorrectTitleError(String filmTitle) {// articleTitle - это то что в Controller в стр 60 приходит в вывод ошибки. грубо говоря ввел несуществующую статью она и попадает в метод обработки ошибок
        System.out.println("=================== Сообщение об ошибке ===================");
        System.out.println("Статьи с названием " + filmTitle + " не существует");
        System.out.println("=====================================================");
    }

    public void removeSingleFilm(Film title){
        System.out.println("=================== Удаление фильма ===================");
        System.out.println("Фильм " + title + " был удален");
        System.out.println("=====================================================");

    }


}

