package com.example.addressbook;

// ListView 표시될 한 개의 Item
// alt + Insert ==> 단축키

public class Address {
    //member Variable --------------------
    private String name;
    private String phone;
    private String email;
    private int     ImgResId;

    //Constructor Method  ----------------
    public Address(String name, String phone, String email, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        ImgResId = imgResId;

    }

    // Member variable 제어 메서드
    // Getter / Setter Method ---------------------
    // class에 있는 객체를 쓰려고 기본적으로 있어야함 

    // Getter
    public String getName() {
        return name;
    }

    // Setter
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

    // Custom Method -------------------------
    // 한방에 써줄 수 있는거
    public String getInfo() {
        return this.name + " - " + this.phone + " - " + this.email;
    }
}
