package com.example.black_jack;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level1 extends AppCompatActivity {

    Dialog dialog; // создаем переменную класса  Dialog с именем  dialog. класс сделали сами - это типа диалоговое окно имя - может быть любое появляется в начале уровня

    // эти переменные используются во всем коде. поэтому их тут и в таком виде
    private LinearLayout layoutDealerCards; // слой карт дилера
    private LinearLayout layoutPlayerCards; // слой карт игрока

    private List<Card> deck; // колода карт
    private List<Card> playerHand; // карты на руках игрока
    private List<Card> dealerHand; // карты на руках дилера

    private int playerTotal; // счет игрока
    private int dealerTotal; // счет дилера



    // элементы интерфейса - кнопки тектсовые поля картинки
    private Button buttonHint1; // кнопка взять карту
    private Button buttonStand1; // кнопка остановиться
    private TextView playerName; // поле имени игрока
    private TextView playerScore; // поле счета игрока
    private TextView dealerName; // поле имени игрока
    private TextView dealerScore; // поле счета игрока
    private TextView buttonBack;
    private TextView buttonRestart;

    private Button buttonBet1;
    private Button doubleBet1;
    private TextView playerBankShow;
    private TextView dealerBankShow;
    private TextView textBank;
    private boolean gameOver = false; // булевая переменная окончания игры. изначально игра не окончена
    private boolean bancrote = false;// булевая переменная на банкрота.
    private int playerCash = 10; // кэш игрока
    private int dealerCash = 10; // кэш дилера
    private int bet = 2; // размер ставки
    private boolean wBet = false; // булевая переменная удвоеной ставки. нужна чтобы корректно возвращать кэш игрокамив случае ничьей. без нее вернется только размер ставки то есть будем терять кэш на размер ставки
    private int bank = 0; // переменная размера банка (куда лепим ставки)



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

//==========================диалоговое окно при старте==============================================
// здесь расположен потому что иначе глюк будет с отображением очков дилера. сперва делал после колоды перед кнопкой назад но был косяк. поэтому здесь
        dialog = new Dialog(this); // создаем новое диалоговое окно и оно откроется в этом же окне (this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрываем заголовок этогг окна(как я помнял сверху не будет плашки с текстом типа новове окно или диалоговое окно)
        dialog.setContentView(R.layout.dialog);// Подключаем XML-файл, в котором ты заранее создал внешний вид диалога (например, текст и кнопка). Файл res/layout/dialog.xml — это и есть шаблон твоего окна.
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// устанавливаем прозрачность фона диалогового окна (чтобы рамки не было белой хз откуда она там берется)
        dialog.setCancelable(false);// нельзя закрыть окно кликом за его пределами
        Button dialog_button = dialog.findViewById(R.id.dialog_button); //Находим кнопку внутри твоего dialog.xml, у которой в разметке указан android:id="@+id/dialog_button".
// при нажатии на кнопку диалог закроется (вызов dialog.dismiss()).
        dialog_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show(); // показываем диалог
//=================================================================================================

//*********************** Заполняем колоду карт ******************************************
        deck = new ArrayList<>();
        // каждая карта - объект класса Card у которого есть картинка (R.drawable.ace_of_clubs), значение (11) и масть ("clubs"). Значение нужно для подсчиета очков
        deck.add(new Card(R.drawable.ace_of_clubs, 11, "clubs"));
        deck.add(new Card(R.drawable.ace_of_diamonds, 11, "diamonds"));
        deck.add(new Card(R.drawable.ace_of_hearts, 11, "hearts"));
        deck.add(new Card(R.drawable.ace_of_spades2, 11, "diamonds"));

        deck.add(new Card(R.drawable.king_of_clubs2, 10, "clubs"));
        deck.add(new Card(R.drawable.king_of_diamonds2, 10, "diamonds"));
        deck.add(new Card(R.drawable.king_of_hearts2, 10, "hearts"));
        deck.add(new Card(R.drawable.king_of_spades2, 10, "diamonds"));

        deck.add(new Card(R.drawable.queen_of_clubs2, 10, "clubs"));
        deck.add(new Card(R.drawable.queen_of_diamonds2, 10, "diamonds"));
        deck.add(new Card(R.drawable.queen_of_hearts2, 10, "hearts"));
        deck.add(new Card(R.drawable.queen_of_spades2, 10, "diamonds"));

        deck.add(new Card(R.drawable.jack_of_clubs2, 10, "clubs"));
        deck.add(new Card(R.drawable.jack_of_diamonds2, 10, "diamonds"));
        deck.add(new Card(R.drawable.jack_of_hearts2, 10, "hearts"));
        deck.add(new Card(R.drawable.jack_of_spades2, 10, "diamonds"));

        deck.add(new Card(R.drawable.ten_of_clubs, 10, "clubs"));
        deck.add(new Card(R.drawable.ten_of_diamonds, 10, "diamonds"));
        deck.add(new Card(R.drawable.ten_of_hearts, 10, "hearts"));
        deck.add(new Card(R.drawable.ten_of_spades, 10, "diamonds"));

        deck.add(new Card(R.drawable.nine_of_clubs, 9, "clubs"));
        deck.add(new Card(R.drawable.nine_of_diamonds, 9, "diamonds"));
        deck.add(new Card(R.drawable.nine_of_hearts, 9, "hearts"));
        deck.add(new Card(R.drawable.nine_of_spades, 9, "diamonds"));

        deck.add(new Card(R.drawable.eight_of_clubs, 8, "clubs"));
        deck.add(new Card(R.drawable.eight_of_diamonds, 8, "diamonds"));
        deck.add(new Card(R.drawable.eight_of_hearts, 8, "hearts"));
        deck.add(new Card(R.drawable.eight_of_spades, 8, "diamonds"));

        deck.add(new Card(R.drawable.seven_of_clubs, 7, "clubs"));
        deck.add(new Card(R.drawable.seven_of_diamonds, 7, "diamonds"));
        deck.add(new Card(R.drawable.seven_of_hearts, 7, "hearts"));
        deck.add(new Card(R.drawable.seven_of_spades, 7, "diamonds"));

        deck.add(new Card(R.drawable.six_of_clubs, 6, "clubs"));
        deck.add(new Card(R.drawable.six_of_diamonds, 6, "diamonds"));
        deck.add(new Card(R.drawable.six_of_hearts, 6, "hearts"));
        deck.add(new Card(R.drawable.six_of_spades, 6, "diamonds"));

        deck.add(new Card(R.drawable.five_of_clubs, 5, "clubs"));
        deck.add(new Card(R.drawable.five_of_diamonds, 5, "diamonds"));
        deck.add(new Card(R.drawable.five_of_hearts, 5, "hearts"));
        deck.add(new Card(R.drawable.five_of_spades, 5, "diamonds"));

        deck.add(new Card(R.drawable.four_of_clubs, 4, "clubs"));
        deck.add(new Card(R.drawable.four_of_diamonds, 4, "diamonds"));
        deck.add(new Card(R.drawable.four_of_hearts, 4, "hearts"));
        deck.add(new Card(R.drawable.four_of_spades, 4, "diamonds"));

        deck.add(new Card(R.drawable.three_of_clubs, 3, "clubs"));
        deck.add(new Card(R.drawable.three_of_diamonds, 3, "diamonds"));
        deck.add(new Card(R.drawable.three_of_hearts, 3, "hearts"));
        deck.add(new Card(R.drawable.three_of_spades, 3, "diamonds"));

        deck.add(new Card(R.drawable.two_of_clubs, 2, "clubs"));
        deck.add(new Card(R.drawable.two_of_diamonds, 2, "diamonds"));
        deck.add(new Card(R.drawable.two_of_hearts, 2, "hearts"));
        deck.add(new Card(R.drawable.two_of_spades, 2, "diamonds"));
//*************************************************************************************************


//=============== доступ к полям где будут показываться карты игрока и дилера ====================
        layoutDealerCards = findViewById(R.id.layoutDealerCards);
        layoutPlayerCards = findViewById(R.id.layoutPlayerCards);

// доступ к элементам интерфейса
        buttonHint1 = findViewById(R.id.buttonHint1);
        buttonStand1 = findViewById(R.id.buttonStand1);
        buttonBack = findViewById(R.id.buttonBack);
        buttonRestart = findViewById(R.id.buttonRestart);

        playerScore = findViewById(R.id.playerScore);
        dealerScore = findViewById(R.id.dealerScore);
        playerName = findViewById(R.id.playerName); // доступ к полю имени игрока
        dealerName = findViewById(R.id.dealerName); // доступ к полю имени игрока

        buttonBet1 = findViewById(R.id.buttonBet1);
        doubleBet1 = findViewById(R.id.doubleBet1);
        playerBankShow = findViewById(R.id.playerBankShow);
        dealerBankShow = findViewById(R.id.dealerBankShow);
        textBank = findViewById(R.id.textBank);


// получаем имя игрока и устройства
        String playerNameString = getIntent().getStringExtra("playerName"); // строковая переменная куда кладем имя которое игрок ввел при выборе имени и уровня
        String dealerNameString = Build.MODEL; // получаем модель телефона
        playerName.setText(playerNameString); // устанавливаем имя игрока п поле
        dealerName.setText(dealerNameString);

// запуск игры при попадании на экран (выбрал уровень на предыдущем экране и попав сюда сразу начал игру)
        startGame();

// =============================== жмем на назад =================================================
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // возвращаемся на первый экран
                Intent intent = new Intent(Level1.this, MainActivity.class);
                startActivity(intent);
            }
        });
