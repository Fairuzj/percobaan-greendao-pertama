package com.example.ok.percobaan1;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class User {

    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @Generated(hash = 99511649)
    public User(Long id, @NotNull String name, @NotNull String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }
    public String getAddress() {
        return this.address;
    }
    public String setAddress(String address) {
        this.address = address;
        return address;
    }

}