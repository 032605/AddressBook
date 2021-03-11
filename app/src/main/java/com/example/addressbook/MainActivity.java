package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //Member Variable --------------------
    // 디버그를 위한 로그 FALSE로 바꿔주면 아무것도 안바뀐다
    private final boolean   D          = true;
    private final String    TAG        = "MainActivity";


    // View Object
    private EditText nameETXT, phoneETXT, emailETXT;
    private TextView addressTXT;
    private ListView   listView;

    private Button  addBTN, delBTN;

    // List
    private ArrayList<HashMap <String, String>> arrayList;
    private SimpleAdapter   adapter;
    private HashMap<String,String> map;

    //Member Method - AppCompatActivity;s override --------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Activity 화면 설정
        setContentView(R.layout.activity_main);

        // XML view 객체 가져오기
        nameETXT = findViewById(R.id.nameETXT);
        phoneETXT = findViewById(R.id.phoneETXT);
        emailETXT = findViewById(R.id.emailETXT);
        addressTXT = findViewById(R.id.addressTXT);

        listView = findViewById(R.id.listview);

        // 디버깅을 위해 true로 넣은 값을 false로 넣어주면 확인 안됨
        if (D) Log.i(TAG, "onCreate()");
        Toast.makeText(this, "⌯'▾'⌯ ", Toast.LENGTH_LONG).show();

        arrayList = new ArrayList<HashMap<String, String>>();

        adapter = new SimpleAdapter(MainActivity.this,
                                    arrayList,
                                    R.layout.haha_item,
                                    new String[] {"name", "phone","email"},
                                    new int[] {R.id.text_name, R.id.text_phone, R.id.text_email});
        listView.setAdapter(adapter);
    }

    // Member Method - custom --------------------------------

    // 숫자나 문자 들어간 경우는 switch 문이 더 깔끔
    public void click(View v){
        switch(v.getId())
        {
            case R.id.addBTN:

                map = new HashMap<String,String>();
                map.put("name", String.valueOf(nameETXT.getText()));
                map.put("phone", String.valueOf(phoneETXT.getText()));
                map.put("email", String.valueOf(emailETXT.getText()));

                if (nameETXT.getText().length()>0 && phoneETXT.getText().length()>0 && emailETXT.getText().length() > 0) {
                    arrayList.add(map);

                    adapter.notifyDataSetChanged();

                    initETXT();

                } else Toast.makeText(this, R.string.add_msg, Toast.LENGTH_LONG).show();

                break;

            case R.id.delBTN:

                // 마지막 값을 얻고 싶다면 index NUM에서 - 1
                int lastIdx = arrayList.size() - 1;
                if (arrayList.size() == 0)
                    return;
                arrayList.remove(lastIdx);
                adapter.notifyDataSetChanged();

                break;
        }
    }

    // Member Method - custom --------------------
    // 초기화
    private void initETXT(){
        nameETXT.setText("");
        phoneETXT.setText("");
        emailETXT.setText("");
    }

}