// ===============================================================================================
// ===============================жмем на перезапуск =========================================
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(); // просто запускаем метод начала игры заново
            }
        });
// ===========================================================================================
        // жмем кнопку СТАВКА
        buttonBet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bet(); // запускаем метод СТАВКА см его ниже
// ===================тут то же самое что в методе bet() изначально метода я не делал===============
               /* if (playerCash >= bet && dealerCash >= bet) {


                    playerCash = playerCash - bet;
                    dealerCash = dealerCash - bet;

                    updateCash();

//                playerBankShow.setText(String.valueOf(playerCash));
//                dealerBankShow.setText(String.valueOf(dealerCash));

                    bank = bank + bet * 2;
                    textBank.setText(String.valueOf(bank));

                    if (bank > 0) {
                        buttonHint.setEnabled(true);
                        buttonRestart.setEnabled(true);
                        buttonStop.setEnabled(true);
                    } else {
                        buttonHint.setEnabled(false);
                        buttonRestart.setEnabled(false);
                        buttonStop.setEnabled(false);
                    }

                }
                else {
                    Toast.makeText(Level3.this, "Недостаточно денежек", Toast.LENGTH_SHORT).show();
                }*/
// =================================================================================================
                buttonBet1.setEnabled(false); // отключаем кнопку ставка чтобы не делали ставку больше одного раза
            }
        });

