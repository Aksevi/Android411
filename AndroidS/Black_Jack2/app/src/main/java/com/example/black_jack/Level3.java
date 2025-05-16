package com.example.black_jack;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Level3 extends AppCompatActivity {
/*    // переменные для звуков
    private MediaPlayer soundCard; //
    private MediaPlayer soundBet;
    private MediaPlayer soundDoubleBet;*/


    // переменные текстовых полей интерфейса
    private TextView playerNameShow;
    private TextView playerScoreShow;
    private TextView dealerNameShow;
    private TextView dealerScoreShow;
    private TextView textResult;
    private TextView playerBankShow;
    private TextView dealerBankShow;
    private TextView textBank;
    // переменные кнопок интерфейса
    private Button buttonHint;
    private Button buttonRestart;
    private Button buttonStop;
    private Button buttonBack;
    private Button buttonBet;
    private Button buttonDoubleBet;

    // переменные кода
    private int playerScore = 0; // очки игрока изначальные (стоимость его карт)
    private int dealerScore = 0; // очки дилераизначальные (стоимость его карт)
    Random random = new Random(); // переменная для рандома
    private boolean gameOver = false; // булевая переменная окончания игры. изначально игра не окончена
    private boolean bancrote = false;// булевая переменная на банкрота.

    private int playerCash = 10; // кэш игрока
    private int dealerCash = 10; // кэш дилера
    private int bet = 2; // размер ставки
    private boolean doubleBet = false; // булевая переменная удвоеной ставки. нужна чтобы корректно возвращать кэш игрокамив случае ничьей. без нее вернется только размер ставки то есть будем терять кэш на размер ставки
    private int bank; // переменная размера банка (куда лепим ставки)

    private Switch switchDealerMode; //переменная переключателя режима диллера
    private boolean dealerAgressive = false; // булевая переменная агрессивности. по умолчанию не агрессивный


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

//++++++++++++++++++++++++++++++доступ к интерфейсу+++++++++++++++++++++++++++++++++++++++++++++++++
        playerNameShow = findViewById(R.id.playerNameShow);
        playerScoreShow = findViewById(R.id.playerScoreShow);
        dealerNameShow = findViewById(R.id.dealerNameShow);
        dealerScoreShow = findViewById(R.id.dealerScoreShow);
        textResult = findViewById(R.id.textResult);
        buttonBack = findViewById(R.id.buttonBack);
        buttonRestart = findViewById(R.id.buttonRestart);
        buttonHint = findViewById(R.id.buttonHint);
        buttonStop = findViewById(R.id.buttonStop);
        playerBankShow = findViewById(R.id.playerBankShow);
        dealerBankShow = findViewById(R.id.dealerBankShow);
        textBank = findViewById(R.id.textBank);
        buttonBet = findViewById(R.id.buttonBet);
        buttonDoubleBet = findViewById(R.id.buttonDoubleBet);
        switchDealerMode = findViewById(R.id.switchdealerMode);

// здесь получаем имя игрока которое он ввел в MainActivity и модель тлф
        String playerNameShowString = getIntent().getStringExtra("playerName");
        String dealerNameShowString = Build.MODEL;
//и устанваливаем их в соответствующие поля
        playerNameShow.setText(playerNameShowString);
        dealerNameShow.setText(dealerNameShowString);

// метод запуска игры. см ниже
        startNewGame();

// переключатель режима дилера включаем
        switchDealerMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dealerAgressive = isChecked; // теперь булевая переменная агрессивности стала true
                Toast.makeText(getApplicationContext(),
                        dealerAgressive ? "Дилер стал агрессивным!" : "Дилер играет безопасно.",
                        Toast.LENGTH_SHORT).show();
            }
        });

// жмем кнопку СТАВКА
        buttonBet.setOnClickListener(new View.OnClickListener() {
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
                buttonBet.setEnabled(false); // отключаем кнопку ставка чтобы не делали ставку больше одного раза
            }
        });

// жмем кнопку УДВОИТЬ СТАВКУ
        buttonDoubleBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doubleBet = true; // булевая переменная стала тру (надо при расчете возврата ставки в кэш если ничья)
                bet(); // метод СТАВКА см его ниже
                playerStand(); // и сразу передача хода дилеру. по правилам если ставка удвоена то ход передается противнику
                buttonDoubleBet.setEnabled(false);// деактивация кнопки УДВОИТЬ СТАВКУ
            }
        });
// жмем кнопку НАЗАД
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level3.this, MainActivity.class); // переходим на MainActivity
                startActivity(intent);
            }
        });
