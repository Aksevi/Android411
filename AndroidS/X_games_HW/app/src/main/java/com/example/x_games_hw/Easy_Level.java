package com.example.x_games_hw;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Easy_Level extends AppCompatActivity {

    private final List<int[]> winCombinationList = new ArrayList<>(); // список победных вариантов
    private TextView playerName; // имя игрока
    private TextView phoneName; // модель тлф

    private int activePlayer = 1; // кто ходит. по умолчанию - игрок (1)

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // массив полей
    private int count = 1; // счетчик ходов. он = 1 потому как в самом начале - первый ход
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9; // переменные изображений - это у нас сами поля с фоном


    private int humanScore;
    private int computerScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_easy_level);

        playerName = findViewById(R.id.player); // TextView - тип переменной  playerTextView - имя переменной. findViewById(R.id.playerName) - получили доступ по id где playerName - это id текстового поля из easy_level.xml

        phoneName = findViewById(R.id.phoneName); // TextView - тип переменной  phoneTextView - имя переменной. findViewById(R.id.phoneModel) - получили доступ по id где phoneModel - это id текстового поля из easy_level.xml

// здесь добавляем победные комбинации в список победных вариантов
        winCombinationList.add(new int[]{0, 1, 2});
        winCombinationList.add(new int[]{3, 4, 5});
        winCombinationList.add(new int[]{6, 7, 8});
        winCombinationList.add(new int[]{0, 3, 6});
        winCombinationList.add(new int[]{2, 5, 8});
        winCombinationList.add(new int[]{0, 4, 8});
        winCombinationList.add(new int[]{2, 4, 6});
        winCombinationList.add(new int[]{1, 4, 7});

        String getPlayerName = getIntent().getStringExtra("playerName"); // получаем имя которое ввел игрок в mainActivity.java
        String phoneModel = Build.MODEL; // получаем модель телефона

        playerName.setText(getPlayerName); // устанавливаем в поле  playerTextView имя которое ввел юзер в поле getPlayerName из MainActivity и которое мы получили в переменную getPlayerName на этой странице
        phoneName.setText(phoneModel); // устанавливаем в поле  phoneTextView модель телефона которую получили в переменную phoneModel  с помощью Build.MODEL

// получаем доступ к полям изображений по id
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

