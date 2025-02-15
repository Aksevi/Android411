package Lesson17.articles;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

// 36 1-17
public class Controller {
    // контроллер должен взаимодействовать с Model и View. для этого в нем создаем две переменные - одна для работы с Model вторая - с View
    private Model articleModel; // для Model
    private View userInterface;// для View

    // Конструктор. Но из принимаемых аргументов ВРЕМЕННО убрали все что принимается
    public Controller() {
        // ВРЕМЕННО закрываем значениями null
//        this.articleModel = null;
        this.articleModel = new Model(); // для работы с классом model
//        this.userInterface = null;
        this.userInterface = new View();// когда в классе View сделали метод String waitUserAnswer() тогда меняем null на new View()
    }

    // метод для запуска программы/ но запускать будем через Main!
    public void run() {
        // так как в меню есть выбор цифр а выход - q, то сделаем все цифры и букву строковыми значениями. то есть ниже переменная типа String - это то что будет выбирать пользователь
        String answer = "";// изначально она пустая

        while (!answer.equals("q")) { // пока пользователь не ввел q. так как q - выход. Сюда попадем хоть один раз по любому так  как строка answer изначально - пустая, то есть не равна q

            answer = userInterface.waitUserAnswer();//  в переменную answer передаем данные которые ввел пользователь. Для этого обращаемся к переменной userInterface экземпляра класса View (стр 15) и вызовем метод waitUserAnswer (см класс View)

            checkUserAnswer(answer);// вызываем метод checkUserAnswer. находится тут потому что вызывать будем в тот момент когда пользователь что то вводит

        }
    }

// 36 1-55 создаем метод который будем вызывать и передавать значение введенное пользователем

    public void checkUserAnswer(String answer) { // ничего не возвращает поэтому просто void. сюда будет приходить то значение которое выбрал в меню пользователь

// здесь варианты работы метода в зависимости от выбора пользователя
        if (answer.equals("1")) { // если answer = 1 ("1" ПОТОМУ ЧТО ВСЕ ЗНАЧЕНИЯ У НАС КАК СТРОКА)
//36 1-59
            Map article = userInterface.addUserArticle();// создаем статью через userInterface метод addUserArticle()( он находится во View)
            articleModel.addArticle(article); // 2-25 обращаемся к articleModel (Controller стр 15) вызываем метод addArticle() (класс Model стр 18)/ article - это те значения что ввел пользователь и они приходят как принимаемый аргумент метода addArticle() в котором они называются Map dictArticle (Model стр 18)
// 36 2-34               
        } else if (answer.equals("2")) {
            // хотим получить все статьи. для этого создаем  Collection (импортируем!!) с именем articles и запрашиваем данные у Model на получение всех статей через articleModel\ - обращение к методу getAllArticles - Model стр 28
            Collection articles = articleModel.getAllArticles();
// обращаемся к userInterface класса View через метод showAllArticles - View стр 47
            userInterface.showAllArticles(articles);

// 37 0-21 реализация пункта просмотра определенной статьи
        } else if (answer.equals("3")) {
            String articleTitle = userInterface.getUserArticle();// запрос какую статью показать \getUserArticle() метод во View

// 37 0-48 try-cacth - обработка исключений (ошибок) чтобы не было ошибок если запросил несуществующую статью
            try {
                Map article = articleModel.getSingleArticle(articleTitle);// возвращаем статью в виде Map\ getSingleArticle метод в Model
                userInterface.showSingleArticle(article);// показ конкретной статьи со всеми значениями \showSingleArticle метод во View
// если запросил несуществующую статью
            } catch ( NullPointerException name) { // NullPointerException - служ метод name - просто имя оно нужно только тут
                userInterface.showIncorrectTitleError(articleTitle); // try-cacth - исключение. showIncorrectTitleError - метод во View
            }
// 37 1-01 для удаления опред статьи
        } else if (answer.equals("4")) {
            String articleTitle = userInterface.getUserArticle();// запрос какую статью удалить \getUserArticle() метод во View

                Article title = articleModel.removeArticle(articleTitle);// переменная типа Article с именем title\ removeArticle() метод удаления из Model. то есть пользователь ввел  какую стаью удалить. в переменную title попало значение метода removeArticle из Model в который в качестве аргумента попало то название которое ввел юзер
            if (title != null)// если значение title не пустое то мтод сработал и удалил
                userInterface.removeSingleArticle(title);//removeSingleArticle метод удаления опред статьи\ removeSingleArticle() метод из View

            else {// если ввели название не существующей статьи - то вывел ошибку из метода showIncorrectTitleError из класса View с названием articleTitle (то что ввел юзер при запросе удаления)
                userInterface.showIncorrectTitleError(articleTitle);
            }
// 37 1-40 этот пункт для реализ сохр при нажатии на "q" (выходе)
        } else if (answer.equals("q")){
            articleModel.saveData();//saveData() метод сохранения в Model

// 37 1-40 если юзер ввел не сущ пункт то выдаст ошибку
        }else {
            userInterface.showIncorrectAnswerError(answer);//showIncorrectAnswerError(answer) метод из View\ answer - то что ввел юзер при выводе пункта меню
        }

    }
}
