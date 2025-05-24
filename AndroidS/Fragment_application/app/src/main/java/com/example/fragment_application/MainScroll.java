package com.example.fragment_application;

import android.os.Bundle;
import android.view.View;

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
//*********************************анимация переходов*********************************************
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());//  устанавливает кастомную анимацию при переходе между страницами в ViewPager2. Анимация реализована внутри класса ZoomOutPageTransformer. (напт=исали ниже в 81 стр)

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
//=======================класс ZoomOutPageTransformer================================================
// внутренний класс, реализующий интерфейс PageTransformer, чтобы определить, как страница должна вести себя при пролистывании.
    private class ZoomOutPageTransformer implements  ViewPager2.PageTransformer{
// Константы
        private static final float MIN_SCALE = 0.05f;// минимальное масштабирование (то есть насколько может "уменьшиться" страница).
        private static final float MIN_ALPHA = 0.5f; //минимальная прозрачность ( 0.5 - страницы не исчезают полностью, а полупрозрачны).

        @Override
        public void transformPage(@NonNull View page, float position) { //Этот метод вызывается каждый раз, когда страница отображается или прокручивается. Он определяет вид страницы в зависимости от её позиции.

            int pageWidth = page.getWidth(); //Запоминаются размеры страницы (в пикселях). в данном случае нас ширина только интересует
//Условие 1: страница вне экрана слева
            if (position < -1) { //Если страница слишком далеко слева, она становится полностью прозрачной.
                page.setAlpha(0f);
//Условие 2: страница на экране или рядом
            } else if (position <=1) {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position)); //Если страница в центре (position == 0), масштаб = 1 (обычный размер). Чем дальше от центра (±1), тем меньше масштаб. Но не меньше MIN_SCALE.

                float horizontalMargin = pageWidth * (1 - scaleFactor) / 2; //Горизонтальный сдвиг

                if (position < 0){
                    page.setTranslationX(horizontalMargin / 2); //Страница немного сдвигается, чтобы компенсировать уменьшение размера.
                }
                else {
                    page.setTranslationX(-horizontalMargin / 2);
                }
                //Масштабирование и прозрачность:
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_SCALE)); //Альфа-прозрачность увеличивается от MIN_ALPHA до 1, пропорционально масштабу.
            }
            else{ //Условие 3: страница вне экрана справа
                page.setAlpha(0f); //Если страница слишком далеко справа, делаем её полностью прозрачной.
            }
        }
    }
}