// метод обрабатывающий нажатие на поле
// нажимаем на поле и ставим значок
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) { // boxPosition - это номер клетки поля считаются сверху вниз слева направо. isBoxSelectable - метод проверки свободна ли клетка. если свободна - ставится крестик или нолик

                    action((ImageView) v, 0); // если свободна -  вызов функции action -  (ImageView) v - приведение v к типу (ImageView)
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {

                    action((ImageView) v, 1); // вызов функции performAction
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {

                    action((ImageView) v, 2); // вызов функции performAction
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {

                    action((ImageView) v, 3); // вызов функции performAction
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {

                    action((ImageView) v, 4); // вызов функции performAction
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {

                    action((ImageView) v, 5); // вызов функции performAction
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {

                    action((ImageView) v, 6); // вызов функции performAction
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {

                    action((ImageView) v, 7); // вызов функции performAction
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)) { // вызов метода проверки занята ли клетка - если метод считает что не занята то срабатывает функция performAction

                    action((ImageView) v, 8); // вызов функции performAction
                }

            }
        });

    }

    // метод в котром обрабатывается событие нажатия кнопки игроком
    private void action(ImageView imageView, int selectPosition) { // int selectedPosition - позиция (или индекс) ячейки массива полей

        boxPositions[selectPosition] = activePlayer; // boxPositions - это массив игрового поля. [selectPosition] - это ячейка куда игрок ставит крестик или нолик. activePlayer - это активный игрок (1 или 2 - игрок или компьютер соответственно). то есть когда ходит первый игрок 0 в boxPositions заменяется на 1 (или на 2 когда ходит компьютер) в соответствующей клетке. получается что то типа  boxPositions = {1, 2, 0, 2, 2, 1, 0, 1, 0} где 0 - незанятые клетки а 1 и 2 - занятые соответствующими символами Х или О

        imageView.setBackgroundResource(R.drawable.white_box); // чтобы при выборе клетки в ней поле не заменялось значком а  значок ставился поверх фона. то есть этой командой мы снова ставим фон
        imageView.setScaleType(ImageView.ScaleType.CENTER);// здесь центруем значок по центру фона


// если ходит игрок 1
        if (activePlayer == 1) {

            imageView.setImageResource(R.drawable.ximage);// то ставим крестик
// проверка на победу
            if (checkWin()) { // checkWin() это метод ниже в котором и осуществляется проверка на победу
                ResultSource resultSource = new ResultSource(Easy_Level.this, playerName.getText().toString() + " Победил!!!", Easy_Level.this); // ResultSource - тип переменной resultSource - имя переменной. если метод определил победу то выводится окно с именем игрока и надписью что он победил (playerName.getText().toString() + " Победил!!!")
                resultSource.setCancelable(false); // это означает что окно нельзя закрыть нажатием мимо окна
                resultSource.show(); // собственно вызов работы переменной
// получаем доступ к полям счета
                TextView textScore1 = findViewById(R.id.playerScore);

                humanScore++; // увеличиваем счет побед игрока
                textScore1.setText(String.valueOf(humanScore)); // пишем в поле счета игрока счет
// проверка на ничью
            } else if (count == 9) { // если 9 ходоа есть и нет победителя то ничья
                ResultSource resultSource = new ResultSource(Easy_Level.this, "Ничья!!!", Easy_Level.this);
                resultSource.setCancelable(false);
                resultSource.show();

            } else { // если победы нет и нечьей нет то передаем ход игроку 2(компьютеру)
                changePlayer(2);
// это метод задержки чтобы комп ходит с некоторой паузой
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        computerMove(); // метод Хода компьютера
                    }
                }, 1000); // Задержка 1 секунда (1000 миллисекунд)
            }
            count++; // увеличиваем счетчик ходов

        }

    }

    // метод проверки на победу
    private boolean checkWin() {

        boolean resultWin = false; // булевая переменная  resultWin (победа) по умолчанию - false

        for (int i = 0; i < winCombinationList.size(); i++) { // идем по массиву .size() - потому что ArrayList (см вверху в самом). Напомню что массив  двухуровневый  ивыглядит так {0,1,2} (первый индекс), {3,4,5} (второй индекс), {6,7,8} (третий индекс) и тд

            final int[] combination = winCombinationList.get(i); // создаем переменную combination и кладем в нее по очереди  индексы массива

            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer) { // если в одном индексе вложенные индексы 0, 1 и 2 равны активному игроку (то есть в них проставлены цифры 1 или 2) то это победная комбинация. Напомню - изначально массив такой {0, 0, 0}, {0, 0, 0}, {0, 0, 0}/ по мере ходов нули заменяются на 1 и 2 в зависимости кто ходит.
                resultWin = true; // если условие победной комбинации выполнено то resultWin меняем на true
            }
        }