// жмем кнопку УДВОИТЬ СТАВКУ
        doubleBet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wBet = true; // булевая переменная стала тру (надо при расчете возврата ставки в кэш если ничья)
                bet(); // метод СТАВКА см его ниже
                playerStand(); // и сразу передача хода дилеру. по правилам если ставка удвоена то ход передается противнику
                doubleBet1.setEnabled(false);// деактивация кнопки УДВОИТЬ СТАВКУ
            }
        });

// ===========================жмем кнопку "ЕЩЕ КАРТУ" =========================================
        buttonHint1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawCard(playerHand, layoutPlayerCards, true); // дать карту игроку и отобразить ее в поле карт игрока открыв значение
                playerTotal = calculateTotal(playerHand); // пересчитываем очки карт игрока с учетом значение
                playerScore.setText("Очки: " + playerTotal); // показываем очки игрока
                // если перебор
                if (playerTotal > 21) {
                    Toast.makeText(Level1.this, "Перебор! Ты проиграл", Toast.LENGTH_SHORT).show();
                    checkForBancrote();
                    gameOver = true; // игра окончена
                    dealerCash = dealerCash + bank; // дилеру в кэш улетает банк
                    dealerBankShow.setText(String.valueOf(dealerCash)); // в поле cash у диллера обновляем сумму
                    bank = 0; // обнуляем банк
                    buttonBet1.setEnabled(false);
                    doubleBet1.setEnabled(false);

                    // блокируем кнопки чтобы больше не добирать карты
                    buttonHint1.setEnabled(false);
                    buttonStand1.setEnabled(false);
                    buttonRestart.setEnabled(true);
//----------------------------------------если перебор игрока показываем карты дилера и его очки-------------------------------------------------
                    layoutDealerCards.removeAllViews(); // очищаем слой с картами чтобы убрать старые (если были) это нужн чтобы не лепить новые карты поверх старых. здесь не убираем карты из руки дилера  а просто убираем картинки с рубашкой чтобы поместить на их место карты картинкой вверх
                    for (Card card : dealerHand) { // идем по картам на руке у дилера и по очереди их кладем в переменную card
                        ImageView cardView = new ImageView(Level1.this); // создаём новый ImageView, который будет использоваться для отображения карты на экране.
                        cardView.setImageResource(card.getImageResId()); // Устанавливаем изображение карты, используя метод getImageResId() этот метод карты возвращает ID ресурса для изображения карты
// Настраиваем параметры для размещения изображения
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 290); // Создаём объект LinearLayout.LayoutParams, в котором указываем размеры карты, отступы
                        params.setMargins(10, 0, 10, 0);
                        cardView.setLayoutParams(params); // Применяем эти параметры к cardView, чтобы разместить изображение на экране.
                        layoutDealerCards.addView(cardView); // Добавляем ImageView в LinearLayout — контейнер для карт дилера. по факту - карта будет показана на экране в слое карт дилера.
// Когда  у пользователя  перебор , все карты дилера отображаются на экране: Сначала очищается текущий список карт. Затем для каждой карты в руке дилера создаётся изображение, и оно добавляется в контейнер, показывая реальные карты (не рубашки).Этот код позволяет зрителям увидеть карты дилера, когда игрок решает "остановиться" и не брать больше карт.
                    }
                    dealerScore.setText("Очки: " + dealerTotal);
                }
