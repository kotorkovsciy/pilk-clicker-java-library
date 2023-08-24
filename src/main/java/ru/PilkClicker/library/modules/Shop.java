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
import ru.PilkClicker.library.modules.Requests.Shop.SaveItemRequest;
import ru.PilkClicker.library.modules.Responses.Shop.SaveItemResponse;
import ru.PilkClicker.library.modules.Responses.Shop.ShopUserResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static List<ShopUserResponse> shopUser(String token)  throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(Urls.shopUserUrl);

        HttpUtils.setToken(request, token);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONArray response = HttpUtils.getArrayContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        List<ShopUserResponse> items = new ArrayList<ShopUserResponse>();

        for (int i = 0; i < response.length(); i++){
            JSONObject item = new JSONObject(response.get(i).toString());
            items.add(
                    new ShopUserResponse(
                            item.getInt("id"),
                            item.getString("name"),
                            item.getInt("amount"),
                            item.getInt("price"),
                            item.getInt("base_price"),
                            Float.valueOf(item.get("arcoins_per_seconds").toString()),
                            item.getInt("arcoins_per_click"),
                            item.getString("image")
                    )
            );
        }

        return items;
    }

    public static SaveItemResponse saveItem(SaveItemRequest data, String token) throws IOException, JSONException, HttpException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(Urls.saveItemUrl);

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("id", String.valueOf(data.id)));
        params.add(new BasicNameValuePair("amount", String.valueOf(data.amount)));

        HttpEntity putParams = new UrlEncodedFormEntity(params);
        request.setEntity(putParams);

        HttpUtils.setToken(request, token);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        JSONObject response = HttpUtils.getContent(httpResponse);

        httpClient.close();

        if (httpResponse.getStatusLine().getStatusCode() != 200){
            throw new HttpException(response.toString());
        }

        return new SaveItemResponse(
                response.getInt("id"),
                response.getString("name"),
                response.getInt("amount"),
                response.getInt("price"),
                response.getInt("base_price"),
                Float.valueOf(response.get("arcoins_per_seconds").toString()),
                response.getInt("arcoins_per_click"),
                response.getString("image")
        );
    }
}