// жмем кнопку СДАТЬ КАРТЫ
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame(); // метод startNewGame() см его ниже
//                newGame(); // метод startNewGame() см его ниже
            }
        });
// жмем кнопку ВЗЯТЬ КАРТУ
        buttonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameOver) { // если игра не завершена то запускается метод раздачи карт playerTakesCard() см его ниже
                    playerTakesCard();
                }
            }
        });
// жмем кнопку ОСТАНОВИТЬСЯ
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameOver) { // если игра не завершена то запускается метод  playerStand() см его ниже
                    playerStand();
                }
            }
        });
    }

    //==================================МЕТОД ЗАПУСКА НОВОЙ ИГРЫ========================================
    private void startNewGame() {
        // если кто то обанкротился то запускаем новую игру с кэшем равным по 10 у игроков
        if (bancrote) {
            textResult.setTextColor(Color.parseColor("#012103")); // возвращаем текст поля результата к дефолтному цвету
            doubleBet = false;
            playerCash = 10;
            dealerCash = 10;
            buttonBet.setEnabled(true); // сделать ставку доступна
            buttonDoubleBet.setEnabled(false); // удвоить ставку  не доступна
            buttonRestart.setEnabled(false); // сдать карты не доступна
            buttonStop.setEnabled(true); // остановиться доступна
//        playerBankShow.setText(String.valueOf(playerCash));
//        dealerBankShow.setText(String.valueOf(dealerCash));
            // при новой игре или сдаче карт заново игроку и дилеру сразу начисляются по одной карте
            playerScore = random.nextInt(10) + 2; // раздаем игроку и дилеру карту по рандому от 2 до 11 (random.nextInt(10) - это рандом от 0 до 9 \не включая 10\ + 2 - это прибавка 2 к результату - 0 + 2, 3 + 2 и тд. то есть в итоге минимально - 0+2 максимально 9+2)
            playSound(R.raw.card_sound);
            dealerScore = random.nextInt(10) + 2;
            playerScoreShow.setText(String.valueOf(playerScore)); // так как поле счета игрока у нас тектсовое а рандом передает числовое то приводим числовое к строке
            dealerScoreShow.setText("???"); // изначально игрок не видит сколько очков у дилера
            textResult.setText(""); // в поле результат игры пока ничего
            textBank.setText("0"); // в текстовом поле БАНК - 0
            bank = 0; // банк = 0
            buttonRestart.setText("Сдать карты");
// если ставки  сделаны (банк > 0)
            if (bank > 0) {
                buttonHint.setEnabled(true); // делаем доступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStop.setEnabled(true);
                // если ставки не сделаны (банк = 0)
            } else {
                buttonHint.setEnabled(false); // делаем НЕдоступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStop.setEnabled(false);
            }
            gameOver = false; // игра не окончена
        }
// если банкрота нет то сдаем карты обновляя кэш с учетом выгранной или проигранной ставки
        else {
            updateCash();
            doubleBet = false;
            buttonBet.setEnabled(true); // сделать ставку доступна
            buttonDoubleBet.setEnabled(false); // удвоить ставку  не доступна
            buttonRestart.setEnabled(false); // сдать карты не доступна
            buttonStop.setEnabled(true); // остановиться доступна
//        playerBankShow.setText(String.valueOf(playerCash));
//        dealerBankShow.setText(String.valueOf(dealerCash));
            // при новой игре или сдаче карт заново игроку и дилеру сразу начисляются по одной карте
            playerScore = random.nextInt(10) + 2; // раздаем игроку и дилеру карту по рандому от 2 до 11 (random.nextInt(10) - это рандом от 0 до 9 \не включая 10\ + 2 - это прибавка 2 к результату - 0 + 2, 3 + 2 и тд. то есть в итоге минимально - 0+2 максимально 9+2)
            playSound(R.raw.card_sound);
            dealerScore = random.nextInt(10) + 2;
            playSound(R.raw.card_sound);
            playerScoreShow.setText(String.valueOf(playerScore)); // так как поле счета игрока у нас текстовое а рандом передает числовое то приводим числовое к строке
            dealerScoreShow.setText("???"); // изначально игрок не видит сколько очков у дилера
            textResult.setText(""); // в поле результат игры пока ничего
            textBank.setText("0"); // в тьекстовом поле БАНК - 0
            bank = 0; // банк = 0
            // если ставки  сделаны (банк > 0)
            if (bank > 0) {
                buttonHint.setEnabled(true); // делаем доступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStop.setEnabled(true);
                // если ставки не сделаны (банк = 0)
            } else {
                buttonHint.setEnabled(false); // делаем НЕдоступными кнопки ВЗЯТЬ КАРТУ и ОСТАНОВИТЬСЯ
                buttonStop.setEnabled(false);
            }
            gameOver = false; // игра не окончена
        }
    }

    //==================================================================================================
