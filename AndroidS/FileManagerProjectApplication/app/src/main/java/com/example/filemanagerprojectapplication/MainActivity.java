package com.example.filemanagerprojectapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.filemanagerprojectapplication.fragments.CardFragment;
import com.example.filemanagerprojectapplication.fragments.InternalFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//==================================================================================================
//===========================здесь сделали меню выезжает и заезжает=================================
        Toolbar toolbar = findViewById(R.id.toolbar); // Ищем Toolbar по ID из XML. доступ к элементу из activity_main.xml
        setSupportActionBar(toolbar); //setSupportActionBar(toolbar) — превращает наш кастомный Toolbar в полноценную "ActionBar", чтобы работали кнопки, меню и т.п.
// Подключение DrawerLayout (выезжающее меню)
        NavigationView navigationView = findViewById(R.id.nav_view); // доступ к элементу из activity_main.xml  NavigationView — боковое меню (левая панель с пунктами).
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);  // доступ к элементу из activity_main.xml DrawerLayout — контейнер, который управляет выездом меню.
//обавляем "гамбургер" (иконка меню)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer); // экз класса для выезжающего меню. ActionBarDrawerToggle — Синхронизирует иконку ("гамбургер" или "стрелка назад") Автоматически открывает/закрывает меню

        drawerLayout.addDrawerListener(toggle); //addDrawerListener(toggle) — передаём слушателя DrawerLayout'у
        toggle.syncState(); //чтобы иконка появилась.
//==================================================================================================
//==================================================================================================

        replaceFragment(new InternalFragment()); //Сразу при запуске вставляем в контейнер (в FrameLayout) фрагмент InternalFragment.

//Обработка нажатий в меню:
        //Устанавливаем слушатель выбора пунктов в NavigationView
        //При нажатии на пункт меню:
        //Меняем фрагмент на нужный
        //Закрываем выезжающее меню (closeDrawer())
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_internal){ // nav_internal элемент из nav_menu
                    replaceFragment(new InternalFragment());
//                    drawerLayout.closeDrawer(GravityCompat.START); // уезжание меню
                } else if (item.getItemId() == R.id.nav_card) { //nav_card элемент из nav_menu
                    replaceFragment(new CardFragment());
//                    drawerLayout.closeDrawer(GravityCompat.START); // уезжание меню
                }
                else if (item.getItemId() == R.id.nav_about){ // nav_about элемент из nav_menu
                    Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
//                    drawerLayout.closeDrawer(GravityCompat.START); // уезжание меню
                }
                drawerLayout.closeDrawer(GravityCompat.START); // уезжание меню
                return false;
            }
        });

    }// метод замены фрагмента. он стандартный. заменить надо только  R.id.fragment_container
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();//Берём FragmentManager — он рулит всеми фрагментами, Начинаем транзакцию (изменения)
        fragmentTransaction.replace(R.id.fragment_container, fragment); //replace(...) — заменяем текущий фрагмент на новый
        fragmentTransaction.commit(); //commit() — подтверждаем изменения
    }
}