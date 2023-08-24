package ru.PilkClicker.library.modules.Requests.Auth;

public class LogupRequests {
    public String username;
    public String password;
    public String email;

    public LogupRequests(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
