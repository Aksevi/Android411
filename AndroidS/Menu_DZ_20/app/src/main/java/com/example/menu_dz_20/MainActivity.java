package com.example.menu_dz_20;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
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
//***********************************этот блок собственно отвечает за само выезжающее меню***********************************************
//======================это обязательный момент для работы с меню. грубо говоря- всегда его пишем=============================
        MaterialToolbar materialToolBar = findViewById(R.id.material_ToolBar); // доступ к material_ToolBar в activity_main.xml - это наша "шапка", верхняя панель.
        setSupportActionBar(materialToolBar); //Делаем Toolbar главной ActionBar'иной. Без этого меню не привяжется к "бургеру".
//=============================================================================================================================
//получаем доступ к тому элементу котрый будет выезжать. в activity_main.xml это navigation_view
        NavigationView navigationView = findViewById(R.id.navigation_view); //Это сама панель меню — та часть, где написаны пункты: "Фрагмент 1", "Фрагмент 2" и т.д.
        navigationView.setItemIconTintList(null); // это нужно чтобы иконка в самом меню отображалась корректно. вместе с этим в activity_main.xml в поле navigation_view вставляем вот это app:itemIconTint="@null" (хотя я потом убрал и все заработало и так)

//Это корневая обёртка всей активности, в которую "вложено" меню и остальная часть экрана. Именно DrawerLayout умеет «вытаскивать» и «прятать» меню.
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

// Создаёт "связь" между DrawerLayout и Toolbar. Благодаря этой строке:появляется иконка "гамбургера" (три полоски),она крутится при открытии/закрытии меню,синхронизируются состояния (открыт / закрыт).
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, materialToolBar, R.string.drawer_open, R.string.drawer_close); //здесь переменная toggle принимиает несколько параметров - MainActivity.this - значит работает в окне MainActivity, drawerLayout - доступ к корневому тегу где у нас все элементы, materialToolBar - доступ к элементам тулбара, R.string.drawer_open, R.string.drawer_close - это в string создали два ресурса (как я понял это 2 состояния  меню)
        drawerLayout.addDrawerListener(toggle); //Говорим DrawerLayout: "Эй, дружище, теперь слушай toggle, он будет управлять выездом и заездом меню".
//*********************************************************************************************************************************

        replaceFragment(R.id.frame_layout, new Fragment_1()); // здесь мы стартовой страницей сделали Fragment_1 то есть он сразу при запуске будет отображаться без всяких нажатий в меню

//+++++++++++++++++++++++ обрабатываем нажатие в самом меню+++++++++++++++++++++++++++++++++++++++++
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//В зависимости от нажатого пункта (fragment_1, fragment_2, fragment_3), загружается соответствующий Fragment.
                if (item.getItemId() == R.id.fragment_1){
                    replaceFragment(R.id.frame_layout, new Fragment_1());
                    drawerLayout.closeDrawer(GravityCompat.START); // нужно чтобы после выбора пункта меню и после перехода на нужную страницу меню закрывалось
                } else if (item.getItemId() == R.id.fragment_2) {
                    replaceFragment(R.id.frame_layout, new Fragment_2());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.fragment_3) {
                    replaceFragment(R.id.frame_layout, new Fragment_3());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    }
// =========================метод замены фрагмента==============================================================================================
//тут немного отдичается от того что деолали на уроке - тут он универсальный. вызывается так - replaceFragment(R.id.myContainer, new MyFragment()); - R.id.myContainer - сюда пишем например R.id.frame_layout - это наше поле фрагмента из activity_main.xml; new MyFragment() - сюда пишем например new Fragment_1() - это наш фрагмент (читай слой с соответствующим названием)
    public void replaceFragment(@IdRes int containerId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Готовим транзакцию — типа "планируем" замену.

        fragmentTransaction.addToBackStack(null); // добавляет в стек назад(при нажатии кнопки назад вернемся к предыдущему фрагменту)

        fragmentTransaction.replace(containerId, fragment); //Заменяем текущий фрагмент на нужный и подтверждаем замену.
        fragmentTransaction.commit();
    }
//=============================================================================================================================================
}