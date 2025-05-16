package com.example.black_jack;

public class Card {

    private int imageResId; // id картинки
    private int value; // значение карты (стоимость карты в очках)
    private String suit; // масть карты (по желанию)

    // конструктор. он запускается когда создаем новую карту  через deck.add(new Card(...)) и заполняет поля  - вот так например deck.add(new Card(R.drawable.five_of_spades, 5, "diamonds"));
    public Card(int imageResId, int value, String suit) {
        this.imageResId = imageResId;
        this.value = value;
        this.suit = suit;
    }

    // гетеры - позволяют получить доступ к значениям полей
    public int getImageResId() {
        return imageResId;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
}