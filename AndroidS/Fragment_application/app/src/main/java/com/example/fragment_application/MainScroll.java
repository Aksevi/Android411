package com.example.fragment_application;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
//MainScroll — это активити, которая отображает несколько экранов (фрагментов), между которыми можно листать влево-вправо, как в книжке.
//Для этого используется ViewPager2 — современный способ делать такие "скроллящиеся" интерфейсы в Android.
//Это главная активити. Наследуется от FragmentActivity, чтобы можно было использовать ViewPager2 и фрагменты.
public class MainScroll extends FragmentActivity { //AppCompatActivity заменили на FragmentActivity

    private static final int NUM_PAGES = 5; // переменная количества страниц. капс потому что константа final
    private ViewPager2 viewPager2; // это класс из activity_main_scroll.xml  ViewPager2 — это как “листалка страниц”.
    private FragmentStateAdapter pageAdapter;  // адаптер, который говорит ViewPager2: "Вот тебе страница №0 — покажи фрагмент FragmentOne()" и т.д.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scroll);

        viewPager2 = findViewById(R.id.pager); // ищем ViewPager2 в разметке activity_main_scroll.xml. Там должен быть <androidx.viewpager2.widget.ViewPager2 /> с android:id="@+id/pager"

// ***Создаём адаптер (см. ниже) и прикручиваем его к ViewPager2, чтобы он знал, какие фрагменты показывать при листании.
        pageAdapter = new ScreenSliderAdapter(this);
        viewPager2.setAdapter(pageAdapter);
//***************************************************
    }
//Внутренний класс ScreenSliderAdapter. Это адаптер — переводчик, который сообщает ViewPager2, какой фрагмент показывать на какой позиции.
    private class ScreenSliderAdapter extends FragmentStateAdapter {
        //Конструктор: Передаём в адаптер контекст активити, чтобы он знал, где работает.
        public ScreenSliderAdapter(MainScroll mainScroll) {
            super(mainScroll);
        }
// переопределиоли два метода через alt+ins
        @NonNull
        @Override
        public Fragment createFragment(int position) { //Метод createFragment(int position)
            //Смотри как просто:
            //Если ты пролистываешь на позицию 2 — покажем FragmentThree().
            //Это как:
            //➡ позиция 0 = страница "Главная"
            //➡ позиция 1 = "Новости"
            //➡ позиция 2 = "Профиль" и т.д.
            switch (position) {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                case 3:
                    return new FragmentFour();
                case 4:
                    return new FragmentFive();
                default:
                    return null;

            }

        }

        @Override
        public int getItemCount() { //Метод getItemCount()
            return NUM_PAGES; //Говорим: всего 5 страниц будет.
        }
    }
}