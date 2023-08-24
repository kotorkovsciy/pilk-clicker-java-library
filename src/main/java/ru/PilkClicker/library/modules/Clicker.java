package ru.PilkClicker.library.modules;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.PilkClicker.library.Urls;
import ru.PilkClicker.library.modules.Requests.Clicker.ClickerSaveRequest;
import ru.PilkClicker.library.modules.Responses.Clicker.ClickerDetailResponse;
import ru.PilkClicker.library.modules.Responses.Clicker.ClickerSaveResponse;
import ru.PilkClicker.library.modules.Responses.Clicker.TopListResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Clicker {
    public static ClickerDetailResponse clickerDetail(String token) throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(Urls.clickerDetailUrl);

        HttpUtils.setToken(request, token);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONObject response = HttpUtils.getContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        return new ClickerDetailResponse(
                response.getString("username"),
                response.getInt("arcoin_amount"),
                response.getInt("arcoins_per_seconds"),
                response.getInt("arcoins_per_click")
        );
    }

    public static List<TopListResponse> topList(String token) throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(Urls.topListUrl);

        HttpUtils.setToken(request, token);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONArray response = HttpUtils.getArrayContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        List<TopListResponse> toplist = new ArrayList<TopListResponse>();

        for (int i = 0; i < response.length(); i++){
            JSONObject user = new JSONObject(response.get(i).toString());
            toplist.add(
                    new TopListResponse(
                            user.getString("username"),
                            user.getInt("arcoin_amount")
                    )
            );
        }

        return toplist;
    }

    public static ClickerSaveResponse clickerSave(ClickerSaveRequest data, String token) throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(Urls.saveClickerUrl);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("arcoin_amount", String.valueOf(data.arcoinAmount)));
        params.add(new BasicNameValuePair("arcoins_per_seconds", String.valueOf(data.arcoinsPerSeconds)));
        params.add(new BasicNameValuePair("arcoins_per_click", String.valueOf(data.arcoinsPerClick)));

        HttpEntity requestParams = new UrlEncodedFormEntity(params);
        request.setEntity(requestParams);

        HttpUtils.setToken(request, token);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONObject response = HttpUtils.getContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        return new ClickerSaveResponse(
                response.getInt("arcoin_amount"),
                response.getInt("arcoins_per_seconds"),
                response.getInt("arcoins_per_click")
        );
    }
}
