package com.yadevapp.tuto_dynamic_toolbar;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Toolbar mToolbar;
    private ListView mListView;
    private CollapsingToolbarLayout mToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.activity_main_toolbar);
        mListView = findViewById(R.id.activity_main_listview);
        mToolbarLayout = findViewById(R.id.activity_main_toolbar_layout);
        setSupportActionBar(mToolbar);
        mToolbarLayout.setTitle("Title");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mListView.setNestedScrollingEnabled(true);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                getResources().getStringArray(R.array.list_array));
        mListView.setAdapter(arrayAdapter);
    }
}
