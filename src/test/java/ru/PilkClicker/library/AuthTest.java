package ru.PilkClicker.library;

import ru.PilkClicker.library.modules.Responses.Auth.LoginResponse;
import ru.PilkClicker.library.modules.Requests.Auth.LoginRequest;
import ru.PilkClicker.library.modules.Requests.Auth.LogupRequests;
import ru.PilkClicker.library.modules.Auth;

import static org.junit.Assert.assertEquals;

import io.github.cdimascio.dotenv.Dotenv;

import org.apache.http.HttpException;
import org.json.JSONException;
import org.junit.Test;
import ru.PilkClicker.library.modules.Responses.Auth.LogupResponse;

import java.io.IOException;
import java.util.Random;

public class AuthTest
{
    private final Dotenv dotenv = Dotenv.load();
    @Test
    public void testLogin() throws JSONException, IOException, HttpException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        Auth.login(loginAuth);
    }

    @Test
    public void testLogout() throws JSONException, IOException, HttpException {
        LoginRequest loginAuth = new LoginRequest(
                dotenv.get("USERNAME"),
                dotenv.get("PASSWORD")
        );
        LoginResponse response = Auth.login(loginAuth);
        Auth.logout(response.authToken);
    }

    @Test
    public void testLogup() throws JSONException, IOException, HttpException {
        Random random = new Random();
        LogupRequests logupData = new LogupRequests(
                "test_" + random.nextInt(10000),
                "test_" + random.nextInt(10000)  + "rt$$$",
                "test_" + random.nextInt(10000) + "@test.com"
        );
        LogupResponse response = Auth.logup(logupData);
        assertEquals(response.username, logupData.username);
    }
}
