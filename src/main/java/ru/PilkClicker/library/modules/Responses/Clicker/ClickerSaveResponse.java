package ru.PilkClicker.library.modules.Responses.Clicker;

public class ClickerSaveResponse {
    public Integer arcoinAmount;
    public Integer arcoinsPerSeconds;
    public Integer arcoinsPerClick;

    public ClickerSaveResponse(Integer arcoinAmount, Integer arcoinsPerSeconds, Integer arcoinsPerClick){
        this.arcoinAmount = arcoinAmount;
        this.arcoinsPerSeconds = arcoinsPerSeconds;
        this.arcoinsPerClick = arcoinsPerClick;
    }
}
