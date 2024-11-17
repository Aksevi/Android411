package storonnee;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Tab {
    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("Простая таблица");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Данные таблицы
        String[][] data = {
                {"Ячейка 1", "Ячейка 2"},
                {"Ячейка 3", "Ячейка 4"},
                {"Ячейка 5", "Ячейка 6"}
        };

        // Заголовки столбцов
        String[] columnNames = {"Столбец 1", "Столбец 2"};

        // Создаем таблицу
        JTable table = new JTable(data, columnNames);

        // Добавляем таблицу в окно
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Делаем окно видимым
        frame.setVisible(true);
    }
}

