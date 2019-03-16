package com.example.mariya.kudagoleshch;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

   // private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final String[] catNamesArray = new String[] { "Рыжик", "Барсик", "Мурзик",
        //        "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
        //        "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };

        //mAdapter = new ArrayAdapter<>(this,
        //       android.R.layout.simple_list_item_1, catNamesArray);

        //setListAdapter(mAdapter);

    }
}
