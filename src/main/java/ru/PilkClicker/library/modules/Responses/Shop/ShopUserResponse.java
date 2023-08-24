package ru.PilkClicker.library.modules.Responses.Shop;

public class ShopUserResponse {
    public Integer id;
    public String name;
    public Integer amount;
    public Integer price;
    public Integer basePrice;
    public Float arcoinsPerSeconds;
    public Integer arcoinsPerClick;
    public String image;

    public ShopUserResponse(
            Integer id,
            String name,
            Integer amount,
            Integer price,
            Integer basePrice,
            Float arcoinsPerSeconds,
            Integer arcoinsPerClick,
            String image
    ){
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.basePrice = basePrice;
        this.arcoinsPerSeconds = arcoinsPerSeconds;
        this.arcoinsPerClick = arcoinsPerClick;
        this.image = image;
    }
}
