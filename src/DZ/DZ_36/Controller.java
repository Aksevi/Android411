package DZ.DZ_36;

import java.util.Collection;
import java.util.Map;

public class Controller {
// для взаимодействия Controller с View и Model две переменныe
    private  Model filmModel;// для работы c Model
    private  View filmInterface;// для работы c View
// конструктор
    public Controller() {
        this.filmModel = new Model();
        this.filmInterface = new View();
    }
// метод запуска. вызывается в Main
    public void run(){
        String answer = "";// переменная в которую попадает выбор пользователя. изначально пустая. так как в выборе есть помимо цифр буква ("q") то делаем переменную типа String

        while (!answer.equals("q")){// пока не ввел "q"
            answer = filmInterface.waitUserAnswer();// в answer передаем данные которые ввел пользователь(в меню выбора) через метод waitUserAnswer() из класса View - обращаемся к filmInterface которая работает с View(стр 9)
            checkUserAnswer(answer);// вызываем метод checkUserAnswer. находится тут потому что вызывать будем в тот момент когда пользователь что-то вводит
        }
    }
// метод который передает значение введенное пользователем
    public void checkUserAnswer(String answer){
        if (answer.equals("1")){ // если нажал "1" (потому что string) то
            Map film = filmInterface.addUserFilm();// создается Map film(список с ключами и значениями) через метод addUserFilm() в классе View/ filmInterface работает с View(стр 9)
            filmModel.addFilm(film);// через переменную filmModel (стр 8) вызываем метод addFilm из класса Model и передаем в него значение film

        } else if (answer.equals("2")) {
            Collection films = filmModel.getAllFilms();
            filmInterface.showAllFilms(films);

        } else if (answer.equals("3")) {
            String filmTitle = filmInterface.getUserFilm();

            try{
                Map film = filmModel.getSingleFilm(filmTitle);// получаем конкретный фильм
                filmInterface.showSingleFilm(film);
            }catch (NullPointerException name){
                filmInterface.showIncorrectTitleError(filmTitle);
            }

        } else if (answer.equals("4")) {
            String filmTitle = filmInterface.getUserFilm();
            Film name = filmModel.removeFilm(filmTitle);
            if(name != null)
                filmInterface.removeSingleFilm(name);
            else{
                filmInterface.showIncorrectTitleError(filmTitle);
            }

        }else if (answer.equals("q")){
            filmModel.saveData();
        }else {
            filmInterface.showIncorrectTitleError(answer);
        }
    }
}
