package com.example.gamexo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class PlayingField extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>(); // массив хранящий победные комбинации

    private TextView playerOneName; // переменная для имени игрока 1
    private TextView playerTwoName; // переменная для имени игрока 2

    private int activePlayer = 1; // переменная активного игрока - то есть того кто в данный момент времени ходит. по умолчанию - первый игрок

    private int [] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0}; // массив из 9 кнопок-полей куда ставим крестики нолики

    private int totalSelectBoxes = 1; // подсчет текущего  хода. изначально текущий ход - первый

    private ImageView image1, image2, image3, image4, image5, image6, image7, image8 ,image9; // переменные для получения доступ к изображениям полей кнопок image1-9 это их id в activity_playing_field.xml

// переменные счета для игроков
    private int  currentScoreOne = 0;
    private int  currentScoreTwo = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_playing_field);

        playerOneName = findViewById(R.id.PlayerOneName); // доступ к текст полям из playing field.xml
        playerTwoName = findViewById(R.id.PlayerTwoName); // доступ к текст полям из playing field.xml
        
// заносим в массив комбинаций варианты. с 0 потому что ячеек 9, а считаем с 0 по 8!!!
        combinationList.add(new int[]{0, 1, 2}); // здесь указываем когда будет победа - то есть когда крестик или нолик занимает 3 поля по горизонтали вертикали или даигонали. цифры - это номера полей слева направо сверху вниз
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});
        

        String getPlayerOneName = getIntent().getStringExtra("playerOne"); // стринговая переменная getPlayerOneName (просто имя) и в нее получаем данные которые передавали по ключу "playerOne" из майн активити
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo"); // стринговая переменная getPlayerTwoName (просто имя) и в нее получаем данные которые передавали по ключу "playerTwo" из майн активити

        playerTwoName.setText(getPlayerOneName); // передаем в переменную playerTwoName то что получили из майн активити в TextView PlayerOneName - то есть в текстовое поле имя игрока 1
        playerOneName.setText(getPlayerTwoName); // передаем в переменную playerOneName то что получили из майн активити в TextView PlayerTwoName - то есть в текстовое поле имя игрока 2

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