//-----------------------------------------------------------------------------------------------------------------------------------------------
            }
        });
// ===========================================================================================
// ===========================жмем кнопку "СТОП"=========================================
        buttonStand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerStand();
/*//+++++++++++++++++++++++++++++++++++++ дилер добирает карты ++++++++++++++++++++++++++++++++++++
//++Пока у него меньше 17 он на руку получает карты которые рисуются в его слое
                while (dealerTotal < 17) {
                    drawCard(dealerHand, layoutDealerCards, true);
                    dealerTotal = calculateTotal(dealerHand);// очки дилера плюсуются с картами
                }
//++++++++++++++++++++++ показываем карты дилера(заменяем рубашку на картинки) +++++++++++++++++++
                layoutDealerCards.removeAllViews(); // очищаем слой с картами чтобы убрать старые (если были) это нужн чтобы не лепить новые карты поверх старых. здесь не убираем карты из руки дилера  а просто убираем картинки с рубашкой чтобы поместить на их место карты картинкой вверх
                for (Card card : dealerHand) { // идем по картам на руке у дилера и по очереди их кладем в переменную card
                    ImageView cardView = new ImageView(Level1.this); // создаём новый ImageView, который будет использоваться для отображения карты на экране.
                    cardView.setImageResource(card.getImageResId()); // Устанавливаем изображение карты, используя метод getImageResId() этот метод карты возвращает ID ресурса для изображения карты
// Настраиваем параметры для размещения изображения
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 290); // Создаём объект LinearLayout.LayoutParams, в котором указываем размеры карты, отступы
                    params.setMargins(10, 0, 10, 0);
                    cardView.setLayoutParams(params); // Применяем эти параметры к cardView, чтобы разместить изображение на экране.
                    layoutDealerCards.addView(cardView); // Добавляем ImageView в LinearLayout — контейнер для карт дилера. по факту - карта будет показана на экране в слое карт дилера.
// Когда пользователь нажимает на кнопку "Stand", все карты дилера отображаются на экране: Сначала очищается текущий список карт. Затем для каждой карты в руке дилера создаётся изображение, и оно добавляется в контейнер, показывая реальные карты (не рубашки).Этот код позволяет зрителям увидеть карты дилера, когда игрок решает "остановиться" и не брать больше карт.
                }
                dealerScore.setText("Очки: " + dealerTotal); // показываем очки дилера

//++++++++++++++++++++++++++++++++ определяем победителя ++++++++++++++++++++++++++++++++++++++++++
                String result;
                if (dealerTotal > 21) {
                    result = "Дилер перебор! Ты выйграл!";
                } else if (dealerTotal > playerTotal) {
                    result = "Дилер победил!";
                } else if (dealerTotal < playerTotal) {
                    result = "Ты победил!";
                } else {
                    result = "Ничья!";
                }
                Toast.makeText(Level1.this, result, Toast.LENGTH_SHORT).show();
                // блокируем кнопки чтобы больше не добирал никто
                buttonHint.setEnabled(false);
                buttonStand.setEnabled(false);
                buttonBet.setEnabled(false);
                doubleBet.setEnabled(false);
                buttonRestart.setEnabled(true);*/
            }
        });
