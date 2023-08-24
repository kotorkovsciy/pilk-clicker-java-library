package ru.PilkClicker.library.modules.Responses.Auth;

public class LogupResponse {
    public Integer id;
    public String username;
    public String email;

    public LogupResponse(Integer id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