// нажимаем на кнопки ставя символ
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) {

                    performAction((ImageView) v, 0); // вызов функции performAction -  (ImageView) v - приведение v к типу (ImageView)
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {

                    performAction((ImageView) v, 1); // вызов функции performAction
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {

                    performAction((ImageView) v, 2); // вызов функции performAction
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {

                    performAction((ImageView) v, 3); // вызов функции performAction
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {

                    performAction((ImageView) v, 4); // вызов функции performAction
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {

                    performAction((ImageView) v, 5); // вызов функции performAction
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {

                    performAction((ImageView) v, 6); // вызов функции performAction
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {

                    performAction((ImageView) v, 7); // вызов функции performAction
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)){ // вызов метода проверки занята ли клетка - если метод считает что не занята то срабатывает функция performAction

                    performAction((ImageView) v, 8); // вызов функции performAction
                }

            }
        });

    }

// функция что происходит если нажал на кнопку
    private void performAction(ImageView imageView, int selectedBoxPosition){  // int selectedBoxPosition - позиция (или индекс) ячейки массива полей

        boxPositions[selectedBoxPosition] = activePlayer; // boxPositions - это индекс arraylist которому соответствует одна из клеток поля игрового. activePlayer - это активный игрок (1 или 2 цифры). соответсвенно когда ходит первый игрок в boxPositions[selectedBoxPosition] ставится 1, когда второй - 2 -> private int [] boxPositions = {1, 2, 1, 1, 2, 2, 0, 0, 0} и тд
        imageView.setBackgroundResource(R.drawable.white_box);// чтобы при нажатии и установке символа фон (белый квадратик) не убирался а значок ставился поверх него
        imageView.setScaleType(ImageView.ScaleType.CENTER); // центрируем изображение по центру, то есть крестик или нолик будут ставится не на все поле а по центру с отступами

// доступ к текст полям из playing field.xml копируем сверху просто
        playerOneName = findViewById(R.id.PlayerOneName);
        playerTwoName = findViewById(R.id.PlayerTwoName);
// получаем доступ полю счета
        TextView scoreOne = findViewById(R.id.scoreOne);
        TextView scoreTwo = findViewById(R.id.scoreTwo);

// если ходит 1 игрок
        if (activePlayer == 1){
            imageView.setImageResource(R.drawable.ximage); // то ставится в клетку крестик

// вызываем метод проверки на победу
            if (checkResult()){ // если попали в победную комбинацию
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, playerOneName.getText().toString() + " is a Winner!", PlayingField.this); // открываем диалоговое окно с надписью в этом же окне
                resultDialog.setCancelable(false); // можно ли закрыть окно кликнув за его пределами
                resultDialog.show(); // показывает окно с результатом

// если победа то увеличиваем счет игрока 1 на единицу
                currentScoreOne++;
                scoreOne.setText(String.valueOf(currentScoreOne)); // записываем счет в поле счета игрока 1

            }
            else if(totalSelectBoxes == 9 ){ // проверяем на ничью если ходов уже 9 и никто не победил
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, "Ничья!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }

            else { // если победы нет то передаем ход второму игроку
                changePlayerTurn(2); // вызов метода переключения на 2 игрока
                totalSelectBoxes++; // счетчик хода  увеличиваем на 1
            }
        }
        else { // иначе если ходит 2 игрок
            imageView.setImageResource(R.drawable.oimage); // то ставится в клетку нолик

// вызываем метод проверки на победу
            if (checkResult()){ // если попали в победную комбинацию
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, playerTwoName.getText().toString() + " is a Winner!", PlayingField.this); // открываем диалоговое окно с надписью в этом же окне
                resultDialog.setCancelable(false); // можно ли закрыть окно кликнув за его пределами
                resultDialog.show(); // показывает окно с результатом

// если победа то увеличиваем счет игрока 2 на единицу
                currentScoreTwo++;
                scoreTwo.setText(String.valueOf(currentScoreTwo)); // записываем счет в поле счета игрока 2
            }

            else if(totalSelectBoxes == 9 ){ // проверяем на ничью если ходов уже 9 и никто не победил
                ResultDialog resultDialog = new ResultDialog(PlayingField.this, "Ничья!", PlayingField.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else { // если победы нет то передаем ход второму игроку
                changePlayerTurn(1); // вызов метода переключения на 1 игрока
                totalSelectBoxes++; // счетчик хода  увеличиваем на 1
            }
        }

    }
//  метод проверки на победу
    private boolean checkResult(){
        
        boolean resultWin = false; // по умолчанию. победы нет

        for (int i = 0; i < combinationList.size(); i++) { // идем по массиву. длина массива ограничение .size  потому что arraylist.
            final int[] combination = combinationList.get(i); // присваиваем в combination элемент из списка {0, 1, 2}, {3, 4, 5} и тд

            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer) {// идет по масиву и проверяет на комбинации. смысл - вложенный массив из 3 элементов то есть  {0, 1, 2} - это 1 индекс, {3, 4, 5} - второй и так далее и внутри этого индекса еще элементы 0, 1, 2 и так далее. то есть он проверяет так - берет combination и проверяет равны ли ее элементы значку игрока 1 [0] индекс равен активному игроку && (И!!) [1] равен активному игроку, && (И!!) [2] равен активному игроку. если равны - то выдает победный диалог
                resultWin = true; // меняем значение resultWin на true
            }
        }
        return resultWin; // если победной комбинации не найдено то возвращает resultWin = false; и играем дальше
        
    }
    
    //  метод переключения игрока
    private void changePlayerTurn(int currentPlayerTurn){
        activePlayer = currentPlayerTurn; //  currentPlayerTurn - это переменная с которой работает этот метод.  activePlayer это переменная котрую создали в самомо верху. ей присваиваем переменную с которой работает этот метод. и дальше просто меняем 1 на 2 и наоборот, когда вызываем метод - например changePlayerTurn(1); или changePlayerTurn(2);

// доступ к текстовому полю в слое LinearLayout
        LinearLayout PlayerOneLayoutOuter = findViewById(R.id.PlayerOneLayoutOuter); //LinearLayout  - тип данных PlayerOneLayoutOuter - имя
        LinearLayout PlayerTwoLayoutOuter = findViewById(R.id.PlayerTwoLayoutOuter); //LinearLayout  - тип данных PlayerOneLayoutOuter - имя

        if (activePlayer == 1){
            PlayerOneLayoutOuter.setBackgroundResource(R.drawable.black_border); // выделяем рамкой активного игрока
            PlayerTwoLayoutOuter.setBackgroundResource(R.drawable.white_box); // нет рамки

        }
        else {
            PlayerTwoLayoutOuter.setBackgroundResource(R.drawable.black_border); // выделяем рамкой активного игрока
            PlayerOneLayoutOuter.setBackgroundResource(R.drawable.white_box);
        }
    }


// метод проверки занята ли клетка
    private boolean isBoxSelectable(int boxPosition){ // булевая метод для проверки занята ли клетка
        boolean response = false; // по умолчанию  занята
        if (boxPositions[boxPosition] == 0){ // boxPositions - это наш массив из 9 кнопок полей. [boxPosition] - это иодин эелемент массива. проверяем  - если этот элемент = 0 то есть не занята
            response = true;// то прога думает что не занята и можно ставить значок

        }
        return response; // иначе если клетка не = 0 то есть занята то возвращаем response = false
    }

// функция перезапуска игры
public void restartMatch()  {

    boxPositions = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0}; // обнуляем значения массива так как в нем выше уже значения перезаписаны на 1 и 2

    activePlayer = 1; // обнуляем игрока. снова активный - игрок 1

   totalSelectBoxes = 1; // сбрасываем счетчик ходов

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
}