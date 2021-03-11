package com.example.addressbook;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDataHolder {
    public ImageView icon;
    public TextView text_name, text_phone, text_email;

    // ListView item 표시해주는 XML layout ==> Java Obeject 저장
    public ItemDataHolder(View root) {
        this.text_name = root.findViewById(R.id.text_name);
        this.text_phone = root.findViewById(R.id.text_phone);
        this.text_email = root.findViewById(R.id.text_email);
        this.icon = root.findViewById(R.id.icon);
    }

    public ItemDataHolder(ImageView icon, TextView text_name, TextView text_phone, TextView text_email) {
        this.icon = icon;
        this.text_name = text_name;
        this.text_phone = text_phone;
        this.text_email = text_email;
    }
}