// возвращаем результат работы метода. если if выше сработал на победную комбинацию то вернем true/ если не сработал то вернем false
        return resultWin;
    }


    // метод переключения на другого игрока
    private void changePlayer(int currentPlayer) { // сам метод.  currentPlayer - переменная этого метода

        activePlayer = currentPlayer; // activePlayer - переменнная активного игрока которую создали вверху.  currentPlayer - переменная этого метода. соответственно ей присваиваем 1 или 2 (первого или второго игрока) когда вызываем этот метод. например changePlayer(2) или changePlayer(1)

// Обновляем цвет текста для текущего игрока
        if (activePlayer == 1) {
            playerName.setTextColor(Color.RED);
            phoneName.setTextColor(Color.LTGRAY);
        } else {
            playerName.setTextColor(Color.LTGRAY);
            phoneName.setTextColor(Color.RED);

        }
    }

    // метод проверки занята ли клетка
    private boolean isBoxSelectable(int boxPosition) { // булевая метод для проверки занята ли клетка
        boolean response = false; // по умолчанию  занята
        if (boxPositions[boxPosition] == 0) { // boxPositions - это наш массив из 9 кнопок полей. [boxPosition] - это иодин эелемент массива. проверяем  - если этот элемент = 0 то есть не занята
            response = true;// то прога думает что не занята и можно ставить значок

        }
        return response; // иначе если клетка не = 0 то есть занята то возвращаем response = false
    }


    // функция перезапуска игры
    public void restartMatch() {

        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; // обнуляем значения массива так как в нем выше уже значения перезаписаны на 1 и 2

        activePlayer = 1; // обнуляем игрока. снова активный - игрок 1

        count = 1; // сбрасываем счетчик ходов

// получаем доступ по id. переменные image 1-9 объявлены выше как тип ImageView
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

// сбрасываем все заполненные клеточки на дефолт
        image1.setImageResource(R.drawable.white_box);
        image2.setImageResource(R.drawable.white_box);
        image3.setImageResource(R.drawable.white_box);
        image4.setImageResource(R.drawable.white_box);
        image5.setImageResource(R.drawable.white_box);
        image6.setImageResource(R.drawable.white_box);
        image7.setImageResource(R.drawable.white_box);
        image8.setImageResource(R.drawable.white_box);
        image9.setImageResource(R.drawable.white_box);
    }


    // ход компьютера
    private void computerMove() {
//это объявляем для работы метода хода посложнее 338-349/ тут типа из кнопок полей сделали массив


        List<Integer> emptyCells = new ArrayList<>(); //создаем список с именем emptyCells. сюда будем помещать те клетки  которые еще не ходили
        for (int i = 0; i < boxPositions.length; i++) { // проходимся по списку boxPositions (это наши поля клетки)
            if (boxPositions[i] == 0) { // и если клетка пустая (==0)
                emptyCells.add(i); // добавляем ее в массив пустых полей
            }
        }
// "Если пустых ячеек больше нет (emptyCells.isEmpty() возвращает true), то дальше делать нечего — просто выходим из метода (return)". То есть — игровое поле полностью занято, и никакой ход больше невозможен.
        if (emptyCells.isEmpty()) {
            return;
        }


// тут у нас типа интеллект

        int selectedPosition = getWinningMove(2); // // объявляем переменную selectedPosition - этой переменной обозначаем  клетки куда ходит комп. Ищем, есть ли где-нибудь победная комбинация, где у компьютера уже 2 клетки и осталась одна пустая. Если такая есть — метод вернёт индекс этой клетки (и мы туда сразу поставим нолик — победа!).

// Если выиграть не получилось (-1 означает "не нашёл клетку для победы"),то ищем — а не собирается ли игрок победить в следующем ходу? Если игрок занял 2 клетки в одной линии, а третья пустая — мы туда срочно ставим свой нолик, чтобы не дать ему выиграть.
        if (selectedPosition == -1) {
            selectedPosition = getWinningMove(1);
        }
// если нет ни варианта победы ни закрыть игрока но свободен центр(4 клетка) то комп ходит туда
        if (selectedPosition == -1 && isBoxSelectable(4)) { // если по методу isBoxSelectable 4 клетка (нумерация с 0 !!!) = 0 то есть пустая (см работу метода isBoxSelectable!)
            selectedPosition = 4; // то комп ходит в клетку 4
        }

// ну и если ничего полезного никак не выходит то ходим рандомно
            if (selectedPosition == -1){
                // Случайная пустая клетка
                selectedPosition = emptyCells.get(new Random().nextInt(emptyCells.size())); // emptyCells.size() — узнаём, сколько пустых ячеек осталось. new Random().nextInt(...) — получаем случайное число от 0 до emptyCells.size() - 1. emptyCells.get(...) — достаём по этому индексу одну из пустых клеток. selectedPosition — сохраняем выбранную позицию, чтобы сделать туда ход.

            }
            // "Имитация" нажатия на клетку от имени компьютера
            ImageView selectedImage = null; // изначально выбранная клетка - ничего не содержит
            switch (selectedPosition) { // selectedPosition это ранее выбранная случайцная клетка. соответственно комп смотрит на ее позицию и делаем ход в соответствующий case
                case 0:
                    selectedImage = image1;
                    break;
                case 1:
                    selectedImage = image2;
                    break;
                case 2:
                    selectedImage = image3;
                    break;
                case 3:
                    selectedImage = image4;
                    break;
                case 4:
                    selectedImage = image5;
                    break;
                case 5:
                    selectedImage = image6;
                    break;
                case 6:
                    selectedImage = image7;
                    break;
                case 7:
                    selectedImage = image8;
                    break;
                case 8:
                    selectedImage = image9;
                    break;
            }

            if (selectedImage != null) { // соотсветсвенно если не пустая значит ставит нолик ну и фон и центрует это все
                selectedImage.setImageResource(R.drawable.oimage);
                boxPositions[selectedPosition] = activePlayer;
                selectedImage.setBackgroundResource(R.drawable.white_box);
                selectedImage.setScaleType(ImageView.ScaleType.CENTER);

                TextView textScore2 = findViewById(R.id.phoneScore);

// проверка на победу
                if (checkWin()) {
                    ResultSource resultSource = new ResultSource(Easy_Level.this, phoneName.getText().toString() + " Победил!!!", Easy_Level.this);
                    resultSource.setCancelable(false);
                    resultSource.show();

                    computerScore++;
                    textScore2.setText(String.valueOf(computerScore));
                } else if (count == 9) {
                    ResultSource resultSource = new ResultSource(Easy_Level.this, "Ничья!!!", Easy_Level.this);
                    resultSource.setCancelable(false);
                    resultSource.show();

                } else {
                    changePlayer(1);
                    count++;

                }
            }

        }


