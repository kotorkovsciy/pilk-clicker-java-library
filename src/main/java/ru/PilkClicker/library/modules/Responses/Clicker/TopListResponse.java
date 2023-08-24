package ru.PilkClicker.library.modules.Responses.Clicker;

public class TopListResponse {
    public String username;
    public Integer arcoinAmount;

    public TopListResponse(String username, Integer arcoinAmount){
        this.username = username;
        this.arcoinAmount = arcoinAmount;
    }
}