// ==================================метод раздачи карт игрокам=====================================
    private void playerTakesCard() {
        int card = random.nextInt(10) + 2; // card - переменная куда рандомно выдают значение карт. random.nextInt(10) + 2 собственно сам рандом. (10) - это рандомное число от 0 до 9, +2 это к рандомному числу прибавляем 2. так как карты от 2 до 11 то надо так - выпал рандомный 0 прибавили 2 вот двойка. выпала 1 - прибавили 2 - тройка и тд
        playSound(R.raw.card_sound);
        playerScore = playerScore + card; // прибавляем к очкам игрока стоимость карты
        playerScoreShow.setText(String.valueOf(playerScore));
// сразу проверка на перебор
        if (playerScore > 21) {
            textResult.setText("Перебор! Вы проиграли."); // текст в поле результат
            dealerScoreShow.setText(String.valueOf(dealerScore)); // показываем очки дилера
            gameOver = true; // игра окончена
            dealerCash = dealerCash + bank; // дилеру в кэш улетает банк
            dealerBankShow.setText(String.valueOf(dealerCash)); // в поле cash у диллера обновляем сумму
            bank = 0; // обнуляем банк
            buttonRestart.setEnabled(true); // СДАТЬ КАРТЫ ДОСТУПНА
            buttonStop.setEnabled(false); // СТОП КАРТЫ НЕДОСТУПНА
            buttonHint.setEnabled(false); // взять КАРТу НЕДОСТУПНА
            updateCash(); // метод см ниже. обновляем кэш с учетом выгранной или проигранной ставки
            checkForBancrote(); // метод см ниже проверка на банкрота
        }
    }

    //==================================================================================================
// ==================================метод остановиться=============================================
//когда игрок нажал ОСТАНОВИТЬСЯ ИЛИ УДВОИЛ СТАВКУ ход переходит дилеру
    private void playerStand() {
        dealerScoreShow.setText(String.valueOf(dealerScore));// показываем счет дилера
// ++++++++++дилер добирает карты+++++++++++
        // этот блок работает если свитч агрессивности включен (dealerAgressive = true)
        if (dealerAgressive) {
            while (true) {
                if (dealerScore >= 21) break; // перебор или 21 — стоп
                if (dealerScore >= playerScore) break; // дилер уже выигрывает — стоп
                if (dealerScore >= (dealerAgressive ? 19 : 17)) break; // достиг лимита стратегии — стоп
                // иначе (если в if выше не попали)-  берём карту
                int dealerCard = random.nextInt(10) + 2;// рандомно получает карты
                playSound(R.raw.card_sound);
                dealerScore = dealerScore + dealerCard;//к его очкам суммируется стоимость карт
            }
        }   else { // этот блок работает если свитч агрессивности выключен
            while (dealerScore < 17) { // пока у него меньше 17 очков
                int dealerCard = random.nextInt(10) + 2; // рандомно получает карты
                playSound(R.raw.card_sound);
                dealerScore = dealerScore + dealerCard;//к его очкам суммируется стоимость карт
            }
        }
        dealerScoreShow.setText(String.valueOf(dealerScore));// обновляем инфу в поле очков дилера
// проверка
        if (dealerScore > 21) { // если дилер > 21

            textResult.setText("Дилер перебор! Вы победили");
            playerCash = playerCash + bank; // кэш из банка игроку
            playerBankShow.setText(String.valueOf(playerCash)); // обновляем поле кэша игрока
            bank = 0; // обнуляем банк
            buttonRestart.setEnabled(true);//СДАТЬ КАРТЫ доступна
            buttonStop.setEnabled(false);//ОСТАНОВИТЬСЯ не доступна
            buttonHint.setEnabled(false);
            updateCash(); // метод см ниже
            checkForBancrote(); // метод см ниже
        } else if (playerScore > dealerScore) { // если игрок > дилера
            textResult.setText("Вы победили!");
            playerCash = playerCash + bank;
            playerBankShow.setText(String.valueOf(playerCash));
            bank = 0;
            buttonRestart.setEnabled(true);
            buttonStop.setEnabled(false);
            buttonHint.setEnabled(false);
            updateCash();
            checkForBancrote();

        } else if (dealerScore > playerScore) { // если  дилера > игрока
            textResult.setText("Вы проиграли!");
            dealerCash = dealerCash + bank;
            dealerBankShow.setText(String.valueOf(dealerCash));
            bank = 0;
            buttonRestart.setEnabled(true);
            buttonStop.setEnabled(false);
            buttonHint.setEnabled(false);
            updateCash(); // метод см ниже. обновляем кэш с учетом выгранной или проигранной ставки
            checkForBancrote(); // метод см ниже проверка на банкрота
        } else {
            textResult.setText("Ничья!"); // если  дилера = игрок
            if (doubleBet = false) { // и если удвоения ставки не было
                dealerCash = dealerCash + bet; // то игрокам возвращается по их ставке в кэш
                playerCash = playerCash + bet;
                bank = 0;
                buttonRestart.setEnabled(true);
                buttonStop.setEnabled(false);
                buttonHint.setEnabled(false);
                updateCash(); // метод см ниже. обновляем кэш с учетом выгранной или проигранной ставки
                checkForBancrote(); // метод см ниже проверка на банкрота
            } else { // если было удвоение ставки и ничья
                dealerCash = dealerCash + bet * 2; // то игрокам возвращается по двойной ставке в кэш
                playerCash = playerCash + bet * 2;
                bank = 0;
                buttonRestart.setEnabled(true);
                buttonStop.setEnabled(false);
                buttonHint.setEnabled(false);
                updateCash(); // метод см ниже. обновляем кэш с учетом выгранной или проигранной ставки
                checkForBancrote(); // метод см ниже проверка на банкрота
            }
        }
        gameOver = true; // игра окончена - игрок нажал остановиться. дилер сходил. проверили кто выйграл или ничья - раунд закончился
    }