// метод поиска победного хода попроще
        private int getWinningMove ( int player){
// список победных комбинаций
            int[][] winningCombinations = {
                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // строки
                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // столбцы
                    {0, 4, 8}, {2, 4, 6}             // диагонали
            };

// поиск сколько клеток из победной комбинации занял игрок (combo - это {0,0,0} а index это одна из цифр внутри комбо)
            for (int[] combo : winningCombinations) { // combo - просто название переменной для цикла for/ ну типа это одна победная комбинация. вот это "combo : winningCombinations" читается как "для каждой комбинации combo в массиве winningCombinations сделай...". короче проходит по массиву winningCombinations и  в combo закидывает по очереди   и тд ( победные комбинации)

                int countPlayer = 0; // это счетчик котрый считает сколько клеток занято игроком
                int emptyIndex = -1; // это переменная куда заполминаем номер пустой клетки в combo. -1 потому что на данном этапе пустых клеток нет. когда найдем то присвоим сюда индекс пустой клетки

// а здесь мы уже проходим по каждой победной комбинации combo {0, 1, 2}, {3, 4, 5} и тд
                for (int index : combo) {
                    if (boxPositions[index] == player) { // если в списке combo находим клетку занятую игроком то
                        countPlayer++; // увеличиваем число занятых игроком клеток
                    } else if (boxPositions[index] == 0) { // если находим клетку не занятую игроком
                        emptyIndex = index; // то присваиваем ее индекс в emptyIndex
                    }
                }
// если игрок занял 2 клетки и одна пустая (emptyIndex != -1) то комп ходит сюда
                if (countPlayer == 2 && emptyIndex != -1) {
                    return emptyIndex;
                }
            }

            return -1;
        }


}





//???
/*    private void makeMove(int position, int player) {

        ImageView[] imageViews;
        imageViews = new ImageView[]{
                findViewById(R.id.image1),
                findViewById(R.id.image2),
                findViewById(R.id.image3),
                findViewById(R.id.image4),
                findViewById(R.id.image5),
                findViewById(R.id.image6),
                findViewById(R.id.image7),
                findViewById(R.id.image8),
                findViewById(R.id.image9)
        };

        if (boxPositions[position] != 0) return;

        ImageView selectedImage = imageViews[position];
        selectedImage.setImageResource(player == 1 ? R.drawable.ximage : R.drawable.oimage);
        selectedImage.setBackgroundResource(R.drawable.white_box);
        selectedImage.setScaleType(ImageView.ScaleType.CENTER);

        boxPositions[position] = player;
        count++;

        if (checkWin()) {
            ResultSource resultSource = new ResultSource(Easy_Level.this,
                    (player == 1 ? playerName.getText().toString() : "Компьютер") + " Победил!!!",
                    Easy_Level.this);
            resultSource.setCancelable(false);
            resultSource.show();

            if (player == 1) {
                phoneScore++;
                TextView textScore2 = findViewById(R.id.textScore2);
                textScore2.setText(String.valueOf(playerScore));
            }
        } else if (count == 9) {
            ResultSource resultSource = new ResultSource(Easy_Level.this, "Ничья!!!", Easy_Level.this);
            resultSource.setCancelable(false);
            resultSource.show();
        } else {
            changePlayer(player == 1 ? 2 : 1);

//    }*/



// метод поиска победного хода посложнее
/*
private int findWinningMove(int player) {
    int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // строки
            {0,3,6}, {1,4,7}, {2,5,8}, // столбцы
            {0,4,8}, {2,4,6}           // диагонали
    };

    for (int[] combo : winPositions) {
        int a = combo[0], b = combo[1], c = combo[2];
        int countPlayer = 0;
        int empty = -1;

        if (boxPositions[a] == player) countPlayer++;
        else if (boxPositions[a] == 0) empty = a;

        if (boxPositions[b] == player) countPlayer++;
        else if (boxPositions[b] == 0) empty = (empty == -1) ? b : empty;

        if (boxPositions[c] == player) countPlayer++;
        else if (boxPositions[c] == 0) empty = (empty == -1) ? c : empty;

        if (countPlayer == 2 && empty != -1) {
            return empty;
        }
    }
    return -1;

    }
*/
