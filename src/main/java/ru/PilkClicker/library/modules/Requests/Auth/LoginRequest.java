package ru.PilkClicker.library.modules.Requests.Auth;

public class LoginRequest {
    public String username;
    public String password;

    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }
}
