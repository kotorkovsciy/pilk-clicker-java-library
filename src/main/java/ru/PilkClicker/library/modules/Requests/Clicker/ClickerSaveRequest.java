package ru.PilkClicker.library.modules.Requests.Clicker;

public class ClickerSaveRequest {
    public Integer arcoinAmount;
    public Integer arcoinsPerSeconds;
    public Integer arcoinsPerClick;

    public ClickerSaveRequest(
            Integer arcoinAmount,
            Integer arcoinsPerSeconds,
            Integer arcoinsPerClick
    ){
        this.arcoinAmount = arcoinAmount;
        this.arcoinsPerSeconds = arcoinsPerSeconds;
        this.arcoinsPerClick = arcoinsPerClick;
    }
}
