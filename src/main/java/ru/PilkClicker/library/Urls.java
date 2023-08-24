package ru.PilkClicker.library;

public class Urls {
    private static final String Url = "http://pilk-clicker.ru/api";

    private static final String urlAuth = Url + "/auth";
    public static String loginUrl = urlAuth + "/token/login/";
    public static String logoutUrl = urlAuth + "/token/logout/";
    public static String logupUrl = urlAuth + "/users/";


    public static String clickerDetailUrl = Url + "/clicker/";
    public static String topListUrl = Url + "/top_list/";
    public static String shopUserUrl = Url + "/shop_user_detail/";
    public static String saveClickerUrl = Url + "/save_clicker/";
    public static String saveItemUrl = Url + "/save_item/";
}