// ===========================================================================================
    }

    //**************************************** МЕТОД СТАРТА ИГРЫ ***************************************
    private void startGame() {
// очищаем руки и интерфейс
        if (bancrote){
            wBet = false;// булевая переменная удвоенной ставки
            playerCash = 10;
            dealerCash = 10;
            bank = 0;
            textBank.setText("Банк: 0");
            buttonBet1.setEnabled(true); // сделать ставку доступна
            doubleBet1.setEnabled(false); // удвоить ставку  не доступна
            buttonRestart.setEnabled(false); // сдать карты не доступна
            buttonHint1.setEnabled(false);
            buttonStand1.setEnabled(false);

/* // если ставки  сделаны (банк > 0)
            if (bank > 0) {
                buttonHint.setEnabled(true); // делаем доступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand.setEnabled(true);
                doubleBet.setEnabled(true);
                // если ставки не сделаны (банк = 0)
            } else {
                buttonHint.setEnabled(false); // делаем НЕдоступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand.setEnabled(false);
                doubleBet.setEnabled(false);
            }*/
        }
        else {
            updateCash();
//        playerBankShow.setText(String.valueOf("Cash: " + playerCash));
//        dealerBankShow.setText(String.valueOf("Cash: " + dealerCash));
            textBank.setText("Банк: 0");
            doubleBet1.setEnabled(false);
            buttonBet1.setEnabled(true);
            buttonRestart.setEnabled(false);
            buttonHint1.setEnabled(false);
            buttonStand1.setEnabled(false);

            playerHand = new ArrayList<>();
            dealerHand = new ArrayList<>();
            layoutPlayerCards.removeAllViews(); // убираем карты с экрана
            layoutDealerCards.removeAllViews(); // убираем карты с экрана
            playerTotal = 0; // обнуляем очки игрока и дилера
            dealerTotal = 0;
            bank = 0;

/*            // если ставки  сделаны (банк > 0)
            if (bank > 0) {
                buttonHint.setEnabled(true); // делаем доступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand.setEnabled(true);
                doubleBet.setEnabled(true);
                // если ставки не сделаны (банк = 0)
            } else {
                buttonHint.setEnabled(false); // делаем НЕдоступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand.setEnabled(false);
                doubleBet.setEnabled(false);
            }*/
        }
// мешаем колоду
        Collections.shuffle(deck);

// раздаем карты - по 2 игроку и дилеру
        drawCard(playerHand, layoutPlayerCards, true); // первая карта игроку - открыта
        drawCard(dealerHand, layoutDealerCards, false); // первая карта дилеру - закрыта
        drawCard(playerHand, layoutPlayerCards, true); // вторая карта игроку - открыта
        drawCard(dealerHand, layoutDealerCards, false); // вторая карта дилеру - закрыта

// считаем очки (calculateTotal - метод отдельный)
        playerTotal = calculateTotal(playerHand);
        dealerTotal = calculateTotal(dealerHand);
// показываем очки игрока
        playerScore.setText("Очки: " + playerTotal);
        dealerScore.setText("Очки: ???");
/*// разблокируем кнопки чтобы можно было играть
        buttonStand1.setEnabled(true);
        buttonHint1.setEnabled(true);
        buttonRestart.setEnabled(false); // сдать карты не доступна
        buttonBet1.setEnabled(true);
        doubleBet1.setEnabled(false);*/
//**********************************************************************************************
    }

    // >>>>>>>>>>>>>>>>>>>>>>>> МЕТОД: drawCard (раздача карт)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private void drawCard(List<Card> hand, LinearLayout layout, boolean showCard) { // List<Card> hand - работает с списком карт, LinearLayout layout слои где показывают карты и  boolean showCard определяет видно ли значение карты при раздаче
        Card card = deck.remove(0); // берем карту с верха колоды (индекс 0) и удаляем ее из колоды (грубо - в колоде ее нет она на ркуах у игрока или дилера)
        hand.add(card); //  и добавляем ее в руку

        ImageView cardView = new ImageView(this); // Создаём новое изображение (как бы "слот" под карту), которое будет добавлено на экран.
        if (showCard) {
            cardView.setImageResource(card.getImageResId()); // если showCard - true  то показываем карту. showCard - булевая переменная из метода /drawCard(List<Card> hand, LinearLayout layout, boolean showCard)/ true она или false - мы определили в методе starGame когда раздаем игрокам карты /drawCard(playerHand, layoutPlayerCards, true);/

        } else {
            cardView.setImageResource(R.drawable.card_back); // если showCard - false то карта рубашкой вверх
        }
