package ru.PilkClicker.library;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;
import ru.PilkClicker.library.modules.Auth;
import ru.PilkClicker.library.modules.Requests.Shop.SaveItemRequest;
import ru.PilkClicker.library.modules.Responses.Shop.SaveItemResponse;
import ru.PilkClicker.library.modules.Responses.Shop.ShopUserResponse;
import ru.PilkClicker.library.modules.Shop;
import ru.PilkClicker.library.modules.Requests.Auth.LoginRequest;
import ru.PilkClicker.library.modules.Responses.Auth.LoginResponse;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ShopTest {
    private final Dotenv dotenv = Dotenv.load();
    @Test
    public void testShopUser() throws JSONException, HttpException, IOException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse loginToken = Auth.login(loginAuth);
        List<ShopUserResponse> responses = Shop.shopUser(loginToken.authToken);
        assertFalse(responses.isEmpty());
    }

    @Test
    public void testSaveItem() throws JSONException, HttpException, IOException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse loginToken = Auth.login(loginAuth);
        List<ShopUserResponse> items = Shop.shopUser(loginToken.authToken);
        SaveItemResponse response = Shop.saveItem(
                new SaveItemRequest(
                        items.get(0).id,
                        10
                ),
                loginToken.authToken
        );
        assertEquals(10, (int) response.amount);
    }
}
