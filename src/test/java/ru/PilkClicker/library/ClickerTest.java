package ru.PilkClicker.library;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;
import ru.PilkClicker.library.modules.Auth;
import ru.PilkClicker.library.modules.Requests.Auth.LoginRequest;
import ru.PilkClicker.library.modules.Clicker;
import ru.PilkClicker.library.modules.Requests.Clicker.ClickerSaveRequest;
import ru.PilkClicker.library.modules.Responses.Auth.LoginResponse;
import ru.PilkClicker.library.modules.Responses.Clicker.ClickerDetailResponse;
import ru.PilkClicker.library.modules.Responses.Clicker.ClickerSaveResponse;
import ru.PilkClicker.library.modules.Responses.Clicker.TopListResponse;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ClickerTest {
    private final Dotenv dotenv = Dotenv.load();
    @Test
    public void testClickerDetail() throws JSONException, HttpException, IOException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse loginToken = Auth.login(loginAuth);
        ClickerDetailResponse response = Clicker.clickerDetail(loginToken.authToken);
        assertEquals(loginAuth.username, response.username);
    }

    @Test
    public void testTopList() throws JSONException, HttpException, IOException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse loginToken = Auth.login(loginAuth);
        List<TopListResponse> response = Clicker.topList(loginToken.authToken);
        assertFalse(response.isEmpty());
    }

    @Test
    public void testClickerSave() throws JSONException, HttpException, IOException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse loginToken = Auth.login(loginAuth);
        ClickerSaveResponse response = Clicker.clickerSave(
                new ClickerSaveRequest(
                        1000,
                        1,
                        1
                ),
                loginToken.authToken
        );
        assertEquals(1000, (int) response.arcoinAmount);
    }
}
