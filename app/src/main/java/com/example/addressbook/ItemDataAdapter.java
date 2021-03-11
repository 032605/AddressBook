package com.example.addressbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// ItemData를 관리해주는 ArrayAdapter를 상속해오겠다!!
public class ItemDataAdapter extends ArrayAdapter<ItemData> {
    // Member Variable ------------------------------
    private Context            context;
    private int                 layoutResID; // UI
    private  ArrayList<ItemData>    dataList;

    // Constructor Method  ---------------- 생성자
    // ArrayList<ItemData> objects)를 int resource에 맞게끔 그려주는 것이 adapter의 역할
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layoutResID=resource;
        this.dataList = objects;
    }

    // Override Method -------------------------------- code - override 선택창
    // adapter 들어가는 함수 2개
    // 1) 전체 개수 세는 함수 -- getCount
    // 2) 화면을 그려주는 함수 -- getView

    // 개수는 계속 바뀔 것이기 때문
    @Override
    public int getCount() {
        return dataList.size();
    }

    // contetview 와 같은 역할. xml을 java 객체로 보여주기 위한 함수
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data ==> XML Layout에 넣어서 보이고 사용할 수 있도록 객체 생성 변환(convertView)


        // 1) item Layout xml ==> java 객체 변환  // inflater 안드로이드에서 제공되는 것

        if (convertView == null ) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // root로 지정된 것이 없어서 null 값
            convertView  = inflater.inflate(layoutResID, null);

            ItemDataHolder holder = new ItemDataHolder(convertView);
            convertView.setTag(holder);
        }
        ItemDataHolder holder = (ItemDataHolder) convertView.getTag();
/*
        // 2) item Layout's View 객체 가져오기  ( holder class에서 진행 )
        TextView text_name = convertView.findViewById(R.id.text_name);
        TextView text_phone = convertView.findViewById(R.id.text_phone);
        TextView text_email = convertView.findViewById(R.id.text_email);
        ImageView icon = convertView.findViewById(R.id.icon);
*/
        TextView text_name = holder.text_name;
        TextView text_phone = holder.text_phone;
        TextView text_email = holder.text_email;
        ImageView icon = holder.icon;

        // 3) Data 준비
        // final 쓰는 이유는 10개 데이터가 있으면 10번 돌기 때문에 final을 써서 한번만 돌게 한다.
        final ItemData item = dataList.get(position);

        // 4) Layout < --- > Data
        text_name.setText(item.getName());
        text_phone.setText(item.getPhone());
        text_email.setText(item.getEmail());
        icon.setImageResource(item.getImgResId());


        // image 크기 동일하게

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), item.getImgResId());
        bitmap = bitmap.createScaledBitmap(bitmap,80,80,true);
        icon.setImageBitmap(bitmap);

        return convertView;
    }
}
