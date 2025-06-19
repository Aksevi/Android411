package com.example.filemanagerprojectapplication;

import java.io.File;

public interface OnFileSelectedListener {

    void onFileClicked(File file); // короткий клик
    void onFileLongClicked(File file, int position);// длинный клик. int position добавили для реализации Renaim

}


