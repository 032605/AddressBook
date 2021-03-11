package com.example.addressbook;
// ListView 표시될 한 개의 Item

public class ItemData {
    private String  name;
    private String  phone;
    private String  email;
    private int     ImgResId;

    public ItemData(String name, String phone, String email, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        ImgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImgResId() {
        return ImgResId;
    }

    public void setImgResId(int imgResId) {
        ImgResId = imgResId;
    }
}