// Настраиваем размеры карты и отступы, чтобы они красиво отображались и не слипались на экране.
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 290); // "Эй, LinearLayout, когда будешь раскладывать свои элементы — вот инструкции, как именно показать вот этот элемент (в нашем случае — картинку)!" размеры можно настроить как надо тебе
        params.setMargins(10, 0, 10, 0); // Метод setMargins(left, top, right, bottom): Добавляет внешние отступы вокруг элемента — чтобы они не слипались с другими элементами.

        cardView.setLayoutParams(params); //Назначаем параметры ImageView (размер, отступы) типа здесь мы тупо применяем параметры из строк выше к картинке
        layout.addView(cardView); // Добавляем cardView в layout, где собираются все карты (например, layoutPlayerCards или layoutDealerCards)
    }
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    //++++++++++++++++++++++++++++++++++ Метод для подсчёта очков +++++++++++++++++++++++++++++++++++++
    //здесь нюанс - по правилам блекджека значение туза может быть = 11 или 1 в зависимости от ситуации
    private int calculateTotal(List<Card> hand) {
        int total = 0; // изначально очки карт = 0
        int aceCount = 0; // счетчик тузов
// проходим по картам в руке - в переменную card класса Card по очереди кладем карты из руки (hand) игрока
        for (Card card : hand) {
            total += card.getValue(); // добавляем значение карт в поле очков
            if (card.getValue() == 11) // если карта - туз
                aceCount++; // , то увеличиваем счетчик тузов
// ***************************Например:
//Если в руке 2 карты: туз (11) и 8, то на этом шаге:
//total = 0 + 11 + 8 = 19
//aceCount = 1 (так как мы нашли 1 туз).
//***********************************************************************************
        }
// Если перебор и есть тузы то рассчет стоимости тузов меняется
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
//******************************** РАЗБОР ЛОГИКИ ***************************************************
//Теперь мы проверяем, если сумма очков total больше 21 (перебор):
// Туз стоит 11 очков, но если у нас перебор, то мы можем сделать его равным 1, чтобы уменьшить сумму.
// Так мы пытаемся привести сумму к валидному значению, если перебор. Это делаем до тех пор, пока сумма не станет меньше или равной 21.
//Мы уменьшаем total на 10, так как туз теперь считается как 1 (11 — 10 = 1).
// Каждый раз, когда уменьшаем значение туза, уменьшаем aceCount, потому что нам нужно отслеживать, сколько тузов осталось, чтобы корректно изменять их значение.
//ПРИМЕР: Предположим, в руке у игрока три карты: Туз (11), 7, 10 Начинаем с: total = 0 aceCount = 0 Первая карта — туз (11): total = 11 aceCount = 1 Вторая карта — 7: total = 11 + 7 = 18 aceCount = 1 Третья карта — 10: total = 18 + 10 = 28 aceCount = 1 Сумма больше 21 (перебор), уменьшаем туза: total = 28 - 10 = 18 aceCount = 0 (туз теперь считается как 1) И итоговая сумма: total = 18
//************************************************************************************************
        }
        return total;// возвращаем количество очков
    }
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // =======================================метод ставки==============================================
    public void bet() {
// если денег хватает то делается ставка
        if (playerCash >= bet && dealerCash >= bet) {
            if (!wBet){ // если ставка не двойная то звук одной монетки
                playSound(R.raw.money_sound3);
            } else { // если ставка  двойная то звук много монет
                playSound(R.raw.money_sound2);
            }
            playerCash = playerCash - bet;
            dealerCash = dealerCash - bet;
            updateCash(); // обновляется значение кэша в полях игрока и дилера
            bank = bank + bet * 2; // в банк кладется ставка игрока и дилера
            textBank.setText(String.valueOf(bank)); // обновляется значение поля банк

            if (bank > 0) {
                buttonHint1.setEnabled(true); // делаем доступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand1.setEnabled(true);
                doubleBet1.setEnabled(true);
                // если ставки не сделаны (банк = 0)
            } else {
                buttonHint1.setEnabled(false); // делаем НЕдоступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStand1.setEnabled(false);
                doubleBet1.setEnabled(false);
            }
        } else { // если денег не хватает у кого то
            Toast.makeText(Level1.this, "Недостаточно денежек", Toast.LENGTH_SHORT).show();
        }
//==================================================================================================
    }
    //==============================МЕТОД ПРОИГРЫВАНИЯ ЗВУКА============================================
