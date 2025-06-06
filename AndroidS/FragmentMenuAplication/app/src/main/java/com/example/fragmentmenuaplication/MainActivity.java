package com.example.fragmentmenuaplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//=======================обязательно для работы с меню==============================================
// Находишь Toolbar по ID из XML и превращаешь его в стандартный ActionBar, чтобы можно было к нему "прицепить" меню (в т.ч. «гамбургер» слева).
        MaterialToolbar materialToolbar = findViewById(R.id.materialToolBar);
        setSupportActionBar(materialToolbar); // доступ к пунктам меню
//==================================================================================================

// Здесь ты получаешь доступ к компонентам бокового меню:
        NavigationView navigationView = findViewById(R.id.navigation_view); //NavigationView — само меню со списком пунктов (обычно задаётся в menu.xml).
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout); //DrawerLayout — контейнер, который позволяет выдвигать меню.

//Это создаёт кнопку-гамбургер (три полоски слева в тулбаре), которая открывает и закрывает меню. addDrawerListener следит за её состоянием.
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //*******************************Синхронизирует состояние иконки "гамбургера" в Toolbar с состоянием DrawerLayout****************************
        actionBarDrawerToggle.syncState();//💡 Важно! Хорошая практика добавить actionBarDrawerToggle.syncState(); в конце — чтобы иконка синхронизировалась.
        // Без него: Гамбургер может не появиться сразу или не работать корректно при открытии/закрытии меню.
        // Иконка в Toolbar может быть не той, что ожидается (например, иконка "назад" или "пользователь").
        //✅ С ним: Android точно знает: "ага, у нас есть выдвижное меню, значит ставим три полоски и связываем поведение кнопки с открытием/закрытием меню"
        //Раньше у тебя была иконка пользователя и три точки — потому что Toolbar использовался как обычный ActionBar, без меню Drawer.
        // new ActionBarDrawerToggle(...)	Создаёт связку "меню ↔ тулбар"
        //drawerLayout.addDrawerListener(...)	Подключает эту связку как слушателя
        // syncState()	Обновляет иконку и синхронизирует состояние

        //**********************************************************************************************

//        replaceFragment(new FragmentFirstPage());//задаём стартовый фрагмент (типа "домашняя страница").
        replaceFragment(new FragmentFirstPage() );//задаём стартовый фрагмент (типа "домашняя страница").

//============================ Обработка пунктов меню===============================================
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.first_page) {
                    replaceFragment(new FragmentFirstPage()); // Переключаешь на 1 фрагмент.
                    drawerLayout.closeDrawer(GravityCompat.START); // закрывает меню после выбора
                } else if (item.getItemId() == R.id.second_page) {
                    replaceFragment(new FragmentSecondPage()); // Переключаешь на 2 фрагмент.
                    drawerLayout.closeDrawer(GravityCompat.START);// закрывает меню после выбора
                } else if (item.getItemId() == R.id.third_page) {
                    replaceFragment(new FragmentThirdPage()); // Переключаешь на 3 фрагмент.
                    drawerLayout.closeDrawer(GravityCompat.START);// закрывает меню после выбора
                }
                else if (item.getItemId() == R.id.fourth_page) {
                    replaceFragment(new FragmentFourthPage()); // Переключаешь на 4 фрагмент.
                    drawerLayout.closeDrawer(GravityCompat.START);// закрывает меню после выбора
                }
                return false;
            }
        });
//====================================================================================================
    }

    // ==================================метод замены фрагмента==========================================
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction(); // создаем FragmentTransaction fragmentTransaction и запускаем изменения
        fragmentTransaction.replace(R.id.frame_layout, fragment); //подменяем текущий фрагмент новым. R.id.frame_layout — это контейнер в activity_main.xml, куда вставляются фрагменты.
        fragmentTransaction.commit();// применяем изменения
    }
//====================================================================================================
}