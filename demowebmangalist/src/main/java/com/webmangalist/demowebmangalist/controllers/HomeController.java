package com.webmangalist.demowebmangalist.controllers;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class HomeController{

    @GetMapping("/")
    public String index(@RequestParam(required = false) String manga, ModelMap modelMap){
        String[] friends = {"John","Alice","Bob"};
        modelMap.addAttribute("friends", friends);
        
        modelMap.addAttribute("manga", manga);
        String infoAPI = getAPI(manga);
        modelMap.addAttribute("infoAPI", infoAPI);
        return "home";
    }

    public String getAPI(String manga){
        try {
            manga = manga.replace(" ", "+");
            System.out.println(manga);
            /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jikan1.p.rapidapi.com/manga/2/characters"))
                .header("x-rapidapi-host", "jikan1.p.rapidapi.com")
                .header("x-rapidapi-key", "a2bf8adc01mshdd0dca505b69705p136aebjsna4edc5215179")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("oui API " + response.body());*/

            /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://animanga2.p.rapidapi.com/manga/search/solo%20leveling"))
                .header("x-rapidapi-host", "animanga2.p.rapidapi.com")
                .header("x-rapidapi-key", "a2bf8adc01mshdd0dca505b69705p136aebjsna4edc5215179")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());*/

            /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://kitsu.io/api/edge/manga?filter%5Btext%5D=attack+on+titan"))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());*/

            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://kitsu.io/api/edge/manga?filter%5Btext%5D="+ manga))
                .header("Accept", "application/vnd.api+json")
                .header("Content-Type", "application/vnd.api+json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());




            return response.body();
        } catch (Exception e) {
            System.out.println("error API");
            return "error API";
        }
        
    }

}