/*        private void playSound(int soundResId) {
        mediaplayer = MediaPlayer.create(this, soundResId);
        if (mediaplayer != null){
            mediaplayer.setOnCompletionListener(mediaplayer -> mediaplayer.release());
            mediaplayer.start();
        }*/
    // это то же самое что выше просто без лямбды
    private void playSound(int soundResId){
        MediaPlayer mediaplayer = MediaPlayer.create(this, soundResId); // Создаём временный медиаплеер
        if (mediaplayer != null){
            mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaplayer.release(); // Освобождаем ресурсы после проигрывания
                }
            });
            mediaplayer.setVolume(1.0f, 1.0f); // Максимальная громкость (левый и правый каналы)
            mediaplayer.start(); // Запускаем звук
        }
//==================================================================================================
    }
    // ==================================метод обновления интерфейса====================================
    private void updateCash() {
        // доступ к интерфейсу
        playerBankShow = findViewById(R.id.playerBankShow);
        dealerBankShow = findViewById(R.id.dealerBankShow);
        textBank = findViewById(R.id.textBank);
// устанавливаем в поле Cash игрка и диллера текущее значение. потом при каждом запуске метода это значение попадает в эти поля
        playerBankShow.setText(String.valueOf(playerCash));
        dealerBankShow.setText(String.valueOf(dealerCash));

    }
