package com.example.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Member Variable --------------------
    // 디버그를 위한 로그 FALSE로 바꿔주면 아무것도 안바뀐다
    private final boolean   D          = true;
    private final String    TAG        = "MainActivity";


    // View Object
    private EditText nameETXT, phoneETXT, emailETXT;
    private TextView addressTXT;
    private ListView   listView;

    // Data
    private ArrayList<Address> addressList = new ArrayList<>();

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
    }

    // Member Method - custom --------------------------------

    // 숫자나 문자 들어간 경우는 switch 문이 더 깔끔
    public void click(View v){
        switch(v.getId())
        {
            case R.id.addBTN:
                // 3개 editText 값 읽어서 Address 객체 생성 및 추가
                // (1) 3개 editText 값 입력 여부 체크
                if (nameETXT.getText().length()>0 && phoneETXT.getText().length()>0 && emailETXT.getText().length() > 0)
                {
                    // (2) Address 객체 생성 및 Arraylist 추가
                    addressList.add(new Address(nameETXT.getText().toString(),
                                                phoneETXT.getText().toString(),
                                                emailETXT.getText().toString()));

                    // 제대로 들어갔는지 개수 확인
                    Log.i(TAG, "add =>" + addressList.size());

                    // 3개 입력 필드 초기화
                    initETXT();

                    // TextView에 데이터 출력
                   displayAddress();
                } else {
                    Log.i(TAG, "abc =");
                    // (2-2) 사용자에게 알림 띄우기
                    Toast.makeText(this, R.string.add_msg, Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.delBTN:
                    // 가장 최근에 생성된 데이터 삭제
                if (addressList.size() > 0) {
                    int lastIdx = addressList.size() - 1;
                    addressList.remove(lastIdx);

                    // 데이터 출력
                    displayAddress();
                }
                     else {
                    Log.i(TAG, "delBTN =");
                    Toast.makeText(this, R.string.del_msg, Toast.LENGTH_LONG).show();
                }
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

    // Address 출력 메서드 ------------
    private void displayAddress() {
        String datas = "";
        for (int idx = 0; idx < addressList.size(); idx++)
            // datas에 뒤에 변수를 더하는 것
            datas += addressList.get(idx).getInfo() + "\n";

        if (datas.length() > 0)
            addressTXT.setText(datas);
        else
            addressTXT.setText(R.string.nothing);
    }

}