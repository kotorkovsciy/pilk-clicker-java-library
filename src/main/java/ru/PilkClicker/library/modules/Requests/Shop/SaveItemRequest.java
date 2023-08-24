package ru.PilkClicker.library.modules.Requests.Shop;

public class SaveItemRequest {
    public Integer id;
    public Integer amount;

    public SaveItemRequest(Integer id, Integer amount){
        this.id = id;
        this.amount = amount;
    }
}