//==================================================================================================

    // ==================================метод обновления интерфейса====================================
    private void updateCash() {
        // доступ к интерфейсу
        playerBankShow = findViewById(R.id.playerBankShow);
        dealerBankShow = findViewById(R.id.dealerBankShow);
// устанавливаем в поле Cash игрка и диллера текущее значение. потом при каждом запуске метода это значение попадаеи в эти поля
        playerBankShow.setText(String.valueOf(playerCash));
        dealerBankShow.setText(String.valueOf(dealerCash));
    }
//==================================================================================================

    // ==================================метод проверки на банкротство====================================
    private void checkForBancrote() {
        if (playerCash <= 0) {
            textResult.setTextColor(Color.parseColor("#FF69B4")); // если игрок банкрот то цвет текста меняем
            textResult.setText("Ты обанкротился, друг!");
            gameOver = true;
            buttonRestart.setText("Новая игра"); // заменяем текст на кнопке сдать карты на новая игра
            bancrote = true; // булевую переменную включаем на тру чтобы корректно отработал метод новой игры
        }
        if (dealerCash <= 0) {
            textResult.setText("Красавчик - дилер без штанов!");
            gameOver = true;
            buttonRestart.setText("Новая игра"); // заменяем текст на кнопке сдать карты на новая игра
            bancrote = true; // булевую переменную включаем на тру чтобы корректно отработал метод новой игры
        }
    }
 //==================================================================================================
// =======================================метод ставки==============================================
    public void bet() {
// если денег хватает то делается ставка
        if (playerCash >= bet && dealerCash >= bet) {
            if (!doubleBet){ // если ставка не двойная то звук одной монетки
                playSound(R.raw.money_sound3);
            } else { // если ставка  двойная то звук много монет
                playSound(R.raw.money_sound2);
            }
            playerCash = playerCash - bet;
            dealerCash = dealerCash - bet;
            updateCash(); // обновляется значение кэша в полях игрока и дилера
            bank = bank + bet * 2; // в банк кладется ставка игрока и дилера
            textBank.setText(String.valueOf(bank)); // обновляется значение поля банк

            if (bank > 0) { // если банк больше 0 (ставки сделаны)
                buttonHint.setEnabled(true);
                buttonDoubleBet.setEnabled(true);
                buttonStop.setEnabled(true);
            } else { // если банк = 0 (ставки не сделаны)
                buttonHint.setEnabled(false);
                buttonDoubleBet.setEnabled(false);
                buttonStop.setEnabled(false);
            }
        } else { // если денег не хватает у кого то
            Toast.makeText(Level3.this, "Недостаточно денежек", Toast.LENGTH_SHORT).show();
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
}