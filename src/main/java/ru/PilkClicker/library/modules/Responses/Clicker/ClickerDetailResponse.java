package ru.PilkClicker.library.modules.Responses.Clicker;

public class ClickerDetailResponse {
    public String username;
    public Integer arcoinAmount;
    public Integer arcoinsPerSeconds;
    public Integer arcoinsPerClick;

    public ClickerDetailResponse(
            String username,
            Integer arcoinAmount,
            Integer arcoinsPerSeconds,
            Integer arcoinsPerClick
    ){
        this.username = username;
        this.arcoinAmount = arcoinAmount;
        this.arcoinsPerSeconds = arcoinsPerSeconds;
        this.arcoinsPerClick = arcoinsPerClick;
    }
}
