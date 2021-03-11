package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    // Member Variable ------------------------------
    private final boolean       D = true;
    private final String        TAG = "CustomActivity";

    private ListView    dataLST;

    private ArrayList<ItemData>     datArrays;
    private ItemDataAdapter     adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        init();
    }

    // Member Method - custom --------------------
    // 초기화
    private void init() {
        dataLST = findViewById(R.id.listview);

        datArrays = new ArrayList<ItemData>();
        datArrays.add(new ItemData("김나현", "010-2941-5481","032605@naver.com",R.drawable.user));
        datArrays.add(new ItemData("김가나", "010-1234-5481","skgus5481@naver.com",R.drawable.user));

        adapter = new ItemDataAdapter(this, R.layout.haha_item, datArrays);
        dataLST.setAdapter(adapter);
    }
 }