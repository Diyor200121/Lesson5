package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.response.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        System.out.println("------------------Weather data------------------------");
        while (true) {
            Thread.sleep(20);
            System.out.print("Enter location :");
            String location = scanner.nextLine();
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder(new URI("http://api.weatherapi.com/v1/current.json?" +
                            "key=49b300f793864de4ac8111823231707&" +
                            "q=" + location))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                String body = response.body();
                Response response1 = gson.fromJson(body, Response.class);
                System.out.println("Name : " + response1.getLocation().getName());
                System.out.println("Country : " + response1.getLocation().getCountry());
                System.out.println("Region : " + response1.getLocation().getRegion());
                System.out.println("Localtime : " + response1.getLocation().getLocaltime());
                System.out.println("Tz_id : " + response1.getLocation().getTz_id());
                System.out.println("Temp_c `: " + response1.getCurrent().getTemp_c());
                System.out.println("Temp_f : " + response1.getCurrent().getTemp_f());
                System.out.println("is_day : " + response1.getCurrent().getIs_day());
            } else {
                Logger logger = Logger.getLogger("location");
                logger.log(Level.INFO, "Location invalid");
            }
        }
    }
}