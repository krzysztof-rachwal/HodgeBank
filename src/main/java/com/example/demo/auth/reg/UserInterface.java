package com.example.demo.auth.reg;

public interface UserInterface {
    boolean doesUserNameExist(String u);
    boolean addUser(User user);
}
