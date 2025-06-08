package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        String url = "https://fakestoreapi.com/products/1";

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Something went wrong");
                return;
            }

            String jsonResponse = response.body().string();

            // Convert JSON string to Java object
            Product product = gson.fromJson(jsonResponse, Product.class);

            // Now you can use the product object anywhere here
            System.out.println("Product title: " + product.getTitle());
            System.out.println("Price: " + product.getPrice());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
