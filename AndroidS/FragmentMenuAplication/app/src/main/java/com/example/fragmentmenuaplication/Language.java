package com.example.fragmentmenuaplication;

import java.util.ArrayList;

public class Language {

    private static ArrayList<Language> languageArrayList; //Это статическое поле, общее для всех объектов Language. Хранит список всех языков, созданных вручную.
// Обычные поля экземпляра — идентификатор и название языка.
    private int id;
    private String name;

// alt+ins конструктор с id и name
    public Language(int id, String name) { // Позволяет создать язык с определённым ID и названием.
        this.id = id;
        this.name = name;
    }
    // alt+ins геттер и сеттер с id и name. Стандартные методы для доступа к полям (get) и их изменения (set).
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

// придуманный метод. Создаёт список языков вручную.
    public static void initLanguage(){
        languageArrayList = new ArrayList<>();
// добавляем языки
        Language english = new Language(0, "English"); // в таком виде потмоу что есть конструктор
        languageArrayList.add(english);

        Language japan = new Language(1, "Japan");
        languageArrayList.add(japan);

        Language french = new Language(2, "French");
        languageArrayList.add(french);

        Language russian = new Language(3, "Russian");
        languageArrayList.add(russian);

        Language belarussian = new Language(4, "Belarussian");
        languageArrayList.add(belarussian);

        Language german = new Language(5, "German");
        languageArrayList.add(german);

    }
//Метод getLanguageArrayList() Просто возвращает текущий список языков. Можно использовать для отображения списка в RecyclerView, Spinner и т.д.
    public static ArrayList<Language> getLanguageArrayList(){
        return languageArrayList;
    }
//  Метод languageNames() Возвращает массив названий языков (String[]), без ID.
    public static  String[] languageNames(){
        String[] names = new String[languageArrayList.size()];

        for (int i = 0; i < languageArrayList.size(); i++) {
            names[i] = languageArrayList.get(i).name;
        }
        return names;
    }
}