//==================================================================================================

    // ==================================метод проверки на банкротство====================================
    private void checkForBancrote() {
        if (playerCash <= 0) {
//            textResult.setTextColor(Color.parseColor("#FF69B4")); // если игрок банкрот то цвет текста меняем
//            textResult.setText("Ты обанкротился, друг!");
            Toast.makeText(this, "Ты обанкротился, друг!", Toast.LENGTH_SHORT).show();
            gameOver = true;
            buttonRestart.setText("Новая игра"); // заменяем текст на кнопке сдать карты на новая игра
            bancrote = true; // булевую переменную включаем на тру чтобы корректно отработал метод новой игры
        }
        if (dealerCash <= 0) {
//            textResult.setText("Красавчик - дилер без штанов!");
            Toast.makeText(this, "Красавчик - дилер без штанов!", Toast.LENGTH_SHORT).show();
            gameOver = true;
            buttonRestart.setText("Новая игра"); // заменяем текст на кнопке сдать карты на новая игра
            bancrote = true; // булевую переменную включаем на тру чтобы корректно отработал метод новой игры
        }
    }
    //==================================================================================================
    private void playerStand(){
        //+++++++++++++++++++++++++++++++++++++ дилер добирает карты ++++++++++++++++++++++++++++++++++++
//++Пока у него меньше 17 он на руку получает карты которые рисуются в его слое
        while (dealerTotal < 17) {
            drawCard(dealerHand, layoutDealerCards, true);
            dealerTotal = calculateTotal(dealerHand);// очки дилера плюсуются с картами
        }
//++++++++++++++++++++++ показываем карты дилера(заменяем рубашку на картинки) +++++++++++++++++++
        layoutDealerCards.removeAllViews(); // очищаем слой с картами чтобы убрать старые (если были) это нужн чтобы не лепить новые карты поверх старых. здесь не убираем карты из руки дилера  а просто убираем картинки с рубашкой чтобы поместить на их место карты картинкой вверх
        for (Card card : dealerHand) { // идем по картам на руке у дилера и по очереди их кладем в переменную card
            ImageView cardView = new ImageView(Level1.this); // создаём новый ImageView, который будет использоваться для отображения карты на экране.
            cardView.setImageResource(card.getImageResId()); // Устанавливаем изображение карты, используя метод getImageResId() этот метод карты возвращает ID ресурса для изображения карты
// Настраиваем параметры для размещения изображения
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 290); // Создаём объект LinearLayout.LayoutParams, в котором указываем размеры карты, отступы
            params.setMargins(10, 0, 10, 0);
            cardView.setLayoutParams(params); // Применяем эти параметры к cardView, чтобы разместить изображение на экране.
            layoutDealerCards.addView(cardView); // Добавляем ImageView в LinearLayout — контейнер для карт дилера. по факту - карта будет показана на экране в слое карт дилера.
// Когда пользователь нажимает на кнопку "Stand", все карты дилера отображаются на экране: Сначала очищается текущий список карт. Затем для каждой карты в руке дилера создаётся изображение, и оно добавляется в контейнер, показывая реальные карты (не рубашки).Этот код позволяет зрителям увидеть карты дилера, когда игрок решает "остановиться" и не брать больше карт.
        }
        dealerScore.setText("Очки: " + dealerTotal); // показываем очки дилера

//++++++++++++++++++++++++++++++++ определяем победителя ++++++++++++++++++++++++++++++++++++++++++
        String result;
        if (dealerTotal > 21) {
            result = "Дилер перебор! Ты выйграл!";
            playerCash = playerCash + bank;
            updateCash(); // метод см ниже
            checkForBancrote(); // метод см ниже
        } else if (dealerTotal > playerTotal) {
            result = "Дилер победил!";
            dealerCash = dealerCash + bank;
            updateCash(); // метод см ниже
            checkForBancrote(); // метод см ниже
        } else if (dealerTotal < playerTotal) {
            result = "Ты победил!";
            playerCash = playerCash + bank;
            updateCash(); // метод см ниже
            checkForBancrote(); // метод см ниже
        } else {
            result = "Ничья!";
            dealerCash = dealerCash + bank/2;
            playerCash = playerCash + bank/2;
            updateCash(); // метод см ниже
            checkForBancrote(); // метод см ниже
        }
        Toast.makeText(Level1.this, result, Toast.LENGTH_SHORT).show();
        // блокируем кнопки чтобы больше не добирал никто
        buttonHint1.setEnabled(false);
        buttonStand1.setEnabled(false);
        buttonBet1.setEnabled(false);
        doubleBet1.setEnabled(false);
        buttonRestart.setEnabled(true);
    }
// ===========================================================================================
}