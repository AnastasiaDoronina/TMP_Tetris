package com.company;
import java.io.Serializable;

public class user implements Serializable {
    String name;
    int id;
    public user(String name, int id){
        this.name=name;
        this.id=id;
    }
}
